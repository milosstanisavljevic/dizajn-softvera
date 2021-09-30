package app.guiSwing.controller;

import app.guiSwing.rightPanelView.PageView;
import app.guiSwing.view.MainFrame;
import app.repository.Page;
import app.repository.Project;
import app.repository.node.Node;

import java.awt.event.ActionEvent;

public class RectangleAction extends AbstractAppAction {
    public RectangleAction() {
        putValue(SMALL_ICON, loadIcon("icons/square.jpg"));
        putValue(NAME, "Rectangle");
        putValue(SHORT_DESCRIPTION, "Rectagle");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Node item = MainFrame.getInstance().getTree().getSelectedNode();
        if(item instanceof Page) {
            ((Page) item).startRectangleState();
        }
       /* for(PageView pv : MainFrame.getInstance().getOpenedDocumentView().getPageViews()){
            pv.startRectangleState();
        }*/

        //MainFrame.getInstance().getOpenedDocumentView().getPageView().startRectangleState();
    }
        //pw.getMenager().setRectangleState();

}
