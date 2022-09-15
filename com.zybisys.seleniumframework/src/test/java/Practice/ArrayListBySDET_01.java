package Practice;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListBySDET_01 {

	public static void main(String[] args) {

		ArrayList al = new ArrayList();
		al.add(1);
		al.add("tulasi");
		al.add(15.4);
		al.add(true);
		al.add('a');
		System.out.println(al);
		System.out.println(al.size());
		// remove element based on index
		al.remove(2);
		System.out.println(al);
		// remove element
		al.remove("tulasi");
		System.out.println(al);
		// add element based on particular index
		al.add(2, "ram");

		System.out.println(al);
		// retrive particular element based on index
		// System.out.println(al.get(3));

		// change element /replace element
		System.out.println(al.set(2, "tulasi"));
		System.out.println(al.get(2));
		System.out.println(al);

		// search
		System.out.println(al.contains("tulasi"));
		
		//isEmpty()
		System.out.println(al.isEmpty());
		
		//1)Reading data from for loop
		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i)+" ");
		}
		
		//2)Reading data from for each loop
//		for(Object e:al)
//		{
//			System.out.println(e);
//		}

		//3)Reading data from iterator
		
//		Iterator it = al.iterator();
//		while(it.hasNext())
//		{
//			System.out.println(it.next());
//		}
	}

}
