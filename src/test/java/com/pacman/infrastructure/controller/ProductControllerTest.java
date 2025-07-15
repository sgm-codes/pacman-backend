package com.pacman.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pacman.infrastructure.dto.WeightRequest;
import com.pacman.infrastructure.entrypoint.PacmanApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = PacmanApplication.class)
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSortedEndpoint_returnsSortedProducts() throws Exception {
        WeightRequest request = new WeightRequest();
        request.setSales(1.0);
        request.setStock_ratio(0.5);

        mockMvc.perform(post("/api/products/sorted")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").isNumber());
    }
    public void testSortedEndpoint_withSalesWeight() throws Exception {
        WeightRequest request = new WeightRequest();
        request.setSales(1.0);

        mockMvc.perform(post("/api/products/sorted")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(6));
    }

    @Test
    public void testSortedEndpoint_withStockRatioOnly() throws Exception {
        WeightRequest request = new WeightRequest();
        request.setStock_ratio(1.0);

        mockMvc.perform(post("/api/products/sorted")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(6));
    }

    @Test
    public void testSortedEndpoint_withNoWeights() throws Exception {
        WeightRequest request = new WeightRequest(); // Ambos null

        mockMvc.perform(post("/api/products/sorted")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(6));
    }
}
