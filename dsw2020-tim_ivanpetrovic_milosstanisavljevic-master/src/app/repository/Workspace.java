package app.repository;

import app.repository.node.Node;
import app.repository.node.NodeComposite;
import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;

@Getter
public class Workspace extends NodeComposite implements Serializable {

    private File workspaceFile;

    public Workspace(String name) {
        super(name, null);
    }

    @Override
    public NodeComposite getChildAt(int index) {
        return null;
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public void addChild(Node child) {
        if (child != null && child instanceof Project) {
            Project project = (Project) child;
            if (!this.getChildren().contains(project)) {
                this.getChildren().add(project);
            }
        }
    }

    public File getWorkspaceFile() {
        return workspaceFile;
    }

    public void setWorkspaceFile(File workspaceFile) {
        this.workspaceFile = workspaceFile;
    }
    public void writeInWFile(File file){

        try {
            PrintWriter out = new PrintWriter(file.getAbsolutePath());

            for (Node child: this.getChildren()) {
                out.println(((Project)child).getPFile().getAbsolutePath());

            }
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("Fajl nije ucitan");
        }

    }

}
