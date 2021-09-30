package app.guiSwing.controller;

import app.RuDokApp;
import app.errorHandler.Type;
import app.guiSwing.view.MainFrame;
import app.guiSwing.view.multimediaSlotView.ImageSlotView;
import app.guiSwing.view.multimediaSlotView.SlotMultimediaView;
import app.guiSwing.view.multimediaSlotView.TextSlotView;
import app.repository.Page;
import app.repository.elements.SlotType;
import app.repository.node.Node;

import java.awt.event.ActionEvent;

public class MultimediaSlotAction extends AbstractAppAction{

    public MultimediaSlotAction (){

        //putValue(SMALL_ICON, loadIcon("icons/share.jpg"));
        putValue(NAME, "SlotMultimedia");
        putValue(SHORT_DESCRIPTION, "Slot Multimedia");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        SlotMultimediaView slotMultimediaView = null;
        TextSlotView textSlotView = null;
        ImageSlotView imageSlotView = null;

        Node item = (MainFrame.getInstance().getTree().getSelectedNode());

        if (item instanceof Page) {
            if(((Page) item).getSelectedSlot()!=null) {
                MainFrame mainFrame = MainFrame.getInstance();

                if(((Page) item).getSelectedSlot().getType().equals(SlotType.NONE)) {
                    slotMultimediaView = new SlotMultimediaView(mainFrame, false, ((Page) item).getSelectedSlot());
                    slotMultimediaView.setVisible(true);
                }else if (((Page) item).getSelectedSlot().getType().equals(SlotType.TYPE_TEXT)){
                    textSlotView = new TextSlotView(((Page) item).getSelectedSlot());
                    textSlotView.setVisible(true);
                }else if (((Page) item).getSelectedSlot().getType().equals(SlotType.TYPE_IMAGE)){
                    imageSlotView = new ImageSlotView(((Page) item).getSelectedSlot());
                    imageSlotView.setVisible(true);
                }
            }else{
                RuDokApp.getErrorHandler().generateError(Type.WRONG_NODE);
            }
        }
    }
}
