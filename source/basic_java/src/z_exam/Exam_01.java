package z_exam;

public class Exam_01 {
	public static void main(String[] args) {
		
		//P.24-25
		
		//[2-2] 리터럴, 변수, 상수
		int i =100;
		long l = 100L;
		final float PI = 3.14f;
		
		// - 리터럴: 100, 100L, 3.14F (★ L이랑 F도 포함해야한다.)
		// - 변수: i, l
		// - 키워드: int, long, final, float (자주색 글씨)
		// - 상수: PI
		

		//[2-4] 다음 문장들의 출력 결과. 오류 있으면 괄호 안에 '오류'
		// (1) System.out.println("1" + "2");
		/*
		 * String + String -> String 간 결합
		 * 답: 12
		 */
		
		// (2) System.out.println(true + "");
		/*
		 * boolean + String = String + String = String
		 *    "true" + "" = "true"
		 *  답: "true"
		*/
		
		// (3) Q3. System.out.println('A' + 'B');
		/*
		 *  char + char => int + int => 'A'의 숫자값 + 'B'의 숫자값 
		 *	character의 숫자값 구하는 방법: 정수형으로 변수 선언 및 초기화하여 출력. 
		 *	tip. 4바이트보다 작은애들(byte, char, short)끼리 연산할땐 자동으로 int가 된다.
		 *	  -> 유니코드 표 찾기 or 캐스팅하기
		 *
		 *	int a = 'A';
		 *	System.out.println(a); //65
		 *	int b = 'B';
		 *	System.out.println(b); //66
		 *	65+66=131
		 *	답: 131
		 */
		
		// (4) System.out.println('1' + 2);
		/*	
		 * 	char + int => int + int => '1'의 숫자값 + 2
		 *	int c = '1';
		 *	System.out.println(c); //49
		 *	49+2=51
		 *	답: 51
		 */
		
		// (5) System.out.println('1' + '2');
		/*
		 * char + char => int => '1'의 숫자값 + '2'의 숫자값
		 *	int d = '2';
		 *	System.out.println(d); //50
		 *	49+50=99
		 *	답: 99
		 */
		
		
		//  (6) System.out.println(4 + 24.3715F);
		/*
		 *  int + float => float + float 
		 *	변수 타입이 같아야 연산 가능하니 int를 float로 캐스팅
		 *	float e = 4; // int->float 으로 가는 것이니 (float) 생략 가능
		 *	float f = 24.3715F;
		 *	System.out.println(e+f); // 28.3715
		 *	답: 28.3715
		 */
		
		//	(7) System.out.println('A' + 3.14);
		/*
		 *	char + double => double + double
		 *	'A'의 숫자값 + 3.14
		 *	int a = 'A'; 위에서 이미 정수로 초기화함. 
		 *	3.14는 실수이니 연산을 위해 정수를 실수로 캐스팅
		 *	double g = a;
		 *	System.out.println(g + 3.14); // 68.14
		 *	답: 68.14
		 */
		
		//	(8) System.out.println('J' + "ava");
		/*
		 *  char + String => String + String => String
		 *	답: "Java"
		 */
		
		//	(9) System.out.println(true + null);
		/*
		 *  true는 boolean형의 값
		 *	null은 참조형의 기본값 => 그래서 null 주인(타입)이 누군지 모름 => 타입 일치 불가 
		 *	기본형과 참조형은 서로 형변환할 수 없다. (책 22쪽)
		 *	답: 오류
		 *	System.out.println(true + "null"); // null
		 */
	
		//[2-5] 키워드가 아닌 것은?
		//	(1) if
		// v(2) True	-> true
		// v(3)	NULL	-> null
		// v(4) Class	-> class
		// v(5)	System	-> 이클립스에서 검은색으로 보임
		
		/*
		 *  키워드는 이클립스에서 자주색으로 보인다.
		 *  첫글자가 대문자면 클래스명
		 */
		
		

		/*
		[2-6] 변수의 이름으로 사용할 수 있는 것
		v 1. $ystem : 특수문자 '_', '$' 사용 가능
		  2. channel#5 : X. 
		  3. 7eleven : X. 첫 글자에 숫자 불가
		v 4. If : (암묵적 약속: 첫 글자에 대문자 불가,클래스명만 가능)
		v 5. 자바 : (암묵적 약속: 한글X)
		  6. new : X(예약어는 변수명으로 사용불가)
		v 7. $MAX_NUM : (암묵적 약속: 전부 대문자이며 _으로 연결하는 것은 상수)
		  8. hello@com :특문은 '_', '$'만 사용 가능
		*/

		
		//[2-7] 참조형 변수와 같은 크기의 기본형은?
		/*
		 * 참조형 변수의 크기 4byte
		 */
		
		/*
		답: int, float
		오답: long(8byte), short(2byte), double(8byte)
		*/
		
		
		//[2-8] 형변환 생략할 수 있는 것
		/*
		 *참고: byte-char,short-int-long-float-double
		 */
		
		/*
		byte b = 10;
		char ch = 'A';
		int i = 100;
		long l = 1000L;
		*/
		
		/*
		  1. b = (byte)i (불가, int -> byte)
		  2. ch = (char)b (불가, byte -> char)
		  3. short s = (short)ch (불가, char -> short)
		v 4. float f = (float)l; (long -> float)
		v 5. i = (int)ch; (char -> int)
		*/
		

		
		
		//[2-9] char타입의 변수에 저장될 수 있는 정수 값의 범위는?
		//	char는 2byte = 16bit. 
		//	정수형은 부호값때문에 한칸비워야하지만 char는 문자형이어서 안비워도됨
		// 범위: 0~2^16-1
		
		
		/*
		[2-10] 변수를 잘 못 초기화 한 것은?
		v Q1. byte b = 256;
		  A1. byte 범위 = -2^7 ~ 2^7-1 = -128 ~ 127
		v Q2. char c = '';
		  A2. 무조건 1글자 가져야함. '' 안에 공백이라도 넣어야함
		v Q3. char answer = 'no';
		  A3. 무조간 1글자 
		v Q4. float f = 3.14
		  A4. 3.14f;로 수정 실수는 기본자료형 double로 인식하기때문.
		o Q5. double d = 1.4e3f;
		  A5. 1. double d = (double)1.4e3f; 캐스팅연산자 생략됨 
		*/
		
		
		
		
		
	}

}
