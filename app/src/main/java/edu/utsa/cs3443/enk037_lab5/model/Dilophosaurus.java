package edu.utsa.cs3443.enk037_lab5.model;

public class Dilophosaurus extends Theropod{
    public Dilophosaurus(String name, boolean isVegetarian){
        super(name,isVegetarian);
    }
    @Override
    public String getSubType() {
        return "Dilophosaurus";
    }
}
