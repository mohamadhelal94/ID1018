package seminar;

public class Receipt {
    private final Sale sale;
    private final String storeName = "My Store";
    private final String storeAddress = "123 Fake St. 12345 NYC, NY, USA";
    private final Amount amountPaid;
    private final Amount change;


    /**
     * Receipt constructor
     * @param completedSale the sale which the receipt is for.
     */
    public Receipt(Sale completedSale, Amount paid, Amount changeGiven){
        this.sale = completedSale;
        this.amountPaid = paid;
        this.change = changeGiven;
    }

    //getters below

    /**
     * A getter that returns the sale of the receipt.
     * @return the sale
     */
    public Sale getSale(){
        return sale;
    }

    /**
     * Returns the name of the store where the sale took place.
     * @return the name of the store
     */
    public String getStoreName(){ return storeName; }

    /**
     * Returns the address of the store where the sale took place.
     * @return the address of the store
     */
    public String getStoreAddress(){ return storeAddress; }

    /**
     * Returns the {@link Amount} paid by the customer.
     * @return the amount paid by the customer
     */
    public Amount getAmountPaid(){ return amountPaid; }

    /**
     * Returns the {@link Amount} of change given to the customer.
     * @return the amount of change
     */
    public Amount getChange(){ return change; }
}