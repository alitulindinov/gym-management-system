package decorator.addon;

import decorator.base.MembershipDecorator;
import factory.product.Membership;

public class PersonalTrainerDecorator extends MembershipDecorator {

    private static final double PRICE = 15000;

    public PersonalTrainerDecorator(Membership membership) {
        super(membership);
    }

    @Override
    public String getDescription() {
        return membership.getDescription() + " + personal trainer";
    }

    @Override
    public double getMonthlyPrice() {
        return membership.getMonthlyPrice() + PRICE;
    }
}
