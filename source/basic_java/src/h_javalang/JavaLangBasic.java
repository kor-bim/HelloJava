package h_javalang;


public class JavaLangBasic {
	public static void main(String[] args) {
		/*
		1. java.leng 패키지
			- java프로그래밍 기본적으로 필요한 클래스들을 모아놓은 패키지이다.
			- String, Object, System ...
		2. Object
			- Object클래스는 멤버변수없이 11개의 매서드로 되어있다.
			- equals()
				: 참조변수가 가르키는 주소를 비교
				: 주소가 아닌 해당 인스턴스가 가지고 있는 값을 비교하게 하려면 equals()를 오바라이드 해야한다.
				: equals()가 오버라이드 되어있는 클래스들 => String, File, Date...
			- hashCode() - 10진수로 이루어져 있다
				: 객체의 주소에서 해시코드를 만들어 반환한다.
				: String 클래스는 같은 문자열을 가지고 있다면 동일한 해시코드를 반환하게 만들어져 있다. 
			- toString()
				: Object의 toString()
					=> return getClass().getName()+"@"+Integer.toHexString(hashCode());
				: toString() 오버라이드 되어있는 클래스들
					=> String, 
			- getClass()
				: 클래스의 정보를 얻어올 때 사용한다.
				
					(1) 생성된 객체로부터 얻는 방법
						Class obj = new Person().getClass();
					(2) 클래스 리터럴로 부터 얻는 방법
						Class obj = Person.class;
					(3) 클래스명으로부터 얻는 방법
						Class obj = Class.forName("Person");
			
		3. String
			- 다른언어에서는 문자열을 char[]형 배열로 다룬다. 하지만 java에서는 문자열을 다를 수 있는 String클래스 제공한다.
			- 문자열을 합칠때는 합쳐진 문자열을 저장할 인스턴스 새로 생성된다.
			- 문자열의 비교
				: 문자열 리터럴 만드는 방법과, 객체의 생성자를 이용할 수 있다.
			- 인코딩변환
				: 이클립스에서는 기본 인코딩방식은 MS949
				: 한글 윈도우의 기본 인코딩방식은 CP949
				: 우리가 사용하는 인코딩 방식은 UTF-8
			- 문자열 format
				: 기본형 타입을 String타입으로 변환
					1) 빈문자열을 더하는 방식
						int a = 10;
						String b =a + "";
					2) valueOf()
						String b = String.valueOf(a);
				: String 타입을 기본형으로 변환
					1) wrapper클래스를 이용하는 방식
						String b = "123";
						int c = Integer.parseInt(b);
						int c = Integer.valueOf(b);
					2) wrapper클래스의 진수
						String b = "234"
						int c = Integer.parseInt(b,8);
		4. StringBuffer, StringBuilder
			- 문자열을 합치기 위해서 사용한다.
		5. wrapper클래스
			- 모든것을 객체로 다루어야 한다.
			기본형 
			boolean   | Boolean
			char      | Character ***
			byte      | Byte
			short     | Short
			int       | Integer
			long      | Long
			float     | Float
			double    | Double
			-기본형 타입 => wrapper클래스타입으로 변환 : auto-boxing
			- wrapper클래스타입 => 기본형타입 : unboxing
		6. 정규식
			- 텍스트 데이터에서 원하는 형태의 문장을 찾기 위해 만들어 졌다.
			- 정규식 순서
				: 패턴정의
					=> Pattern클래스를 이용하여 패턴을 정의한다.
					Pattern p = Pattern.compile("[a-z]*");
					: 텍스트와 비교
						=> Matcher클래스를 이용하여 패턴과 텍스트를 비교한다.
						Matcher m = p.matcher("text");
						m.matches()
			- 정규식 문법
				^ : 문자열의 시작 ^a
				$ : 문자열의 끝 a$
				. : 임의의 한문장, \ 는 포함되지않음
				* : 0개 또는 무한정 있을 수 있다.
				+ : 1개 이상 있을 수 있다.
				? : 0개 또는 1개
				() : 하나의 문자로 인지한다. (abc)
				{} : 반복횟수를 지정한다. {3,5}// 3,4,5번 반복 {4,}//4번이상 반복
				[] : 범위를 나타날때 쓴다 [abc]// abc중에 하나 [a-zA-z] a에서z A에서 Z or생략가능 
				|  : or연산을 수행할때 사용
				\s : 공백문자
				\S : 공백을 제외한 모든 문자
				\w : 영어 대문자 또는 소문자 또는 숫자 [a-zA-z0-9]
				\d : 숫자만 [0-9]
				
				
			
		 */
		
	}
}
