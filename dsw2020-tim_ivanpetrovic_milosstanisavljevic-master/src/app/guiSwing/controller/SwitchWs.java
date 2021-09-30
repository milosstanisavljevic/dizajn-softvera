package app.guiSwing.controller;

import app.guiSwing.view.MainFrame;
import app.repository.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

public class SwitchWs extends AbstractAppAction{
    public SwitchWs() {

        putValue(NAME, "Switch");
        putValue(SHORT_DESCRIPTION, "switch");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
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
    }
}
