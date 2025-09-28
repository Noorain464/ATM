public class WithdrawTransaction extends Transaction {
    public WithdrawTransaction(Atm atm, double amount) {
        super(atm, amount);
    }

    @Override
    public void execute() {
        boolean success = atm.getBankService().withdrawFunds("123456", amount);
        if (success) {
            atm.getCashDispenser().dispense((int) amount);
            atm.getPrinter().printReceipt("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
