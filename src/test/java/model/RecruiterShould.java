package model;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class RecruiterShould {
    @Test
    public void be_available() {
        Recruiter recruiter = new Recruiter(1, "Toto", LocalDateTime.now());
        boolean available = recruiter.isAvailable(LocalDateTime.now());
        Assert.assertTrue(available);
    }
}
