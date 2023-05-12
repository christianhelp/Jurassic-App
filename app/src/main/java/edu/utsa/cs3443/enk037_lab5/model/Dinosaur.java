package edu.utsa.cs3443.enk037_lab5.model;//Christian Walker enk037
//An interface for the other subclass of dinos to use with basic methods that they all should use at some point

public interface Dinosaur {
	//to string method that overrides the basic one
	public String toString();
	//Returns true if the users passes true for the specific dino being a vegetarian
	public boolean isVegetarian();
	//Getter for the name of the specific dino
	public String getName();
	//getter for the type of the dinosaur.
	//Will call upon a getSubType method declared in an abstract class and implemented in it's subtype
	public String getType();
}
