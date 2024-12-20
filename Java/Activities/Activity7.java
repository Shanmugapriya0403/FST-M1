package javapractice;



public class Activity7 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MountainBike bike =new MountainBike(3, 0, 25);
		System.out.println(bike.bicycleDesc());
		bike.speedUp(50);
		bike.applyBrake(10);

	}

}
