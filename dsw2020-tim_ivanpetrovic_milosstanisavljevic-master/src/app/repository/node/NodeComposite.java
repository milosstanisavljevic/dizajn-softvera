package app.repository.node;


import app.observer.IListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public abstract class NodeComposite extends Node implements Serializable {

    List<Node> children;
    transient private ArrayList<IListener> listeners;

    public NodeComposite(String name, Node parent) {
        super(name, parent);
        this.children = new ArrayList<>();
        this.listeners = new ArrayList<IListener>();
    }

    public NodeComposite(String name, Node parent, List<Node> children) {
        super(name, parent);
        this.children = new ArrayList<>();
    }

    private Object readResolve(){
        listeners = new ArrayList<>();
        return this;
    }

    public abstract NodeComposite getChildAt(int index);


    public abstract int getChildCount();

    public abstract void addChild(Node child);

    public Node getChildByName(String name) {
        for (Node child : this.getChildren()) {
            if (name.equals(child.getName())) {
                return child;
            }
        }
        return null;
    }

    //public abstract int getIndex(Node aChild);

    public List<Node> getChildren() {
        return children;
    }

    @Override
    public void addListener(IListener listener) {
        if (listener == null) return;
        if (listeners == null) listeners = new ArrayList<IListener>();
        if (listeners.contains(listener)) return;
        listeners.add(listener);

    }

    @Override
    public void removeListener(IListener listener) {
        if (listener == null || listeners == null || !listeners.contains(listener))
            return;
        listeners.remove(listener);
    }

    @Override
    public void notifyListeners(Object event) {
        if (this.listeners == null || this.listeners.isEmpty() || event == null)
            return;
        for (IListener l : listeners) {
            l.update(event);
        }
    }
}


