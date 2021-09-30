package app.guiSwing.controller;

import app.RuDokApp;
import app.errorHandler.Type;
import app.guiSwing.view.MainFrame;
import app.repository.Workspace;
import app.repository.node.Node;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

@Getter
@Setter
public class ExitAction extends AbstractAppAction {

    public ExitAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("icons/log-out.png"));
        putValue(NAME, "Remove current Node");
        putValue(SHORT_DESCRIPTION, "Remove current Node");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Node node = MainFrame.getInstance().getTree().getSelectedNode();

        if (node instanceof Workspace) {
            RuDokApp.getErrorHandler().generateError(Type.CANNOT_BE_DELETED);
        } else {
            MainFrame.getInstance().getTree().removeCurrentNode(node);
        }

    }

}

