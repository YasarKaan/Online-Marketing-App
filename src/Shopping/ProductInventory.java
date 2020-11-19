package Shopping;

        import Exceptions.ProductNotFoundException;

        import java.util.*;

public class ProductInventory<T extends Product> extends Inventory<T> {
    public Product findProduct(String str) {
        try {
            Product product = find( str );
            if (!(product==null)) {
                return product;
            } else throw new ProductNotFoundException();
        } catch (ProductNotFoundException e) {
            System.out.println( e.getMessage() );
            return null;
        }
    }

    @Override
    public void addElementToInventory(T t, int in) {
       if (inventoryMap.containsKey( t )){
           inventoryMap.replace(t,inventoryMap.get( t )+in);
       }
       else{
           inventoryMap.put( t,in );
       }
    }

    @Override
    public boolean removeElementFromInventory(T t, int in) {
         if(inventoryMap.get( t )<in){
             System.out.println("Product not that much");
             return false;
         }else{
             if(inventoryMap.get( t )==in){
                 inventoryMap.remove( t );
                 return true;
             }else{
                 inventoryMap.replace( t,inventoryMap.get( t )-in);
                 return true;
             }
         }
    }


    private Product find(String name){
        Product twpProduct = null;
        Set<T> set =  inventoryMap.keySet();
        for(Product product:set){
            if(product.getName().toUpperCase().equals( (name).toUpperCase() ) ){
                twpProduct=product;
                break;
            }
        }
        return twpProduct;
    }
    public String toString(){
        String string ="";
        Set<T> productSet =  inventoryMap.keySet();
        for(Product product:productSet){
            string =string + product.toString()+" Quantity: "+inventoryMap.get( product );
        }
        return string;
    }
}
