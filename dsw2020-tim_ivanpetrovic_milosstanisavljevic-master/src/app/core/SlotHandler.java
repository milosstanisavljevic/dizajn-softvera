package app.core;


import app.guiSwing.rightPanelView.PageView;
import app.repository.Page;
import app.repository.elements.SlotDevice;

import java.awt.*;
import java.awt.geom.Point2D;

public interface SlotHandler {

    double rotate(Point clicked, Point released, SlotDevice slot);

    void resize(Point2D start, Point2D drag, SlotDevice selectedSlot,int x, int y);

    SlotDevice move(Point2D start, Point2D drag, SlotDevice selectedSlot,int x, int y);

   // void move(Point2D position1, Point2D position2, SlotDevice slotDevice, int x, int y);
}
