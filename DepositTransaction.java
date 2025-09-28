public class DepositTransaction extends Transaction {
    public DepositTransaction(Atm atm, double amount) {
        super(atm, amount);
    }

    @Override
    public void execute() {
        atm.getBankService().depositFunds("123456", amount);
        atm.getPrinter().printReceipt("Deposited: " + amount);
    }
}
