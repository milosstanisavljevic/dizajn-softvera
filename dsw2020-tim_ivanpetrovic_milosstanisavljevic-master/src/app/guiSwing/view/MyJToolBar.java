package app.guiSwing.view;

import app.guiSwing.controller.*;

import javax.swing.*;
import java.awt.*;

public class MyJToolBar extends JToolBar {

    public MyJToolBar() {

        super(HORIZONTAL);
        setFloatable(false);
        setBackground(Color.LIGHT_GRAY);

        add(new NewProjectAction());
        addSeparator();
        add(new ExitAction());
        addSeparator();
        add(new ShareDocumentAction());
        addSeparator();
        add(new SaveProjectAction());
        addSeparator();
        add(new OpenProjectAction());
        addSeparator();
        add(new UndoAction());
        addSeparator();
        add(new RedoAction());
        addSeparator();
        add(new MultimediaSlotAction());
        addSeparator();
        add(new SwitchWs());
    }
}