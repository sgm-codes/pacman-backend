package com.pacman;

import com.pacman.application.ProductService;
import com.pacman.domain.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    private final ProductService service = new ProductService();

    @Test
    public void testSortingBySalesOnly() {
        List<Product> sorted = service.getSortedProducts(Map.of("sales", 1.0));
        assertEquals(5, sorted.get(0).id()); // CONTRASTING LACE T-SHIRT (650)
    }

    @Test
    public void testSortingByStockRatioOnly() {
        List<Product> sorted = service.getSortedProducts(Map.of("stock_ratio", 1.0));
        assertEquals(2, sorted.get(0).id()); // CONTRASTING FABRIC T-SHIRT (3/3 sizes)
    }

    @Test
    public void testSortingWithMixedWeights() {
        List<Product> sorted = service.getSortedProducts(Map.of("sales", 0.7, "stock_ratio", 0.3));
        assertEquals(5, sorted.get(0).id()); // CONTRASTING LACE T-SHIRT still highest
    }

    @Test
    public void testUnknownCriterionIgnored() {
        List<Product> sorted = service.getSortedProducts(Map.of("notfound", 1.0));
        // Orden original, porque todos tienen puntuación 0.0
        assertEquals(6, sorted.size());
    }

    @Test
    public void testZeroWeightsResultInNoOrdering() {
        List<Product> sorted = service.getSortedProducts(Map.of("sales", 0.0));
        assertEquals(6, sorted.size());
        // No garantiza orden específico, pero no debe fallar
    }


}
