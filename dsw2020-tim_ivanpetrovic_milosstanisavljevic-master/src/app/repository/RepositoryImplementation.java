package app.repository;

import app.core.Repository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RepositoryImplementation implements Repository {

    private Workspace root;

    public RepositoryImplementation() {
        root = new Workspace("Workspace");
    }

    @Override
    public Workspace getWorkspace() {
        return root;
    }
}