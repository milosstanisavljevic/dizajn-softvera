package app.guiSwing.view;

import app.guiSwing.controller.*;

import javax.swing.*;

public class Palette extends JToolBar {
    public Palette() {
        super(VERTICAL);
        setFloatable(false);
        add(new SelectAction());
        addSeparator();
        add(new TriangleAction());
        addSeparator();
        add(new RectangleAction());
        addSeparator();
        add(new CircleAction());
        addSeparator();
        add(new MoveAction());
        addSeparator();
        add(new ScaleAction());
        addSeparator();
        add(new RotateAction());
        addSeparator();
        add(new DeleteAction());
    }
}
