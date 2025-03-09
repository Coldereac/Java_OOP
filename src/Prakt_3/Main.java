package Prakt_3;

/*
Розробити клас «Банківський рахунок», забезпечити можливість
додавання та зняття грошей з рахунку, перевірки поточного балансу, а
також нарахування відсотків. Використовувати статичні змінні для
зберігання процентної ставки та підрахунку загального балансу за
всіма рахунками.
 */

public class Main {
    public static void main(String[] args) {
        // Створимо два об'єкта BankAccount для перевірки конструктора та totalBalance
        BankAccount account1 = new BankAccount(2000.95);
        BankAccount account2 = new BankAccount(3501.35);

        System.out.println("Баланс першого аккаунта: " + account1.getBalance());
        System.out.println("Баланс другого аккаунта: " + account2.getBalance());
        System.out.printf("Загальний баланс: %.2f%n", BankAccount.getTotalBalance());

        //Перевірка зняття та внесення грошей на рахунок
        account1.deposit(378.68);
        System.out.println("Баланс першого аккаунта після внеску: " + account1.getBalance());
        System.out.printf("Загальний баланс: %.2f%n", BankAccount.getTotalBalance());
        account1.withdraw(218);
        System.out.println("Баланс першого аккаунта після зняття: " + account1.getBalance());
        System.out.printf("Загальний баланс: %.2f%n", BankAccount.getTotalBalance());

        //Перевірка процента нарахування
        System.out.printf("Баланс першого аккаунта після додання проценту: %.2f%n", account1.getBalance());
        System.out.printf("Загальний баланс: %.2f%n", BankAccount.getTotalBalance());

        //Перевірка помилки при відмінному балансі
        account2.withdraw(account2.getBalance() + 200);
        System.out.printf("Баланс другого аккаунта: %.2f%n", account2.getBalance());
        System.out.println("Спроба додати процент: ");
        try {
            account2.addPercent();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
