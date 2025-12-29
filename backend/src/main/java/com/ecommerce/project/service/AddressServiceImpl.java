package com.ecommerce.project.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.project.exceptions.APIException;
import com.ecommerce.project.model.Address;
import com.ecommerce.project.model.User;
import com.ecommerce.project.payload.AddressDTO;
import com.ecommerce.project.repositories.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO, User user) {
        Address address = modelMapper.map(addressDTO, Address.class);

        // List<Address> addressList = user.getAddresses();
        // addressList.add(address);
        // user.setAddresses(addressList);
        user.getAddresses().add(address);
        
        address.setUser(user);

        Address savedAddress = addressRepository.save(address);

        AddressDTO savedAddressDTO = modelMapper.map(savedAddress, AddressDTO.class);

        return savedAddressDTO;
    }

    @Override
    public List<AddressDTO> getAddresses() {
        List<Address> addresses = addressRepository.findAll();

        if(addresses.size() == 0) {
            throw new APIException("No address exists");
        }

        List<AddressDTO> addressDTOs = addresses.stream()
            .map(address -> modelMapper.map(address, AddressDTO.class))
            .toList();

        return addressDTOs;
    }

    @Override
    public List<AddressDTO> getAddressByUser(User user) {
        List<Address> addresses = addressRepository.findByUserId(user.getUserId());

        if(addresses.size() == 0) {
            throw new APIException("No address exists for user: " + user.getUserName());
        }

        List<AddressDTO> addressDTOs = addresses.stream()
            .map(address -> modelMapper.map(address, AddressDTO.class))
            .toList();

        return addressDTOs;
    }

}
