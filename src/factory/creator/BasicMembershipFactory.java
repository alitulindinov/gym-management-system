package factory.creator;

import factory.product.BasicMembership;
import factory.product.Membership;

public class BasicMembershipFactory extends MembershipFactory {

    @Override
    public Membership createMembership() {
        return new BasicMembership();
    }
}
