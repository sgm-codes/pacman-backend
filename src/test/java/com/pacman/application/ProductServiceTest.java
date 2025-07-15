package com.pacman.application;

import com.pacman.domain.model.Product;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    @Test
    public void testGetSortedProducts_bySales() {
        ProductService service = new ProductService();
        Map<String, Double> weights = new HashMap<>();
        weights.put("sales", 1.0);

        List<Product> result = service.getSortedProducts(weights);

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}