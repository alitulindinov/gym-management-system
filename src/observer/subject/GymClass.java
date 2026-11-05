package observer.subject;

import observer.subscriber.GymObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete subject - a group class in the gym (yoga, boxing, ...).
 * When the schedule changes, all subscribed observers get a message.
 */
public class GymClass implements Subject {

    private final String title;
    private final String trainer;
    private String time;
    private final List<GymObserver> observers = new ArrayList<>();

    public GymClass(String title, String trainer, String time) {
        this.title = title;
        this.trainer = trainer;
        this.time = time;
    }

    @Override
    public void subscribe(GymObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unsubscribe(GymObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (GymObserver observer : observers) {
            observer.update(message);
        }
    }

    public void changeTime(String newTime) {
        String oldTime = time;
        time = newTime;
        notifyObservers(title + " moved from " + oldTime + " to " + newTime);
    }

    public void cancel(String reason) {
        notifyObservers(title + " at " + time + " is cancelled: " + reason);
    }

    public String getTitle() {
        return title;
    }

    public int getSubscribersCount() {
        return observers.size();
    }

    @Override
    public String toString() {
        return title + " with " + trainer + " at " + time + " (" + observers.size() + " subscribers)";
    }
}
