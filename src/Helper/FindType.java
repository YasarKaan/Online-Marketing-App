package Helper;

import User.*;

public class FindType {
    public int check(User user) {
        try {
            Customer user1 = (Customer) user;
            return 2;
        } catch (ClassCastException e) {
            try {
                Supplier user1 = (Supplier) user;
                return 3;
            } catch (ClassCastException d) {
                AdminUser user1 = (AdminUser) user;
                return 1;
            }
        }
    }
}
