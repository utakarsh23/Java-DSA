package AssignmentOne;

import java.util.Scanner;

//question 25
public class BankAccount {
    public long currentBalance;
    public String ownerName; //un-necessary
    static String Bank = "ABX"; //un-necessary
    private int pass;

    public BankAccount(long currentBalance, String ownerName, int pass) {
        this.currentBalance = currentBalance;
        this.ownerName = ownerName;
        this.pass = pass;
    }
    public void deposit() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter amount to be deposited : ");
        int amount = input.nextInt();
        System.out.println("Enter password : ");
        short enteredPass = input.nextShort();
        if(pass != enteredPass) {
            System.out.println("Wrong password");
            return;
        }
        System.out.print("Amount Deposited into the account holder : ");
        currentBalance += amount;
        System.out.println(amount);
        boolean further;
        System.out.print("Want to check current Balance ? Yes or No ? ");
        String s = input.next();
        further = s.equals("Yes");
        if(further)
            checkCurrentBalence();
    }
    public void checkCurrentBalence() {
        System.out.println("Current User Balance : " + currentBalance);
    }
    public void withdraw() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter amount to be withdrawn : ");
        int amount = input.nextInt();
        System.out.println("Enter password : ");
        short enteredPass = input.nextShort();
        if(pass != enteredPass) {
            System.out.println("Wrong password");
            return;
        }
        System.out.print("Amount Withdrawn from the account holder : ");
        currentBalance -= amount;
        System.out.println(amount);
        boolean further;
        System.out.println("Want to check current Balance ? Yes or No ?");
        String s = input.next();
        further = s.equals("Yes");
        if(further)
            checkCurrentBalence();
    }
}

class mainClass {
    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome! Create account with your details ");
            System.out.print("Enter your Name : ");
            String name = input.nextLine();
            System.out.print("Enter your initializing money : ");
            long money = input.nextLong();
            System.out.print("Enter your Password : ");
            int pass = input.nextInt();

            BankAccount p1 = new BankAccount(money, name, pass);

            while (true) {
                System.out.println("Choose Option : ");
                System.out.println("1 -> Deposit money");
                System.out.println("2 -> Withdraw money");
                System.out.println("3 -> Check Current balance");
                System.out.println("4 -> Exit");
                int x = input.nextInt();
                switch (x) {
                    case 1 -> p1.deposit();
                    case 2 -> p1.withdraw();
                    case 3 -> p1.checkCurrentBalence();
                }
                if (x == 4) {
                    break;
                }
                System.out.println("Press x to return to main menu");
                input.next();

            }
        }
    }
}
