package com.pacman.infrastructure.controller;

import com.pacman.domain.model.Product;
import com.pacman.application.ProductService;
import com.pacman.domain.ports.ProductRankingPort;
import com.pacman.infrastructure.dto.WeightRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@Log4j2
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRankingPort service;

    public ProductController(ProductRankingPort service) {
        this.service = service;
    }

    @PostMapping(value = "/sorted", produces = "application/json")
    public List<Product> getSortedProducts(@RequestBody WeightRequest weights) {
        Map<String, Double> weightsMap = new HashMap<>();
        log.info("Received weights: {}", weights);
        if (weights.getSales() != null) weightsMap.put("sales", weights.getSales());
        if (weights.getStock_ratio() != null) weightsMap.put("stock_ratio", weights.getStock_ratio());
        return service.getSortedProducts(weightsMap);
    }
}
