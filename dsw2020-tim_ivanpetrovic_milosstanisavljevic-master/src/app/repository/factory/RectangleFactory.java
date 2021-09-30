package app.repository.factory;

import app.repository.Slot;
import app.repository.elements.RectangleElement;
import app.repository.elements.SlotDevice;
import app.repository.node.Node;

import java.awt.*;
import java.awt.geom.Point2D;

public class RectangleFactory extends SlotFactory {

    @Override
    public SlotDevice create(Point2D position) {
        RectangleElement element = new RectangleElement("Rectangle",Color.RED,new Dimension(100,50),position);
        return element;
    }
}