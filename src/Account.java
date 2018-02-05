public class Account {
    private int accoutNumber;
    private String owner;
    private double balance;
    private boolean isTesting = true;

    public Account(int accoutNumber, String owner, double balance) {

        if(accoutNumber > 0)
        {
            this.accoutNumber = accoutNumber;
        }
        else
        {
            throw new IllegalArgumentException("Account Number: " + accoutNumber + " cannot be negative!");
        }

        this.owner = owner;

        if (balance > 0)
        {
            this.balance = balance;
        }
        else
        {
            throw new IllegalArgumentException("Balance: " + balance + " cannot be negative!");
        }

    }

    public int getAccoutnNumber() {
        return accoutNumber;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
