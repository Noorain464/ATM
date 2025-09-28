public class IdleState implements ATMState {
    private Atm atm;

    public IdleState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(String cardNumber) {
        if (atm.getCardReader().insertCard(cardNumber)) {
            System.out.println("Card inserted.");
            atm.setCurrentState(atm.getCardInsertedState());
        } else {
            System.out.println("Invalid card.");
        }
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Insert card first.");
    }

    @Override
    public void selectOperation(String operationType, double amount) {
        System.out.println("Insert card first.");
    }

    @Override
    public void ejectCard() {
        System.out.println("No card inserted.");
    }
}
