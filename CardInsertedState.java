public class CardInsertedState implements ATMState {
    private Atm atm;

    public CardInsertedState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(String cardNumber) {
        System.out.println("Card already inserted.");
    }

    @Override
    public void enterPin(String pin) {
        if (atm.getBankService().authenticateCard("123456", pin)) {
            System.out.println("PIN correct.");
            atm.setCurrentState(atm.getAuthenticatedState());
        } else {
            System.out.println("Wrong PIN.");
        }
    }

    @Override
    public void selectOperation(String operationType, double amount) {
        System.out.println("Enter PIN first.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected.");
        atm.setCurrentState(atm.getIdleState());
    }
}
