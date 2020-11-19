package Exceptions;

public class ProductNotFoundException extends Exception {
    private String message="Product is not here";
    public ProductNotFoundException(){}
    public String getMessage() {
        return message;
    }
}

