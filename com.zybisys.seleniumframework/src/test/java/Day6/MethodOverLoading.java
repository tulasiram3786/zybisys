package Day6;

public class MethodOverLoading {
	
	void add(int a, int b)
	{
		System.out.println(a+b);
	}

	void add(int a, double b)
	{
		System.out.println(a+b);
	}
	void add(int a, double b,double c)
	{
		System.out.println(a+b+c);
	}
	void add(int a, double b,int c)
	{
		System.out.println(a+b+c);
	}
	
	public static void main(String[] args) {
		MethodOverLoading obj=new MethodOverLoading();
		obj.add(10, 20);
		obj.add(10, 20.5);
		obj.add(10, 20.5, 20.5);
		obj.add(10, 40.5, 20);
		
	}
}
