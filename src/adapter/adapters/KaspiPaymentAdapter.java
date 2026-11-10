package adapter.adapters;

import adapter.adaptee.KaspiApi;
import adapter.target.PaymentProcessor;

/**
 * Adapter: makes KaspiApi look like PaymentProcessor.
 */
public class KaspiPaymentAdapter implements PaymentProcessor {

    private final KaspiApi kaspiApi;

    public KaspiPaymentAdapter(KaspiApi kaspiApi) {
        this.kaspiApi = kaspiApi;
    }

    @Override
    public boolean pay(String account, double amountKzt) {
        int tenge = (int) Math.round(amountKzt);
        String result = kaspiApi.sendTransfer(account, tenge);
        return "OK".equals(result);
    }
}
