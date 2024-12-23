package javapractice;

import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "Cricket");
		hm.put(2, "FootBall");
		hm.put(3, "VolleyBall");
		hm.put(4, "Badminton");
		hm.put(5, "Hockey");
		System.out.println("Size of a hashmap:" + hm.size());
		System.out.println("Print Original hashmap:" + hm);
		hm.remove(3);
		System.out.println("After Removing volleyball from hashmap:" +hm);
		if(hm.containsValue("Badminton")) {
			System.out.println("Badminton is in the Map");
		}else {
			System.out.println("Badminton is not in the hashmap");
		}
		
	}

}
