package app.repository.slothandler;


import app.core.SlotHandler;
import app.guiSwing.rightPanelView.graphics2d.painters.CirclePainter;
import app.guiSwing.rightPanelView.graphics2d.painters.RectanglePainter;
import app.guiSwing.rightPanelView.graphics2d.painters.TrianglePainter;
import app.repository.Page;
import app.repository.elements.CircleElement;
import app.repository.elements.RectangleElement;
import app.repository.elements.SlotDevice;
import app.repository.elements.TriangleElement;

import java.awt.*;
import java.awt.geom.Point2D;

public class SlotHandlerImpl implements SlotHandler {





    @Override
    public double rotate(Point clicked, Point released, SlotDevice selectedSlot) {
        double angle = 0;
        double centerx = selectedSlot.getPosition().getX();
        double centery = selectedSlot.getPosition().getY();

        double clickedx = clicked.x - centerx;
        double clickedy = clicked.y - centery;

        double releasedx = released.x - centerx;
        double releasedy = released.y - centery;

        double y = clickedx * releasedy - clickedy * releasedx;
        double x = clickedx * releasedx + clickedy * releasedy;
        angle = Math.atan2(y, x);

        angle = Math.toDegrees(angle);

        if(selectedSlot instanceof RectangleElement){
            selectedSlot.setElementPainter(new RectanglePainter(selectedSlot));
        }else if(selectedSlot instanceof CircleElement){
            selectedSlot.setElementPainter(new CirclePainter(selectedSlot));
        }else  if(selectedSlot instanceof TriangleElement){
            selectedSlot.setElementPainter(new TrianglePainter(selectedSlot));
        }

        return angle;
    }

    @Override
    public void resize(Point2D start, Point2D drag, SlotDevice selectedSlot,int x, int y) {
        System.out.println("moveShandler");
        //int widthInt= (int) (x+ (dragged.getX()- start.getX()));
        //        int heightInt= (int) (y+ (dragged.getY()- start.getY()));
        //        slotPainter.getSlot().setDimension(new Dimension(widthInt,heightInt));
        int width = (int)(x+(drag.getX()-start.getX()));
        int height = (int)(y+(drag.getY()- start.getY()));
        selectedSlot.setSize(new Dimension(width,height));

        if(selectedSlot instanceof RectangleElement){
            selectedSlot.setElementPainter(new RectanglePainter(selectedSlot));
        }else if(selectedSlot instanceof CircleElement){
            selectedSlot.setElementPainter(new CirclePainter(selectedSlot));
        }else  if(selectedSlot instanceof TriangleElement){
            selectedSlot.setElementPainter(new TrianglePainter(selectedSlot));
        }
        System.out.println("Move metoda");

    }

 // svaki prima slot i x,y kordinatu mouseReleased
   /* @Override
    public SlotDevice move(Point2D endingPoint, SlotDevice selectedSlot) {
        selectedSlot.setPosition(endingPoint);

        return selectedSlot;
         }*/

    @Override
    public SlotDevice move(Point2D start, Point2D drag, SlotDevice selectedSlot, int oldx, int oldy) {
        int x = (int)(oldx+(drag.getX()-start.getX()));
        int y = (int)(oldy+(drag.getY()- start.getY()));
        selectedSlot.setPosition(new Point(x,y));


        if(selectedSlot instanceof RectangleElement){
            selectedSlot.setElementPainter(new RectanglePainter(selectedSlot));
        }else if(selectedSlot instanceof CircleElement){
            selectedSlot.setElementPainter(new CirclePainter(selectedSlot));
        }else  if(selectedSlot instanceof TriangleElement){
            selectedSlot.setElementPainter(new TrianglePainter(selectedSlot));
        }
        System.out.println("Move metoda");
        return selectedSlot;
    }
}
