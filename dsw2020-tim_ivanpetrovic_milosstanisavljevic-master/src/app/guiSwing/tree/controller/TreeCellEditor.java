package app.guiSwing.tree.controller;

import app.guiSwing.tree.model.TreeItem;
import app.repository.*;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class TreeCellEditor extends DefaultTreeCellEditor implements ActionListener {

    private Object clickedOn = null;
    private JTextField edit = null;

    public TreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
        super(arg0, arg1);
    }

    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {

        clickedOn = arg1;
        edit = new JTextField(arg1.toString());
        edit.addActionListener(this);
        return edit;
    }

    public boolean isCellEditable(EventObject arg0) {
        if (arg0 instanceof MouseEvent)
            return ((MouseEvent) arg0).getClickCount() == 3;
        return false;
    }

    public void actionPerformed(ActionEvent e) {

        if (!(clickedOn instanceof TreeItem))
            return;

        TreeItem clicked = (TreeItem) clickedOn;

        if (clicked.getNodeModel() instanceof Workspace) {
            clicked.setName(e.getActionCommand());
            clicked.getNodeModel().setName(e.getActionCommand());
        }
        if (clicked.getNodeModel() instanceof Project) {
            clicked.setName(e.getActionCommand());
            clicked.getNodeModel().setName(e.getActionCommand());
        }
        if (clicked.getNodeModel() instanceof Document) {
            clicked.setName(e.getActionCommand());
            clicked.getNodeModel().setName(e.getActionCommand());
        }
        if (clicked.getNodeModel() instanceof Page) {
            clicked.setName(e.getActionCommand());
            clicked.getNodeModel().setName(e.getActionCommand());
        }
        if (clicked.getNodeModel() instanceof Slot) {
            clicked.setName(e.getActionCommand());
            clicked.getNodeModel().setName(e.getActionCommand());
        }

    }
}

