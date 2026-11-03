package factory.product;

public class BasicMembership implements Membership {

    @Override
    public String getName() {
        return "Basic";
    }

    @Override
    public String getDescription() {
        return "Gym floor access (08:00 - 18:00)";
    }

    @Override
    public double getMonthlyPrice() {
        return 10000;
    }
}
