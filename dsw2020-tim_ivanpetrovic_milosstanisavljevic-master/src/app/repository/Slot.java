package app.repository;

import app.guiSwing.rightPanelView.graphics2d.painters.ElementPainter;
import app.observer.IListener;
import app.repository.node.Node;
import app.repository.node.NodeComposite;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serializable;

public class Slot extends NodeComposite implements Serializable {



    public Slot(String name, Node parent) {

        super(name, parent);
    }


    @Override
    public NodeComposite getChildAt(int index) {
        return null;
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public void addChild(Node child) {

    }
}
// slot nasledjuju RS CS TS , abstraktna klasa SlotFactory metode makeSlot i create jos u desnu stranu 3 klase koje prave obekjekat, RF,CF I TF