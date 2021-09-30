package app.core;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public abstract class ApplicationFramework {

    protected GUI gui;
    protected Repository repository;
    protected ErrorHandler errorHandler;
    protected SlotHandler slotHandler;

    public abstract void run();

    public void initialise(GUI gui, Repository repository, ErrorHandler errorHandler,SlotHandler slotHandler) {
        this.gui = gui;
        this.repository = repository;
        this.errorHandler = errorHandler;
        this.slotHandler = slotHandler;
        this.errorHandler.addListener(gui);
    }
}