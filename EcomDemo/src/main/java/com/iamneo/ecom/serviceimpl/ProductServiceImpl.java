package com.iamneo.ecom.serviceimpl;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iamneo.ecom.dto.ProductDTO;
import com.iamneo.ecom.model.Product;
import com.iamneo.ecom.repository.ProductRepository;
import com.iamneo.ecom.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
    private ProductRepository productRepository;
	
    @Override
    public List<ProductDTO> getAllProductsForUser() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            productDTOs.add(convertToDTO(product));
        }
        return productDTOs;
    }

    @Override
    public List<ProductDTO> getAllProductsForAdmin() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            productDTOs.add(convertToDTO(product));
        }
        return productDTOs;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<Product> saveProduct(Product product) {
    	System.out.println("going to make rest call:::");
    	
//    	HttpHeaders headers = new HttpHeaders();
//    	headers.setContentType(MediaType.APPLICATION_JSON);
//    	HttpEntity<Object> entity = new HttpEntity<>(product, headers);
//    	ResponseEntity<Product> responseEntity = restTemplate().exchange("http://localhost:8081/api/addproduct", HttpMethod.POST, entity, Product.class);
    	//restTemplate().put(uRL, entity);

    	ResponseEntity<Product> responseEntity = new RestTemplate().postForEntity("http://localhost:8081/api/addproduct", product, Product.class);
        return responseEntity;
    }

    @Override
    public ResponseEntity<Product> deleteProduct(Long id) {
    	System.out.println("going to make rest call:::");
    	
//    	HttpHeaders headers = new HttpHeaders();
//    	headers.setContentType(MediaType.APPLICATION_JSON);
//    	HttpEntity<Object> entity = new HttpEntity<>(id, headers);
    	HashMap<String, Long> uriVariables = new HashMap<>(); 
    	uriVariables.put("id", id);
    	ResponseEntity<Product> responseEntity = restTemplate().exchange("http://localhost:8081/api/deleteproduct/{id}", HttpMethod.DELETE, null, Product.class, uriVariables);

    	//ResponseEntity<Product> responseEntity = new RestTemplate().delete("http://localhost:8081/api/deleteproduct/{id}", uriVariables);

        return responseEntity;
    }

    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setProductName(product.getProductName());
        dto.setProductPrice(product.getProductPrice());
        return dto;
    }
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}