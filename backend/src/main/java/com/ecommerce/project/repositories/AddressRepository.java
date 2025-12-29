package com.ecommerce.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.project.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("SELECT ad FROM Address ad WHERE ad.user.id = ?1")
    List<Address> findByUserId(Long userId);

}
