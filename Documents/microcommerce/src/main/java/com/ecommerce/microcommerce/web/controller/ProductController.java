package com.ecommerce.microcommerce.web.controller;


import com.ecommerce.microcommerce.exeptions.nullValueExeption;
import com.ecommerce.microcommerce.model.Product;
import com.ecommerce.microcommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @RequestMapping(value = "/Produits", method = RequestMethod.GET)
    public List<Product> GetListProduit() {
        return productRepository.findAll();

    }

    @RequestMapping(value = "/Produit/{id}",method = RequestMethod.GET)
    public Optional<Product> GetProductById(@PathVariable  int id )
    {
        Optional<Product> product= productRepository.findById(id);
        if (product==null) {
            throw new nullValueExeption("le produit d'id : " + id + "n'existe pas ");
        }
        else

        return product;
    }

    @PostMapping (value="/add/produit")
    public void AddProduct( @Valid @RequestBody Product product){
        productRepository.save(product);
    }

    @GetMapping(value="/test/Produits/{num}")
    public List<Product> FindProductTestPrix( @PathVariable int num)
    {
     return productRepository.findByPrixGreaterThan(num);
    }

    @GetMapping(value="/test/produits/{nametest}")
    public  List<Product> FindProductNameTest(@PathVariable String nametest)
    {
        return productRepository.findByNomLike("%"+nametest+"%");

    }

    @DeleteMapping(value="/delete/produit/{id}")
    public void DeleteProduct(@PathVariable int id)
    {
        productRepository.deleteById(id);
    }

    @PutMapping (value = "/Produits")
    public void updateProduit(@RequestBody Product product) {

        productRepository.save(product);
    }

}