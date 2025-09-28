import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DefaultDispensing implements DispensingStrategy {
    @Override
    public void dispense(int amount,Map<Integer, Integer> cashInventory) {
        Map<Integer, Integer> result = new HashMap<>();
        // logic to get the minimum number of notes
        ArrayList<Integer> denominations = new ArrayList<>(Arrays.asList( 200, 500, 100, 20, 50, 10));
        Collections.sort(denominations, Collections.reverseOrder());
        for (int denom : denominations) {
            int available = cashInventory.getOrDefault(denom, 0);
            int needed = amount / denom;
            int used = Math.min(needed, available);

            if (used > 0) {
                result.put(denom, used);
                amount -= used * denom;
                cashInventory.put(denom, available - used);
            }
        }
        System.out.println(result);
        System.out.println("Dispensing amount: " + amount + " using minimum notes strategy.");
    }
}
