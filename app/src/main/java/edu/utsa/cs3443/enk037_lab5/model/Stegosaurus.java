package edu.utsa.cs3443.enk037_lab5.model;

//Christian Walker enk037
//A class that extends the stegosaur abasract class
public class Stegosaurus extends Stegosaur{
	public Stegosaurus(String name, boolean isVegetarian) {
		super(name,isVegetarian);
	}
	//Returns the subtype of specific dinosaur called by the stegosaur class
	public String getSubType() {
		return "Stegosaurus ";
	}

}
