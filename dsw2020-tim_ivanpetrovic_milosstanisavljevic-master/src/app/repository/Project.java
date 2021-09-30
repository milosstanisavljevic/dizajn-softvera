package app.repository;


import app.guiSwing.controller.ActionEnum;
import app.repository.node.Node;
import app.repository.node.NodeComposite;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Project extends NodeComposite implements Serializable {


    private static final long serialVersionUID = 4629837184178871630L;
    private ArrayList<Page> pages = new ArrayList<Page>();
    private transient boolean changed;
    private File pFile;

    public Project(String name, Node parent) {

        super(name, parent);
        this.changed = false;
        this.pFile = null;
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
        if (child != null && child instanceof Document) {
            Document document = (Document) child;
            if (!this.getChildren().contains(document)) {
                this.getChildren().add(document);
                this.notifyListeners(ActionEnum.ACTION_ADD);
                this.notifyListeners(ActionEnum.ACTION_RENAME);
                this.notifyListeners(ActionEnum.ACTION_F);
            }

        }
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        if (this.changed!=changed){
            this.changed=changed;
            if(changed == true){
                this.setName("*" + this.getName());
                //this.notifyListeners(ActionEnum.ACTION_RENAME);

            }
            //SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
        }
    }
    public File getPFile() {
        return pFile;
    }

    public void setPFile(File pFile) {
        this.pFile = pFile;
    }
}
