package app.guiSwing.rightPanelView;

import app.guiSwing.controller.ActionEnum;
import app.guiSwing.view.MainFrame;
import app.observer.IListener;
import app.repository.Document;
import app.repository.Project;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProjectView extends JPanel implements IListener {

    private final JLabel name;
    private final JTabbedPane tabbedPane;
    private final Project project;
    private final ArrayList<DocumentView> documentViews;


    public ProjectView(Project project) {

        this.project = project;
        documentViews = new ArrayList<DocumentView>();
        this.project.addListener(this);

        name = new JLabel(project.getName());
        this.setLayout(new BorderLayout());
        JPanel panel = new JPanel(new BorderLayout());
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        panel.add(tabbedPane, BorderLayout.CENTER);
        add(panel, BorderLayout.CENTER);
        add(name, BorderLayout.NORTH);

    }

    @Override
    public void update(Object update) {
        System.out.println("usao u projectview");
        if (update == ActionEnum.ACTION_ADD) {
            addTab();
        }
        if (update == ActionEnum.ACTION_RENAME) {
            name.setText(project.getName());
        }
        if (update == ActionEnum.ACTION_F) {
            focus();
        }

    }

    public void createDocumentView(Document document) {
        DocumentView documentView = new DocumentView(document);
        System.out.println("create document view");
        this.tabbedPane.addTab(document.getName(), documentView);

    }


    public void addTab() {
        System.out.println("Ulazi u add tab");


        Document document = (Document) project.getChildAt(project.getChildCount() - 1);

        this.createDocumentView(document);


    }
    /*public DocumentView getDocumentViewAt(ProjectView pv,int index){
        return this.documentViews.get(index);
    }*/

    /*public DocumentView getSelectedDocumentView(){
       var index = this.getSelectedIndex();
       if(index < 0)
            return null;
        var component = this.getComponentAt(index);
        if(component instanceof DocumentView)
            return (DocumentView) component;
        else
            return null;
    }*/

    public void focus() {
        MainFrame.getInstance().getSplitPane().setRightComponent(this);
        MainFrame.getInstance().getSplitPane().revalidate();
        MainFrame.getInstance().getSplitPane().repaint();
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }
}
