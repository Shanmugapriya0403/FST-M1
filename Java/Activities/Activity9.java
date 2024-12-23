package javapractice;

import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> nameList =new ArrayList<String>();
		nameList.add("Shanmu");
		nameList.add("Sugan");
		nameList.add("Arvi");
		nameList.add("Aami");
		nameList.add("Vihana");
		System.out.println("Print all the name");
		for(String name:nameList) {
			System.out.println(name);
		}
		System.out.println("Size of name list:" +nameList.size());
		System.out.println("Get second name from list:" + nameList.get(1));
		System.out.println("Is shanmu in list:" + nameList.contains("Shanmu"));
		
		
	}

}
