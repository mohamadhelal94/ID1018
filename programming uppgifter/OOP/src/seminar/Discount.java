package seminar;

public class Discount {
    private final int customerID;
    private final double discountFactor;

    /**
     * A constructor for {@link Discount}
     * @param customerID the customer ID to be associated with the discount.
     * @param discountFactor the effect of the discount.
     */
    public Discount(int customerID, double discountFactor){
        this.customerID = customerID;
        this.discountFactor = discountFactor;
    }

    /**
     * Gets the customer ID associated with an instance of {@link Discount}.
     * @return the customer ID
     */
    public int getCustomerID(){
        return customerID;
    }

    /**
     * Gets a discount factor associated with an instance of {@link Discount}.
     * @return the discount factor
     */
    public double getDiscountFactor(){
        return discountFactor;
    }
}