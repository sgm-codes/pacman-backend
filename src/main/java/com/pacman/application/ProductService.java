package com.pacman.application;

import com.pacman.domain.model.Product;
import com.pacman.domain.criteria.*;

import java.util.*;

import com.pacman.domain.ports.ProductRankingPort;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements ProductRankingPort {

    private final List<Product> products = List.of(
        new Product(1, "V-NECH BASIC SHIRT", 100, Map.of("S", 4, "M", 9, "L", 0)),
        new Product(2, "CONTRASTING FABRIC T-SHIRT", 50, Map.of("S", 35, "M", 9, "L", 9)),
        new Product(3, "RAISED PRINT T-SHIRT", 80, Map.of("S", 20, "M", 2, "L", 20)),
        new Product(4, "PLEATED T-SHIRT", 3, Map.of("S", 25, "M", 30, "L", 10)),
        new Product(5, "CONTRASTING LACE T-SHIRT", 650, Map.of("S", 0, "M", 1, "L", 0)),
        new Product(6, "SLOGAN T-SHIRT", 20, Map.of("S", 9, "M", 2, "L", 5))
    );

    public List<Product> getSortedProducts(Map<String, Double> weights) {
        Map<String, ScoringCriterion> criteria = Map.of(
            "sales", new SalesCriterion(),
            "stock_ratio", new StockRatioCriterion()
        );

        return products.stream()
            .sorted(Comparator.comparingDouble(p ->
                -weights.entrySet().stream()
                    .mapToDouble(e -> e.getValue() * 
                        criteria.getOrDefault(e.getKey(), product -> 0.0).score(p))
                    .sum()
            ))
            .toList();
    }
}
