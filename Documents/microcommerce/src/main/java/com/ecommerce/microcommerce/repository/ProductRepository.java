package com.ecommerce.microcommerce.repository;

import com.ecommerce.microcommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    /*
    public List<Product> findAll();
    public Product ProductfindById(int id);
    public Product Productsave(Product product);

     */

     public List<Product> findByPrixGreaterThan(int num);
     public List<Product> findByNomLike(String recherche);
}
