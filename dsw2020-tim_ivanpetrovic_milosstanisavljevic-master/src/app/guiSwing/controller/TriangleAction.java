package app.guiSwing.controller;


import app.guiSwing.rightPanelView.PageView;
import app.guiSwing.view.MainFrame;
import app.repository.Page;
import app.repository.node.Node;

import java.awt.event.ActionEvent;

public class TriangleAction extends AbstractAppAction {
    public TriangleAction() {

        putValue(SMALL_ICON, loadIcon("icons/triangle.jpg"));
        putValue(NAME, "Triangle");
        putValue(SHORT_DESCRIPTION, "Triangle");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //for (PageView pv : MainFrame.getInstance().getOpenedDocumentView().getPageViews()) {
          //  pv.startTriangleState();
        //}
        Node item = MainFrame.getInstance().getTree().getSelectedNode();
        if(item instanceof Page) {
            ((Page) item).startTriangleState();
        }
    }
}