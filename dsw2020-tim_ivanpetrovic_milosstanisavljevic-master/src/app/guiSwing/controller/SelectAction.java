package app.guiSwing.controller;

import app.guiSwing.view.MainFrame;
import app.repository.Page;
import app.repository.node.Node;

import java.awt.event.ActionEvent;

public class SelectAction extends AbstractAppAction{
    public SelectAction(){
        putValue(SMALL_ICON, loadIcon("icons/select.png"));
        putValue(NAME, "Select");
        putValue(SHORT_DESCRIPTION, "Select");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Node item = MainFrame.getInstance().getTree().getSelectedNode();
        if(item instanceof Page) {
           System.out.println("selectAction");
            ((Page) item).startSelectState();
        }
    }
}
