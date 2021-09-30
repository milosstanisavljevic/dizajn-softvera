package app.guiSwing.state;

import app.RuDokApp;
import app.command.RotateCommand;
import app.guiSwing.rightPanelView.graphics2d.painters.DevicePainter;
import app.repository.Page;
import app.repository.elements.SlotDevice;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

public class RotateState extends State {

    private Page mediator;
    private Point oldPoint;
    private Point point;
    private double angle;


    public RotateState(Page mediator) {
        this.mediator = mediator;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        oldPoint = e.getPoint();
        if (mediator.getSelectedSlots().isEmpty()) {
            for (SlotDevice element : mediator.getSlotElements()) {
                if (element.getPainter().elementAt(element.getPosition())) {
                    mediator.getSelectedSlots().add(element);
                    break;
                }
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        point = e.getPoint();
        if (!mediator.getSelectedSlots().isEmpty()) {
            for (SlotDevice slot : mediator.getSelectedSlots()) {
                //double oldAngle = slot.getAngle();
                angle = RuDokApp.getSlotHandler().rotate(oldPoint,point,slot);
                AffineTransform transform = new AffineTransform();
                transform.rotate(Math.toRadians(angle), slot.getPosition().getX(), slot.getPosition().getY());
                ((DevicePainter) slot.getPainter()).setShape(transform.createTransformedShape(((DevicePainter) slot.getPainter()).getShape()));
                slot.setAngle(angle);
            }
        }
        mediator.notifyListeners(this);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        point = e.getPoint();
        if (!mediator.getSelectedSlots().isEmpty()) {
            for (SlotDevice slot : mediator.getSelectedSlots()) {
                  //double oldAngle = slot.getAngle();
                  //angle = RuDokApp.getSlotHandler().rotate(oldPoint,point,slot,oldAngle);

                ((DevicePainter) slot.getPainter()).setShape(((DevicePainter) slot.getPainter()).getShape());
                slot.setOriginalAngle(slot.getOriginalAngle() + slot.getAngle());
                System.out.println("MOUSE RELEASED NA ROTATE");
            }
        }
        //mediator.getCmdManager().addCommand(new RotateCommand(mediator));
        mediator.notifyListeners(this);
    }

//    private double angleCalculator(Point clicked, Point released, SlotDevice slot) {
//
//        double centerx = slot.getPosition().getX();
//        double centery = slot.getPosition().getY();
//
//        double clickedx = clicked.x - centerx;
//        double clickedy = clicked.y - centery;
//
//        double releasedx = released.x - centerx;
//        double releasedy = released.y - centery;
//
//        double y = clickedx * releasedy - clickedy * releasedx;
//        double x = clickedx * releasedx + clickedy * releasedy;
//        angle = Math.atan2(y, x);
//
//        angle = Math.toDegrees(angle);
//
//        return angle;
//    }
}

