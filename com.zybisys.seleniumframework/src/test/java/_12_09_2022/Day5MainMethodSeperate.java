package _12_09_2022;

public class Day5MainMethodSeperate {
	
	public static void main(String[] args) {

		Day5ClassAndObject obj = new Day5ClassAndObject();
		obj.eid = 101;
		obj.ename = "ram";
		obj.esal = 25000;
		obj.deptno = 500;
		obj.job = "engineer";

		obj.display();

		Day5ClassAndObject obj2 = new Day5ClassAndObject();
		obj2.eid = 102;
		obj2.ename = "tulasi";
		obj2.esal = 300000;
		obj2.deptno = 1000;
		obj2.job = "developer";

		obj2.display();

	}

}
