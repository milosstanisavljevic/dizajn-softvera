package app.repository.elements;

import app.guiSwing.rightPanelView.graphics2d.painters.CirclePainter;
import app.repository.Slot;
import app.repository.node.Node;

import java.awt.*;
import java.awt.geom.Point2D;

public class CircleElement extends SlotDevice {
    public CircleElement(String name,Paint paint, Dimension size,
                         Point2D position) {
        super(name,paint,size,position);
        elementPainter = new CirclePainter(this);
    }
}
