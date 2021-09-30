package app.guiSwing.controller;

import app.RuDokApp;
import app.errorHandler.Type;
import app.guiSwing.view.MainFrame;
import app.guiSwing.view.multimediaSlotView.TextSlotView;
import app.repository.Page;
import app.repository.elements.SlotType;
import app.repository.node.Node;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class TextButtonListener extends AbstractAppAction{


    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new TextFilter());

        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {

            String path = jfc.getSelectedFile().getAbsolutePath();
            Node item = (MainFrame.getInstance().getTree().getSelectedNode());

            if (item instanceof Page) {
                if (((Page) item).getSelectedSlot() != null) {

                    MainFrame mainFrame = MainFrame.getInstance();
                    ((Page) item).getSelectedSlot().setType(SlotType.TYPE_TEXT);
                    ((Page) item).getSelectedSlot().setFile(new File(path));
                    TextSlotView textSlotView = new TextSlotView(((Page) item).getSelectedSlot());
                    textSlotView.setVisible(true);
                } else {
                    RuDokApp.getErrorHandler().generateError(Type.WRONG_NODE);
                }
            }
        }
    }
}
