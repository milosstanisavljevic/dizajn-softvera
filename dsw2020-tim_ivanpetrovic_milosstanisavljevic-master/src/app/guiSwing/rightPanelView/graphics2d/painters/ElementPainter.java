package app.guiSwing.rightPanelView.graphics2d.painters;

import app.repository.Slot;
import app.repository.elements.SlotDevice;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serializable;

public abstract class ElementPainter implements Serializable {

    public ElementPainter(SlotDevice element) {
    }

    public abstract void paint(Graphics2D graphics2D, SlotDevice element);

    public abstract Rectangle paintLasso(Rectangle lassoRec, Graphics2D g, Point oldPoint, Point newPoint);

    public abstract boolean elementAt(Point2D position);
}
