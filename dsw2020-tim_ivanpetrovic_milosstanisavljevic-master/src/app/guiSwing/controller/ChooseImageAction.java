package app.guiSwing.controller;

import app.guiSwing.view.MainFrame;
import app.guiSwing.view.multimediaSlotView.ImageSlotView;
import app.repository.Page;
import app.repository.node.Node;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class ChooseImageAction extends AbstractAppAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new ImageFilter());

        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {

            String path = jfc.getSelectedFile().getAbsolutePath();

            Node item = (MainFrame.getInstance().getTree().getSelectedNode());
            if (item instanceof Page) {
                if (((Page) item).getSelectedSlot() != null) {
                    MainFrame mainFrame = MainFrame.getInstance();
                    ((Page) item).getSelectedSlot().setFile(new File(path));

                    ImageSlotView imageSlotView = new ImageSlotView(((Page) item).getSelectedSlot());
                    imageSlotView.setVisible(true);
                }
            }
        }
    }
}
