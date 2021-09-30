package app.guiSwing.controller;

import app.RuDokApp;
import app.errorHandler.Type;
import app.guiSwing.view.MainFrame;
import app.repository.Project;
import app.repository.node.Node;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;

public class SaveProjectAction extends AbstractAppAction{

    public SaveProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("icons/save.png"));
        putValue(NAME, "Save project");
        putValue(SHORT_DESCRIPTION, "Save project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileFilter());

        Node project = MainFrame.getInstance().getTree().getSelectedNode();
        File projectFile;

        if ((project instanceof Project)) {

            projectFile = ((Project) project).getPFile();

            if (!((Project) project).isChanged()) {
                return;
            }

            if (((Project) project).getPFile() == null) {
                if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                    projectFile = jfc.getSelectedFile();

                } else {
                    return;
                }
            }

            ObjectOutputStream os;
            try {
                os = new ObjectOutputStream(new FileOutputStream(projectFile));
                os.writeObject(project);
                ((Project)project).setPFile(projectFile);
                ((Project)project).setChanged(false);

            }catch (IOException e1) {
                e1.printStackTrace();
            }

        } else {
            RuDokApp.getErrorHandler().generateError(Type.WRONG_NODE);
        }
    }
}
