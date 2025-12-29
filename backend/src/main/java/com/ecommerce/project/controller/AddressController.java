package com.ecommerce.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.project.model.User;
import com.ecommerce.project.payload.AddressDTO;
import com.ecommerce.project.service.AddressService;
import com.ecommerce.project.util.AuthUtil;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AuthUtil authUtil;

    @PostMapping("/addresses")
    public ResponseEntity<AddressDTO> createAddress(@Valid @RequestBody AddressDTO addressDTO) {
        User user = authUtil.loggedInUser();
        
        AddressDTO savedAddressDTO = addressService.createAddress(addressDTO, user);
        
        return new ResponseEntity<>(savedAddressDTO, HttpStatus.CREATED);
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<AddressDTO>> getAddresses() {
        List<AddressDTO> addressDTOs = addressService.getAddresses();
        
        return new ResponseEntity<>(addressDTOs, HttpStatus.OK);
    }
    
    @GetMapping("/users/addresses")
    public ResponseEntity<List<AddressDTO>> getAddressByUser() {
        User user = authUtil.loggedInUser();
        
        List<AddressDTO> addressDTOs = addressService.getAddressByUser(user);
        
        return new ResponseEntity<>(addressDTOs, HttpStatus.OK);
    }

}
