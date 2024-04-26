package com.np.coffeeinventoryservice.controller;

import com.np.coffeeinventoryservice.model.InventoryItem;
import com.np.coffeeinventoryservice.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    // Constructor with @Autowired (if using constructor injection)
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    // @GetMapping, @PostMapping, @PutMapping, @DeleteMapping methods...
    @GetMapping("/{productName}")
    public InventoryItem findInventoryItem(@PathVariable String productName) {
        return inventoryService.findInventoryItem(productName);
    }

    @PostMapping
    public InventoryItem saveInventoryItem(@RequestBody InventoryItem inventoryItem) {
        return inventoryService.saveInventoryItem(inventoryItem);
    }

    @GetMapping
    public List<InventoryItem> findAllInventoryItems() {
        return inventoryService.findAllInventoryItems();
    }

    @PutMapping
    public InventoryItem updateInventoryItem(@RequestBody InventoryItem inventoryItem) {
        return inventoryService.updateInventoryItem(inventoryItem);
    }

    @DeleteMapping("/{id}")
    public void deleteInventoryItem(@PathVariable Long id) {
        inventoryService.deleteInventoryItem(id);
    }

    @DeleteMapping
    public void deleteAllInventoryItems() {
        inventoryService.deleteAllInventoryItems();
    }

    @GetMapping("/id/{id}")
    public InventoryItem findInventoryItemById(@PathVariable Long id) {
        return inventoryService.findInventoryItemById(id);
    }

    @GetMapping("/name/{productName}")
    public InventoryItem findInventoryItemByName(@PathVariable String productName) {
        return inventoryService.findInventoryItemByName(productName);
    }

    @GetMapping("/quantity/{quantity}")
    public List<InventoryItem> findInventoryItemsByQuantity(@PathVariable Integer quantity) {
        return inventoryService.findInventoryItemsByQuantity(quantity);
    }

    @GetMapping("/quantity/greater/{quantity}")
    public List<InventoryItem> findInventoryItemsByQuantityGreaterThan(@PathVariable Integer quantity) {
        return inventoryService.findInventoryItemsByQuantityGreaterThan(quantity);
    }

    @GetMapping("/quantity/less/{quantity}")
    public List<InventoryItem> findInventoryItemsByQuantityLessThan(@PathVariable Integer quantity) {
        return inventoryService.findInventoryItemsByQuantityLessThan(quantity);
    }
}