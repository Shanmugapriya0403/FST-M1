package javapractice;

public class Bicycle implements BicycleParts,BicycleOperations {

	public int gears=0;
	public int currentSpeed=0;
	//constructor 
	public Bicycle(int gears, int currentSpeed) {
		this.gears=gears;
		this.currentSpeed=currentSpeed;
	}
	@Override
	public void applyBrake(int decreement) {
		// TODO Auto-generated method stub
		currentSpeed-=decreement;
		System.out.println("CurrentSpeed" +currentSpeed);
	}

	@Override
	public void speedUp(int increement) {
		// TODO Auto-generated method stub
		currentSpeed+=increement;
		System.out.println("CurrentSpeed" +currentSpeed);
	}
	public String bicycleDesc() {
		return("No of gears:" + gears+ "\n Speed of bicycle:" + currentSpeed);
	}
	

}
