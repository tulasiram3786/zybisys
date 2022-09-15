package _12_09_2022;

public class DefaultConstructorAndParameterisedConstructor {
	
	int x;
	int y;
	
	DefaultConstructorAndParameterisedConstructor()   //default constructor
	{
		x=10;
		y=20;
	}
	
	DefaultConstructorAndParameterisedConstructor(int a, int b)   //parameterised constructor
	{
		x=a;
		y=b;
	}
	
	void display()
	{
		System.out.println(x+y);
	}

	public static void main(String[] args) {
		
		DefaultConstructorAndParameterisedConstructor obj=new DefaultConstructorAndParameterisedConstructor();   //default constructor
		obj.display();
		
		DefaultConstructorAndParameterisedConstructor obj2=new DefaultConstructorAndParameterisedConstructor(100,200);   //parameterised constructor
		obj2.display();
		
	}

}
