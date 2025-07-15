package com.pacman;

import com.pacman.infrastructure.entrypoint.PacmanApplication;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PacmanApplicationTest {

    @Test
    public void testMainMethodRunsWithoutException() {
        assertDoesNotThrow(() -> PacmanApplication.main(new String[]{}));
    }
}
