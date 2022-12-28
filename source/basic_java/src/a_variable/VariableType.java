package a_variable;

public class VariableType {
	public static void main(String[] args) {
		/*
		변수의 타입
		
		1. primitive type(기본형 타입) - 8개, 기본값 1개만 지정가능
		  - boolean, char, byte, short, int, long, float, double
		
		2. reference type(참조형 타입)
		  - 8가지 기본형을 제외한 나머지 타입, 객체의 주소를 저장한다.
		  - 둔산동에 있는 경륜이네 집에 가면 경륜이 가족이 있다.
		  
		3. 기본형 타입 크기 (1byte = 8bit)
		  - 1byte : boolean, byte
		  - 2byte : char, short
		  - 4byte : int, float
		  - 8byte : long, double
		  
		4. 종류
		  - 논리형 : boolean (true, false 중 하나를 값으로) 
		  - 문자형 : char(a,b,c같은 1글자를 저장하는 데 사용)
		  - 정수형 : byte, short, int, long (정수값 저장, 기본형은 int)
		  - 실수형 : float, double (실수값 저장)
		
		5. 논리형 - boolean(기본값 : false)
		  - boolean형 변수에는 true 또는 false의 값 중 하나만 저장할 수 있다.
		  - boolean형 변수는 대답(yes/no), 스위치(on/off) 등의 논리구조에 사용
		  - 데이터를 다루는 가장 작은 단위가 byte이기 때문에 1byte의 크기를 가진다.
		  - *실제로는 1bit만 있어도 표현할 수 있음 bit 1칸에 2진수로 t/f표현 가능
		
		*/
		//Q. 변수 power를 선언하고 true의 값으로 초기화 하여라.
		// 변수명 : power 값 : true  1. 문제 내 주어진 값을 확인
		// 변수타입 변수명 = 값;        2. 초기화의 기본형
		// ??? power = true;      3. 변수명을 모르지만 true/false는 boolean 뿐임
		boolean power = true;
		
		// power name = true; 내가 처음에 실수한 거
		// boolean power = true; 그다음에 풀어본 거
		
		/*
		6. 문자형 - char
		 - java는 Unicode 문자체계(16진수)를 이용한다. 2byte의 크기를 가진다.
		 - 문자 하나를 저장하기 위해서 사용. 'A' (single quote)
		*/
		//Q. 변수 ch를 선언하고 'A'의 값으로 초기화 하여라.
		// 변수명 : ch, 값: 'A'
		// 변수타입 변수명 = 값;
		// ??? ch = 'A';
		char ch = 'A';
		char ch2 = '\u0041'; //유니코드, 41=16진수
		char ch3 = 65; //10진수
		System.out.println(ch);
		System.out.println(ch2);
		System.out.println(ch3);
		
		/*
		7. 정수형 - byte, short, int, long
		 - 기본 자료형은 int
		 - 변수에 저장하려는 정수값의 범위에 따라 4개의 정수형 중에 하나를 선택한다.
		 - byte, short의 경우 크기가 작아서 범위를 넘어서는 경우가 많다.
		      그래서 int형을 사용하는 것이 좋다.
		*/
		//Q1. 변수 b1에 50의 값을 저장하여라.
		byte b1 = 50;
		//Q2. 변수 s1에 25000의 값을 저장하여라.
		short s1 = 25000;
		//Q3. 변수 i1에 15억의 값을 저장하여라.
		int i1 = 1500000000;
		//Q4. 변수 l1에 53억의 값을 저장하여라.
		long l1 = 5300000000L; //자바는 int범위를 넘어서도 int로 인식하기때문에 long값이라고 알려줘야함
		
		/*
		8. 실수형 - float, double
		  - 실수형 값을 저장할 때 사용.
		  - float: 1+8+23 
		    double: 1+11+52
		  - 실수형 중 자료형을 선택할때는 값의 범위도 중요하지만 정밀도도 중요하다.
		    float: 소숫점 일곱째자리까지 3.141592 double: 13번째까지
		*/
		//Q1. 변수 f1에 3.141592를 저장하여라.
		float f1 = 3.141592F; //대표자료형이 double이라 소수점이 있으면 double로만 인식
		//Q2. 변수 d1에 3.141592531548를 저장하여라.
		double d1 = 3.141592531548;
		
		/*
		9. String
		  - 문자열을 다루는 클래스, 참조형
		  - 기본값이 null이다. (아직 주소 자체가 안만들어짐)
		*/
		String name = ""; //아무것도 없는 주소가 있는것 = 빈집
		String gibon = null; //집 자체가 없음
		
		String r1 = "========\n---\t-----"; // '\'제외 아무거나 무제한으로 들어가도 됨
		// \n 엔터쳐라 \t 탭만큼띄워라
		System.out.println(r1);
		
		//1. 변수 a1에 7의 값을 저장해 주세요
		//변수명 a1 변수값 7
		int a1 = 7;
		
		//2. 변수 s2에 "이름"의 값을 저장해 주세요
		//변수명 s2 변수값 이름
		String s2 = "9";	
		
		//3. a1과 s2의 합을 변수 result1에 저장해 주세요
		//숫자+문자 합? 변수명 result1 변수값 a1+s2
		//int + String => String + String (String이 범위 더 크기때문)
		String result1 = a1 + s2;
		System.out.println(result1);
		System.out.println(""+true); //"" + "true"
		System.out.println(""+null); //"" + "null"
		
		/*
		10. overflow
		  - 변수 자신이 저장할 수 있는 범위를 넘어섰을 때, 최솟값으로 돌아가서 다시 시작하는 현상
		  - 정수형에서만 일어남 - 그래서 int를 기본값으로
		*/
		byte b2 = 126; //byte는 최대저장값이 127
		b2++; //++: b2가 가지고 있는 값을 한단계 올려준다
		System.out.println(b2); // 127
		b2++;
		System.out.println(b2); // 128이 나올 것 같지만 -128이 나옴
		
		/*
		11. 형변환 (casting)
		  - '캐스트 연산자'를 이용하여 형변환을 할 수 있다.
		  - 'A' => 10진수일때 어떤 값인지??
		    10  => 문자형으로 뭘까??
		  - ** 연산할 것들의 타입이 같아야 연산을 할 수 있다
		*/
		int sip = 'A';
		System.out.println(sip);
		char ten = (char)10;
		System.out.println(ten);
		
		//Q1. byte형 변수 b3에 100의 값을 저장
		byte b3 = 100;
		//Q2. char형 변수 c3에 'K'의 값
		char c3 = 'K';
		//Q3. int형 변수 i3에 400000의 값을 저장
		int i3 = 400000;
		//Q4. float형 변수 f3에 3.14를 저장
		float f3 = 3.14F;
		
		//정상플로우: byte -> short, char -> int -> long -> float -> double
		
		//Q5. c3에 저장된 값의  10진수값을 변수 result2에 저장
		//c3는 캐릭터, 캐릭터를 10진수값 result2에 저장하는거니까 변수타입 int
		//int 값에 바로 넣고싶지만 c3는 캐릭터니까 앞에 (int)를 붙여 캐스팅
		//character->int 큰걸로 가는거니까 오버플로우 안 생겨서 (int) 생략가능
		int result2 = (int)c3;
		//Q6. result2의 값을 출력
		System.out.println(result2);
		
		//Q7. f3에 저장된 값중 정수값만 취득하여 result3에 저장
		//f3은 3.14, 실수를 정수 result3에 저장하니까 변수 int
		//int 값에 바로 넣고싶지만 f3은 실수니깐 앞에 (int)를 붙여 캐스팅
		//float->int 작은걸로 가는거니까 (int)붙여서 오버플로우 방지해야함!!
		int result3 = (int)f3;
		//Q8. result3를 출력
		System.out.println(result3);
		
		//예제1. 변수 a 선언, 8의 값으로 초기화
		int a = 8;
		//예제2. 변수 b 선언, 3의 값으로 초기화
		int b = 3;
		//예제3. 변수 result4 선언, a의 값을 b의 값으로 나누기한 결과로 초기화. (정수)
		int result4 = a/b;
		//예제4. 변수 result5 선언, a의 값을 b의 값으로 나누기한 결과로 초기화. (실수)
		//double result5 = a/b; 이건 2.0으로나옴
		//double result5 = (double)a/b; = 2.6666666665
		//double은 근사치, float이 정확한 값
		//a도 int, b도 int니까, 결과값도 int, 그래서 (float)(a/b)로 하면 안됨
		//하지만 실수 결과값을 얻고싶으니 (float)으로 캐스팅해줘야함
		//1. (float)*a/b 순서대로 연산, a가 먼저 float으로 바뀜
		//2. float / int 연산되니까 int가 float으로 바뀌는 결과가 나옴.
		float result5 = (float)a/b;
		System.out.println(result4);
		System.out.println(result5);
		
		//Q1. byte 타입의 변수 b6를 선언, 15의 값으로 초기화
		byte b6 = 15;
		//Q2. char 타입의 변수 c6를 선언, 'A'의 값으로 초기화
		char c6 = 'A';
		//Q3. b6와 c6의 합을 byte형 변수 result6에 저장
		//java의 기본인 4byte보다 작은 byte,short,char는 다 똑같이 int로 퉁침
		//b6, c6가 int로 만나서 
		byte result6 = (byte)(b6 + c6);
		
		System.out.println(result6);
		
		//p.23
		//Q1.
		byte byte01 = 33;
		//Q2.
		long long01 = 888;
		//Q3.
		char char01 = 'A';
		//Q4.
		float float01 = 3.141592F;
		//Q5.
		int intger01 = (int)long01;
		System.out.println(intger01);
		//Q6.
		short short01 = (short)char01;
		System.out.println(short01);
		//Q7.
		int integer01 = (int)float01;
		System.out.println(integer01);
		//Q8.
		int integer02 = (int)byte01; // or 생략가능
		System.out.println(integer02);
		//Q9.
		int integer03 = (int)char01; // or 생략가능 
		System.out.println(integer03);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
