package javapractice;

public class Activity6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Plane plane =new Plane(5);
		plane.onboard("shan");
		plane.onboard("Kana");
		plane.onboard("Sugan");
		plane.onboard("Arvi");
		plane.onboard("Aami");
		System.out.println("pepole on passengers:" + plane.getPassengers());
		System.out.println("plane take off at:" + plane.takeOff());
		System.out.println("Plane landed at:" + plane.getLastTimeLanded());
		System.out.println("People on the plane after landing: " + plane.getPassengers());

	}

}
