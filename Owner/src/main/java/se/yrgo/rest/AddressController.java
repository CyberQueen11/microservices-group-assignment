package se.yrgo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.domain.AddressEntity;
import se.yrgo.domain.OwnerEntity;
import se.yrgo.service.AddressService;
import se.yrgo.service.OwnerService;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService ownerService) {
        this.addressService = ownerService;
    }

    @GetMapping
    public List<AddressEntity> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @PostMapping
    public ResponseEntity<AddressEntity> createUser(@RequestBody AddressEntity address) {
        AddressEntity createdAddress = addressService.registerAddress(address);
        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
    }

    @PutMapping("/update-address")
    public ResponseEntity<String> updateOwner(@RequestBody AddressEntity address) {
        boolean isUpdated = addressService.updateAddress(address);
        if (isUpdated) {
            return ResponseEntity.ok("Address updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-address")
    public ResponseEntity<String> deleteOwner(@RequestBody AddressEntity address) {
        boolean isDeleted = addressService.deleteAddress(address);
        if (isDeleted) {
            return ResponseEntity.ok("Address deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}