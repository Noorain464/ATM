import java.util.HashMap;
import java.util.Map;

public class CashDispenser {
    private static CashDispenser instance;
    private Map<Integer, Integer> cashInventory = new HashMap<>();
    private DispensingStrategy dispensingStrategy;

    private CashDispenser() {
        cashInventory.put(2000, 10);
        cashInventory.put(500, 20);
        cashInventory.put(200, 20);
        cashInventory.put(100, 10);
        cashInventory.put(50, 10);
        cashInventory.put(20, 10);
        cashInventory.put(10, 10);
    }

    public static CashDispenser getInstance() {
        if (instance == null) {
            synchronized (CashDispenser.class) {
                if (instance == null) {
                    instance = new CashDispenser();
                }
            }
        }
        return instance;
    }

    public void setDispensingStrategy(DispensingStrategy strategy) {
        this.dispensingStrategy = strategy;
    }

    public void dispense(int amount) {
        if (dispensingStrategy == null) {
            throw new IllegalStateException("No dispensing strategy set!");
        }
        dispensingStrategy.dispense(amount, cashInventory);
    }

    public Map<Integer, Integer> getCashInventory() {
        return cashInventory;
    }
}
