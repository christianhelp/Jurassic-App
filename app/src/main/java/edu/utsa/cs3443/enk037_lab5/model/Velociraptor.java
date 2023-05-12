package edu.utsa.cs3443.enk037_lab5.model;

//Christian Walker enk037
//A class that extends the abstract Theropod class
public class Velociraptor extends Theropod{
	public Velociraptor(String name, boolean isVegetarian) {
		super(name,isVegetarian);
	}
	//Returns the subtype of specific dinosaur called by the theropod class
	public String getSubType() {
		return "Velociraptor ";
	}
	
}
