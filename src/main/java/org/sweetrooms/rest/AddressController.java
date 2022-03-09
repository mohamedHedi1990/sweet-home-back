package org.sweetrooms.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.AddressService;
import org.sweetrooms.persistence.entities.Address;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/address")
@Tag(description = "Restfull APIs for Address",name = "address ressource")
public class AddressController {
    @Autowired
    AddressService addressService;
    @Operation(summary = "Get addresses",
            description = "Provides all available addresses list")
    @GetMapping("")
    public List<Address> getAllAdresses()
    {
        return this.addressService.getAllAdresses();
    }
    @Operation(summary = "Get addresse",
            description = "Provides a specific address by ID")
    @GetMapping("/{id}")
    public Address getAdminById(@PathVariable(name = "id") Long id)
    {
        return this.addressService.getAddressById(id);
    }
    @Operation(summary = "save addresse",
            description = "save a new addresses")
    @PostMapping("")
    public Address saveAddress(Address address)
    {
        return this.addressService.saveAddress(address);
    }
    @Operation(summary = "delete addresse",
            description = "delete a specific addresse by ID")
    @DeleteMapping("/{id}")
    public void deleteAddresse(@PathVariable(name = "id") Long id)
    {
        this.addressService.deleteAddress(id);
    }
}
