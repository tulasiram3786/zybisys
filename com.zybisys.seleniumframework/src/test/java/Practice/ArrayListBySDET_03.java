package Practice;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListBySDET_03 {
	
	public static void main(String[] args) {
		
		
		//This class is used to convert array to arraylist
		String arr[]= {"cat","dog","rat"};
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
		
		//convert array to arraylist
		ArrayList al=new ArrayList(Arrays.asList(arr));
		System.out.println(al);
	}

}
