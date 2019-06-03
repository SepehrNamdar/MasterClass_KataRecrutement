package model;

import java.time.LocalDateTime;

public class Candidate {
    private String nom;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;

    public Candidate(String nom) {
        this.nom = nom;
    }

    public void setAvailability(LocalDateTime dateFrom, LocalDateTime dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public boolean isAvailable(LocalDateTime time) {
        return time.isBefore(dateTo) && time.isAfter(dateFrom);
    }
}
