package se.yrgo.service;

import se.yrgo.domain.Purchase;

import java.util.List;

public interface PurchaseService {
    List<Purchase> getAllPurchases();
    void createPurchase(Purchase purchase);
}