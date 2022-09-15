package _12_09_2022;

public class Day5Constructor {
	
	int sid;
	String sname;
	char gender;
	
	Day5Constructor(int id,String name, char gen)
	{
		sid=id;
		sname=name;
		gender=gen;
	}
	
	void display()
	{
		System.out.println(sid+"  "+sname+"  "+gender);
	}

}
