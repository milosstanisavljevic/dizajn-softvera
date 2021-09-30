package app.guiSwing.controller;

import app.RuDokApp;
import app.errorHandler.Type;
import app.guiSwing.view.MainFrame;
import app.guiSwing.view.multimediaSlotView.ImageSlotView;
import app.repository.Page;
import app.repository.elements.SlotType;
import app.repository.node.Node;

import java.awt.event.ActionEvent;

 public class ImageButtonListener extends AbstractAppAction{

    @Override
    public void actionPerformed(ActionEvent e) {
        Node item = (MainFrame.getInstance().getTree().getSelectedNode());
        if (item instanceof Page) {
            if(((Page) item).getSelectedSlot()!=null) {

                MainFrame mainFrame = MainFrame.getInstance();
                ((Page) item).getSelectedSlot().setType(SlotType.TYPE_IMAGE);
                ImageSlotView imageSlotView = new ImageSlotView(((Page) item).getSelectedSlot());
                imageSlotView.setVisible(true);
            }else{
                RuDokApp.getErrorHandler().generateError(Type.WRONG_NODE);
            }
        }

    }
}
