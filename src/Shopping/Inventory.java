package Shopping;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Inventory<T> implements IInventory<T> {
    protected HashMap<T,Integer> inventoryMap= new HashMap<>(  );

    public HashMap<T, Integer> getInventoryMap() {
        return inventoryMap;
    }
}
