package factory.creator;

import factory.product.Membership;
import factory.product.VipMembership;

public class VipMembershipFactory extends MembershipFactory {

    @Override
    public Membership createMembership() {
        return new VipMembership();
    }
}
