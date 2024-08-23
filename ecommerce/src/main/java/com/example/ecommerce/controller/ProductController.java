package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/list")
    public String getProductsPage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product-list";  // Bu product-list.html'yi döndürecek
    }

    @PostMapping("/list")
    public String addProduct(@ModelAttribute Product product, Model model) {
        productService.addProduct(product);
        model.addAttribute("products", productService.getAllProducts());
        return "product-list";  // Ekleme işlemi sonrası aynı sayfayı döndürüyoruz
    }
}