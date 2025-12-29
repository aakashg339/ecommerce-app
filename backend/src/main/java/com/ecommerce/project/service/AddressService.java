package com.ecommerce.project.service;

import java.util.List;

import com.ecommerce.project.model.User;
import com.ecommerce.project.payload.AddressDTO;

public interface AddressService {

    AddressDTO createAddress(AddressDTO addressDTO, User user);

    List<AddressDTO> getAddresses();

    List<AddressDTO> getAddressByUser(User user);

}
