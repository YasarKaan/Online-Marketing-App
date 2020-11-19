package Application;

import Helper.TakeInput;
import User.AdminUser;
import User.Supplier;

import java.util.ArrayList;

public class AdminApp {
    TakeInput takeInput = new TakeInput();
    Menus menus = new Menus();
    public void adminApp(AdminUser adminUser, ArrayList<Supplier> suppliersList){
        while(true){
            menus.adminChoiceMenu();
            int adminChoice = takeInput.getInput();
            if(adminChoice==1){
                System.out.println( suppliersList.toString() );
                System.out.println("Choose supplier to verify");
                int supInt = takeInput.getInput();
                adminUser.checkConfirmation(suppliersList.get(supInt-1));
            }else if(adminChoice==2){
                System.out.println(adminUser.getBalance());
            }else if(adminChoice==3){
                break;
            }
        }

    }
}
