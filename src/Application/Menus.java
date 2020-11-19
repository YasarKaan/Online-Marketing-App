package Application;

public class Menus {
    public void operationMenuBeforeLogIn(){
        System.out.println("1) Sign Up");
        System.out.println("2) Sign In");
        System.out.println("0) Exit");
    }
    public void customerOperations(){
        System.out.println("1) Add product to Basket");
        System.out.println("2) Remove product from Basket");
        System.out.println("3) Deposit Money");
        System.out.println("4) Add Address");
        System.out.println("5) Show bought products");
        System.out.println("6) Refund");
        System.out.println("7) Show Basket");
        System.out.println("8) Buy ");
        System.out.println("0) Log out");
    }
    public void supplierList(){
        System.out.println("1) Housewares");
        System.out.println("2) Electronics");
        System.out.println("3) Accessories");
        System.out.println("4) Cosmetics");
    }
    public void adminChoiceMenu(){
        System.out.println("1) Verify Supplier");
        System.out.println("2) Show Balance   ");
        System.out.println("3) Log Out        ");
    }
    public void supplierMenu() {
        System.out.println("1) Show Inventory");
        System.out.println("2) Show Sold Inventory");
        System.out.println("3) Show Endorsement");
        System.out.println("4) Show Balance");
        System.out.println("0) Log Out ");
    }
}
