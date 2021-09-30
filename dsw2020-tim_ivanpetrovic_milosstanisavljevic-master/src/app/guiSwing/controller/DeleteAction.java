package app.guiSwing.controller;

import app.guiSwing.view.MainFrame;
import app.repository.Page;
import app.repository.node.Node;

import java.awt.event.ActionEvent;

public class DeleteAction extends AbstractAppAction{

    public DeleteAction(){
        putValue(SMALL_ICON, loadIcon("icons/delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Node item = MainFrame.getInstance().getTree().getSelectedNode();

        if(item instanceof Page) {
            ((Page) item).startDeleteAction();
            item.notifyListeners(this);
        }
    }
}
