package model;

import java.time.LocalDateTime;

public class Recruiter {
    private int i;
    private String name;
    private LocalDateTime dateTime;

    public Recruiter(int i, String name, LocalDateTime dateTime) {
        this.i = i;
        this.name = name;
        this.dateTime = dateTime;
    }

    public boolean isAvailable(LocalDateTime localDateTime) {
        return this.dateTime.isEqual(localDateTime);
    }

    public String getName() {
        return name;
    }
}
