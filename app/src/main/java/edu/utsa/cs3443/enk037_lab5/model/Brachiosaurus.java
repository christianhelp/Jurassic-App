package edu.utsa.cs3443.enk037_lab5.model;

//Christian Walker enk037
//A class that extends the saurpod abasract class
public class Brachiosaurus extends Sauropod{
	public Brachiosaurus(String name, boolean isVegetarian) {
		super(name,isVegetarian);
	}
	//Returns the subtype of specific dinosaur called by the sauropod class
	public String getSubType() {
		return "Brachiosaurus ";
	}

}
