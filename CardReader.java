public class CardReader {
    private CardValidationStrategy validationStrategy;

    public CardReader(CardValidationStrategy strategy) {
        this.validationStrategy = strategy;
    }

    public boolean insertCard(String cardNumber) {
        return validationStrategy.validate(cardNumber);
    }
    public void ejectCard() {
        System.out.println("Card ejected.");
    }
}
