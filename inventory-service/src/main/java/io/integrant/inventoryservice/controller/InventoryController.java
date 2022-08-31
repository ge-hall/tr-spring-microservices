package io.integrant.inventoryservice.controller;

import io.integrant.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;
    @GetMapping
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public boolean isInStock(@PathVariable String skuCode) {

        return inventoryService.isInStock(skuCode);
    }
}
