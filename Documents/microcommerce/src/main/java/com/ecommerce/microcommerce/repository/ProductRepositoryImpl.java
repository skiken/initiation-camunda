package com.ecommerce.microcommerce.repository;

import com.ecommerce.microcommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepositoryImpl { //implements ProductRepository {

    /*

    public static List<Product>products=new ArrayList<>();
    static {
        products.add(new Product(1, new String("Ordinateur portable"), 350,120));
        products.add(new Product(2, new String("Aspirateur Robot"), 500,400));
        products.add(new Product(3, new String("Table de Ping Pong"), 750,436));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product ProductfindById(int id) {

        for(Product p : products){
            if (p.getId()==id){
               return p;

            }
        }
        return null;
    }



    @Override
    public Product Productsave(Product product) {
        products.add(product);
        return product;

    }


     */
}
