package edu.utsa.cs3443.enk037_lab5.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;


public class Zone {
    private ArrayList<Dinosaur> dinosaurs;
    private int personCount;
    private String dinosStored,zone,risk;

    public Zone(String dinosStored, String risk,String zone, int personCount){
        this.dinosStored = dinosStored;
        this.zone = zone;
        this.risk = risk;
        this.dinosaurs = new ArrayList<>();
        this.personCount = personCount;
    }
    @NonNull
    public String toString() {
        String ret = "Zone Name: " + this.getZone()+"\n";
        for(int i=0; i < dinosaurs.size();i++){
            ret = ret.concat(dinosaurs.get(i).toString()+"\n");
        }
        return ret;
    }
    public ArrayList<Dinosaur> getDinosaurs() {
        return dinosaurs;
    }

    public void setDinosaurs(ArrayList<Dinosaur> dinosaurs) {
        this.dinosaurs = dinosaurs;
    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    public String getDinosStored() {
        return dinosStored;
    }

    public void setDinosStored(String dinosStored) {
        this.dinosStored = dinosStored;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }
}
