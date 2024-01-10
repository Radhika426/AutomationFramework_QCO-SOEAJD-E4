package practice;

public class GenericMethodPractice {

	public static void main(String[] args) { //Caller
		
		/* Hard coded*/
//		int a = 10;
//		int b = 20;
//		int c = a+b;
//		System.out.println(c);
		
		add(20, 30);
		add(100, 300);
		int sum = add(100,3);
		System.out.println(sum);

	}
	
	//Generic method/ Reusable method
	public static int add(int a, int b) { //Called
		
		int c = a+b;
		return c;
	}

}
