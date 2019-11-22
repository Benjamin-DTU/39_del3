package undefined;

public class Account {
    private int balance = 20;

    public void withdraw(int amount) {
        balance -= amount;
        if (balance < 0) {
            balance = 0;
        }
    }
    public void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return this.balance;
    }

}