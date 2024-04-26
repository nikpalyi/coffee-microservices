package com.np.coffeeinventoryservice.service;

import com.np.coffeeinventoryservice.model.InventoryItem;
import com.np.coffeeinventoryservice.repository.InventoryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private final InventoryItemRepository repository;

    public InventoryService(InventoryItemRepository repository) {
        this.repository = repository;
    }

    // Business methods that use the repository...
    public InventoryItem findInventoryItem(String productName) {
        return repository.findByProductName(productName);
    }

    public InventoryItem saveInventoryItem(InventoryItem inventoryItem) {
        return repository.save(inventoryItem);
    }

    public List<InventoryItem> findAllInventoryItems() {
        return repository.findAll();
    }

    public InventoryItem updateInventoryItem(InventoryItem inventoryItem) {
        return repository.save(inventoryItem);
    }

    public void deleteInventoryItem(Long id) {
        repository.deleteById(id);
    }

    public void deleteAllInventoryItems() {
        repository.deleteAll();
    }

    public InventoryItem findInventoryItemById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public InventoryItem findInventoryItemByName(String productName) {
        return repository.findByProductName(productName);
    }

    public List<InventoryItem> findInventoryItemsByQuantity(Integer quantity) {
        return repository.findByQuantity(quantity);
    }

    public List<InventoryItem> findInventoryItemsByQuantityGreaterThan(Integer quantity) {
        return repository.findByQuantityGreaterThan(quantity);
    }

    public List<InventoryItem> findInventoryItemsByQuantityLessThan(Integer quantity) {
        return repository.findByQuantityLessThan(quantity);
    }
}