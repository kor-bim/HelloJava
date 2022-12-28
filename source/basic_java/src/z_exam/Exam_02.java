package z_exam;

public class Exam_02 {
	public static void main(String[] args){
		
		//P.45-47
		
		
		//[3-1] 다음 중 형변환을 생략할 수 있는 것은? (모두 고르시오)
		byte b = 10;
		char ch = 'A';
		int in = 100;
		long lo = 1000L;
		
		/*
		 * 형변환 흐름도
		 * byte -> short -> int -> long -> float -> double
		 * 			char  ↗
		 * 
		 * 1. boolean형 제외한 나머지 7개의 기본형은 서로 형변환이 가능하다.
		 * 2. 기본형과 참조형은 서로 형변환할 수 없다.
		 * 3. 작은타입 -> 큰타입 에서는 형변환 생략 가능
		 */
		
		// X(1) b= (byte) in; 
		//	int -> byte => 큰 -> 작 => 생략불가
		// X(2) ch= (char) b; ★
		//	byte -> char => b가 int로 바뀐 후에 캐스팅 => int -> char => 큰 -> 작 => 생략불가
		// X(3) short s = (short) ch;
		//	char -> short => ch가 int로 바뀐 후 캐스팅 => int -> short => 큰-> 작 => 생략불가
		// O(4) float f = (float) lo; 
		//	long -> float => 작 -> 큰 => 생략가능
		// O(5) in = (int) ch;
		//	char -> int => 작 -> 큰 => 생략가능
		
		
		//[3-2] 다음 연산의 결과를 적으시오.
		int x = 2;
		int y = 5;
		char c = 'A'; // 'A'의 문자코드는 65
		
		// (1) System.out.println(1 + x<<33);
		/*
		 * 내가 푼 오답)
		 * 연산 순서: x<<33  ->  1 + x<<33
		 * 1. x<<33 : x^33 -> 2 대입 -> 2^33 -> int는 32비트이기 때문에, 32칸 움직이면 다시 제자리 -> 2^32 * 2^1 -> 2
		 * 2. 1 + x<<3 : 1 + 2 
		 * 답 : 3
		 * -틀린이유:
		 * 1) 연산순서도 잘못됨: 			   사칙연산 내에서 *,% -> +,- -> <<,>>,>>> 순서로 진행
		 * 2) 쉬프트 연산자의 개념도 잘못알았음: x<<33 은 그냥 2^33이 아니고 x * 2^33 이어야함! ★
		 * 
		 * 정답)
		 * 연산순서: 1+x -> 1+x의 <<33
		 * 1. 1+x = 3
		 * 2. (1+2) << 33 -> 3 << 33 -> 3 * 2^33 -> 3 * 2^32 * 2^1 -> int는 32비트, 32칸움직이면 제자리
		 * 답: 3*2 = 6 
		 */

		// (2) System.out.println(y >= 5 || x < 0 && x > 2);
		/*
		 * 연산 순서: &&이 ||보다 먼저 실행된다.
		 * &&: 두 조건 모두 true여야 true
		 * ||: 두 조건 중 하나라도 true면 true
		 * 
		 * 1. x < 0 && x > 2 :  조건1: false 조건2: false 결과: false
		 * 2. y >= 5 || false : 조건1: true  조건2: false 결과: true
		 * 답 : true
		 */
		
		// (3) System.out.println(y += 10 - x++);
		/*
		 * 연산 순서: 단항연산자(++,--,~,!)가 제일 먼저 계산된다.
		 * 단항 연산자: 숫자++(후위형): 대입 후, 증가한다.
		 * 대입 연산자: 원래 타입 유지하며 연산되고, 새로운 값이 저장된다. 가장 낮은 우선순위.
		 * 
		 * 1. 10 - x++ : 10 - 2 = 8 (이제 x = 3)
		 * 2. y += 8 : y = y+8 -> y+8=13
		 * 답 : 13
		 * 
		 * 그럼 이제 x=3, y=13
		 */
		
		
		// (4) System.out.println(x += 2);
		/*
		 * x += 2 : x = x+2 
		 * x는 (문제3)에서 3이 되었으므로
		 * 답: 5
		 * 
		 * ** 그럼 이제 x=5로 변함
		 */
		
		// (5) System.out.println(!('A' <= c && c <= 'Z'));
		/*
		 * &&: 두 조건 모두 true여야 true
		 * !: 논리부정연산자. boolean형만 사용가능.
		 * 
		 * char c = 'A' // 65
		 * 1. 조건1: 'A' <= c -> true
		 * 2. 조건2: c <= 'Z' -> true --> true
		 * 3. !true
		 * 답: false
		 */
		
		// (6) System.out.println('C' - c);
		/*
		 * 산술 변환의 규칙
		 * 1. 두 피연산자의 타입을 같게 일치시킨다 (보다 큰 타입으로 일치)
		 * 2. 피연산자의 타입이 int보다 작은 타입이면 int로 변환한다.
		 * 
		 * 1. char + char => int (int보다 작은 타입이면 int로 변환)
		 * 2. 67 - 65 = 2
		 * 답: 2
		 */
		
		
		// (7) System.out.println('5' - '0');
		/*
		 * 1. char + char => int (int보다 작은 타입이면 int로 변환)
		 * 2. 5의 아스키코드값 - 0의 아스키코드 값 
		 * 3. 5차이
		 * 답: 5 (숫자)  //이걸 응용하는 문제가 다음장 연습문제에서 나올것
		 */
		
		// (8) System.out.println(c+1);
		/*
		 * <산술 변환의 규칙>
		 * 1. 두 피연산자의 타입을 같게 일치시킨다 (보다 큰 타입으로 일치)
		 * 2. 피연산자의 타입이 int보다 작은 타입이면 int로 변환한다.
		 * 
		 * 1. char + int -> int + int -> int
		 * 2. 65 + 1 = 66
		 * 답 : 66
		 */
		
		// (9) System.out.println(++c);
		/* 
		 * <증감 연산자>
		 * 1. 자동 형변환이 발생하지 않아, 타입이 그대로다.
		 * 2. ++숫자 : +1된 숫자로 대입 후 계산
		 * 3. 숫자++ : 기존 숫자로 계산 후 +1증가
		 * 4. 혼자있을 땐 아무 상관없다.
		 * 
		 * 1. ++c : 'B'  (이제 c='B')
		 * 답 : B
		 */
		
		// (10) System.out.println(c++);
		/*
		 * <증감 연산자>
		 * 1. c=c++; 이렇게 변수 초기화처럼 혼자있을 땐 상관없다.
		 * 2. System.out.println(c++) : print가 있기때문에 연산식처럼 생각
		 * 
		 * 1. 위 문제에서 c가 66으로 바뀜.
		 * 2. c먼저 대입 후 증가
		 * 3. c='B' (이제 c='C')
		 * 답 : B
		 */
		
		// (11) System.out.println(c);
		/*
		 * 1. 위에서 c가 'C'로 바뀜.
		 * 답 : C
		 */
		
		System.out.println(1 + x<<33);
		System.out.println(y >= 5 || x < 0 && x > 2);
		System.out.println(y += 10 - x++);
		System.out.println(x+=2);
		System.out.println(!('A'<=c && c<='Z'));
		System.out.println('C'-c);
		System.out.println('5'-'0');
		System.out.println(c+1);
		System.out.println(++c);
		System.out.println(c++);
		System.out.println(c);
		
		
		
		
		//[3-3] <num의 값에 따라 "양수", "음수", "0"을 출력하는 코드>
		//		삼항연산자를 이용해서 만드세요.
		int num = 10;
//		String result = ( 답 )
//		System.out.println(result);
		
		/* 
		 * <삼항 연산자>
		 * 1. 조건 ? true : false
		 * 2. 삼항 연산자 안에 삼항 연산자 넣을 수 있음
		 * 
		 * 1. num이 양수?
		 * 1-y. "양수" 1-n. num이 음수?
		 * 1-n-y. "음수" 1-n-n. "0"
		 * 
		 * num이 양수? : num > 0
		 * num이 음수? : num < 0
		 * 
		 * 두 질문 합치면
		 * 답 : num > 0 ? "양수" : num < 0 ? "음수" : "0"
		 */
		String result = num > 0 ? "양수" : num < 0 ? "음수" : "0";
		System.out.println(result);
		
		
		
		//[p.41 비슷한 문제] <result0 값에 따라 "대문자", "소문자", "영문자 아님"을 출력하는 코드>
		char eng = 'B';
//		String result0 = ( 답 );
//		System.out.println(result0);
		
		/*
		 * 1. x가 대문자?
		 * 1-y. "대문자" 1-n. x가 소문자?
		 * 1-n-y. "소문자" 1-n-y. "영문자 아님"
		 * 
		 * x가 대문자? : 'A' <= x && x <= 'Z'
		 * x가 소문자? : 'a' <= x && x <= 'z'
		 * 
		 * 두 질문 합치면
		 * 답: 'A' <= eng && eng <= 'Z' ? "대문자" : 'a' <= eng && eng <= 'z' ? : "소문자" : "영문자 아님";
		 */
		 String result0 = 'A' <= eng && eng <= 'Z' ? "대문자" : 'a' <= eng && eng <= 'z' ? "소문자" : "영문자 아님";
		 System.out.println(result0);
		
		 
		 
		//[3-4] <사과를 담는데 필요한 바구니의 수를 구하는 코드>
		//		만일 사과의 수가 123개이고 하나의 바구니에는 10개의 사과를 담을 수 있다면,
		//		13개의 바구니가 필요할 것이다.
		int apples = 123; //사과의 개수
		int bucket = 10; //바구니의 크기 (바구니에 담을 수 있는 사과의 개수)
//		int numOfBucket = ( 답 ) // 모든 사과를 담는데 필요한 바구니의 수
//		System.out.println("필요한 바구니의 수 :"+numOfBucket); //13
		
		/* ---오답  (이유: 변수 값이 달라지면 적용이 안된다.)
		 * <정수 올림>
		 * 0. float -> int 하면서 소수점 버리는 것을 이용할 것이다.
		 * 1. 설명다시쓰기
		 * 
		 * 1. 일의 자리에서 십의 자리로 올릴 것: 123 + 10 		133
		 * 2. 십의 자리이상 남겨둘 것: (123 + 10)/10			13.3
		 * 3. int 캐스팅 (정수화): (int)((123+10)/10)	13
		 * -- 이렇게 하면 apple, bucket 수가 바뀔 때 쓸 수 없음 
		 * 
		 * 1. apples + bucket
		 * 2. (apples + bucket)/10
		 * 오답: (int)((apples + bucket)/10)
		 * 
		 */
		
		/* 정답
		 * 1. 꽉 찬 바구니들만 있을 때  = '바구니 용량'이 '사과의 개수' 배수일 때 ==> 나머지 0
		 * 2. 바구니 용량에 다 차지 않았을 때 ==> 나머지가 있을 때
		 * 
		 * 질문
		 * Q. 바구니가 꽉 차고 남은 사과가 없니??
		 * YES. 몫만큼 바구니 개수 필요 
		 * NO. 몫+1 만큼 바구니 더 필요 (나머지 담기 위한 용도)
		 * 
		 * 삼항 연산식에 대입하면
		 * 조건. apples % bucket == 0?
		 * true. apples / bucket			-> int / int 니까 캐스팅 안해줘도됨 
		 * false. apples / bucket + 1		-> int / int 니까 캐스팅 안해줘도됨
		 * 답 : apples % bucket == 0 ? apples / bucket : apples / bucket + 1
		 * 
		 * 선생님풀이  -- 다시이해해보기
		 * 나머지==0 -> 몫+0
		 * 나머지>0  -> 몫+1 
		 * 몫 + (나머지가 0 ? 0 : 1)
		 * 
		 * 다른풀이 (틀린풀이)
		 * (apples+bucket)/bucket
		 * 분배법칙때문에 apples/bucket + bucket/bucket -> apples/bucket + 1
		 *  
		 */
		int numOfBucket = apples % bucket == 0 ? apples / bucket : apples / bucket + 1;
		System.out.println("필요한 바구니의 수:"+numOfBucket);
		
		
		//[3-5] <변수 num2의 값 중에서 백의 자리 이하를 버리는 코드>
		//		만일 num의 값이 '456'이라면 400이 되고, '111'이라면 '100'이 된다.
		int num2 = 456;
//		int result2 = (답);
//		System.out.println(result2);
		
		/* 
		 * <정수 버림>
		 * 0. float -> int 하면서 소수점 버리는 것을 이용할 것이다.
		 * 1. 남기고 싶은 자리까지는 정수가 되도록 10^-n으로 나눠준다
		 * 2. (숫자*10^-nF)를 int로 캐스팅해 정수만 남겨준다.
		 * 3. 다시 10^n만큼 곱해 원래 자릿수로 만들어준다.
		 * 
		 * 내가 푼 방식 (이건 정수말고 실수일 경우에 쓰는 풀이 방법)
		 * 1. 백의 자리 이하 버릴 것 : 456 * 10^-2 				4.56
		 * 2. int 캐스팅(정수화) : (int)(456 * 10^-2) 	 	4
		 * 3. 다시 10^2 곱해 준다 : (int)(456 *10^-2)*100 	400
		 * 답: (int)(num/100)*100
		 * 
		 * 쉬운방법 (이게 문제가 요구한 풀이방법)
		 * 1. 100으로 나눠서 나머지 값을 변수 num에서 빼주면 됨
		 * 2. num - (num % 100)
		 * 답: int result = num - num % 100
		 * 
		 * 쉬운방법2
		 * 1. 어짜피 인트니까 num/100하면 4가 된다
		 * 2. 다시 100곱해준다
		 * 답: int result = ( num / 100 )* 100
		 */
		int result2 = (int)(num2/100)*100;
		System.out.println(result2);
		
		
		//[3-6] 아래의 코드의 문제점을 수정해서 실행결과와 같은 결과를 얻도록 하시오
		byte a6 = 10;
		byte b6 = 20;
		byte c6 = (byte)(a6+b6); // byte+byte -> int => byte로 형변환
		char ch6 = 'A';
//	X	ch6 = ch6 + 2; // char + int -> int가 되니 char로 형변환
		ch6 = (char)(ch6 + 2); //혹은 ch6 +=2 ch6 해도됨
//	X	float f6 = 3/2;  // int / int -> int => 1.5 값이 int 로  1이 됐다가 -> float로 형변환되어서 소수점 이하 손실 (1.0)
		float f6 = 3/2F;
//	X	long l6 = 3000 * 3000 * 3000; // int 범위 넘어서서 오버플로우. long이라는거 인식시켜줘야됨.. 밥그릇에 국담는다고 밥되는거아니다 밥될려면 국밥을 담아줘야된다..?
		long l6 = 3000L * 3000 * 3000; // 앞에서부터 하나씩 차례대로 연산이 진행되니까 캐스팅을 맨앞에서 바로 붙여줘야됨
		float f26 = 0.1f;
		double d6 = 0.1;
//	x	boolean result3 = d6==f26;		//해설) double은 2^n승으로 표현됨 -> 그에 가까운 근사치  0.1f은 정확한값이 나온다
		boolean result3 = (float)d6==f26; //해설) 만약 같은 값으로 비교하고싶으면  정확한 float으로 캐스팅 (double은 부정확)
//	x	boolean result3 = !(d6==f26);   //오답인 이유) 지금은 맞지만 0.5라고 하면 틀린값으로 나오기때문

		System.out.println("c6="+c6);			// c6=30
		System.out.println("ch6="+ch6);			// ch6=C
		System.out.println("f6="+f6);			// f6=1.5
		System.out.println("l6="+l6);			// l6=27000000000
		System.out.println("result3="+result3);	// result3=true

		
		//[3-7] <변수 num3의 값보다 크면서도 가장 가까운 10의 배수에서 변수 num3의 값을 뺀 나머지를 구하는 코드>
		//		예) 24의 크면서도 가장 가까운 10의 배수는 30이다. 19의 경우는 20이고, 81의 경우는 90이다.
		//			30에서 24를 뺀 나머지는 6이기 때문에 변수 num3값이 24라면 6을 결과를 얻어야 한다.
		int num3 = 24;
//		int result4 = ( 답 );
//		System.out.println("result4 :"+result);
		
		/*
		 * <num3의 값보다 크면서도 가장 가까운 10의 배수>
		 * 1. 올린 값 만들기 위해 10 더하기 :		24 + 10 = 34
		 * 2. 1의 자리 버릴 수 있도록 10 나누기 : 	(24 + 10) / 10 = 3.4
		 * 3. 소수점 이하 버리도록 int로 캐스팅 : 	(int)((24 + 10)/10) = 3
		 * 4. 다시 자리수 원상 복귀하도록 10 곱하기 :(int)((24 + 10)/10)*10 = 30
		 * 5. 24를 num3 으로 치환
		 * 
		 * <구하려는 코드: 'num3의 값보다 크면서도 가장 가까운 10의 배수' - 'num3의 값'
		 * 내가 푼 답) -10의자리를 이용한 풀이 -- 이거풀이방식 이상한거같은데 다시해보자
		 * 답: (num3+10)/10)*10 - num3;   //int니까 굳이 캐스팅할필요없음
		 *    = 결합방식 쓰면(num3/10+1)*10-num3
		 *    
		 * 쉬운 풀이) -1의자리를 이용한 풀이 -- 해당숫자의1의자리와 정답을 합치면 10
		 * 1. num%10하면 1의자리 취득
		 * 2. 정답을 x로 두면 num%10 + x =10
		 * 3. x= 10 - num%10
		 * 답: 10-num3%10
		 * 
		 */
		int result4 = ((num3+10)/10)*10 - num3;
		System.out.println("result4:"+result4);
		
		
		
		//[3-8] <화씨(Fahrenheit)를 섭씨(Celcius)로 변환하는 코드>
		//		변환공식: C = 5/9 * (F - 32)
		//		단, 변환 결과값은 소수점 셋째자리에서 반올림해야한다.
		int fahrenheit = 100;		// 화씨
//		float formula = ( 답1 );		// 변환공식 활용
//		float celcius = ( 답2 );		// formula 소수점 셋째자리에서 반올림
//		System.out.println("Fahrenheit"+fahrenheit);
//		System.out.println("Celcius:"+celcius);
		
		//섭씨로 바꾸는 코드
		float formula = 5F/9 * (fahrenheit - 32);
		/*
		 * 처음했던 생각) --틀림
		 * 공식 그대로 5/9로 적용하면 double * int 가 된다. float의 값을 얻기위해 5/9에 F를 붙여준다.
		 * 
		 * 다시한 생각)
		 * float celcius = 5 / 9 * (F - 32); int / int * (int - int) -> int * int -> int -> 캐스팅필수
		 * float celcius = 5F / 9 * (F - 32); float / int * int -> float * int -> float
		 */
		
		//변환된 섭씨(formula)를 소수점 둘째자리까지만 표현하는 코드
		/*
		 * 1. formula를 둘째자리까지 정수로 만들어준다 : formula * 100
		 * 2. 0.5를 더하여 반올림하여준다 :			 formula * 100 + 0.5
		 * 3. int로 캐스팅해 소수점을 없애준다 : 		 (int)(formula+0.5 * 100)
		 * 3. 다시 소수점 2자리로 만들어준다 : (int)(formula * 100+0.5)/100F    //100F 하는 이유: float 값으로 만들어줘야해서
		 * 답: float celcius = (int)(formula*100+0.5)100f;
		 */
		float celcius = (int)(formula*100+0.5)/100F; //그냥 100으로 나누면: int / int -> 37 => 37이 자동으로 캐스팅 => 37.0 으로 됨
		
		System.out.println("Fahrenheit:"+fahrenheit);
		System.out.println("Celcius:"+celcius);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
