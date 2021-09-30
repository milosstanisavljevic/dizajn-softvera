package app.guiSwing.controller;

import app.guiSwing.view.MainFrame;
import app.repository.Page;
import app.repository.node.Node;

import java.awt.event.ActionEvent;

public class ScaleAction extends AbstractAppAction {
    public ScaleAction() {

        putValue(SMALL_ICON, loadIcon("icons/scale.jpg"));
        putValue(NAME, "Scale");
        putValue(SHORT_DESCRIPTION, "Scale");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Node item = MainFrame.getInstance().getTree().getSelectedNode();
        if (item instanceof Page) {
            ((Page) item).startResizeState();
            System.out.println("ResizeAction");
        }
    }
}
