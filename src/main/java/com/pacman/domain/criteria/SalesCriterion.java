package com.pacman.domain.criteria;

import com.pacman.domain.model.Product;

public class SalesCriterion implements ScoringCriterion {
    @Override
    public double score(Product product) {
        return product.salesUnits();
    }
}
