package app.guiSwing.controller;

import java.io.File;

public class TextFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        return (f.isDirectory() || f.getName().toLowerCase().endsWith(".txt"));
    }

    @Override
    public String getDescription() {
        return "Text Files (*.txt)";
    }
}
