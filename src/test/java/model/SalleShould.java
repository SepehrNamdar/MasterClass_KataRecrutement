package model;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class SalleShould {

    @Test
    public void haveEnoughCapacity() {
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
}
