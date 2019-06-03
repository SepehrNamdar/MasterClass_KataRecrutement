package model;

public class Salle {

    private int capacity;
    private String status;

    public Salle(int capacity) {
        this.capacity = capacity;
    }

    public void reserve() {
        this.status = "reserved";
    }

    public String getStatus() {
        return this.status;
    }
}
