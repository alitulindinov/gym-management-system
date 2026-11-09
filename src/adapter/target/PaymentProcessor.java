package adapter.target;

/**
 * Target interface of the Adapter pattern.
 * Our gym system only knows how to work with this interface.
 */
public interface PaymentProcessor {

    // amount is always in tenge (KZT)
    boolean pay(String account, double amountKzt);
}
