package app.guiSwing.view;

import app.guiSwing.controller.AboutController;

import javax.swing.*;

public class MyJMenuBar extends JMenuBar {

    private final JMenu file = new JMenu("File");
    private final JMenu view = new JMenu("View");
    private final JMenu options = new JMenu("Options");
    private final JMenu about = new JMenu("Help");

    private final JMenu fileNew = new JMenu("New");
    private final JMenuItem fileNewProject = new JMenuItem("New Project");
    private final JMenuItem fileOpen = new JMenuItem("Open");
    private final JMenuItem fileSave = new JMenuItem("Save");
    private final JMenuItem fileSaveAs = new JMenuItem("Save as");
    private final JMenuItem filePrint = new JMenuItem("Print");
    private final JMenuItem fileDelete = new JMenuItem("Delete");
    private final JMenuItem fileClose = new JMenuItem("Close");
    private final JMenuItem helpAbout = new JMenuItem("About");

    public MyJMenuBar() {

        fileNew.add(fileNewProject);

        file.add(fileNew);
        file.addSeparator();
        file.add(fileOpen);
        file.addSeparator();
        file.add(fileSave);
        file.add(fileSaveAs);
        file.addSeparator();
        file.add(filePrint);
        file.addSeparator();
        file.add(fileDelete);
        file.addSeparator();
        file.add(fileClose);

        add(file);
        add(view);
        add(options);

        helpAbout.addActionListener(new AboutController());
        about.add(helpAbout);
        add(about);
    }
}
