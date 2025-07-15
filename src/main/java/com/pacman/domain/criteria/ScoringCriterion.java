package com.pacman.domain.criteria;

import com.pacman.domain.model.Product;

// Patrón estrategia
public interface ScoringCriterion {
    double score(Product product);
}
