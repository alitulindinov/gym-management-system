package factory.product;

/**
 * Product interface of the Factory Method pattern.
 * Every membership type in the gym implements this interface.
 */
public interface Membership {

    String getName();

    String getDescription();

    double getMonthlyPrice();
}
