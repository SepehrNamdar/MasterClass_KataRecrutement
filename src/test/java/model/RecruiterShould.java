package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecruiterShould {

    @Test
    public void be_available() {
        Recruiter recruiter = new Recruiter(1, "Toto", LocalDateTime.of(2019,Month.JUNE,3,0,0,0));
        boolean available = recruiter.isAvailable(LocalDateTime.of(2019, Month.JUNE,3, 0, 0, 0));
        assertTrue(available);
    }

    @Test
    public void be_not_available() {
        Recruiter recruiter = new Recruiter(1, "Toto", LocalDateTime.of(2018,Month.JUNE,3,0,0,0));
        boolean available = recruiter.isAvailable(LocalDateTime.of(2019, Month.JUNE,3, 0, 0, 0));
        assertFalse(available);
    }
}
