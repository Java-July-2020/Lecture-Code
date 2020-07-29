package recrusion;

public class recursiveExample {
	//Entry Point Method
	public static void main(String[] args) {
		
		System.out.println(power(5, 2));
	
	}
	
	
	static int power(int base, int exp) {
		// base case
		if(exp == 0) {
			return 1;
		}
		
		//recursive case
		return base * power(base, exp - 1);
	}
	
	
	
	
	static int fact(int number) {
		// base case
		if(number == 1) 
			return 1;
		
		//Recursive case
		return number * fact(number - 1);
	}
}
