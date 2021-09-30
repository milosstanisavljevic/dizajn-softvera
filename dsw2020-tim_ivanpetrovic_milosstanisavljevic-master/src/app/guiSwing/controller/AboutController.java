package app.guiSwing.controller;

import app.guiSwing.view.AboutView;

import java.awt.event.ActionEvent;

public class AboutController extends AbstractAppAction {

    public AboutController() {
        putValue(NAME, "About");
        putValue(SHORT_DESCRIPTION, "About");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        AboutView aboutView = new AboutView();
        aboutView.setVisible(true);
    }
}
