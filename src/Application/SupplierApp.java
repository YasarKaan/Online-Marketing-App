package Application;

import Helper.TakeInput;
import User.Supplier;
import User.User;

public class SupplierApp {
    Menus menus = new Menus();
    TakeInput takeInput= new TakeInput();
    public void supplierApp(User tmpuser){
        Supplier supplier =(Supplier) tmpuser;
        while (true) {
            menus.supplierMenu();
            int supplierChoice = takeInput.getInput();
            if (supplierChoice == 1) {
                System.out.println( supplier.getShop().toString() );
            } else if (supplierChoice == 2) {
                System.out.println( supplier.getProductInventory().toString() );
            } else if (supplierChoice==3){

            } else if(supplierChoice==4){
                System.out.println(supplier.getBalance());
            } else if(supplierChoice==0){
                break;
            }
        }
    }
}
