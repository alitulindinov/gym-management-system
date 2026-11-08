package decorator.addon;

import decorator.base.MembershipDecorator;
import factory.product.Membership;

public class SaunaDecorator extends MembershipDecorator {

    private static final double PRICE = 5000;

    public SaunaDecorator(Membership membership) {
        super(membership);
    }

    @Override
    public String getDescription() {
        return membership.getDescription() + " + sauna";
    }

    @Override
    public double getMonthlyPrice() {
        return membership.getMonthlyPrice() + PRICE;
    }
}
