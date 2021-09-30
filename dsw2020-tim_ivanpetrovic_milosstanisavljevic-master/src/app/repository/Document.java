package app.repository;

import app.guiSwing.controller.ActionEnum;
import app.repository.node.Node;
import app.repository.node.NodeComposite;

import java.io.Serializable;
import java.util.ArrayList;

public class Document extends NodeComposite implements Serializable {

    private ArrayList<Page> pages = new ArrayList<>();
    public Document(String name, Node parent) {
        super(name, parent);
    }

    @Override
    public NodeComposite getChildAt(int index) {
        return (NodeComposite) this.getChildren().get(index);
    }

    @Override
    public int getChildCount() {
        return this.getChildren().size();
    }

    @Override
    public void addChild(Node child) {
        if (child != null && child instanceof Page) {
            Page page = (Page) child;
            if (!this.getChildren().contains(page)) {
                this.getChildren().add(page);
                pages.add(page);
                this.notifyListeners(ActionEnum.ACTION_ADD);
                this.notifyListeners(ActionEnum.ACTION_RENAME);
            }
        }
    }

    public ArrayList<Page> getPages() {
        return pages;
    }
}
