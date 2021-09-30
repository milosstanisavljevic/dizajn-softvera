package app.repository.elements;

import app.guiSwing.rightPanelView.graphics2d.painters.RectanglePainter;
import app.repository.Slot;
import app.repository.node.Node;

import java.awt.*;
import java.awt.geom.Point2D;

public class RectangleElement extends SlotDevice {
    public RectangleElement(String name,Paint paint, Dimension size,
                            Point2D position) {
        super(name,paint,size,position);
        elementPainter = new RectanglePainter(this);
    } //Stroke stroke,String name, Dimension size,Point2D position
}
