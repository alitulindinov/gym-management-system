package adapter.adapters;

import adapter.adaptee.ForeignCardApi;
import adapter.target.PaymentProcessor;

/**
 * Adapter: converts tenge to US cents and calls ForeignCardApi.
 */
public class ForeignCardPaymentAdapter implements PaymentProcessor {

    private static final double KZT_PER_USD = 500.0; // fixed rate, just for the demo

    private final ForeignCardApi cardApi;

    public ForeignCardPaymentAdapter(ForeignCardApi cardApi) {
        this.cardApi = cardApi;
    }

    @Override
    public boolean pay(String account, double amountKzt) {
        long cents = Math.round(amountKzt / KZT_PER_USD * 100);
        String transactionId = cardApi.charge(account, cents, "USD");
        return transactionId != null && transactionId.startsWith("TX-");
    }
}
