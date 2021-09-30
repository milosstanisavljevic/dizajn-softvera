package app.guiSwing.controller;

import app.RuDokApp;
import app.errorHandler.Type;
import app.guiSwing.view.MainFrame;
import app.repository.Document;
import app.repository.Project;
import app.repository.node.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ShareDocumentAction extends AbstractAppAction {

    public ShareDocumentAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("icons/share.jpg"));
        putValue(NAME, "Share Document");
        putValue(SHORT_DESCRIPTION, "Share");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Node node = MainFrame.getInstance().getTree().getSelectedNode();
        if (node instanceof Document) {
            Node n = node.getParent();
            JDialog dialog = new JDialog();
            dialog.setTitle("Share document");
            dialog.setSize(300, 200);
            dialog.add(new JLabel("Choose Project"), BorderLayout.CENTER);
            JButton button = new JButton("Share Document");
            dialog.add(button, BorderLayout.SOUTH);
            dialog.setVisible(true);
            dialog.setLocationRelativeTo(null);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Node parent = MainFrame.getInstance().getTree().getSelectedNode();
                    if (!(parent instanceof Project)) {
                        RuDokApp.getErrorHandler().generateError(Type.WRONG_NODE);
                    } else {
                        if (parent == n) {
                            RuDokApp.getErrorHandler().generateError(Type.SELECT_ITEM);
                        } else {
                            MainFrame.getInstance().getTree().insert(node);
                            dialog.setVisible(true);

                        }
                    }
                }
            });
        }
    }
}
