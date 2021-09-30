package app.guiSwing.rightPanelView.graphics2d.painters;

import app.repository.Slot;
import app.repository.elements.RectangleElement;
import app.repository.elements.SlotDevice;

import java.awt.geom.GeneralPath;

public class RectanglePainter extends DevicePainter {
    public RectanglePainter(SlotDevice element) {
        super(element);
        RectangleElement rectangle = (RectangleElement) element;

        shape = new GeneralPath();


        ((GeneralPath) shape).moveTo(rectangle.getPosition().getX(), rectangle.getPosition().getY());

        ((GeneralPath) shape).lineTo(rectangle.getPosition().getX() + rectangle.getSize().width, rectangle.getPosition().getY());

        ((GeneralPath) shape).lineTo(rectangle.getPosition().getX()+ rectangle.getSize().width, rectangle.getPosition().getY() + rectangle.getSize().height);

        ((GeneralPath) shape).lineTo(rectangle.getPosition().getX(), rectangle.getPosition().getY() + rectangle.getSize().height);

        ((GeneralPath) shape).closePath();
    }
}
