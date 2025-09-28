public interface ATMState {
    void insertCard(String cardNumber);
    void enterPin(String pin);
    void selectOperation(String operationType, double amount);
    void ejectCard();
}
