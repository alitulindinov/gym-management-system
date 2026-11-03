package factory.product;

public class VipMembership implements Membership {

    @Override
    public String getName() {
        return "VIP";
    }

    @Override
    public String getDescription() {
        return "Gym floor 24/7 + group classes + pool + free towel";
    }

    @Override
    public double getMonthlyPrice() {
        return 30000;
    }
}
