package javapractice;

public class Car {

	String color;
	int make;
	String transmission;
	int tyres;
	int doors;
	
	//Creating constructor
	Car(){
		tyres=4;
		doors=4;
	}

	//methods to display characteristics
	public void displayCharacteristics() {
		System.out.println("Color of the car:"+ color);
		System.out.println("Make of the car:"+ make);
		System.out.println("Transmission of the car: " + transmission);
		System.out.println("Number of doors on car:" + doors);
		System.out.println("Number of tyres on car:" +tyres);
		
	}
	public void accelerate() {
		System.out.println("Car is moving");
	}
	public void brake() {
		System.out.println("Car has stopped");
	}
}
