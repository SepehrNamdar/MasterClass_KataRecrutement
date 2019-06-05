package model;

import java.time.LocalDateTime;
import java.util.List;

public class Candidate {
    private String nom;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
    private List<String> skills;

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

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> candidateTechnos) {
        this.skills = candidateTechnos;
    }
}
