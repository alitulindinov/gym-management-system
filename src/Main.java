import adapter.adaptee.ForeignCardApi;
import adapter.adaptee.KaspiApi;
import adapter.adapters.ForeignCardPaymentAdapter;
import adapter.adapters.KaspiPaymentAdapter;
import adapter.target.PaymentProcessor;
import decorator.addon.LockerDecorator;
import decorator.addon.PersonalTrainerDecorator;
import decorator.addon.SaunaDecorator;
import factory.creator.BasicMembershipFactory;
import factory.creator.MembershipFactory;
import factory.creator.PremiumMembershipFactory;
import factory.creator.VipMembershipFactory;
import factory.product.Membership;
import singleton.GymDatabase;

/**
 * Gym Management System - final project.
 * Team: Kaisar, Darkhan, Ali.
 *
 * Main is the only class outside of the pattern packages.
 * It tests every pattern one by one and then shows how they work together.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("===== GYM MANAGEMENT SYSTEM =====");

        testSingleton();
        testFactoryMethod();
        testDecorator();
        testAdapter();
    }

    // ---------- Kaisar: creational patterns ----------

    private static void testSingleton() {
        printTitle("1. SINGLETON (creational) - GymDatabase");
        GymDatabase db1 = GymDatabase.getInstance();
        GymDatabase db2 = GymDatabase.getInstance();
        System.out.println("db1 == db2 ? " + (db1 == db2));
    }

    private static void testFactoryMethod() {
        printTitle("2. FACTORY METHOD (creational) - memberships");
        MembershipFactory[] factories = {
                new BasicMembershipFactory(),
                new PremiumMembershipFactory(),
                new VipMembershipFactory()
        };
        for (MembershipFactory factory : factories) {
            Membership membership = factory.issueMembership();
            System.out.println("   " + membership.getDescription() + " -> " + membership.getMonthlyPrice() + " KZT");
        }
    }

    // ---------- Darkhan: structural patterns ----------

    private static void testDecorator() {
        printTitle("3. DECORATOR (structural) - add-ons for membership");
        Membership membership = new BasicMembershipFactory().createMembership();
        System.out.println("Before: " + membership.getDescription() + " = " + membership.getMonthlyPrice());

        membership = new SaunaDecorator(membership);
        membership = new PersonalTrainerDecorator(membership);
        membership = new LockerDecorator(membership);
        System.out.println("After:  " + membership.getDescription() + " = " + membership.getMonthlyPrice());
    }

    private static void testAdapter() {
        printTitle("5. ADAPTER (structural) - payment systems");
        PaymentProcessor kaspi = new KaspiPaymentAdapter(new KaspiApi());
        PaymentProcessor card = new ForeignCardPaymentAdapter(new ForeignCardApi());

        System.out.println("Kaspi payment success: " + kaspi.pay("+77011234567", 18000));
        System.out.println("Card payment success:  " + card.pay("4400123456789012", 18000));
    }

    // ---------- helpers ----------

    private static void printTitle(String title) {
        System.out.println();
        System.out.println("=== " + title + " ===");
    }
}
