package Helper;

import User.Customer;

import java.util.ArrayList;

public class AddUser {
    public void addUser(String user, ArrayList allUserList , ArrayList customersList){
        String[] userData = user.split(",");
        String[] datas = getDatas( userData );
        Customer customer = new Customer( userData[1],userData[2],0,userData[4],userData[5],datas );
        customersList.add( customer);
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
