package _12_09_2022;

public class Greatestof3Numbers {

	public static void main(String[] args) {
	
		int num1=1044;
		int num2=207;
		int num3=30;
		
		if(num1>=num2)
		{
			System.out.println("num1 is big");
		}
		else if(num2>=num3)
		{
			System.out.println("num2 is big");
		}
		else if(num3>=num1)
		{
			System.out.println("num3 is big");
		}
		else
		{
			System.out.println("invalid");
		}

	}

}
