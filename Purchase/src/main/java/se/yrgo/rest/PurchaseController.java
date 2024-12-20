package se.yrgo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.domain.Purchase;
import se.yrgo.service.PurchaseService;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public List<Purchase> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @PostMapping("/create-purchase")
    public ResponseEntity<String> createPurchase(@RequestBody Purchase purchase) {
        purchaseService.createPurchase(purchase);
        return ResponseEntity.ok("Purchase created successfully");
    }

    @PutMapping("/update-purchase")
    public ResponseEntity<String> updatePurchase(@RequestBody Purchase purchase) {
        boolean isUpdated = purchaseService.updatePurchase(purchase);
        if (isUpdated) {
            return ResponseEntity.ok("Purchase updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-purchase")
    public ResponseEntity<String> deletePurchase(@RequestBody Purchase purchase) {
        boolean isDeleted = purchaseService.deletePurchase(purchase);
        if (isDeleted) {
            return ResponseEntity.ok("Purchase deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}