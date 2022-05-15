package com.gestionbuvette.uniregal.controllers;

import com.gestionbuvette.uniregal.models.Product;
import com.gestionbuvette.uniregal.services.CategoryService;
import com.gestionbuvette.uniregal.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired private ProductService productService;
    @Autowired private CategoryService countryService;

    //Get All Products
    @GetMapping("/products")
    public String findAll(Model model){
        model.addAttribute("products", productService.findAll());
        model.addAttribute("categories", countryService.findAll());
        return "product";
    }

    @RequestMapping("/products/findById")
    @ResponseBody
    public Optional<Product> findById(Integer id)
    {
        return productService.findById(id);
    }

    //Add Product
    @PostMapping(value="/products/addNew")
    public String addNew(Product product) {
        productService.save(product);
        return "redirect:/products";
    }

    @RequestMapping(value="/products/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Product product) {
        productService.save(product);
        return "redirect:/products";
    }

    @RequestMapping(value="/products/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        productService.delete(id);
        return "redirect:/products";
    }
}