package se.yrgo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.yrgo.data.PurchaseRepository;
import se.yrgo.domain.Purchase;

import java.util.List;


@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    @Override
    public void createPurchase(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    @Override
    public boolean deletePurchase(Purchase purchase) {
        if (purchaseRepository.existsById(purchase.getId())) {
            purchaseRepository.deleteById(purchase.getId());
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePurchase(Purchase purchase) {
        if (purchaseRepository.existsById(purchase.getId())) {
            purchaseRepository.save(purchase);
            return true;
        }
        return false;
    }

}