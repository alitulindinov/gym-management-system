package strategy.pricing;

/**
 * Strategy interface - different ways to calculate the final price.
 */
public interface PricingStrategy {

    String getName();

    double calculate(double monthlyPrice, int months);
}
