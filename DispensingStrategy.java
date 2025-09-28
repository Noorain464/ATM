import java.util.Map;

public interface DispensingStrategy {
    void dispense(int amount, Map<Integer, Integer> cashInventory);
}
