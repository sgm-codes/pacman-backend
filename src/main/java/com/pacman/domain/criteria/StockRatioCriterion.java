package com.pacman.domain.criteria;

import com.pacman.domain.model.Product;

public class StockRatioCriterion implements ScoringCriterion {
    @Override
    public double score(Product product) {
        long available = product.stock().values().stream().filter(s -> s > 0).count();
        return (double) available / product.stock().size();
    }
}
