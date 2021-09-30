package app.repository.factory;

import app.repository.Slot;
import app.repository.elements.CircleElement;
import app.repository.elements.RectangleElement;
import app.repository.elements.SlotDevice;
import app.repository.node.Node;

import java.awt.*;
import java.awt.geom.Point2D;

public class CircleFactory extends SlotFactory {


    @Override
    public SlotDevice create(Point2D position) {
        CircleElement element = new CircleElement("Circle",Color.RED,new Dimension(50,50),position);
        return element;
    }
}
