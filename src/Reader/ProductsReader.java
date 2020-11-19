package Reader;


import Shopping.Product;
import Shopping.ProductInventory;
import Shopping.Shop;
import User.Customer;
import User.Supplier;

import java.util.Scanner;


public class ProductsReader {
    public void readProducts(Shop housewareShop ,Shop electronicShop, Shop accessoriesShop, Shop cosmeticShop) {
        Reader reader = new Reader();
        Scanner data = reader.read( "products.csv" );
        data.nextLine();
        while (data.hasNextLine()) {
            String twpData = data.nextLine();
            String[] userData = twpData.split( "," );
            double price = Double.parseDouble( userData[2] );
            double weight = Double.parseDouble( userData[3] );
            int quantity = Integer.parseInt( userData[4] );
            Product product = new Product( userData[0], userData[1],price,weight );
            if(userData[0].equals( "houseware" )){
                housewareShop.productInventory.addElementToInventory( product,quantity );
            }
            if(userData[0].equals( "electronic" )){
                electronicShop.productInventory.addElementToInventory( product,quantity );
            }
            if(userData[0].equals( "accessories" )){
                accessoriesShop.productInventory.addElementToInventory( product,quantity );
            }
            if(userData[0].equals( "cosmetic" )){
                cosmeticShop.productInventory.addElementToInventory( product,quantity );
            }
            }
        data.close();
        }

    }
