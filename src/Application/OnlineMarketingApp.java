package Application;

import Exceptions.UserCouldNotFoundException;
import Helper.AddUser;
import Helper.FindType;
import Helper.SignIn;
import Helper.TakeInput;
import Reader.ProductsReader;
import Reader.UserReader;
import User.*;
import Writer.Write;
import java.util.ArrayList;

public class OnlineMarketingApp {
    public static void main(String[] args) {
        ArrayList<Customer> customersList = new ArrayList();
        ArrayList<Supplier> suppliersList = new ArrayList();
        ArrayList<AdminUser> adminList = new ArrayList();
        ArrayList<User> allUserList = new ArrayList<>();
        AdminApp adminApp = new AdminApp();
        CustomerApp customerApp = new CustomerApp();
        SupplierApp supplierApp = new SupplierApp();
        FindType findType = new FindType();
        TakeInput takeInput = new TakeInput();
        AddUser addUser = new AddUser();
        Menus menus = new Menus();
        Write write = new Write();
        SignIn sign = new SignIn();
        ProductsReader productsReader = new ProductsReader();
        UserReader userReader = new UserReader();
        userReader.readUser( adminList, customersList, suppliersList ,allUserList);
        AdminUser adminUser = adminList.get( 0 );
        Supplier housewareSupp = suppliersList.get( 0 );
        Supplier accessoriesSupp = suppliersList.get( 1 );
        Supplier electronicSupp = suppliersList.get( 2 );
        Supplier cosmeticSupp = suppliersList.get( 3 );
        productsReader.readProducts( housewareSupp.getShop(), accessoriesSupp.getShop(), electronicSupp.getShop(), cosmeticSupp.getShop() );

        boolean check = true;
        while (check) {
            menus.operationMenuBeforeLogIn();
            int choice = takeInput.getInput();
            if (choice==1){
                String user = "2," +takeInput.takeNewUser();
                user = user+ "," +takeInput.setPassword();
                user = user+ ","+ "0";
                user = user+ "," +takeInput.takeTelephoneNumber();
                user = user+ ","+takeInput.takeEmail();
                user = user+ ","+takeInput.takeAddress();
                write.writeFile( user );
                addUser.addUser( user,allUserList,customersList );
            }
            else if(choice==2){
                String name= takeInput.takeNewUser();
                String password = takeInput.takePassword();
                User tmpuser = sign.signIn(name,password,allUserList);
                if(tmpuser!=null) {
                    int userType = findType.check(tmpuser);
                    if(userType==1){
                        AdminUser adminUser1 = (AdminUser) tmpuser;
                        adminApp.adminApp(adminUser1,suppliersList);
                    }else if(userType==2){
                        Customer customer = (Customer) tmpuser;
                        customerApp.customerApp( customer,adminUser,suppliersList );
                    }else {
                        supplierApp.supplierApp( tmpuser );
                    }
                }
            }
            else if(choice==0){
                check=false;
            }

        }
    }
}
