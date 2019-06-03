package model;

import java.time.LocalDateTime;

public class Salle {

    private int capacity;
    private Status status;
    private LocalDateTime availableFrom;
    private LocalDateTime availableTo;

    public Salle(int capacity) {
        this.capacity = capacity;
        this.status = Status.FREE;
    }

    public void reserve() {
        this.status = Status.RESERVED;
    }

    public Status getStatus() {
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
