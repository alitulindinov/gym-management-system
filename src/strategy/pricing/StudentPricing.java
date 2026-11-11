package strategy.pricing;

public class StudentPricing implements PricingStrategy {

    private static final double DISCOUNT = 0.20; // 20% off for students

    @Override
    public String getName() {
        return "Student discount (-20%)";
    }

    @Override
    public double calculate(double monthlyPrice, int months) {
        return monthlyPrice * months * (1 - DISCOUNT);
    }
}
