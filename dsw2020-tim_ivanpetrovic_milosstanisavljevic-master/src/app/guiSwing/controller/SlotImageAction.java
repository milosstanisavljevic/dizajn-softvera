package app.guiSwing.controller;

import app.RuDokApp;
import app.errorHandler.Type;
import app.guiSwing.view.MainFrame;
import app.guiSwing.view.multimediaSlotView.SlotMultimediaView;
import app.repository.Page;
import app.repository.elements.SlotType;
import app.repository.node.Node;

import java.awt.event.ActionEvent;

public class SlotImageAction extends AbstractAppAction{
    @Override
    public void actionPerformed(ActionEvent e) {
        Node item = MainFrame.getInstance().getTree().getSelectedNode();
        if(item instanceof Page){
            if(((Page) item).getSelectedSlot() != null){
                MainFrame mainFrame = MainFrame.getInstance();
                ((Page) item).getSelectedSlot().setType(SlotType.TYPE_IMAGE);
                SlotMultimediaView slotMultimediaView = new SlotMultimediaView(mainFrame,false,((Page) item).getSelectedSlot());
                slotMultimediaView.setVisible(true);
            }
            else{
                RuDokApp.getErrorHandler().generateError(Type.SELECT_ITEM);
            }
        }
    }
}
