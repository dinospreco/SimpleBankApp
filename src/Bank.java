import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private static int numberOfAccounts;

    Bank()
    {
        this.numberOfAccounts = 0;
    }

    Bank(int bilosta)
    {
        try
        {
            accounts.add(new Account(1, "Dino", 1000000));
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }

        try
        {
            accounts.add(new Account(2, "Sipo", 1000000));
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }

        try
        {
            accounts.add(new Account(3, "Amer", 10));
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }

        this.numberOfAccounts = 3;
    }

    public static int getNumberOfAccounts()
    {
        return numberOfAccounts;
    }

    public void addAccount(int accountNumber, String owner, double balance)
    {
        try
        {
            for (Account acc : accounts)
            {
                if (acc.getAccoutnNumber() == accountNumber)
                {
                    throw new IllegalArgumentException("Account number: " + accountNumber + " already exists!");
                }
            }

            accounts.add(new Account(accountNumber,owner,balance));
            numberOfAccounts++;
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
    }

    public void transfer (int source, int target, double amount)
    {
        int indexOfSourceAcc = -1;
        int indexOfTargetAcc = -1;
        Account targetAcc;
        Account sourceAcc;
        if (source == target) {
            throw new IllegalArgumentException("You can't transfer money to same account.");
        }
        for (Account acc: accounts)
        {
            if (acc.getAccoutnNumber() == source)
            {
                indexOfSourceAcc = accounts.indexOf(acc);
            }
        }

        if (indexOfSourceAcc < 0)
        {
            throw new IllegalArgumentException("Source account number: " + source + " does not exists!");
        }

        for (Account acc: accounts)
        {
            if (acc.getAccoutnNumber() == target)
            {
                indexOfTargetAcc = accounts.indexOf(acc);
            }
        }

        if (indexOfTargetAcc < 0)
        {
            throw new IllegalArgumentException("Target account number: " + target + " does not exists!");
        }

        if(accounts.get(indexOfSourceAcc).getBalance() > amount)
        {
            targetAcc = accounts.get(indexOfTargetAcc);
            sourceAcc = accounts.get(indexOfSourceAcc);

            targetAcc.setBalance(targetAcc.getBalance() + amount);
            sourceAcc.setBalance(sourceAcc.getBalance() - amount);
        }
        else
        {
            throw new IllegalArgumentException("Not enough money on " + source + " account!");
        }
    }

    public void printAllInfo()
    {
        for (Account acc: accounts)
        {
            System.out.println("Owner: " + acc.getOwner());
            System.out.println("Account Number: " + acc.getAccoutnNumber());
            System.out.println("Balance: " + acc.getBalance());
            System.out.println();
        }
    }

    public void printAccInfo(int accNumber)
    {
        boolean found = false;
        for (Account acc : accounts)
        {
            if (acc.getAccoutnNumber() == accNumber)
            {
                System.out.println("Owner: " + acc.getOwner());
                System.out.println("Account Number: " + acc.getAccoutnNumber());
                System.out.println("Balance: " + acc.getBalance());
                System.out.println();
                found = true;
                return;
            }
        }
        if (!found)
        {
            System.out.println("Account number " + accNumber + " was not found!");
        }
    }
}
