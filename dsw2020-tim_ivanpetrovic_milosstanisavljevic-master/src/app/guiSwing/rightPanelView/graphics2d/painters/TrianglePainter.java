package app.guiSwing.rightPanelView.graphics2d.painters;

import app.repository.Slot;
import app.repository.elements.SlotDevice;
import app.repository.elements.TriangleElement;

import java.awt.geom.GeneralPath;

public class TrianglePainter extends DevicePainter {

    public TrianglePainter(SlotDevice element) {
        super(element);
        TriangleElement triangle = (TriangleElement) element;

        shape = new GeneralPath();

        ((GeneralPath) shape).moveTo(triangle.getPosition().getX(), triangle.getPosition().getY());
        ((GeneralPath) shape).lineTo(triangle.getPosition().getX() + triangle.getSize().width, triangle.getPosition().getY() + triangle.getSize().height);
        ((GeneralPath) shape).lineTo(triangle.getPosition().getX(), triangle.getPosition().getY() + triangle.getSize().height);
        ((GeneralPath) shape).closePath();
    }
}
