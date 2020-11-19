package Shopping;

public class Product {
    protected String category;
    protected String name;
    protected double price;
    protected double weight;

    public Product(String category, String name, double price, double weight) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public double calculateShippingCost(){
        if(this.getName().equals("electronic") || this.getName().equals("houseware")){
            return this.getWeight()*2;
        }
        else if(this.getName().equals("accessories")){
            return this.getWeight()*2*4.5;
        }
        else{
            return this.getWeight()*2*3.5;
        }
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public String toString(){
        return "\n"+category+" "+name+" "+price+" "+weight;
    }
}