package factory.creator;

import factory.product.Membership;
import factory.product.PremiumMembership;

public class PremiumMembershipFactory extends MembershipFactory {

    @Override
    public Membership createMembership() {
        return new PremiumMembership();
    }
}
