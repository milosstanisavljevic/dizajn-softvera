package app.guiSwing.controller;

import app.guiSwing.rightPanelView.PageView;
import app.guiSwing.view.MainFrame;
import app.repository.Page;
import app.repository.node.Node;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class UndoAction extends AbstractAppAction {

    public UndoAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        putValue(MNEMONIC_KEY, KeyEvent.VK_U);
        putValue(SMALL_ICON, loadIcon("icons/undo.png"));
        putValue(NAME, "Undo");
        putValue(SHORT_DESCRIPTION, "Undo");
    }

    public void actionPerformed(ActionEvent e) {

        Page page= (Page) MainFrame.getInstance().getTree().getSelectedNode();
        page.getCmdManager().undoCommand();
    }
}
