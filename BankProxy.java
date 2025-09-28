public class BankProxy implements BankService {
    private BankService realBankService;

    public BankProxy(BankService realBankService) {
        this.realBankService = realBankService;
    }

    @Override
    public boolean authenticateCard(String cardNumber, String pin) {
        System.out.println("[Proxy] Authenticating...");
        return realBankService.authenticateCard(cardNumber, pin);
    }

    @Override
    public double getAccountBalance(String accountNumber) {
        System.out.println("[Proxy] Fetching balance...");
        return realBankService.getAccountBalance(accountNumber);
    }

    @Override
    public boolean withdrawFunds(String accountNumber, double amount) {
        System.out.println("[Proxy] Withdrawing...");
        return realBankService.withdrawFunds(accountNumber, amount);
    }

    @Override
    public boolean depositFunds(String accountNumber, double amount) {
        System.out.println("[Proxy] Depositing...");
        return realBankService.depositFunds(accountNumber, amount);
    }
}
