package com.ecommerce.project.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Page<Product> findByCategory(Category category, Pageable pageDetails);

    Page<Product> findByProductNameContainingIgnoreCase(String keyword, Pageable pageDetails);

}
