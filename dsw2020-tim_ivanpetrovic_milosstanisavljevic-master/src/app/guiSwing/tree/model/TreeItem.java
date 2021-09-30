package app.guiSwing.tree.model;

import app.repository.node.Node;
import app.repository.node.NodeComposite;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.Iterator;

public class TreeItem extends DefaultMutableTreeNode {

    private String name;
    private Node nodeModel;

    public TreeItem(Node nodeModel) {
        this.nodeModel = nodeModel;
        this.name = nodeModel.getName();
    }

    public TreeItem(String name, Node nodeModel) {
        this.name = name;
        this.nodeModel = nodeModel;
    }

    public String getName() {
        return name;
    }

    public Node getNodeModel() {
        return nodeModel;
    }

    public void setName(String name) {
        this.name = name;
        this.nodeModel.setName(name);
    }

    public void setNodeModel(Node nodeModel) {
        this.nodeModel = nodeModel;
    }

    @Override
    public int getIndex(TreeNode node) {
        return findIndexByChild((TreeItem) node);
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return findChildByIndex(childIndex);
    }

    @Override
    public int getChildCount() {
        if (nodeModel instanceof NodeComposite)
            return ((NodeComposite) nodeModel).getChildren().size();
        return 0;
    }

    @Override
    public boolean getAllowsChildren() {
        return nodeModel instanceof NodeComposite;
    }

    @Override
    public boolean isLeaf() {
        return !(nodeModel instanceof NodeComposite);
    }

    @Override
    public Enumeration children() {
        if (nodeModel instanceof NodeComposite)
            return (Enumeration) ((NodeComposite) nodeModel).getChildren();
        return null;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof TreeItem) {
            TreeItem otherObj = (TreeItem) obj;
            return this.nodeModel.equals(otherObj.nodeModel);
        }
        return false;
    }

    private TreeNode findChildByIndex(int childIndex) {

        if (nodeModel instanceof NodeComposite) {
            TreeItem toLookFor = new TreeItem(((NodeComposite) nodeModel).getChildren().get(childIndex));

            Iterator childrenIterator = children.iterator();
            TreeNode current;

            while (childrenIterator.hasNext()) {
                current = (TreeNode) childrenIterator.next();
                if (current.equals(toLookFor))
                    return current;
            }
        }
        return null;
    }

    private int findIndexByChild(TreeItem node) {

        if (this.nodeModel instanceof NodeComposite) {
            return ((NodeComposite) this.nodeModel).getChildren().indexOf(node.getNodeModel());
        }


        return -1;
    }

    @Override
    public String toString() {
        return name;
    }

}
