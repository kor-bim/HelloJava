package b_operation;

public class Operation_02 {
	public static void main(String[] args){
		/*
		1. 증감연산자 (++, --)
		  - 증가연산자 (++) : 피연산자의 값을 1증가시킨다.
		  - 감소연산자 (--) : 피연산자의 값을 1감소시킨다.
		  * 자신의  타입을 그대로 유지한다
		*/
		byte b1 = 50;
		b1++; //자신의 타입을 그대로 유지하며 1더해짐
//		b1 = b1+1; = byte+int의 연산결과는 byte에 넣으려해서 오류
//		b1 = (byte)(b1+1);
		char c1 = 'A';
//		c1 = (char)(c1 + 1);
		c1++; // 'B'
		System.out.println(c1);
		++c1; // 'C'
		
		int i1 = 40;
		int i2 = 50;
		
		//왜 결과값이 다르지?
//		int i3 = i1 + ++i2; //91, 단항먼저 계산, ++i2=51
		int i3 = i1 + i2++; //90, ++이 뒤에 붙으면 원래값 넣어서 계산되면서  i2값 자체가 바뀜 
		System.out.println(i3);
		
		//책30쪽
		//예제1. int형 변수 number를 선언하고 30의 값으로 초기화
		int number = 30;
		//예제2. char형 변수 ch 선언하고 'C'의 값으로 초기화
		char ch = 'C'; //67
		//예제3. 출력하여라
		int result = number++ + 3 + ++ch + ++number;
//		               30     + 3 + 'D'  +    32
//		             num=31         (68)   num=32
//		int result = 30 + 3 + 68 + 32 = 135
		
	
		System.out.println("number : " + number); // number : 32
		System.out.println("ch : " + ch); // ch : D
		System.out.println("result : " + result); //result : 133
		
		/*
		2. 부호연산자 ( +, - )
		  - 기본 자료형중에 boolean, char를 제외한 나머지 자료형에 사용가능
		
		3. 비트전환 연산자 (~) // 비트=2진수, 컴터는 음수값을 못알아듣는다
		  - 틸트는 자신의 타입을 유지하지못해서 byte앞에 붙으면 int로 변함
		  - 정수형과 char형에만 사용이 가능. (근데 char형은 양수를 ~해도 양수값으로 나온다)
		  - char형은 오버플로우때문에 사용하는 것임
		  - 피연산자를 2진수로 표현하였을때 0은 1로, 1은 0으로 바꾼다
		  
		    10   00001010
		   ~10   11110101 => 1의 보수 -11
		 ~10+1   11110110 => 2의 보수  -10
		     보수: 각 자리의 숫자의 합이 어느 일정한 수가 되게 하는 수
		*/
		
		byte b2 = 10;
		byte b3 = (byte)~b2;
		System.out.println(b3);
		
//		//비트변환연산자 혼자 연습 - 'char형은 오버플로우때문에 사용하는 것' -> 이게뭔소리여
//		char aa = 'A'; //65
//		char bb = (char)~aa; 
//		
//		System.out.println((int)aa); //65
//		System.out.println(bb); //특수문자 ㅎ
//		System.out.println((int)bb); //65470 : char를 비트변환한 값은 양수가 나옴.
		
		
		/*
		4. 논리부정 연산자 ( ! )
		  - boolean형에만 사용가능하다.
		  - true -> false, false -> true
		*/
		boolean power = false;
		System.out.println(power);
		
		//power의 값을 부정하여 다시 power변수에 저장해주세요
		power = !power;
		System.out.println(power);
		  
		  
		  
		  
		  
		  
		  
		  

		
		
				
		
		
	}
}
