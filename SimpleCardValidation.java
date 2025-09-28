public class SimpleCardValidation implements CardValidationStrategy {
    @Override
    public boolean validate(String cardNumber) {
        return cardNumber != null && cardNumber.length() == 12;
    }
}
