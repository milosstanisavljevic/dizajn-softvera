package app.guiSwing.controller;

import app.guiSwing.view.MainFrame;
import app.repository.Page;
import app.repository.node.Node;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MoveAction extends AbstractAppAction {
    public MoveAction() {
        putValue(SMALL_ICON, loadIcon("icons/move.png"));
        putValue(NAME, "Move");
        putValue(SHORT_DESCRIPTION, "Move");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Node item = MainFrame.getInstance().getTree().getSelectedNode();
        if (item instanceof Page) {
            ((Page) item).startMoveState();
            System.out.println("MoveAction");
        }
    }
}
