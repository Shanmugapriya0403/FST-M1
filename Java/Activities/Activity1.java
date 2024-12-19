package javapractice;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car benz = new Car();
		benz.make=2020;
		benz.color="Black";
		benz.transmission="Automatic";
		
		benz.displayCharacteristics();
		benz.accelerate();
		benz.brake();
		}

}
