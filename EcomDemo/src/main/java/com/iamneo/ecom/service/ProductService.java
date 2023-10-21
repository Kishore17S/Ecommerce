package com.iamneo.ecom.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.iamneo.ecom.dto.ProductDTO;
//import com.iamneo.ecom.model.ProductDTO;
import com.iamneo.ecom.model.Product;

public interface ProductService {
	 List<ProductDTO> getAllProductsForUser();
	    
	 List<ProductDTO> getAllProductsForAdmin();
	    
	 Product getProductById(Long id);
	    
	 ResponseEntity<Product> saveProduct(Product product);
	    
	 ResponseEntity<Product> deleteProduct(Long id);
}