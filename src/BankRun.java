import java.util.Scanner;

public class BankRun {
    public static void main(String[] args) {

        Bank banka = null;
        int option = 0;
        Scanner input = new Scanner(System.in);
        try
        {
            banka = new Bank(1);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        while(true)
        {
            switch (option)
            {
                case 0:
                    System.out.println("\n");
                    mainMenu();
                    option = input.nextInt();
                    break;
                case 1:
                    System.out.println("\n");
                    accountMenu();
                    option = input.nextInt() * 10;
                    break;
                case 2:
                    System.out.println("\n");
                    transferMenu(banka);
                    option = 0;
                    break;
                case 3:
                    return;
                case 10:
                    banka.printAllInfo();
                    option = 0;
                    break;
                case 20:
                    System.out.println("Total number of accounts: " + Bank.getNumberOfAccounts());
                    option = 0;
                    break;
                case 30:
                    System.out.print("Account number: ");
                    banka.printAccInfo(input.nextInt());
                    option = 0;
                    break;
                case 40:
                    input.nextLine();
                    System.out.print("Owner: ");

                    String owner;
                    owner = input.nextLine();

                    System.out.print("Account number is: ");
                    int accNumber = Bank.getNumberOfAccounts() + 1;
                    System.out.print(accNumber + "\n");

                    System.out.print("Initial balance: ");
                    double balance = input.nextDouble();

                    try
                    {
                        banka.addAccount(accNumber,owner,balance);
                    }
                    catch (Exception e)
                    {
                        System.out.println("ERROR: Account was not created");
                        System.out.println(e);
                    }
                    option = 0;
                    break;

            }
        }

    }

    public static void mainMenu()
    {
        System.out.println("1. Accounts");
        System.out.println("2. Transfer money");
        System.out.println("3. Exit");
        System.out.print("Type number: ");
    }

    public static void accountMenu()
    {
        System.out.println("1. Print info of all accounts");
        System.out.println("2. Print number of accounts");
        System.out.println("3. Print info of specific account number");
        System.out.println("4. Add account");
        System.out.print("Type number: ");
    }

    public static void transferMenu(Bank banka)
    {
        Scanner transferInput = new Scanner(System.in);
        int targetAcc;
        int sourceAcc;
        double amount;
        System.out.print("Source Account Number: ");
        sourceAcc = transferInput.nextInt();
        System.out.print("Target Account Number: ");
        targetAcc = transferInput.nextInt();
        System.out.print("Amount: ");
        amount = transferInput.nextDouble();

        try
        {
            banka.transfer(sourceAcc,targetAcc,amount);
            System.out.println("Transaction complete!");
            return;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return;
        }
    }
}
