package app.guiSwing.state;

import app.repository.Page;
import app.repository.elements.SlotDevice;


import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectState extends State {
    private Page mediator;

    public SelectState(Page mediator){
        this.mediator=mediator;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mediator.setOldPoint(e.getPoint());
        }

    @Override
    public void mouseDragged(MouseEvent e) {
        mediator.startLassoState();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

            Point position = e.getPoint();
            mediator.setNewPoint(e.getPoint());
            mediator.setStartLasso(false);

            if (e.isControlDown()) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    int i = mediator.getDeviceAtPosition(position);

                    if (i != -1) {
                        SlotDevice slotDevice = mediator.getDeviceAt(i);
                        mediator.setStartLasso(false);
                        mediator.addSelectedSlot(slotDevice);
                        mediator.setSelectedSlot(slotDevice);
                        System.out.println("Selektovan je  " + slotDevice);
                        slotDevice.setPaint(Color.BLACK);
                        mediator.addSlotElement(slotDevice);
                    } else {
                        mediator.removeAllSelectedSlots();
                    }
                }
            }
    }
}
