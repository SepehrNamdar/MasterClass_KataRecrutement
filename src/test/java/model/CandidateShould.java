package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CandidateShould {

    @Test
    public void be_available() {
        Candidate c = new Candidate("nom");
        LocalDateTime dateTo = LocalDateTime.now().plusDays(1);
        LocalDateTime dateFrom = LocalDateTime.now().minusDays(1);
        c.setAvailability(dateFrom, dateTo);
        boolean available = c.isAvailable(LocalDateTime.now());
        assertTrue(available);
    }
}
