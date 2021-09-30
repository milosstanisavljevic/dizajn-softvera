package app.guiSwing.controller;

import app.guiSwing.view.MainFrame;
import app.repository.Page;
import app.repository.node.Node;

import java.awt.event.ActionEvent;

public class RotateAction extends AbstractAppAction {
    public RotateAction() {
        putValue(SMALL_ICON, loadIcon("icons/rotate.jpg"));
        putValue(NAME, "Rotate element");
        putValue(SHORT_DESCRIPTION, "Rotate");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Node item = MainFrame.getInstance().getTree().getSelectedNode();
        if (item instanceof Page) {
            ((Page) item).startRotateState();
            System.out.println("RotateAction");
        }
    }
}
