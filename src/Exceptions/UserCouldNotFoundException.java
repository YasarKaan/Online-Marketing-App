package Exceptions;

public class UserCouldNotFoundException extends Exception {

    private String message="Nickname or Password invalid try again";

    public UserCouldNotFoundException(){}

    public String getMessage(){
        return message;
    }
}
