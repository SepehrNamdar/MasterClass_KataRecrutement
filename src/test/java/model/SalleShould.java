package model;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SalleShould {

    @Test
    public void return_reserved_when_salle_is_reserved() {
        // Given
        Salle salle = new Salle(4);

        // When
        salle.reserve(4);

        // Then
        assertEquals(Status.RESERVED, salle.getStatus());
    }

    @Test
    public void not_reserve() {
        Salle salle = new Salle(4);

        assertThatExceptionOfType(CapacityTooShortException.class)
                .isThrownBy(() ->
                        salle.reserve(5));
    }

    @Test
    public void is_available_at_time() {
        // Given
        Salle salle = new Salle(4);
        salle.setAvailable(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));

        //when
        boolean available = salle.isAvailable(LocalDateTime.now());
        // Then
        assertTrue(available);
    }

    @Test
    public void return_false_when_salle_is_not_available(){

        Salle salle = new Salle(4);
        salle.setAvailable(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
        //when
        boolean available = salle.isAvailable(LocalDateTime.now().plusDays(2));
        // Then
        assertFalse(available);

    }

    @Test
    public void return_free() {
        // Given
        Salle salle = new Salle(4);

        // Then
        assertEquals(Status.FREE, salle.getStatus());
    }
}
