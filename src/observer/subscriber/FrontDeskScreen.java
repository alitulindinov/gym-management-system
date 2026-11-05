package observer.subscriber;

/**
 * Concrete observer - the screen at the gym reception.
 * It shows every schedule change to people in the lobby.
 */
public class FrontDeskScreen implements GymObserver {

    @Override
    public void update(String message) {
        System.out.println("  [Front desk screen] " + message);
    }
}
