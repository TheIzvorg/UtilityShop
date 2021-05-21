package Classes;

import javafx.scene.image.Image;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Product {
    static String[] name = new String[3];
    static Integer[] count = {0,0,0};
    static Double[] price = new Double[3];

    public static void FillProduct(int id, String productName, double productPrice, int productCount){
        Product.name[id] = productName;
        Product.price[id] = productPrice;
        Product.count[id] = productCount;
    }

    public static String getProduct(int i){
        return Product.name[i] + " - " + Product.price[i] + " за шт. * " + Product.count[i] + " шт.";
    }
}
