package com.np.coffeeinventoryservice.repository;

import com.np.coffeeinventoryservice.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
    InventoryItem findByProductName(String productName);

    List<InventoryItem> findByQuantity(Integer quantity);

    List<InventoryItem> findByQuantityGreaterThan(Integer quantity);

    List<InventoryItem> findByQuantityLessThan(Integer quantity);
}