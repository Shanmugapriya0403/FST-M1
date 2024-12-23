package javapractice;

import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hs = new HashSet<String>();
		hs.add("A");
		hs.add("S");
		hs.add("V");
		hs.add("C");
		hs.add("N");
		hs.add("D");
		hs.add("B");
		System.out.println("Size of Hashset:" + hs.size());
		System.out.println("Original set" + hs);
		System.out.println("Removing A from set" + hs.remove("A"));
		if(hs.remove("D")) {
			System.out.println("D has removed");
		}else {
			System.out.println("D has not removed");
		}
		System.out.println("Checking id V is in the set" + hs.contains("V"));
		System.out.println("update hash set:" + hs);
	}

}
