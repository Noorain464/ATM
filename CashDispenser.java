import java.util.Map;

public class CashDispenser {
    //singleton
    //Map with denomination as key and count as value
    private Map<Integer, Integer> cashInventory;
    //Strategy to dispense cash
    DispensingStrategy dispensingStrategy;
    

}
