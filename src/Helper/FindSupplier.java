package Helper;

import Shopping.Product;
import Shopping.Shop;
import User.Supplier;

import java.util.ArrayList;

public class FindSupplier {
    public Supplier findSupplier(Product product, ArrayList<Supplier> arrayList) {
        for (Supplier supplier : arrayList) {
            if (supplier.getShopCategory().toUpperCase().equals( product.getCategory().toUpperCase() )) {
                return supplier;
            }
        }
        return null;
    }
}
