package observer.subscriber;

import factory.product.Membership;

/**
 * Concrete observer - a gym member.
 * A member can subscribe to classes and gets notifications about changes.
 */
public class Member implements GymObserver {

    private final String name;
    private final String phone;
    private Membership membership;

    public Member(String name, String phone, Membership membership) {
        this.name = name;
        this.phone = phone;
        this.membership = membership;
    }

    @Override
    public void update(String message) {
        System.out.println("  [SMS to " + name + " " + phone + "] " + message);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    @Override
    public String toString() {
        return name + " | " + membership.getName() + " | " + membership.getDescription()
                + " | " + membership.getMonthlyPrice() + " KZT/month";
    }
}
