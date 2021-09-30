package app.guiSwing.view;



import app.guiSwing.controller.TextFilter;
import app.guiSwing.rightPanelView.DocumentView;
import app.guiSwing.rightPanelView.PageView;
import app.repository.Document;
import app.repository.Page;
import app.repository.Project;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;

public class OpenWs extends WindowAdapter {

    private JFrame dialog;

    public OpenWs(JFrame dialog){
        this.dialog=dialog;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Object[] options = {"Yes","No"};
        int answer =JOptionPane.showOptionDialog(dialog,"Do you want to open previously saved Workspace?","Open previous workspace",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

        if(answer == JOptionPane.YES_OPTION){
            JFileChooser jfc = new JFileChooser();
            jfc.setFileFilter(new TextFilter());

            ArrayList<String> paths = new ArrayList<>();

            if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {

                try {
                    BufferedReader br = new BufferedReader(new FileReader(jfc.getSelectedFile()));

                    String line = br.readLine();

                    while (line != null) {
                        paths.add(line);

                        line = br.readLine();
                    }

                    br.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }

                for (String curr : paths) {
                    try {
                        ObjectInputStream os = new ObjectInputStream(new FileInputStream(curr));

                        Project p = null;
                        try {
                            p = (Project) os.readObject();
                        } catch (ClassNotFoundException el) {
                            el.printStackTrace();
                        }


                        MainFrame.getInstance().getTree().addProject(p);

                        //for (Document d : p.) {

                            //DocumentView documentView = new DocumentView(d);



                            MainFrame.getInstance().getProjectView().addTab();

//                            for (Page page : d.getPages()) {
//                                PageView pageView = new PageView(page);
//                                pageView.setPage(page);
//                            }

                        //}

                    } catch (FileNotFoundException e1) {
                        System.out.println("file not found");
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        System.out.println("i/o exception");
                        e1.printStackTrace();
                    }

                }
            }

        }else if(answer == JOptionPane.NO_OPTION){
            return;
        }
    }
}
