public class TransactionState implements ATMState {
    private Atm atm;

    public TransactionState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(String cardNumber) {
        System.out.println("Transaction in progress. Cannot insert another card.");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Transaction in progress. PIN already verified.");
    }

    @Override
    public void selectOperation(String operationType, double amount) {
        System.out.println("Transaction already selected. Processing...");
    }

    @Override
    public void ejectCard() {
        System.out.println("Transaction in progress. Please wait...");
    }

    public void executeTransaction() {
        Transaction txn = atm.getTransaction();
        if (txn != null) {
            txn.execute();
        } else {
            System.out.println("No transaction found.");
        }
        atm.setCurrentState(atm.getExitState());
    }
}
