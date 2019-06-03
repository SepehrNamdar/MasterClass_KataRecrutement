package model;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class SalleShould {

    @Test
    public void return_reserved_when_salle_is_reserved() {
        // Given
        Salle salle = new Salle(4);

        // When
        salle.reserve();

        // Then
        Assert.assertEquals("reserved", salle.getStatus());
    }
    @Test
    public void is_available_at_time() {
        // Given
        Salle salle = new Salle(4);
        salle.setAvailable(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));

        //when
        boolean available = salle.isAvailable(LocalDateTime.now());
        // Then
        Assert.assertTrue(available);
    }

    @Test
    public void return_false_when_salle_is_not_available(){

        Salle salle = new Salle(4);
        salle.setAvailable(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
        //when
        boolean available = salle.isAvailable(LocalDateTime.now().plusDays(2));
        // Then
        Assert.assertFalse(available);

    }
    @Test
    public void return_free() {
        // Given
        Salle salle = new Salle(4);

        // Then
        Assert.assertEquals("free", salle.getStatus());
    }
}
