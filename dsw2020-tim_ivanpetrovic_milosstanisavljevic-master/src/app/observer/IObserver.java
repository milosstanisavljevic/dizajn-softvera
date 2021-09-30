package app.observer;

public interface IObserver {

    void addListener(app.observer.IListener listener);

    void removeListener(app.observer.IListener listener);

    void notifyListeners(Object event);
}
