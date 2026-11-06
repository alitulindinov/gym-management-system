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

    // ---------- helpers ----------

    private static void printTitle(String title) {
        System.out.println();
        System.out.println("=== " + title + " ===");
    }
}
