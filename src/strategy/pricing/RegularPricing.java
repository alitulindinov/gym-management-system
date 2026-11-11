package strategy.pricing;

public class RegularPricing implements PricingStrategy {

    @Override
    public String getName() {
        return "Regular price";
    }

    @Override
    public double calculate(double monthlyPrice, int months) {
        return monthlyPrice * months;
    }
}
