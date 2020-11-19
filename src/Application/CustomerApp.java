package Application;


import Helper.FindSupplier;
import Helper.TakeInput;
import Shopping.Product;
import Shopping.Transfer;
import User.*;
import Writer.Write;

import java.util.ArrayList;

public class CustomerApp {
    Write write = new Write();
    Transfer transfer = new Transfer();
    TakeInput takeInput = new TakeInput();
    FindSupplier findSupplier = new FindSupplier();
    Menus menus = new Menus();
    public void customerApp(Customer customer, AdminUser adminUser, ArrayList<Supplier> supplierList){
        Transfer transfer = new Transfer();
        double startBalance= customer.getBalance();
        while(true){
            System.out.println(customer.getBalance());
            menus.customerOperations();
            int choice= takeInput.getInput();
            if(choice==0){
                break;
            }
            else if(choice==1){
                menus.supplierList();
                System.out.println("Select Category:");
                int select= takeInput.getInput();
                Supplier supplier = supplierList.get( select-1);
                System.out.println( supplier.getShop().toString() );
                String selectProduct= takeInput.getProductName();
                System.out.println("Select Amount:");
                int selectAmount= takeInput.getInput();
                customer.getBasket().addBasket( selectProduct,selectAmount,supplier );
            }
            else if(choice== 2 ){
                System.out.println(customer.getBasket().toString());
                String selectProduct= takeInput.getProductName();
                System.out.println("Select Amount:");
                int selectAmount= takeInput.getInput();
                customer.getBasket().removeBasket( selectProduct,selectAmount,supplierList );
            }
            else if(choice==3){
                System.out.println("Enter deposit money");
                double money = takeInput.getInput();
                customer.setBalance( customer.getBalance()+money );
            }
            else if(choice==4){

            }
            else if(choice==5){
                System.out.println( customer.getProductInventory().toString() );
            }
            else if(choice==6) {
                System.out.println( customer.getProductInventory().toString() );
                System.out.println( "Choose which product do you want to refund" );
                String string = takeInput.getProductName();
                Product product = customer.getProductInventory().findProduct( string );
                if (product != null) {
                    Supplier supplier = findSupplier.findSupplier( product, supplierList );
                    transfer.refund( customer, supplier, product );
                }
            }
            else if(choice==7){
                System.out.println( customer.getBasket().toString() );
            }
            else if(choice==8){
                System.out.println(customer.getBasket().toString());
                if(transfer.buyProducts( customer.getBasket(),customer,adminUser,supplierList )){
                    System.out.println("Successful");
                }else{
                }
            } else if(choice==9){
                String str = (String) takeInput.takeAddress(customer);
                write.writeFile((takeInput.takeAddress(customer));
            }
        }
    }
}
