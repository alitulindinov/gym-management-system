package strategy.context;

import factory.product.Membership;
import strategy.pricing.PricingStrategy;

/**
 * Context of the Strategy pattern.
 * It does not know HOW the price is calculated - it just asks the current strategy.
 */
public class PriceCalculator {

    private PricingStrategy strategy;

    public PriceCalculator(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    // strategy can be changed at runtime
    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateTotal(Membership membership, int months) {
        return strategy.calculate(membership.getMonthlyPrice(), months);
    }

    public String getStrategyName() {
        return strategy.getName();
    }
}
