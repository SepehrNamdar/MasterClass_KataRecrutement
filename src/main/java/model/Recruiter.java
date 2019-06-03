package model;

import java.time.LocalDateTime;

public class Recruiter {
    private int i;
    private String toto;
    private LocalDateTime now;

    public Recruiter(int i, String toto, LocalDateTime now) {
        this.i = i;
        this.toto = toto;
        this.now = now;
    }

    public boolean isAvailable(LocalDateTime localDateTime) {
        return true;
    }
}
