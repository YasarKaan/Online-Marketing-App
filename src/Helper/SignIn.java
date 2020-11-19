package Helper;

import Exceptions.UserCouldNotFoundException;
import User.*;

import java.util.ArrayList;

public class SignIn {

    public User signIn(String name, String password, ArrayList<User> allUserList) {
        try {
            for (User user : allUserList) {
                int i = 1;
                if (name.equals( user.getUsername() )) {
                    if (user.getPassword().equals( password )) {
                        System.out.println( "Successful!" );
                        return user;
                    } else {
                        throw new UserCouldNotFoundException();
                    }
                } else if (allUserList.size() == i) {
                    throw new UserCouldNotFoundException();
                }
                i++;
            }
        } catch (UserCouldNotFoundException e) {
            e.getMessage();
        }
        return null;
    }

}