package User;

import Shopping.Basket;
import Shopping.ProductInventory;
import Shopping.Shop;

public class Customer extends RegularUser {
    private int freeCargo=0;
    private ProductInventory productInventory = new ProductInventory();
    private Basket basket = new Basket();
    public Customer(String username, String password, double balance, String telNumber, String email, String... addresses) {
        super( username, password, balance, telNumber, email, addresses );
    }
    public Address addAddress(String title, String country,String city,String district,  String street, String doorNumber){
        Address newAddress = new Address(title,country,city,district,street,doorNumber);
        return newAddress;
    }

    public int getFreeCargo() {
        return freeCargo;
    }

    public void setFreeCargo(int freeCargo) {
        this.freeCargo = freeCargo;
    }

    public ProductInventory getProductInventory() {
        return productInventory;
    }

    public void setProductInventory(ProductInventory productInventory) {
        this.productInventory = productInventory;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
