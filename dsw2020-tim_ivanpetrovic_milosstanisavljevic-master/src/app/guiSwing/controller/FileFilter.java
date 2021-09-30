package app.guiSwing.controller;

import java.io.File;

public class FileFilter extends javax.swing.filechooser.FileFilter {

    @Override
    public boolean accept(File f) {
        return (f.isDirectory() || f.getName().toLowerCase().endsWith(".gpf"));
    }

    @Override
    public String getDescription() {
        return "GrafEditor Project Files (*.gpf)";
    }
}
