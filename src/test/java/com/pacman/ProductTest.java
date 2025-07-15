package com.pacman;

import com.pacman.domain.model.Product;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testProductCreationAndAccessors() {
        Map<String, Integer> stock = Map.of("S", 4, "M", 2, "L", 0);
        Product product = new Product(10, "Cool Shirt", 50, stock);

        assertEquals(10, product.id());
        assertEquals("Cool Shirt", product.name());
        assertEquals(50, product.salesUnits());
        assertEquals(2, product.stock().get("M"));
    }
}