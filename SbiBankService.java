public class SbiBankService implements BankService {
    private double balance = 5000.0;

    @Override
    public boolean authenticateCard(String cardNumber, String pin) {
        return "123456".equals(cardNumber) && "1234".equals(pin); // dummy logic
    }

    @Override
    public double getAccountBalance(String accountNumber) {
        return balance;
    }

    @Override
    public boolean withdrawFunds(String accountNumber, double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean depositFunds(String accountNumber, double amount) {
        balance += amount;
        return true;
    }
}
