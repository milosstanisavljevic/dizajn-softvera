package app.guiSwing.rightPanelView;

import app.command.CommandManager;
import app.guiSwing.controller.ActionEnum;
import app.guiSwing.rightPanelView.graphics2d.painters.DevicePainter;
import app.guiSwing.rightPanelView.graphics2d.painters.ElementPainter;
import app.observer.IListener;
import app.repository.Page;
import app.repository.Project;
import app.repository.elements.SlotDevice;
import app.guiSwing.state.StateMenager;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
public class PageView extends JPanel implements IListener {

    private JLabel pageName;
    private Page page;
    private List<DevicePainter> elements;
    private DevicePainter selectedElement;
    private StateMenager stateMenager;
    private CommandManager commandManager;

    public PageView(Page page) {
        this.page = page;
        this.page.addListener(this);
        pageName = new JLabel(page.getName());
        elements = new ArrayList<>();
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(200, 500));
        this.add(pageName);
        this.commandManager = new CommandManager();

        DiagramController c = new DiagramController();
        this.addMouseListener(c);
        this.addMouseMotionListener(c);

    }

    @Override
    public void update(Object update) {
        if (update == ActionEnum.ACTION_RENAME) {
            pageName.setText(page.getName());
        }
       else{
          Project project = (Project) page.getParent().getParent();
          project.setChanged(true);
            repaint();
        }
    }

    public Page getPage() {
        return page;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.8f));

        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        Iterator<SlotDevice> it = page.getDeviceIterator();
        while (it.hasNext()){
            SlotDevice element = it.next();
            ElementPainter painter = element.getPainter();
            painter.paint(graphics2D,element);

            if (page.isStartLasso())
                page.setLassoRec(painter.paintLasso(page.getLassoRec(), graphics2D,page.getOldPoint(), page.getNewPoint()));
        }

    }

    /*public ArrayList<DevicePainter> getPainters() {
        return painters;
    }*/

    private class DiagramController extends MouseAdapter implements MouseMotionListener {

        public void mousePressed(MouseEvent e) {
           page.getManager().getCurrentState().mousePressed(e);

        }

        public void mouseReleased(MouseEvent e) {
            page.getManager().getCurrentState().mouseReleased(e);
        }

       public void mouseDragged(MouseEvent e ){
            System.out.println(page.getManager().getCurrentState());
            page.getManager().getCurrentState().mouseDragged(e);
        }

   }

    public List<DevicePainter> getElements() {
        return elements;
    }

    public DevicePainter getSelectedElement() {
        return selectedElement;
    }
}
