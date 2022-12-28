package a_variable;

/**
 * doc주석
 * @author PC-02
 * @since 2020.07.21
 *
 */
public class VariableBasic {
	public static void main(String[] args) {//어떠한 일을 수행(메소드)
		
//		한줄주석 (ctrl+shift+C)
		
		/*
		여
		러
		줄
		*/

		int a; //int:변수타입(이) a:변수명(경륜)
		
		/*
		 * 1. 변수 Variable
		 *  - 단 하나의 값을 저장할 수 있는 공간이다.
		 * 
		 * 2. 변수의 선언 - 이름 선점
		 * 	[변수타입] 변수명; (;<- 한 줄 끝났다)
		 * 선언할때만 타입을 쓰고, 그 후로는 그냥 이름만쓰면됨
		 *
		 * 3. 변수의 초기화
		 * 	변수명 = 값;
		 */
		
		int name; //int는 정수
		 
		name = 10; //변수의 초기화
		
		int name2 = 20; //변수의 선언 및 초기화
		 
		name2 = 40; //변수값 변경 가능
		 
		System.out.println(name2);
		 
		/*
		 * 1. 명명규칙
		 */
		
		//1. 대소문자를 구분하며, 길이의 제한이 없다.
		byte nAmefdfds;
		
		//2. 예약어(keyword, reserved word)는 사용할 수 없다.
		//2-1. 이클립스에서 자주색 = 예약어
		int tRUe;
//		int true;
		
		//3. 숫자로 시작하면 안된다.
		int to5p5;
//		int 5top;
		
		//4. 특수문자'_', '$'만 사용 가능하다.
		int $h_arp;
//		int s#arp;
		
		
		// 개발자간의 암묵적인 약속들(가독성 상향)
		//1. 클래스명의 첫글자는 대문자로 쓴다.
		//	- 변수명과 메소드명은 첫 글자로 소문자를 쓴다.
		
		//2. 여러단어로 이루어진 경우에는 첫번째 이후 단어의 첫글자는 대문자로 써야한다.
		//	last index of -> lastIndexOf
		
		//3. 상수의 이름은 모두 대문자로 써야한다. 두글자 이을때는 '_' 사용
		final int MAX_VALUE = 100; //final이 붙으면 상수됨
		
		//4. 한글은 사용하지 않는다.
		//4-1. 인코딩 설정때문에. ex. utf-8 아니면?
		//4-2. 의미가 애매한게 많다. ex. blue 푸르스름, 퍼렇다
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		

	}

}
