package app.guiSwing.tree.controller;

import app.guiSwing.controller.ActionEnum;
import app.guiSwing.tree.model.TreeItem;
import app.guiSwing.view.MainFrame;
import app.repository.Project;
import app.repository.node.Node;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TSelectionListener implements TreeSelectionListener {

    @Override
    public void valueChanged(TreeSelectionEvent e) {

        TreePath path = e.getPath();
        TreeItem treeItemSelected = (TreeItem) path.getLastPathComponent();
        System.out.println("Tree selected:" + treeItemSelected.getName());
        System.out.println("getPath: " + e.getPath());

        MainFrame.getInstance().getWorkspaceTree().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    TreeItem item = (TreeItem) path.getLastPathComponent();
                    Node node = item.getNodeModel();
                    if (node instanceof Project) {
                        node.notifyListeners(ActionEnum.ACTION_F);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }


        });
    }
}
