package edu.utsa.cs3443.enk037_lab5.model;

public class Gallimimus extends Theropod{
    public Gallimimus(String name, boolean isVegitarian){
        super(name,isVegitarian);
    }
    @Override
    public String getSubType() {
        return "Gallimimus";
    }
}
