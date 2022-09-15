package _12_09_2022;

public class Day5Method {
	
	int sid;
	String sname;
	char gender;
	
	void getvalues(int id, String name, char g)
	{
		sid=id;
		sname=name;
		gender=g;
		
	}
	
	void display()
	{
		System.out.println(sid+"  "+sname+"  "+gender);
	}

}
