package app.guiSwing.controller;

import app.guiSwing.view.MainFrame;
import app.guiSwing.view.multimediaSlotView.TextEditorView;
import app.repository.Page;
import app.repository.node.Node;

import java.awt.event.ActionEvent;

public class EditTextListener extends AbstractAppAction {

    @Override
    public void actionPerformed(ActionEvent e) {

        Node item = (MainFrame.getInstance().getTree().getSelectedNode());
        if (item instanceof Page) {
            if (((Page) item).getSelectedSlot() != null) {
                MainFrame mainFrame = MainFrame.getInstance();
                TextEditorView textEditorView = new TextEditorView(mainFrame, ((Page) item).getSelectedSlot());
                textEditorView.setVisible(true);
            }
        }
    }
}
