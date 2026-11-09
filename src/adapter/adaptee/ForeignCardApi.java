package adapter.adaptee;

/**
 * Adaptee #2 - an international card service.
 * It works in US cents and returns a transaction id instead of true/false.
 */
public class ForeignCardApi {

    public String charge(String cardNumber, long amountInCents, String currency) {
        String lastDigits = cardNumber.substring(cardNumber.length() - 4);
        System.out.println("[ForeignCardApi] Charged " + amountInCents + " " + currency
                + " cents from card ****" + lastDigits);
        return "TX-" + System.currentTimeMillis();
    }
}
