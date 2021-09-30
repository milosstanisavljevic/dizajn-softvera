package app.guiSwing.view;

import app.RuDokApp;
import app.errorHandler.Type;
import app.guiSwing.controller.TextFilter;
import app.repository.Project;
import app.repository.Workspace;
import app.repository.node.Node;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class SaveWs extends WindowAdapter {

    private JFrame dialog;
    private Workspace ws = MainFrame.getInstance().getWorkspace();
    public SaveWs(JFrame dialog){
        this.dialog=dialog;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Object[]choice = {"Yes","No","Cancel"};
        int answer = JOptionPane.showOptionDialog(dialog,"Do you want to save current workspace?","exit",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);

        if(answer == JOptionPane.YES_OPTION){


            JFileChooser jfc = new JFileChooser();
            jfc.setFileFilter(new TextFilter());

            File workspaceFile = ws.getWorkspaceFile();

            if (workspaceFile == null) {
                if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                    workspaceFile = jfc.getSelectedFile();
                    ws.setWorkspaceFile(workspaceFile);

                    for (Node p : ws.getChildren()) {
                        File projectFile = ((Project) p).getPFile();
                        if (projectFile == null) {
                            RuDokApp.getErrorHandler().generateError(Type.WRONG_NODE);
                            return;
                        }
                    }

                }else {
                    return;
                }
            }
            MainFrame.getInstance().getWorkspace().writeInWFile(workspaceFile);

            dialog.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        else if(answer == JOptionPane.NO_OPTION){
            dialog.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }else{
            return;
        }
    }
}
