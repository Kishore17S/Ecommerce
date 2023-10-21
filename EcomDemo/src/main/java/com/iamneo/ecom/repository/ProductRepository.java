package com.iamneo.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iamneo.ecom.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}