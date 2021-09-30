package app.guiSwing.tree.view;

import app.guiSwing.tree.Tree;
import app.guiSwing.tree.model.TreeItem;
import app.guiSwing.view.MainFrame;
import app.repository.*;
import app.repository.node.Node;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class TreeImplementation implements Tree {

    private TreeView treeView;
    private DefaultTreeModel treeModel;

    @Override
    public JTree generateTree(Workspace workspace) {

        TreeItem root = new TreeItem(workspace);
        treeModel = new DefaultTreeModel(root);
        treeView = new TreeView(treeModel);
        return treeView;
    }

    @Override
    public void addProject(Project project) {

        Node nodeModel = ((TreeItem) treeModel.getRoot()).getNodeModel();
        ((TreeItem) treeModel.getRoot()).add(new TreeItem(project));
        ((Workspace) nodeModel).addChild(project);
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void addDocument(Document document) {
        Node nodeModel = getSelectedNode();
        ((TreeItem) treeView.getLastSelectedPathComponent()).add(new TreeItem(document));
        ((Project) nodeModel).addChild(document);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
//        Object o=MainFrame.getInstance().getWorkspaceTree().getSelectionPath().getLastPathComponent();
//        int index=treeModel.getIndexOfChild(treeModel.getRoot(), o);
//        Node nodeModel = ((TreeItem)treeModel.getChild(treeModel.getRoot(), index)).getNodeModel();
//        ((TreeItem)treeModel.getChild(treeModel.getRoot(), index)).add(new TreeItem(document));
//        ((Project) nodeModel).addChild(document);
//        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void addPage(Page page) {
        Node nodeModel = getSelectedNode();
        ((TreeItem) treeView.getLastSelectedPathComponent()).add(new TreeItem(page));
        ((Document) nodeModel).addChild(page);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void addSlot(Slot slot) {
        Node nodeModel = getSelectedNode();
        ((TreeItem) treeView.getLastSelectedPathComponent()).add(new TreeItem(slot));
        ((Page) nodeModel).addChild(slot);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public Node getSelectedNode() {

        return ((TreeItem) treeView.getLastSelectedPathComponent()).getNodeModel();
    }

    @Override
    public void removeCurrentNode(Node node) {
        Node n = node.getParent();
        if (node instanceof Project) {
            ((Workspace) n).getChildren().remove(node);
        }
        if (node instanceof Document) {
            ((Project) n).getChildren().remove(node);
        }
        if (node instanceof Page) {
            ((Document) n).getChildren().remove(node);
        }
        if (node instanceof Slot) {
            ((Page) n).getChildren().remove(node);
        }
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void insert(Node node) {
        Object o = MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
        int index = treeModel.getIndexOfChild(treeModel.getRoot(), o);
        Node nodeModel = ((TreeItem) treeModel.getChild(treeModel.getRoot(), index)).getNodeModel();
        ((TreeItem) treeModel.getChild(treeModel.getRoot(), index)).add(new TreeItem(node));
        ((Project) nodeModel).addChild(node);
        SwingUtilities.updateComponentTreeUI(treeView);
    }
}
