package app.guiSwing.tree;

import app.repository.*;
import app.repository.node.Node;

import javax.swing.*;

public interface Tree {
    JTree generateTree(Workspace workspace);

    void addProject(Project project);

    void addDocument(Document document);

    void addPage(Page page);

    void addSlot(Slot slot);

    void removeCurrentNode(Node node);

    Node getSelectedNode();

    void insert(Node node);

}
