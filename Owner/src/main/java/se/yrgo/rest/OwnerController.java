package se.yrgo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.domain.OwnerEntity;
import se.yrgo.service.OwnerService;


import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<OwnerEntity> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @PostMapping
    public ResponseEntity<OwnerEntity> createOwner(@RequestBody OwnerEntity owner) {
        OwnerEntity createdOwner = ownerService.createOwner(owner);
        return new ResponseEntity<>(createdOwner, HttpStatus.CREATED);
    }

    @PutMapping("/update-owner")
    public ResponseEntity<String> updateOwner(@RequestBody OwnerEntity owner) {
        boolean isUpdated = ownerService.updateOwner(owner);
        if (isUpdated) {
            return ResponseEntity.ok("Owner updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-owner")
    public ResponseEntity<String> deleteOwner(@RequestBody OwnerEntity owner) {
        boolean isDeleted = ownerService.deleteOwner(owner);
        if (isDeleted) {
            return ResponseEntity.ok("Owner deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}