package User;

import Shopping.ProductInventory;
import Shopping.Shop;

public class Supplier extends RegularUser {
    private Boolean verified = false;
    private ProductInventory productInventory = new ProductInventory();
    String shopCategory;
    String shopTitle;
    String taxNumber;
    Shop shop = new Shop();

    public Supplier(String username, String password, double balance,
                    String telNumber, String email,String shopCategory,
                    String shopTitle,String taxNumber, String... adresses) {
        super( username, password, balance, telNumber, email, adresses );
        this.shopCategory= shopCategory;
        this.shopTitle= shopTitle;
        this.taxNumber= taxNumber;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getShopCategory() {
        return shopCategory;
    }

    public void setShopCategory(String shopCategory) {
        this.shopCategory = shopCategory;
    }

    public String getShopTitle() {
        return shopTitle;
    }

    public void setShopTitle(String shopTitle) {
        this.shopTitle = shopTitle;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }
    public String toString(){
        return getUsername();

    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public ProductInventory getProductInventory() {
        return productInventory;
    }

}
