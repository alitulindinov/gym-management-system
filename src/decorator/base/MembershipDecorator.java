package decorator.base;

import factory.product.Membership;

/**
 * Base decorator of the Decorator pattern.
 * It implements Membership and also HAS a Membership inside (wrappee).
 * By default it just forwards all calls to the wrapped object.
 */
public abstract class MembershipDecorator implements Membership {

    protected final Membership membership;

    protected MembershipDecorator(Membership membership) {
        this.membership = membership;
    }

    @Override
    public String getName() {
        return membership.getName();
    }

    @Override
    public String getDescription() {
        return membership.getDescription();
    }

    @Override
    public double getMonthlyPrice() {
        return membership.getMonthlyPrice();
    }
}
