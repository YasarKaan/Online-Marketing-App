package Reader;

import User.*;

import java.util.ArrayList;
import java.util.Scanner;

public class UserReader {


    public void readUser(ArrayList adminList, ArrayList customersList, ArrayList suppliersList,ArrayList allUserList){
        Reader reader = new Reader();
        Scanner data = reader.read( "users.csv" );
        data.nextLine();
        while (data.hasNextLine()){
            String twpData = data.nextLine();
            String[] userData = twpData.split( "," );
            double balance = Double.parseDouble( userData[3] );
            int type = Integer.parseInt( userData[0] );
            if(type==1){
                AdminUser adminUser= new AdminUser(userData[1],userData[2],balance  );
                adminList.add( adminUser );
                allUserList.add( adminUser );
            }else if(type==2){
                String[] datas = getDatas( userData );
                Customer customer = new Customer( userData[1],userData[2],balance,userData[4],userData[5],datas );
                customersList.add( customer);
                allUserList.add( customer );
            }
            else if(type==3){
                String[] datas = getDatas( userData );
               Supplier supplier = new Supplier(userData[1],userData[2],balance,userData[4],userData[5],userData[6],userData[7],userData[8],datas );
                suppliersList.add(supplier);
                allUserList.add( supplier );
            } 
            }
        data.close();
        }
     private String[] getDatas(String[] userData){
         String[] datas = new String[userData.length-9];
         int j=0;
         for (int i=9;i<userData.length;i++) { 
             datas[j]=userData[i];
             j++;
         }
         return datas;
     }   

}
