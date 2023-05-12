package edu.utsa.cs3443.enk037_lab5.model;

//Christian Walker enk037
//Class for Tyrannosaurus which extends the abstract Theropod class
public class Tyrannosaurus extends Theropod{
	public Tyrannosaurus(String name, boolean isVegetarian) {
		super(name,isVegetarian);
	}
	//Returns the subtype of specific dinosaur. Called by the theropod class
	public String getSubType() {
		return "Tyrannosaurus ";
	}
}
