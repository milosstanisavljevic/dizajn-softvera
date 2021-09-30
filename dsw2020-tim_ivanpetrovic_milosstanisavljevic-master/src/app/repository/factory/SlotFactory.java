package app.repository.factory;

import app.repository.Slot;
import app.repository.elements.SlotDevice;
import app.repository.node.Node;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class SlotFactory {
    public SlotDevice makeSlot(Point2D position) {
        SlotDevice slot;
        slot = create(position);
        return slot;
    }

    public abstract SlotDevice create(Point2D position);

}
