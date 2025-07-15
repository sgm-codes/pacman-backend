package com.pacman.domain.model;

import java.util.Map;

public record Product(int id, String name, int salesUnits, Map<String, Integer> stock) {}
