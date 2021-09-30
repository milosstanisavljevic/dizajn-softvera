package app.guiSwing;

import app.core.ErrorHandler;
import app.core.GUI;
import app.core.Repository;
import app.errorHandler.Error;
import app.guiSwing.view.MainFrame;

public class SwingGUI implements GUI {

    private MainFrame instance;
    private final Repository documentRepository;
    private ErrorHandler errorHandler;

    public SwingGUI(Repository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public void start() {
        instance = MainFrame.getInstance();
        instance.setDocumentRepository(documentRepository);
        instance.initialiseWorkspaceTree();
        instance.setVisible(true);
    }

    @Override
    public void update(Object update) {
        if (update instanceof Error) {
            MainFrame.getInstance().showError((Error) update);
        }
    }
}