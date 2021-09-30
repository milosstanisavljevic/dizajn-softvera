package app.repository.node;

import app.guiSwing.controller.ActionEnum;
import app.observer.IObserver;
import lombok.ToString;

import java.io.Serializable;


public abstract class Node implements IObserver, Serializable {
    private String name;
    @ToString.Exclude
    private Node parent;

    public Node(String name, Node parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Node) {
            Node o2 = (Node) o;
            return this.getName().equals(o2.getName());
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.notifyListeners(ActionEnum.ACTION_RENAME);
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
