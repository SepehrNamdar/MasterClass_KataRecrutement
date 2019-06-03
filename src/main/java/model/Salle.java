package model;

import java.time.LocalDateTime;

public class Salle {

    private int capacity;
    private String status;
    private LocalDateTime availableFrom;
    private LocalDateTime availableTo;

    public Salle(int capacity) {
        this.capacity = capacity;
    }

    public void reserve() {
        this.status = "reserved";
    }

    public String getStatus() {
        return this.status;
    }

    public boolean isAvailable(LocalDateTime date) {
        return date.isBefore(availableTo) && date.isAfter(availableFrom);
    }

    public void setAvailable(LocalDateTime availableFrom, LocalDateTime availableTo) {
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
    }
}
