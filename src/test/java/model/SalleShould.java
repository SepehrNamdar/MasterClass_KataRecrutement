package model;

import org.junit.Assert;
import org.junit.Test;

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
}
