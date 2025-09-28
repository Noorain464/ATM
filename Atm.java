public class Atm {
    private Transaction transaction;
    private CardReader cardReader;
    private CashDispenser cashDispenser;
    private Printer printer;
    private BankService bankService;

    private ATMState idleState;
    private ATMState cardInsertedState;
    private ATMState authenticatedState;
    private ATMState exitState;

    private ATMState currentState;
    private ATMState transactionState;
    
    public Atm(BankService bankService) {
    this.bankService = new BankProxy(bankService);
    this.cardReader = new CardReader(new SimpleCardValidation());
    this.cashDispenser = CashDispenser.getInstance();
    this.cashDispenser.setDispensingStrategy( new DefaultDispensing());
    this.printer = new Printer();

    idleState = new IdleState(this);
    cardInsertedState = new CardInsertedState(this);
    authenticatedState = new AuthenticatedState(this);
    transactionState = new TransactionState(this);
    exitState = new ExitState(this);

    currentState = idleState;
}

    public ATMState getTransactionState() { return transactionState; }

    public void insertCard(String cardNumber) { currentState.insertCard(cardNumber); }
    public void enterPin(String pin) { currentState.enterPin(pin); } 
    public void selectOperation(String op, double amt) { currentState.selectOperation(op, amt); }
    public void ejectCard() { currentState.ejectCard(); }

    public void setCurrentState(ATMState state) { this.currentState = state; }
    public ATMState getIdleState() { return idleState; }
    public ATMState getCardInsertedState() { return cardInsertedState; }
    public ATMState getAuthenticatedState() { return authenticatedState; }
    public ATMState getExitState() { return exitState; }

    public CardReader getCardReader() { return cardReader; }
    public BankService getBankService() { return bankService; }
    public CashDispenser getCashDispenser() { return cashDispenser; }
    public Printer getPrinter() { return printer; }

    public void setTransaction(Transaction transaction) { this.transaction = transaction; }
    public Transaction getTransaction() { return transaction; }
}
