package app.guiSwing.state;

import app.RuDokApp;
import app.command.MoveCommand;
import app.core.SlotHandler;
import app.repository.Page;
import app.repository.elements.SlotDevice;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class MoveState extends State{

    private Page mediator;
    private Point2D position1;
    private Point2D position2;
    private SlotDevice device;
    private SlotHandler slotHandler = RuDokApp.getSlotHandler();

    public MoveState(Page mediator) {
        this.mediator = mediator;
    }

 /*   @Override
    public void mousePressed(MouseEvent e) {


        if(e.getButton() == MouseEvent.BUTTON1){
            int a= mediator.getDeviceAtPosition(position1);
            if(a != -1){
                device = mediator.getDeviceAt(a);
                device.setOldPosition(position1);
                System.out.println(device);
            }
        }*/

        @Override
        public void mousePressed(MouseEvent e) {

            System.out.println("mousepressedMove");
            Point2D position = e.getPoint();
            if(e.getButton() == MouseEvent.BUTTON1){
                if(!(mediator.getSelectedSlots()== null)) {
                    position1 = position;
                    for (SlotDevice slotDevice : mediator.getSelectedSlots()) {
                        //Point startingPoint = new Point((int) slotDevice.getPosition().getX(), (int) slotDevice.getPosition().getY());
                        slotDevice.setOldPosition(slotDevice.getPosition());
                    }
                }
            }
        }

   /* @Override
    public void mouseDragged(MouseEvent e) {

        System.out.println("MouseDragged");
        position2 = e.getPoint();
        device = slotHandler.move(position2,mediator.getSelectedSlot());
        mediator.addSlotElement(device);
        mediator.notifyListeners(this);
    }*/

   @Override
   public void mouseDragged(MouseEvent e) {
        position2 = e.getPoint();
       for(SlotDevice slotDevice : mediator.getSelectedSlots()) {

           int x = (int) (slotDevice.getOldPosition().getX());
           int y = (int) (slotDevice.getOldPosition().getY());

           Point endingPoint = new Point(x,y) ;
           device = slotHandler.move(position1,position2,slotDevice,x,y);

           //.move(position1,position2,slotDevice,x,y);
           //RuDokApp.getSlotHandler().move(position1,position2,slotDevice,x,y);
           //device.setName("POMEREN");
           mediator.addSlotElement(device);
       }
       mediator.notifyListeners(this);
   }

    @Override
    public void mouseReleased(MouseEvent e) {
        mediator.getCmdManager().addCommand(new MoveCommand(mediator));
        mediator.notifyListeners(this);
    }
}
