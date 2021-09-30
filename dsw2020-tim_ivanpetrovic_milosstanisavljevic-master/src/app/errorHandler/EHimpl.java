package app.errorHandler;

import app.core.ErrorHandler;
import app.observer.IListener;

import java.util.ArrayList;
import java.util.List;

public class EHimpl implements ErrorHandler {

    private List<IListener> listeners;

    @Override
    public void generateError(Type errorType) {
        if (errorType == Type.CANNOT_BE_DELETED) {
            notifyListeners(new Error(1, "Can't be deleted", "Error parsing files"));
        }
        if (errorType == Type.SELECT_ITEM) {
            notifyListeners(new Error(2, "Select node", "Node is not selected"));
        }
        if (errorType == Type.WRONG_NODE) {
            notifyListeners(new Error(3, "Wrong Node", "Select other Node"));
        }
    }

    @Override
    public void addListener(IListener listener) {
        if (listeners == null) {
            listeners = new ArrayList<IListener>();
        }
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    @Override
    public void removeListener(IListener listener) {
        if (listener != null) {
            listeners.remove(listener);
        }
    }

    @Override
    public void notifyListeners(Object event) {
        if (listeners == null || listeners.isEmpty() || event == null) {
            return;
        }
        for (IListener listener : listeners) {
            listener.update(event);
        }
    }
}
