package Exceptions;

public class NotEnoughBalanceException extends Exception {
    private String message="Not have that much money";
    public NotEnoughBalanceException(){}
    public String getMessage() {
        return message;
    }
}
