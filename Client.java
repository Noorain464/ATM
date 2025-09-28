public class Client {
    public static void main(String[] args) {
        Atm atm = new Atm(new SbiBankService());

        atm.insertCard("123456789012");
        atm.enterPin("1234");
        atm.selectOperation("withdraw", 2000);
        atm.ejectCard();

        atm.insertCard("123456789012");
        atm.enterPin("1234");
        atm.selectOperation("balance", 0);
        atm.ejectCard();
    }
}
