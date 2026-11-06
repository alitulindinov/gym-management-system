package singleton;

import observer.subject.GymClass;
import observer.subscriber.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton pattern.
 * The gym has only one database, so only one instance of this class can exist.
 */
public class GymDatabase {

    private static GymDatabase instance;

    private final List<Member> members = new ArrayList<>();
    private final List<GymClass> classes = new ArrayList<>();

    // private constructor - nobody can call "new GymDatabase()" from outside
    private GymDatabase() {
        System.out.println("[Singleton] GymDatabase created");
    }

    public static synchronized GymDatabase getInstance() {
        if (instance == null) {
            instance = new GymDatabase();
        }
        return instance;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void addClass(GymClass gymClass) {
        classes.add(gymClass);
    }

    public Member findMemberByName(String name) {
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }

    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }

    public List<GymClass> getClasses() {
        return new ArrayList<>(classes);
    }

    public void printReport() {
        System.out.println("---- Gym report ----");
        System.out.println("Members: " + members.size());
        for (Member member : members) {
            System.out.println("  " + member);
        }
        System.out.println("Classes: " + classes.size());
        for (GymClass gymClass : classes) {
            System.out.println("  " + gymClass);
        }
    }
}
