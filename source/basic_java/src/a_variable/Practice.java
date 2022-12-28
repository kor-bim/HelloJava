package a_variable;

public class Practice {
	public static void main(String[] args){
//		System.out.println("1"+"2");		//12
//		System.out.println(true+"");		//1+공백
//		System.out.println('A'+'B');		//A의 문자코드 숫자값+B의 문자코드 숫자값
//		System.out.println('1'+2);			//'1'의 문자코드 숫자값+2
//		System.out.println('1'+'2');		//'1'의 문자코드 숫자값+'2'의 문자코드 숫자값
//		System.out.println(4+24.3715F);		//4+24.3715F 실수?
//		System.out.println('A'+3.14);		//A의 문자코드 숫자값+3.14
//		System.out.println('J'+"ava");		//'J'의 문자코드숫자값ava
//		System.out.println(true+null);		//오류
		
		//Q1. byte형 변수 b3에 100의 값을 저장
		byte b3 = 100;
		//Q2. char형 변수 c3에 'K'의 값
		char c3 = 'K';
		//Q3. int형 변수 i3에 400000의 값을 저장
		int i3 = 400000;
		//Q4. float형 변수 f3에 3.14를 저장
		float f3 = 3.14F;
		
		//Q5. c3에 저장된 값의  10진수값을 변수 result2에 저장
		int result2 = (int)c3;
		System.out.println(result2);
		
		//Q7. f3에 저장된 값중 정수값만 취득하여 result3에 저장
		int result3 = (int)f3;
		System.out.println(result3);
		
		//예제1. 변수 a 선언, 8의 값으로 초기화
		int a = 8;
		//예제2. 변수 b 선언, 3의 값으로 초기화
		int b = 3;
		//예제3. 변수 result4 선언, a의 값을 b의 값으로 나누기한 결과로 초기화. (정수)
		int result4 = a/b;
		//예제4. 변수 result5 선언, a의 값을 b의 값으로 나누기한 결과로 초기화. (실수)
		float result5 = (float)a/b;
		System.out.println(result4);
		System.out.println(result5);
		
		//Q1. byte 타입의 변수 b6를 선언, 15의 값으로 초기화
		byte b6 = 15;
		//Q2. char 타입의 변수 c6를 선언, 'A'의 값으로 초기화
		char c6 = 'A';
		System.out.println(c6);
		//Q3. b6와 c6의 합을 byte형 변수 result6에 저장
		byte result6 = (byte)(b6 + c6);
		System.out.println(result6);
		
//		System.out.println(""+byte);
		//String(참조)+byte(기본)=>연산안됨
		
		char ch01 = 'A';
				
		//5. 변수 ch01의 값이 ASCII값 숫자(ASCII값이 됐는데 숫자로 보이는애들) 때 true인 조건식
		//'0<= ch01 <= '9' (그냥 0,9가 아니고 ASCII코드 숫자값이니까 ''붙여줌)
		//'0' <= ch01 그리고 ch01 <= '9'
		System.out.println('0' <= ch01 && ch01 <= '9');
		
//		//ascii코드값 숫자범위
//		//0 <= ch01 <= 2^7-1
//		//0 <= ch01 && ch01 <=127

		System.out.println(0 <= ch01 && ch01 <= 127); //'A'=true, 65=true		
		
		int in01 = 10;
		boolean re1 = in01 % 2 == 0;
		boolean re2 = in01 % 4 == 0;
		System.out.println(re2);
		System.out.println(re1 || re2);
		
		
		char x = 'B';
	
		//대->"대문자", 소->"소문자", 그외->"영문자 아님"
		
		//x가 대문자 -y-> "대문자"
		//        -n-> x가 소문자? -y-> "소문자"
		//                      -n-> "영문자 아님"
		
		//대문자: 'A' <= x && x <= 'Z'
		//소문자: 'a' <= x && x <= 'z'
		
		//첫번째 시도
//		boolean cap = 'A' <= x && x <= 'Z';
//		boolean nocap = 'a' <= x && x <= 'z';
		
//		String result = cap = true ? "대문자" : nocap = true ? "소문자" : "영문자 아님";
		
		//두번째 시도
		//&&. ||은 boolean 형 또는 boolean형 값을 결과로 하는 조건식만 허용 -> 이거 안쓰고 해보자
		//변수타입 result = 대문자야 ? "대문자" : 소문자야 ? "소문자" : "영문자 아님" 
		
		
		
		
		
		
		
		
		
	}
}
