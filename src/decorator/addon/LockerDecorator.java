package decorator.addon;

import decorator.base.MembershipDecorator;
import factory.product.Membership;

public class LockerDecorator extends MembershipDecorator {

    private static final double PRICE = 2000;

    public LockerDecorator(Membership membership) {
        super(membership);
    }

    @Override
    public String getDescription() {
        return membership.getDescription() + " + personal locker";
    }

    @Override
    public double getMonthlyPrice() {
        return membership.getMonthlyPrice() + PRICE;
    }
}
