package app.guiSwing.controller;

import app.guiSwing.view.MainFrame;
import app.repository.Page;
import app.repository.node.Node;

import java.awt.event.ActionEvent;

public class CircleAction extends AbstractAppAction {
    public CircleAction() {

        putValue(SMALL_ICON, loadIcon("icons/circle.jpg"));
        putValue(NAME, "Circle");
        putValue(SHORT_DESCRIPTION, "Circle");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // PageView pageView = MainFrame.getInstance().getPageView();
        //StateMenager stateMenager = pageView.getMenager();
        //stateMenager.setCircleState();
        //(PageView pv : MainFrame.getInstance().getOpenedDocumentView().getPageViews()){
          //  pv.startCircleState();
        Node item = MainFrame.getInstance().getTree().getSelectedNode();
        if(item instanceof Page) {
            ((Page) item).startCircleState();
        }
        }

}

