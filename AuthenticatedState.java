public class AuthenticatedState implements ATMState {
    private Atm atm;

    public AuthenticatedState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(String cardNumber) {
        System.out.println("Card already inserted.");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Already authenticated.");
    }

    @Override
    public void selectOperation(String operationType, double amount) {
        switch (operationType.toLowerCase()) {
            case "withdraw":
                atm.setTransaction(new WithdrawTransaction(atm, amount));
                break;
            case "deposit":
                atm.setTransaction(new DepositTransaction(atm, amount));
                break;
            default:
                System.out.println("Invalid operation.");
                return;
        }
        System.out.println("Operation selected. Moving to transaction state...");
        atm.setCurrentState(atm.getTransactionState());
        ((TransactionState) atm.getTransactionState()).executeTransaction();
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected.");
        atm.setCurrentState(atm.getIdleState());
    }
}
