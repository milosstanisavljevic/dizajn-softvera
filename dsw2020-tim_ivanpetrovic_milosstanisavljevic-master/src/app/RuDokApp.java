package app;

import app.core.ApplicationFramework;
import app.core.ErrorHandler;
import app.core.GUI;
import app.core.Repository;
import app.errorHandler.EHimpl;
import app.guiSwing.SwingGUI;
import app.repository.RepositoryImplementation;
import app.core.SlotHandler;
import app.repository.slothandler.SlotHandlerImpl;

public class RuDokApp extends ApplicationFramework {

    private static RuDokApp instance;

    private RuDokApp() {

    }

    public static RuDokApp getInstance() {

        if (instance == null) {
            instance = new RuDokApp();
        }
        return instance;
    }

    @Override
    public void run() {
        this.gui.start();
    }


    public static void main(String[] args) {

        Repository r = new RepositoryImplementation();
        GUI gui = new SwingGUI(r);
        ErrorHandler errorHandler = new EHimpl();
        SlotHandler slotHandler = new SlotHandlerImpl();
        ApplicationFramework app = RuDokApp.getInstance();
        app.initialise(gui, r, errorHandler,slotHandler);
        app.run();

    }

    public static ErrorHandler getErrorHandler() {
        return instance.errorHandler;
    }
    public static SlotHandler getSlotHandler(){
        return instance.slotHandler;
    }
}