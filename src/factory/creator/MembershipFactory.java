package factory.creator;

import factory.product.Membership;

/**
 * Creator of the Factory Method pattern.
 * Subclasses decide which concrete Membership to create.
 */
public abstract class MembershipFactory {

    // the factory method
    public abstract Membership createMembership();

    // common logic that uses the factory method
    public Membership issueMembership() {
        Membership membership = createMembership();
        System.out.println("[Factory] Issued " + membership.getName() + " membership");
        return membership;
    }
}
