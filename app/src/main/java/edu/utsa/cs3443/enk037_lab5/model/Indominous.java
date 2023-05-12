package edu.utsa.cs3443.enk037_lab5.model;

public class Indominous extends Theropod{
    public Indominous(String name, boolean isVegitarian){
        super(name,isVegitarian);
    }
    @Override
    public String getSubType() {
        return "Indominous";
    }
}
