package app.guiSwing.view.multimediaSlotView;

import app.repository.elements.SlotDevice;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditorView extends JDialog {

    SlotDevice slot;
    private JToolBar toolBar = new JToolBar();
    JTextPane textPane = new JTextPane();

    public TextEditorView(Frame owner, SlotDevice mySlot) {
        this.slot = mySlot;
        this.setLocationRelativeTo(owner);
        this.add(textPane, BorderLayout.CENTER);
        this.add(toolBar, BorderLayout.NORTH);
        textPane.setText(slot.getText());
        JButton bold = new JButton(new StyledEditorKit.BoldAction());
        JButton italic = new JButton(new StyledEditorKit.ItalicAction());
        JButton underline = new JButton(new StyledEditorKit.UnderlineAction());
        JButton save = new JButton("Save");

        save.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textPane.getText());
                slot.writeInFile(textPane.getText());
                slot.setText(textPane.getText());
                TextSlotView textSlotView = new TextSlotView(slot);
                textSlotView.setVisible(true);
            }
        });

        toolBar.add(bold);
        toolBar.add(italic);
        toolBar.add(underline);
        toolBar.add(save);

        this.setSize(300, 250);
    }
}