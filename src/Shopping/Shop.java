package Shopping;


import User.Supplier;

import java.util.*;

public class Shop {

    public ProductInventory<Product> productInventory = new ProductInventory();
    public void supplierBuyProduct(String str,int in){
        Product product = productInventory.findProduct( str );//TODO do something different;
        productInventory.addElementToInventory(product,in);
    }
    public boolean supplierRemoveProduct(String str, int in){
        boolean check =productInventory.removeElementFromInventory( productInventory.findProduct( str ),in );
        return check;
    }

    public String toString() {
        Set<Product> productSet = productInventory.inventoryMap.keySet();
        StringBuilder stringBuilder = new StringBuilder();
        for (Product product : productSet) {
            stringBuilder.append( product.toString()+" Quantity: "+productInventory.inventoryMap.get( product ) );
            stringBuilder.append( " " );
        }
        return stringBuilder.toString();

    }

}