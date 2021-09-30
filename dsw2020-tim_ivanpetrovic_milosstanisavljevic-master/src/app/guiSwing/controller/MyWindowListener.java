package app.guiSwing.controller;

import app.guiSwing.view.MainFrame;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class MyWindowListener implements java.awt.event.WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        MainFrame mainFrame = MainFrame.getInstance();
        int code = JOptionPane.showConfirmDialog(mainFrame, "Are you sure you want to close the application?", "Closing application", JOptionPane.YES_NO_OPTION);
        if (code == JOptionPane.YES_OPTION) {
            mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        } else {
            mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}