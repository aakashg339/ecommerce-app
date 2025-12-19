package com.ecommerce.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
