package app.repository.factory;

import app.repository.Slot;
import app.repository.elements.RectangleElement;
import app.repository.elements.SlotDevice;
import app.repository.elements.TriangleElement;
import app.repository.node.Node;

import java.awt.*;
import java.awt.geom.Point2D;

public class TriangleFactory extends SlotFactory {

    @Override
    public SlotDevice create(Point2D position) {
        TriangleElement element = new TriangleElement("Triangle",Color.RED,new Dimension(100,50),position);
        return element;
    }
}