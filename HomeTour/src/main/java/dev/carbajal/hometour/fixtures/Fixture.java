package dev.carbajal.hometour.fixtures;

public abstract class Fixture {
	
	// Room variables

	String name;
	
	String shortDesc;
	
	String longDesc;
	
	// Constructor
	
	public Fixture(String name, String shortDesc, String longDesc) {
		
		this.name = name;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		
	}
	
	// Getters and Setters

	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
	}

	public String getShortDesc() {
		
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		
		this.shortDesc = shortDesc;
	}

	public String getLongDesc() {
		
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		
		this.longDesc = longDesc;
	}
	
	// Overriding the Fixture toString() method

	@Override
	public String toString() {
		
		return "Fixture [name = " + name + ", shortDesc = " + shortDesc + ", longDesc = " + longDesc + "]";
	}
	
}
