package edu.utsa.cs3443.enk037_lab5.model;

/*Christian Walker enk037
 * The class that will implement dinosaur known as stegosaur. Class contains all the implementrd functions from Dinosaur
*/
public abstract class Stegosaur implements Dinosaur{
	private String name;
	private boolean isVegetarian;
	
	//Constructor for the theropod class building the name and isVegetarian boolean
	public Stegosaur(String dinoName, boolean isVegetarian) {
		this.setName(dinoName);
		this.setVegetarian(isVegetarian);
	}
	//To String function that will determine if the dino is a carnivore and then get the name and the type
	public String toString() {
		String carn = (this.isVegetarian()) ? " (not carnivore)" : " (carnivore)";
		return getType() + "named " + getName() + carn;
	}
	//Will return the super and subtype of the dinosaur
	public String getType() {
		return "* Stegosaur: " + getSubType();
	}
	//Returns true if vegetarian
	public boolean isVegetarian() {
		return isVegetarian;
	}
	//Set vegetarian to true or false depending on user input
	public void setVegetarian(boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}
	//Get the name
	public String getName() {
		return name;
	}
	//sets the name
	public void setName(String name) {
		this.name = name;
	}
	//Asbtract that will return the subtype
	public abstract String getSubType();
}
