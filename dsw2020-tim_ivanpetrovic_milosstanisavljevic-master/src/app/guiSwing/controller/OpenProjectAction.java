package app.guiSwing.controller;

import app.guiSwing.rightPanelView.DocumentView;
import app.guiSwing.rightPanelView.PageView;
import app.guiSwing.view.MainFrame;
import app.repository.Document;
import app.repository.Page;
import app.repository.Project;
import sun.applet.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OpenProjectAction extends AbstractAppAction {

    public OpenProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("icons/open.png"));
        putValue(NAME, "Open project");
        putValue(SHORT_DESCRIPTION, "Open project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileFilter());

        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            try {
                ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));

                Project p = null;
                try {
                    p = (Project) os.readObject();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }

                MainFrame.getInstance().getTree().addProject(p);
                MainFrame.getInstance().createProjectView(p);

                for (int i = 0; i < p.getChildCount(); i++) {
                    Document d = (Document) p.getChildren().get(i);
                    DocumentView view = new DocumentView(d);
//                    String documentName = p.getChildren().get(i).getName();
//                    String projectName = p.getName();
                    //MainFrame.getInstance().getTree().addDocument(d);
                    MainFrame.getInstance().getProjectView().createDocumentView(d);
                   // MainFrame.getInstance().getTree().addDocument(d);
                    for (Page page :d.getPages()){
                        view.addPage();
                       //PageView pageView = new PageView(page);
                        //pageView.setPage(page);


                    }
                }
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}