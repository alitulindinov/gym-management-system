package factory.product;

public class PremiumMembership implements Membership {

    @Override
    public String getName() {
        return "Premium";
    }

    @Override
    public String getDescription() {
        return "Gym floor 24/7 + group classes";
    }

    @Override
    public double getMonthlyPrice() {
        return 18000;
    }
}
