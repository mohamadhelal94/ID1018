package seminar;

public class Amount {

    private double value;

    /**
     * constructor used if given a double to specify amount
     * @param doubleValue the value that the object should have
     */
    public Amount(double doubleValue){
        this.value = doubleValue;
    }

    /**
     * constructor used if given an integer to specify amount
     * @param intValue the value that the object should have
     */
    public Amount(int intValue){
        this.value = intValue;
    }

    //getters
    /**
     * returns the double value held by an instance of {@link Amount}
     * @return the double value contained within the {@link Amount}
     */
    public double getValue(){
        return value;
    }

    //setters
    /**
     * Set the amount in an instance of {@link Amount}
     * @param value the value we wish to assign to the {@link Amount} instance.
     */
    public void setValue(double value){
        this.value = value;
    }

    /**
     * Same as the other {@code setAmount} method, but takes an integer instead.
     * @param amount the amount we wish to assign to the {@link Amount} instance.
     */
    public void setValue(int amount){
        this.value = amount;
    }

    /**
     * Takes an {@link Amount} and rounds it to a maximum of 2 decimal places.
     * @param amountToRound
     * @return a new instance of {@link Amount} with a rounded value.
     */
    public Amount roundOff(double amountToRound){
        double roundedNumber = (double) Math.round(amountToRound * 100) / 100;
        return new Amount(roundedNumber);
    }
}
