package com.iamneo.ecom.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamneo.ecom.constant.Api;
import com.iamneo.ecom.dto.ProductDTO;
//import com.ecom.main.dto.ProductDTO;
import com.iamneo.ecom.model.Product;
import com.iamneo.ecom.service.ProductService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Api.PRODUCT)
@RequiredArgsConstructor
@Tag(name="Product")
public class ProductController {
	@Autowired
    private  ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
    	//return ResponseEntity.ok().body("Hello Product");
        return productService.getAllProductsForUser();
    }

//    @GetMapping("/admin")
//    public List<ProductDTO> getAllProductsForAdmin() {
//        return productService.getAllProductsForAdmin();
//    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/addproduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("deleteproduct/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}