public class ExitState implements ATMState {
    private Atm atm;

    public ExitState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(String cardNumber) {
        System.out.println("Take your card first.");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("No card.");
    }

    @Override
    public void selectOperation(String operationType, double amount) {
        System.out.println("No card.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected. Returning to idle.");
        atm.setCurrentState(atm.getIdleState());
    }
}
