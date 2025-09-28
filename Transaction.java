public abstract class Transaction {
    protected Atm atm;
    protected double amount;

    public Transaction(Atm atm, double amount) {
        this.atm = atm;
        this.amount = amount;
    }

    public abstract void execute();
}
