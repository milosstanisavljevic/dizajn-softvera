package app.core;

import app.errorHandler.Type;
import app.observer.IObserver;

public interface ErrorHandler extends IObserver {
    void generateError(Type errorType);
}
