package app.guiSwing.controller;

import app.guiSwing.view.MainFrame;
import app.repository.Page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RedoAction extends AbstractAppAction {

    public RedoAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        putValue(MNEMONIC_KEY, KeyEvent.VK_R);
        putValue(SMALL_ICON, loadIcon("icons/redo.png"));
        putValue(NAME, "Redo");
        putValue(SHORT_DESCRIPTION, "Redo");
    }

    public void actionPerformed(ActionEvent e) {
        Page page= (Page) MainFrame.getInstance().getTree().getSelectedNode();
        page.getCmdManager().doCommand();
    }
}