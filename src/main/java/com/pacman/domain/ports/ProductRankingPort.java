package com.pacman.domain.ports;

import com.pacman.domain.model.Product;
import java.util.List;
import java.util.Map;

public interface ProductRankingPort {
    List<Product> getSortedProducts(Map<String, Double> weights);
}