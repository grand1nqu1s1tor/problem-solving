package vending

public class PaymentProcessor{
    private List<Coin> insertedCoins = new ArrayList<>();
    private int currentBalance = 0;

    public void insertCoins(){}
    // Returns the current accumulated balance
    public int getCurrentBalance(){}
    // Checks if enough money has been inserted
    public boolean isSufficient(){}
    // Refunds all inserted coins
    public List<Coin> refund(){}
    // Returns optimal change using largest denominations first
    public List<Coin> getChange(){}

}