package Practice;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListBySDET_02 {
	
	public static void main(String[] args) {
		
		ArrayList al=new ArrayList();
		
		al.add("X");
		al.add("Y");
		al.add("Z");
		al.add("B");
		al.add("A");
		al.add("B");
		al.add("C");
		System.out.println(al);
		
		ArrayList dup=new ArrayList();
		dup.addAll(al);
		System.out.println(dup);
		
		dup.removeAll(al);
		System.out.println(dup);
		System.out.println(dup);
		System.out.println(al);
		
		//collections.sort()
		
		System.out.println(al);
		Collections.sort(al);
		System.out.println("after sorting"+al);
		Collections.sort(al, Collections.reverseOrder());
		System.out.println("after sorting reversing order"+al);
		
		//shuffle
		Collections.shuffle(al);
		System.out.println("after shuffling"+al);
	}

}
