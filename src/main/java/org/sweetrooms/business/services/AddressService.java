package org.sweetrooms.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.persistence.entities.Address;
import org.sweetrooms.persistence.repositories.AddressRepository;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

   public List<Address> getAllAdresses()
   {
       return this.addressRepository.findAll();
   }

   public Address getAddressById(Long id)
   {
       return this.addressRepository.getById(id);
   }
   public Address saveAddress(Address address)
   {
       return this.addressRepository.save(address);
   }
   public void deleteAddress(Long id)
   {
       this.addressRepository.deleteById(id);
   }
}
