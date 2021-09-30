package app.guiSwing.controller;

import app.guiSwing.view.MainFrame;
import app.repository.*;
import app.repository.node.Node;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

@Getter
@Setter
public class NewProjectAction extends AbstractAppAction {

    private static int a = 1;
    private static int b = 1;
    private static int c = 1;
    private static int d = 1;

    public NewProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("icons/plus.png"));
        putValue(NAME, "New Node");
        putValue(SHORT_DESCRIPTION, "Add Node");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Object obj = MainFrame.getInstance().getTree().getSelectedNode();
            Node treeItem = (Node) obj;


            if (treeItem instanceof Workspace) {

                Project p = new Project("Project " + a++, treeItem);
                MainFrame.getInstance().getTree().addProject(p);
                //ProjectView pv = new ProjectView(p);
                MainFrame.getInstance().createProjectView(p);
                //System.out.println();

            }

            if (treeItem instanceof Project) {

                Document d = new Document("Document" + b++, treeItem);
                MainFrame.getInstance().getTree().addDocument(d);

                //createDocumentView(d);
            }
            if (treeItem instanceof Document) {

                Page p = new Page("Page" + c++, treeItem);
                MainFrame.getInstance().getTree().addPage(p);
            }
            if (treeItem instanceof Page) {

                Slot s = new Slot("Slot" + d++, treeItem);
                MainFrame.getInstance().getTree().addSlot(s);

            }

        } catch (NullPointerException exception) {
        }
    }
}
