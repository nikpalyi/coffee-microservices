package com.np.coffeeinventoryservice.controller;

import com.np.coffeeinventoryservice.model.InventoryItem;
import com.np.coffeeinventoryservice.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryService inventoryService;
    private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{productName}")
    public InventoryItem findInventoryItem(@PathVariable String productName) {
        logger.debug("Received request to find inventory item by product name: {}", productName);
        return inventoryService.findInventoryItem(productName);
    }

    @PostMapping
    public InventoryItem saveInventoryItem(@RequestBody InventoryItem inventoryItem) {
        logger.debug("Received request to save inventory item: {}", inventoryItem);
        return inventoryService.saveInventoryItem(inventoryItem);
    }

    @GetMapping
    public List<InventoryItem> findAllInventoryItems() {
        logger.debug("Received request to find all inventory items");
        return inventoryService.findAllInventoryItems();
    }

    @PutMapping
    public InventoryItem updateInventoryItem(@RequestBody InventoryItem inventoryItem) {
        logger.debug("Received request to update inventory item: {}", inventoryItem);
        return inventoryService.updateInventoryItem(inventoryItem);
    }

    @DeleteMapping("/{id}")
    public void deleteInventoryItem(@PathVariable Long id) {
        logger.debug("Received request to delete inventory item with ID: {}", id);
        inventoryService.deleteInventoryItem(id);
    }

    @DeleteMapping
    public void deleteAllInventoryItems() {
        logger.debug("Received request to delete all inventory items");
        inventoryService.deleteAllInventoryItems();
    }

    @GetMapping("/id/{id}")
    public InventoryItem findInventoryItemById(@PathVariable Long id) {
        logger.debug("Received request to find inventory item by ID: {}", id);
        return inventoryService.findInventoryItemById(id);
    }

    @GetMapping("/name/{productName}")
    public InventoryItem findInventoryItemByName(@PathVariable String productName) {
        logger.debug("Received request to find inventory item by product name: {}", productName);
        return inventoryService.findInventoryItemByName(productName);
    }

    @GetMapping("/quantity/{quantity}")
    public List<InventoryItem> findInventoryItemsByQuantity(@PathVariable Integer quantity) {
        logger.debug("Received request to find inventory items by quantity: {}", quantity);
        return inventoryService.findInventoryItemsByQuantity(quantity);
    }

    @GetMapping("/quantity/greater/{quantity}")
    public List<InventoryItem> findInventoryItemsByQuantityGreaterThan(@PathVariable Integer quantity) {
        logger.debug("Received request to find inventory items by quantity greater than: {}", quantity);
        return inventoryService.findInventoryItemsByQuantityGreaterThan(quantity);
    }

    @GetMapping("/quantity/less/{quantity}")
    public List<InventoryItem> findInventoryItemsByQuantityLessThan(@PathVariable Integer quantity) {
        logger.debug("Received request to find inventory items by quantity less than: {}", quantity);
        return inventoryService.findInventoryItemsByQuantityLessThan(quantity);
    }
}
