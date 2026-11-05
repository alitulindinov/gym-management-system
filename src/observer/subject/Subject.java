package observer.subject;

import observer.subscriber.GymObserver;

/**
 * Subject interface of the Observer pattern.
 */
public interface Subject {

    void subscribe(GymObserver observer);

    void unsubscribe(GymObserver observer);

    void notifyObservers(String message);
}
