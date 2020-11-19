package Shopping;

import Helper.FindSupplier;
import User.Supplier;

import java.util.*;


public class Basket {
    private FindSupplier findSupplier = new FindSupplier();
    public ProductInventory<Product> productInventory = new ProductInventory();

    public Product addBasket(String str, int in, Supplier supplier) {
        if (supplier.getShop().productInventory.findProduct( str ) != null) {
            if (supplier.getShop().productInventory.getInventoryMap().get( supplier.getShop().productInventory.findProduct( str ) ) >= in) {
                productInventory.addElementToInventory( supplier.getShop().productInventory.findProduct( str ), in );
                supplier.getShop().productInventory.removeElementFromInventory( supplier.getShop().productInventory.findProduct( str ), in );
                return productInventory.findProduct( str );
            } else {
                return null;
            }
        }
        else return null;
    }

    public boolean removeBasket(String str, int in, ArrayList<Supplier> supplierList) {
        Product product = productInventory.findProduct( str );
        if (product != null) {
            findSupplier.findSupplier( product,supplierList ).getShop().supplierBuyProduct( str,in );
            productInventory.removeElementFromInventory( product, in );
            return true;
        } else {
            return false;
        }
    }


    public String toString() {
        Set<Product> productSet = productInventory.inventoryMap.keySet();
        StringBuilder stringBuilder = new StringBuilder();
        for (Product product : productSet) {
            stringBuilder.append( product.toString()+" Quantity: "+productInventory.inventoryMap.get( product ));
            stringBuilder.append( " " );
        }
        return stringBuilder.toString();

    }
}