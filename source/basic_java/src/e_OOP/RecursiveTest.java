package e_OOP;

public class RecursiveTest {
	public static void main(String[] args) {
		int result = factorial(4);
		System.out.println(result  );
		
		
	}
	
	static int factorial(int num){
		int result =0;
		if(num==1){
			result=1;
		}else{
			result=num*factorial(num-1);
		}
		return result;
	}
	
}
