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
import observer.subject.GymClass;
import observer.subscriber.FrontDeskScreen;
import observer.subscriber.Member;
import singleton.GymDatabase;
import strategy.context.PriceCalculator;
import strategy.pricing.LongTermPricing;
import strategy.pricing.RegularPricing;
import strategy.pricing.StudentPricing;

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
        testStrategy();
        testAdapter();
        testObserver();
        fullScenario();
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

    // ---------- Ali: behavioral patterns ----------

    private static void testStrategy() {
        printTitle("4. STRATEGY (behavioral) - pricing");
        Membership premium = new PremiumMembershipFactory().createMembership();
        PriceCalculator calculator = new PriceCalculator(new RegularPricing());
        int months = 12;

        printPrice(calculator, premium, months);
        calculator.setStrategy(new StudentPricing());
        printPrice(calculator, premium, months);
        calculator.setStrategy(new LongTermPricing());
        printPrice(calculator, premium, months);
    }

    private static void testObserver() {
        printTitle("6. OBSERVER (behavioral) - class schedule notifications");
        GymClass boxing = new GymClass("Boxing", "Coach Arman", "18:00");
        Member aigerim = new Member("Aigerim", "+77010000001", new BasicMembershipFactory().createMembership());
        Member timur = new Member("Timur", "+77010000002", new BasicMembershipFactory().createMembership());

        boxing.subscribe(aigerim);
        boxing.subscribe(timur);
        boxing.subscribe(new FrontDeskScreen());

        System.out.println("Schedule change:");
        boxing.changeTime("19:30");

        boxing.unsubscribe(timur);
        System.out.println("Timur unsubscribed. Cancelling class:");
        boxing.cancel("coach is sick");
    }

    // ---------- all patterns together ----------

    private static void fullScenario() {
        printTitle("7. FULL SCENARIO - all 6 patterns together");
        GymDatabase db = GymDatabase.getInstance();                     // Singleton

        Membership membership = new VipMembershipFactory().issueMembership(); // Factory Method
        membership = new PersonalTrainerDecorator(membership);          // Decorator
        Member dana = new Member("Dana", "+77015556677", membership);
        db.addMember(dana);

        Member erlan = new Member("Erlan", "+77019998877",
                new SaunaDecorator(new BasicMembershipFactory().issueMembership()));
        db.addMember(erlan);

        PriceCalculator calculator = new PriceCalculator(new LongTermPricing()); // Strategy
        double total = calculator.calculateTotal(dana.getMembership(), 6);
        System.out.println("Dana pays for 6 months (" + calculator.getStrategyName() + "): " + total + " KZT");

        PaymentProcessor payment = new KaspiPaymentAdapter(new KaspiApi()); // Adapter
        if (payment.pay(dana.getPhone(), total)) {
            System.out.println("Payment received, welcome Dana!");
        }

        GymClass yoga = new GymClass("Yoga", "Coach Madina", "09:00");  // Observer
        yoga.subscribe(dana);
        yoga.subscribe(erlan);
        db.addClass(yoga);
        yoga.changeTime("10:00");

        System.out.println();
        db.printReport();
        System.out.println("Find 'erlan' in database: " + db.findMemberByName("erlan").getName());
    }

    // ---------- helpers ----------

    private static void printPrice(PriceCalculator calculator, Membership membership, int months) {
        double total = calculator.calculateTotal(membership, months);
        System.out.println(calculator.getStrategyName() + ": " + months + " months = " + total + " KZT");
    }

    private static void printTitle(String title) {
        System.out.println();
        System.out.println("=== " + title + " ===");
    }
}
