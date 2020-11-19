package User;

public class AdminUser extends User {

    public AdminUser(String username,String password,double balance) {
        super(username,password,balance);
    }

    public boolean checkConfirmation(User user){
        Supplier supplier = (Supplier) user;
        if(!supplier.getVerified()) {
            if (!supplier.getTaxNumber().equals("")) {
                supplier.setVerified(true);
                return true;
            } else {
                return false;
            }
        }else{
            return true;
        }
    }
}
