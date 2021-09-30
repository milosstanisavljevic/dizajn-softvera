package app.guiSwing.state;

import app.repository.Page;
import app.repository.elements.SlotDevice;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class LassoState extends State {

    private Page mediator;

    public LassoState(Page mediator){
        this.mediator=mediator;
    }

    @Override
    public void mousePressed(MouseEvent e) {

   //     if (!e.isControlDown()){
   //         mediator.getSelectedSlots().clear();
   //     }
        Point position = e.getPoint();
        mediator.setOldPoint(e.getPoint());
        mediator.setNewPoint(e.getPoint());
        mediator.setStartLasso(false);

        if(e.getButton()==MouseEvent.BUTTON1){
            int i = mediator.getDeviceAtPosition(position);
            if(i!=-1){
                mediator.setStartLasso(false);
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        mediator.setStartLasso(true);
        mediator.setNewPoint(e.getPoint());
        mediator.notifyListeners(this);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        for(int i=0; i< mediator.getElementCount(); i++){
            SlotDevice device = mediator.getSlotElements().get(i);

            if(mediator.getLassoRec().contains(device.getPosition())){
                mediator.getSelectedSlots().add(device);
                 device.setPaint(Color.BLACK);
                 mediator.notifyListeners(this);
             }
            else {
                 device.setPaint(Color.RED);

            }
        }

    }
}