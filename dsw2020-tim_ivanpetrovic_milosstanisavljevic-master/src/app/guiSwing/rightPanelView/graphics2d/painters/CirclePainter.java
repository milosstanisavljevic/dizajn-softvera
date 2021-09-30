package app.guiSwing.rightPanelView.graphics2d.painters;

import app.repository.Slot;
import app.repository.elements.CircleElement;
import app.repository.elements.SlotDevice;

import java.awt.geom.GeneralPath;

public class CirclePainter extends DevicePainter {
    public CirclePainter(SlotDevice element) {
        super(element);
        CircleElement circle = (CircleElement) element;

        shape = new GeneralPath();

        ((GeneralPath) shape).moveTo(circle.getPosition().getX() + circle.getSize().getWidth() / 2, circle.getPosition().getY());

        ((GeneralPath) shape).quadTo(circle.getPosition().getX() + circle.getSize().getWidth(), circle.getPosition().getY(),
                circle.getPosition().getX() + circle.getSize().getWidth(), circle.getPosition().getY() + circle.getSize().getHeight() / 2);

        ((GeneralPath) shape).quadTo(circle.getPosition().getX() + circle.getSize().getWidth(), circle.getPosition().getY() + circle.getSize().getHeight(),
                circle.getPosition().getX() + circle.getSize().getWidth() / 2, circle.getPosition().getY() + circle.getSize().getHeight());

        ((GeneralPath) shape).quadTo(circle.getPosition().getX(), circle.getPosition().getY() + circle.getSize().getHeight(),
                circle.getPosition().getX(), circle.getPosition().getY() + circle.getSize().getHeight() / 2);


        ((GeneralPath) shape).quadTo(circle.getPosition().getX(), circle.getPosition().getY(),
                circle.getPosition().getX() + circle.getSize().getWidth() / 2, circle.getPosition().getY());

    }

}
