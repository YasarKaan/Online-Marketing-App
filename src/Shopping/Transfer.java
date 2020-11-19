package Shopping;

import Exceptions.NotEnoughBalanceException;
import Shopping.Basket;
import Shopping.Product;
import Helper.FindSupplier;
import User.AdminUser;
import User.Customer;
import User.Supplier;

import java.util.ArrayList;
import java.util.Set;

public class Transfer {
    FindSupplier findSupplier = new FindSupplier();
    public boolean buyProducts(Basket basket, Customer customer, AdminUser admin, ArrayList<Supplier> suppliers) {
        int freeCargo = customer.getFreeCargo();
        double price = getPrice( customer, basket );
        if (price <= customer.getBalance()) {
            customer.getProductInventory().getInventoryMap().putAll( basket.productInventory.getInventoryMap() );
            if (freeCargo != 0) {
                for (Product product : basket.productInventory.getInventoryMap().keySet()) {
                    Supplier supplier = findSupplier.findSupplier( product, suppliers );
                    if(supplier.getVerified()){
                        supplier.getProductInventory().addElementToInventory( product, basket.productInventory.getInventoryMap().get( product ) );
                        for (int i = 0; i < basket.productInventory.getInventoryMap().get( product ); i++) {
                            supplier.setBalance( supplier.getBalance() + (((product.getPrice() + product.calculateShippingCost()) * 49) / 50) );
                            admin.setBalance( ((admin.getBalance()) + (product.getPrice() + product.calculateShippingCost()) / 50) );
                        }
                    }else{
                        System.out.println(supplier.getUsername()+" have not verified yet!");
                        break;
                    }
                }
                customer.setBalance( customer.getBalance()-price );
                basket.productInventory.getInventoryMap().clear();
            } else {
                for (Product product : basket.productInventory.getInventoryMap().keySet()) {
                    Supplier supplier = findSupplier.findSupplier( product, suppliers );
                    supplier.getProductInventory().addElementToInventory( product, basket.productInventory.getInventoryMap().get( product ) );
                    for (int i = 0; i < basket.productInventory.getInventoryMap().get( product ); i++) {
                        supplier.setBalance( supplier.getBalance() + (((product.getPrice() + product.calculateShippingCost()) * 49) / 50) );
                        admin.setBalance( ((admin.getBalance()) + (product.getPrice() + product.calculateShippingCost()) / 50) );
                    }
                    customer.setBalance( customer.getBalance() - price );
                    basket.productInventory.getInventoryMap().clear();
                    return true;
                }
            }
        } else {
            try {
                throw new NotEnoughBalanceException();
            } catch (NotEnoughBalanceException e) {
                System.out.println( e.getMessage() );
            }
        }
        return false;
    }

    private double getPrice(Customer customer, Basket basket) {
        double price = 0;
        Set<Product> productSet = basket.productInventory.getInventoryMap().keySet();
        if (customer.getFreeCargo() == 0) {
            for (Product product : productSet) {
                price = price + (product.getPrice()*basket.productInventory.getInventoryMap().get( product ));
                int free = (int) Math.floor( price/2000 );
                customer.setFreeCargo( customer.getFreeCargo() + free );
            }
            for (Product product : productSet) {
                price = price + product.calculateShippingCost();
            }
        } else {
            for (Product product : productSet) {
                price = price + (product.getPrice()*basket.productInventory.getInventoryMap().get( product ));
                int free = (int) Math.floor( price/2000 );
                customer.setFreeCargo( free );
            }
        }
        return price;
    }

    public void refund(Customer customer, Supplier supplier, Product product) {
        try {
            if (supplier.getBalance() > product.getPrice()) {
                customer.setBalance( customer.getBalance() + product.getPrice() );
                supplier.setBalance( supplier.getBalance() - product.getPrice() );
                supplier.getProductInventory().removeElementFromInventory( product,1 );
                customer.getProductInventory().removeElementFromInventory( product,1 );
                supplier.getShop().productInventory.addElementToInventory( product,1 );
                System.out.println("Successful refund!! ");
            } else {
                throw new NotEnoughBalanceException();
            }
        } catch (NotEnoughBalanceException e) {
            e.getMessage();
        }
    }
 /*   public Address selectAddress(Customer customer){
        customer.getContactInfo().getAddressList().toString();
    }*/
}