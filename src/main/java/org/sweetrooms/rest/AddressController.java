package org.sweetrooms.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.AddressService;
import org.sweetrooms.persistence.entities.Address;
import org.sweetrooms.persistence.entities.Admin;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/address")
@Api(value = "Restfull APIs for Address")
public class AddressController {
    @Autowired
    AddressService addressService;
    @GetMapping("")
    public List<Address> getAllAdresses()
    {
        return this.addressService.getAllAdresses();
    }
    @GetMapping("/{id}")
    public Address getAdminById(@PathVariable(name = "id") Long id)
    {
        return this.addressService.getAddressById(id);
    }
    @PostMapping("")
    public Address saveAddress(Address address)
    {
        return this.addressService.saveAddress(address);
    }
    @DeleteMapping("/{id}")
    public void deleteAddresse(@PathVariable(name = "id") Long id)
    {
        this.addressService.deleteAddress(id);
    }
}
