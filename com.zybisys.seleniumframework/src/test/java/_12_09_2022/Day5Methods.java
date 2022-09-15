package _12_09_2022;

public class Day5Methods {
	
	int x=10;
	int y=20;
	
	/*void sum() //case1:-not taking any paramerters and not taking any value
	{
		System.out.println(x+y);
	}*/
	
	/*int sum() //case2:- not taking parameters but return value
	{
		return (x+y);
	}*/
	
	/*void sum(int x, int y) //case3:-taking parameters  but not returning any value
	{
		System.out.println(x+y);
	}*/
	
	int  sum(int a, int b) //case4:- taking parameters and taking values
	{
		return(a+b);
	}
	
	public static void main(String[] args) {
		Day5Methods obj=new Day5Methods();
	//	obj.sum(); //case 1
		
	//	int result = obj.sum();
	//	System.out.println(result);
		
	//	obj.sum(100, 200);  //case3
		
		System.out.println(obj.sum(200, 100)); //case4
		
	}

}
