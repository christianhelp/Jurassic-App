package edu.utsa.cs3443.enk037_lab5.model;

import android.content.res.AssetManager;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.io.InputStream;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import edu.utsa.cs3443.enk037_lab5.MainActivity;

/*Christian Walker enk037
This is the class that will hold our dinos from other classes we access and ultimately act as our manager for our "park"
*/
public class Park {
	//Name of Park
	private String parkName;
	//Capacity of dinosaurs
	private HashMap<String,Boolean> types;
	//Dino array to hold out dino objects
	public static HashMap<String,Zone> zones;

	private MainActivity mainActivity;
	//Consturctor to build our park using getters and setters
	public Park(String parkName, MainActivity mainActivity) throws IOException {
		System.out.println("Constructed!");
		this.mainActivity = mainActivity;
		zones = new HashMap<>();
		this.types = new HashMap<>();
		this.setParkName(parkName);
		setUpPark(mainActivity);
	}
	//To string method that will loop through our objects until it either reaches the end or hits a null object.
	//Then returns the super string with the entire outputs
	@NonNull
	public String toString() {
		String ret = "---------------------------- \n"
				+ "Welcome to"+this.getParkName()+"\n"
				+ "---------------------------- \n";
		for(Map.Entry<String,Zone> iterator: zones.entrySet()) {
			ret = ret.concat(iterator.toString());
		}
		return ret;
	}
	public void addZone(String zoneName, Zone zone){
		zones.put(zoneName,zone);
	}
	//When called, will add the dino object requested by Lab1.java
	public void addDino(String zoneName, Dinosaur dino) {
		Objects.requireNonNull(zones.get(zoneName)).getDinosaurs().add(dino);
	}
	public void setUpPark(MainActivity mainActivity) throws IOException {
		AssetManager am = mainActivity.getAssets();
		InputStream streamIn = am.open("types.csv");
		Scanner sc = new Scanner(streamIn);
		String []input;
		while(sc.hasNextLine()){
			input = sc.nextLine().split(",");
			System.out.println("Type: "+input[0]);
			this.types.put(input[0],Boolean.parseBoolean(input[1]));
		}

		streamIn = am.open("zones.csv");
		sc = new Scanner(streamIn);
		while(sc.hasNextLine()){
			input = sc.nextLine().split(",");

			Zone tempZone = new Zone(input[0],input[1],input[2],Integer.parseInt(input[3]));
			System.out.println(input[2]);
			this.addZone(input[2],tempZone);
		}

		streamIn = am.open("dinos.csv");
		sc = new Scanner(streamIn);

		while(sc.hasNextLine()){
			input = sc.nextLine().split(",");
			Dinosaur dinosaur = determineDino(input[1],input[0]);
			this.addDino(input[2],dinosaur);
		}


		sc.close();
	}


	//Getter for the park name
	public String getParkName() {
		return parkName;
	}
	//Setter for the park name
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	//getter for dino capacity

	public HashMap<String, Zone> getZones() {
		return zones;
	}

	public void setZones(HashMap<String, Zone> zones) {
		zones = zones;
	}

	public HashMap<String, Boolean> getTypes() {
		return types;
	}

	public void setTypes(HashMap<String, Boolean> types) {
		this.types = types;
	}

	public MainActivity getMainActivity() {
		return mainActivity;
	}

	public void setMainActivity(MainActivity mainActivity) {
		this.mainActivity = mainActivity;
	}
	public Dinosaur determineDino(String type,String name){
		Dinosaur dino = null;
		switch (type){
			case "Apatosaurus":
				dino = new Apatosaurus(name,true);
				break;
			case "Brachiosaurus":
				dino = new Brachiosaurus(name,true);
				break;
			case "Dilophosaurus":
				dino = new Dilophosaurus(name,false);
				break;
			case "Gallimimus":
				dino = new Gallimimus(name,false);
				break;
			case "Indominous":
				dino = new Indominous(name,false);
				break;
			case "Stegosaurus":
				dino = new Stegosaurus(name,true);
				break;
			case "Triceratops":
				dino = new Triceratops(name,true);
				break;
			case "Tyrannosaurus":
				dino = new Tyrannosaurus(name,false);
				break;
			default:
				dino = new Velociraptor(name,false);
		}
		return dino;
	}

}
