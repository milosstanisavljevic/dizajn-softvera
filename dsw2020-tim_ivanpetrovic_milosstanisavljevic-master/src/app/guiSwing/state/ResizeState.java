package app.guiSwing.state;

import app.RuDokApp;
import app.command.ResizeCommand;
import app.core.SlotHandler;
import app.repository.Page;
import app.repository.elements.SlotDevice;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class ResizeState extends State{

    private Page mediator;
    private Point2D position1;
    private Point2D position2;
    SlotHandler slotHandler = RuDokApp.getSlotHandler();

    public ResizeState(Page mediator) {
        this.mediator = mediator;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point2D position = e.getPoint();
        if(e.getButton() == MouseEvent.BUTTON1) {

            if(!(mediator.getSelectedSlots() == null)){
                position1 = position;
                for(SlotDevice device: mediator.getSelectedSlots()){
                    device.setOldSize(device.getSize());
                }
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        position2 = e.getPoint();
        for(SlotDevice device : mediator.getSelectedSlots()) {
            int x = (int)(device.getOldSize().getWidth());
            int y = (int)(device.getOldSize().getHeight());
            slotHandler.resize(position1,position2,device,x,y);
        }
        mediator.notifyListeners(this);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        mediator.getCmdManager().addCommand(new ResizeCommand(mediator));
        mediator.notifyListeners(this);
    }
}
