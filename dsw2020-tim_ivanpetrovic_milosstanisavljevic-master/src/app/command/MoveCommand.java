package app.command;

import app.guiSwing.rightPanelView.graphics2d.painters.CirclePainter;
import app.guiSwing.rightPanelView.graphics2d.painters.RectanglePainter;
import app.guiSwing.rightPanelView.graphics2d.painters.TrianglePainter;
import app.repository.Page;
import app.repository.elements.RectangleElement;
import app.repository.elements.SlotDevice;
import app.repository.elements.TriangleElement;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class MoveCommand extends AbstractCommand{

    private Page page;
    private ArrayList<SlotDevice> selectedSlots;
    private ArrayList<Point2D> oldPoints;
    private ArrayList<Point2D> points;

    public MoveCommand(Page page) {

        this.page = page;
        selectedSlots = new ArrayList<>(page.getSelectedSlots());
        oldPoints = new ArrayList<>();
        points = new ArrayList<>();

        for(SlotDevice p: selectedSlots) {
            oldPoints.add(p.getOldPosition());
        }
    }

    @Override
    public void doCommand() {

        for(int i = 0; i < selectedSlots.size();i ++) {

            SlotDevice s = selectedSlots.get(i);
            s.setPosition(s.getPosition());
            points.add(s.getPosition());
            s.setPosition(points.get(i));

            if(s instanceof RectangleElement)
                s.setElementPainter(new RectanglePainter(s));
            else if(s instanceof TriangleElement)
                s.setElementPainter(new TrianglePainter(s));
            else
                s.setElementPainter(new CirclePainter(s));
        }
        page.notifyListeners(this);
    }

    @Override
    public void undoCommand() {

        for(int i = 0; i < selectedSlots.size(); i++) {

            SlotDevice s = selectedSlots.get(i);
            s.setPosition(oldPoints.get(i));

            if(s instanceof RectangleElement)
                s.setElementPainter(new RectanglePainter(s));
            else if(s instanceof TriangleElement)
                s.setElementPainter(new TrianglePainter(s));
            else
                s.setElementPainter(new CirclePainter(s));
            System.out.println(s.getPosition().toString());
        }
        page.notifyListeners(this);
    }
}
