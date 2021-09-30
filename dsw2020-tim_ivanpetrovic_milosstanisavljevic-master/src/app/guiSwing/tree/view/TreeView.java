package app.guiSwing.tree.view;

import app.guiSwing.tree.controller.TSelectionListener;
import app.guiSwing.tree.controller.TreeCellEditor;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class TreeView extends JTree {

    public TreeView(DefaultTreeModel defaultTreeModel) {

        setModel(defaultTreeModel);
        TreeCellRenderer ruTreeCellRenderer = new TreeCellRenderer();
        addTreeSelectionListener(new TSelectionListener());
        setCellEditor(new TreeCellEditor(this, ruTreeCellRenderer) {
        });
        setCellRenderer(ruTreeCellRenderer);
        setEditable(true);
    }
}
