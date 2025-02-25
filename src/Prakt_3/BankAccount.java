package Prakt_3;

class BankAccount {
    private double balance;
    private static double totalBalance;
    private static double interestRate = 5.0; //у процентах

    public BankAccount(double balance) {
        this.balance = balance;
        totalBalance += balance;
    }

    public void deposit(double amount) {
        balance += amount;
        totalBalance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
        totalBalance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public static double getTotalBalance() {
        return totalBalance;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void addPercent() {
        if (balance <= 0){
            throw new IllegalStateException("Cannot add to negative or 0 balance");
        }
        double percent = balance * (interestRate / 100); // порахувати скільки грошей за процент
        balance += percent;
        totalBalance += percent;
    }
}
