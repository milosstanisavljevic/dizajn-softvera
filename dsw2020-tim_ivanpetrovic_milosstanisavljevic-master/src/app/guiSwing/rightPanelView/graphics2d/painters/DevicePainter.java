package app.guiSwing.rightPanelView.graphics2d.painters;

import app.repository.Slot;
import app.repository.elements.SlotDevice;

import java.awt.*;
import java.awt.geom.Point2D;

public class DevicePainter extends ElementPainter {

    protected Shape shape;
    private  SlotDevice slotDevice;
    //DEVICE APINTER == SLOT PAINTER == SLOT VIEW
    public DevicePainter(SlotDevice element) {
        super(element);
        this.slotDevice = element;
    }

    Paint paint = new Color(255, 255, 255);
    //Stroke stroke = new BasicStroke(2f);

    @Override
    public void paint(Graphics2D graphics2D, SlotDevice element) {

        graphics2D.setPaint(element.getPaint());
        graphics2D.setStroke(new BasicStroke((float)(2),BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL));
        graphics2D.draw(getShape());
        graphics2D.setPaint(Color.white);
        graphics2D.fill(getShape());

        if (element instanceof SlotDevice) {
            graphics2D.setPaint(Color.BLACK);
            graphics2D.drawString(element.getName(), (int) element.getPosition().getX() + 10,
                    (int) element.getPosition().getY() + 10);
        }


    }

    @Override
    public Rectangle paintLasso(Rectangle lassoRec, Graphics2D g, Point oldPoint, Point newPoint){

        g.setStroke(new BasicStroke((float)1, BasicStroke.CAP_SQUARE,
                BasicStroke.JOIN_BEVEL, 1f, new float[]{3f, 6f}, 0 ));
        g.setPaint(Color.BLACK);
        lassoRec = new Rectangle((int)oldPoint.getX(),(int)oldPoint.getY(),(int)newPoint.getX(),(int)newPoint.getY());
        g.draw(lassoRec);
        return lassoRec;
    }


    @Override
    public boolean elementAt(Point2D position) {
        return getShape().contains(position);
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public SlotDevice getSlotDevice() {
        return slotDevice;
    }
}
