package strategy.pricing;

public class LongTermPricing implements PricingStrategy {

    @Override
    public String getName() {
        return "Long-term discount (6+ months -10%, 12+ months -15%)";
    }

    @Override
    public double calculate(double monthlyPrice, int months) {
        double total = monthlyPrice * months;
        if (months >= 12) {
            return total * 0.85;
        }
        if (months >= 6) {
            return total * 0.90;
        }
        return total;
    }
}
