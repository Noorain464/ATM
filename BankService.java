public interface BankService {
    boolean authenticateCard(String cardNumber, String pin);
    double getAccountBalance(String accountNumber);
    boolean withdrawFunds(String accountNumber, double amount);
    boolean depositFunds(String accountNumber, double amount);
}
