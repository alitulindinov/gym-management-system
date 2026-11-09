package adapter.adaptee;

/**
 * Adaptee #1 - imagine this is a third-party library we can not change.
 * It has its own method name and works with whole tenge (int).
 */
public class KaspiApi {

    public String sendTransfer(String phoneNumber, int tenge) {
        System.out.println("[KaspiApi] Transfer " + tenge + " KZT from " + phoneNumber);
        return "OK";
    }
}
