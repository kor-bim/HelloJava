package z_exam;

import java.util.Scanner;

public class Exam_03 {
	public static void main(String[] args) {
		
		//p.58-57 명령문
		
		//[4-1] 조건식으로 표현하라
		//(1) int형 변수 x가 10보다 크고 20보다 작을 때 true인 조건식
		/*
			조건1:	10 < x
			결합: 	&&
			조건2:	x <20
			
			답:		10 < x && x <20
		*/
		
		//(2) char형 변수 ch가 공백이고 탭이 아닐 때 true인 조건식
		/*
			조건1:	ch == ' '
			결합:		이고 -> &&
			조건2:	ch != '\t'
			
			답:		ch == ' ' && ch != '\t' 
		*/
		
		//(3) char형 변수 ch가 'x' 또는 'X'일 때 true인 조건식
		/*
 			조건1:	ch == 'x'
 			결합:		또는 -> ||
 			조건2:	ch == 'X'
 			
 			답: 		ch == 'x' || ch =='X'
		*/
		
		//(4) char형 변수 ch가 숫자('0'~'9')일 때 true인 조건식
		/*
			범위:		'0' <= ch <='9'
			조건1:	'0' <= ch
			결합:		중간에 있으니 &&
			조건2:	ch <= '9'
			
			답:		'0' <= ch && ch <= '9'
		*/
		
		//(5) char형 변수 ch가 영문자(대문자 또는 소문자)일 때  true인 조건식
		/*
			대문자범위:		'A' <= ch <= 'Z'
			대문자조건:		'A' <= ch && ch <= 'Z'
			소문자범위:		'a' <= ch <= 'z'
			소문자조건:		'a' <= ch && ch <= 'z'
			* &&은 ||보다 먼저 계산된다.
			
			답: 'A' <= ch && ch <= 'Z' || 'a' <= ch && ch <= 'z'
		*/
		
		
		//(6) boolean형 변수 powerOn가 false일 때 true인 조건식
		/*
			boolean powerOn = false 일때 true?
			답: powerOn == false
			답: !powerOn
		*/
		
		//(7) 문자열 참조변수 str이 "yes"일 때 true인 조건식
		/*
		 	
			답: str == "yes"
			답2: "yes".equals(str) // str은 null일 수도 있으니 무조건 있는 "yes"를 앞에 둬야한다
			
		*/
		
		
		
		//[4-2] 1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하시오
		//2또는 3의배수가 아닌수 = 2의배수가 아닌수 또는 3의배수가 아닌수의 총합
		//1+5+7+11+13+17+19 => 73
		
		//풀이
		//1) 1부터 20까지 합계 구하는 식을
		//2) '정수 num은 2 또는 3의 배수가 아닌 수'라는 조건 추가
		int sum = 0;
		//sum += 1;		시작: 1 , 끝: 20,	증가: +1
		//sum += 2;		조건: num%2 != 0 && num%3 != 0
		//...			반복: sum += num
		//sum += 20;
		for(int num = 1 ; num < 21 ; num++){
			if(!(num%2 ==0 || num%3 ==0)){
				sum += num;
			}
		}
		System.out.println(sum);
		
	

		
		//[4-3] 다음의 for문을 while문으로 변경하시오
//		for(int dan = 2; dan < 10; dan++){
//			for(int gob = 1; gob < 10; gob++) {
//				System.out.println(dan + "*" + gob + "=" + dan*gob);
//			}
//		}
		//for문의 내용: 2단에서 9단까지, 구구단 출력
		/*
		 	*while의 특성
		 	-반복횟수모를때많이사용, 알때도 쓸 수있다
			*while의 기본구조
			-초기화;						
			 while(조건식){
				조건식이 true일때 수행될 문장
				증감식;
			}
		*/
		//문제에서 얻을 수 있는 것:
		//1) 안쪽 for문 : 구구단 안에서의 곱 (2단으로 가정하고 문제풀기)
		//시작: 1, 끝: 9, 증감: gob++ 수행문: System.out.println(dan + "*" + gob + "=" + dan*gob);
//		int gob = 1;
//		while(gob < 10){
//			System.out.println(2 + "*" + gob + "=" + 2 *gob);
//			gob++;
//		}
		//2) 바깥쪽 for문 : 2단,3단,4단...
		//시작: 2, 끝: 9, 증감: dan++
		int dan = 2;
		int gob = 1;
		while(dan < 10){
			while(gob < 10){
				System.out.println(dan + "*" + gob + "=" + dan * gob);
				gob++;
			}
			dan++;
		}
		
		
		
	
		//[4-4] 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을 작성하시오.
		/*
			1. dice1: 시작1, 끝6, 증감+1
			2. dice2: 시작6, 끝1, 증감-1
			3. 둘중하나 반복문: System.out.println(dice1 + "+" + dice2 + "=" + dice1+dice2);
			4. 눈의 합: (1.5), (2.4), (3.3), (4.2), (5.1)
				=> 조건) dice1 + dice2 = 6이될때!
			
			dice1 dice2		//이렇게 경우의수를 직접 구하기 보다는 주사위 범위 (0<=주사위<=6)으로 생각하기
			  1	 +  5 = 6		1,1		2,1		...		6,1	
			  2  +  4 = 6		1,2		2,2		...		6,2
			  3  +  3 = 6		1,3		2,3		...		6,3
			  4  +  2 = 6		1,4		2,4		...		6,4
			  5  +  1 = 6		1,5		2,5		...		6,5
			  					1,6		2,6		...		6,6
		*/
		//(1단계-겉) dice1로 for문
		//시작1, 끝6, 증감+1, 
//		for(int dice1 = 1; dice1 < 7; dice1++){
//			//dice2값에 따라 출력문이 나오도록 반복문 집어넣기	
//		}
		//(2단계-안) dice2값에 따라 출력문이 나오는 for문
		//시작1, 끝6, 증감+1
//		for(int dice2 = 1; dice2 < 7; dice2++){
//			System.out.println(dice1 + "+" + dice2 + "=" + dice1+dice2);
//		}
		//(3단계) 1단계 for문에 2단계 for문 넣고 
		//		dice1, dice2 둘다 주어졌으니 dice2 for문 밑에 눈의 합이 6이라는 조건 추가
		for(int dice1 = 1; dice1 < 7; dice1++){									//1단계
			for(int dice2 = 1; dice2 < 7; dice2++){								//2단계
				if(dice1 + dice2 == 6){											//3단계
				System.out.println(dice1 + "," + dice2);
				}
			}
		}
		
		
		//[4-5] 방정식 2x+4y=10의 모든 해를 구하시오. -> [4-4랑 비슷]
		//		단, x와 y는 정수이고 각각의 범위는 0<=x<=10, 0<=y<=10이다.
		/*
			1. x: 시작 0, 끝 10, 증감 +1
			2. y: 시작 0, 끝 10, 증감 +1
			3. 둘중 하나 반복문: System.out.println("x = " + x + " , y = " + y);
			4. (1.2), (3.1), (5,0) -> 모든해
				=> 조건: 2 * x + 4 * y == 10 이 될 떄
					
		*/
		
		/*
			(사전준비) 경우의 수 전부쓰기 11x11 121개
			x y		x y		...		x  y
			0,0		1,0		...		10,0
			0,1		1,1		...		10,1
			0,2		1,2		...		10,2
			0,3		1,3		...		10,3
			...		...		...		...
			0,10	1,10	...		10,10
		*/
		//(1단계-겉) x 관련 for문
		//시작0 끝10 증가+1
		//반복문 -> y관련 for문
		
//		for(int x = 0; x < 11; x++){
//			//y값에 따라 출력문이 나오도록 반복문 집어넣기
//		}
		
		
		//(2단계-안) y 관련 for문
		//시작0 끝10 증가+1
		//반복문 System.out.println("0 = " + 0 + " , y = " + y);
		
//		for(int y = 0; y < 11; y++){
//			System.out.println("0 = " + 0 + " , y = " + y); //0의 값이 나중에 바뀌니까 0이 x
//		}
		
		//(3단계) 이제 x for문에 y for문 넣고, x,y값 다 있으니 if조건으로 (2*x + 4*y == 10)을 추가
		for(int x = 0; x < 11; x++){
			for(int y = 0; y < 11; y++){
				if(2*x + 4*y == 10){
				System.out.println("x = " + x + " , y = " + y);
				}
			}
		}
		
		
		//[4-6] 사용자로부터 두개의 정수(시작, 끝)를 입력받아 시작(포함)에서 끝(포함)까지의 곱을 출력하는 프로그램을 작성하시오.
		/*
			예) 2, 8 받으면 2*3*4*5*6*7*8*9
			*필요한 것들?
			- Scanner sc = new Scanner(System.in);
			- input은 정수형 변수 , 값은 오버플로우 방지를 위 sc.nextLong()
			- long gob2 = 1;
		*/
		
		Scanner sc = new Scanner(System.in);
//		System.out.println("첫번째 정수를 입력하셔유");	//오버플로우 생각해야하나?
//		long input1 = sc.nextLong();
//		System.out.println("두번째 정수를 입력하셔유");
//		long input2 = sc.nextLong();
//		
//		//input1 과 input2의 곱을 출력
//		long gob2 = 1;
//		//gob2 *= input1
//		//gob2 *= input1 + 1
//		//...
//		//gob2 *= input2 
//		
//		//시작: input1, 끝: input2, 증감: +1
//		//반복문: gob2 *= num
//		for (long num = input1; num < (input2 + 1); num++){
//			gob2 *= num;
//		}
//		System.out.println("두 숫자도 포함한 사이의 곱은 "+gob2+"입니다요");

		
		
		
		
		
		//[4-7] 1 + (1+2) + (1+2+3) + (1+2+3+4) + ... + (1+2+3+...+10)의 결과를 계산하시오.
		/*
			1
			1 + (1+2)
			1 + (1+2) + (1+2+3)
			...
			1 + (1+2) + (1+2+3) + ... + (1+2+3+4+5+6+7+8+9+10)
			
			문제:	'1씩 증가하는 정수의 합'의 합
			접근:	(1단계) 1씩 증가하는 정수의 합 : mukSum
				(2단계) 1단계)의 합			totalSum
		*/
		
		//(1단계)
		int mukSum = 0;
		//1				mukSum += 1		시작:1, 끝:10, 증감량:+1
		//1+2			mukSum += 2		반복: mukSum += num
		//...			...
		//1+2+3+...+10	mukSum += 10
		
//		for(int num = 1; num < 11; num++){
//			mukSum += num;
//		}
//		System.out.println(mukSum); //55
		
		//(2단계)
		int totalSum = 0;									//num에 따른 변화값	//num과 같다
		//1										totalSum += mukSum1			시작:1, 끝:10, 증감량:+1
		//1 + (1+2)								totalSum += mukSum2			반복: totalSum += mukSum
		//...									..
		//1 + (1+2) + ... + (1+2+3...+10)		totalSum += mukSum10
		for(int num = 1; num < 11; num++){
			mukSum += num;		//초기값 num이 입력되어야 mukSum을 구해 totalSum에 대입할 수 있다.
			totalSum += mukSum;
		}
		System.out.println(totalSum); //220, 디버깅완료
		
		//다른 사람 풀이
		int sum0 = 0;
		for(int i = 1;i <= 10;i++){
			for(int j = 1; j <= i;j++){
				sum0 += j;
			}
		}
		
		//[4-8] 1 + (-2) + 3 + (-4) + m...과 같은 식으로 계속 더해나갔을 때,
		//		몇까지 더해야 총합이 100 이상이 되는지 구하시오.
		//1+2+3+...+ num 까지 계속 sum을 하다가 100이상이 될때 멈춰서 num의 값을 구해라
		//조건) 짝수일때 음수여야한다. num%2==0 일때 num = -num;
		
		//1-1. 홀수 -> num / 짝수 -> num*-1
		int sum2 = 0;
		int num2 = 1;
		
		while(true){
			if(num2 % 2 != 0){
				sum2 += num2;
			}else{
				sum2 += num2*-1;
			}
			if(sum2 >= 100){
				System.out.println("num2 : "+num2);
				break;
			}
			num2++;
		}
		System.out.println(sum2);
		
		//1-2.홀수 -> num*buho / 짝수 -> num*-buho
		int buho1 = 1;
		int sum22 = 0;
		int num22 = 1;
		
		while(true){ 
			if(num22%2 != 0){
				sum22 += num22*buho1;
			}else{
				sum22 += num22*buho1;
			}
			if(sum22 >= 100){
				System.out.println("num22 : "+num22);
				break;
			}
			num22++;
			buho1 *= -1;
		}
		System.out.println(sum22);
		
	
		//2 홀수 -> sum = sum+num / 짝수 -> sum = sum-num
		int sum3 = 0;
		int num3 = 1;
		
		while(true){
			if(num3 % 2 !=0){
				sum3 += num3;
			}else{
				sum3 -= num3;
			}
			if(sum3 >= 100){
				System.out.println("num3 : "+num3);
				break;
			}
			num3++;
		}
		System.out.println(sum3);
		
		
		
		
		//[4-9] 사용자로부터 입력받은 정수의 각 자리의 합을 더한 결과를 출력하는 프로그램을 작성하시오.
		//		예를 들어, 사용자가 53263을 입력하였다면 결과는 19가 되어야 한다.
		//
		//1) num의 몫이 0이 될때까지 계속나눠야함 - 0이 되면 종료 - sum을 구한다
		//2) 5+3+2+6+3=19
		
		//1의 자리:	53263 / 10 => 몫: 5326, 나머지:3 => 몫: 다음 자리를 위해 넘겨야할 값 / 나머지: 더할 값들
		//10의 자리:	5326 / 10 => 몫: 532, 나머지: 6
		//100의 자리:	532 / 10 => 몫: 53, 나머지: 2
		//1000의 자리:	53 / 10 => 몫: 5, 나머지: 3
		//10000의 자리:5 / 10 => 몫: 0, 나머지 5
		System.out.println("정수 아무꺼나 입력해주세욜");
		int aaa4 = sc.nextInt();
		int sum4 = 0;
		
		//sum4 += 53263 % 10;			sum4 += aaa4 % 10;
		//aaa4 = 53263 / 10				aaa4 /= 10;
		//sum4 += 5326 % 10;			sum4 += aaa4 % 10;
		//aaa4 = 5326 / 10;				aaa4 /= 10;
		//...							...
		//sum4 += 5 % 10;				sum4 += aaa4 % 10;
		//aaa4 += 5 / 10; // 0. 종료		aaa4 /= 10;
		
		while (!(aaa4==0)){
			sum4 += aaa4%10; //1자리여도 값이 나와야하니까 
			aaa4 /= 10; 
		}
		System.out.println(sum4);
		
		
		
		
		//[4-10] 피보나치 수열은 앞의 두 수를 더해서 다음 수를 만들어 나가는 수열이다. 
		//		예를 들어, 앞의 두 수가 1과 1이라면 그 다음 수는 2가 되고 그 다음 수는 1과 2를 더해서 3이 되어서
		//		1,1,2,3,5,8,13,21,... 과 같은 식으로 진행된다.
		//		1과 1부터 시작하는 피보나치수열의 10번째 수는 무엇인지 계산하는 프로그램을 작성하시오.
		
		//1+1=2
		//1+2=3 // 제일 처음 두 숫자 제외하고 시작3, 끝10
		//2+3=5
		//...
		//A+B=C
		
		int numA = 1;
		int numB = 1;
		int numC = 0;
		
		for(int i = 3;i < 11;i++){
			numC = numA + numB;
			numA = numB;
			numB = numC;
		}
		System.out.println("numC : "+numC);
		
		
		
		//[4-11] while문제
		//1단계) 문자열 value에서 각 문자를 꺼내서		-> using  value.charAt(i)
		//2단계) check if it's number or not	-> '0' <= value.charAt(i) <= '9'
		//2-1단계) if it is	-> isNumber = true;
		//2-2단계) if not		-> isNumber = false;
		
		//step1) take out characters from String value 
		//hint) ch = value.charAt(0) -> '1'
		//what's in [0] -> value.charAt(0)
		//			[1] -> value.charAt(1)
		//				...
		//			[4] -> value.charAt(4)
		//first:0, last:4, fluctuation: +1
		//repetitive: value.charAt(i) -> because the question is using i for index
		
		//step2) check if it's number or not
		//'0' <= value.charAt(i) <= '9'
		//'0' <= value.charAt(i) && value.charAt(i) <= '9'
		
		//step2-1) if value.charAt(i) is true
		//isNumber = true	-> to print "value is number"
		
		//step2-2) if value.charAt(i) is false
		//isNumber = false	-> to print "value isn't number"
		
		//answer
		//for(int i = 0 < value.length(); i++){
		//	if('0' <= value.charAt(i) && value.charAt(i) <= '9'){
		//		isNumber = isNumber;
		//	}else{
		//		isNumber = !isNumber;
		//		break;
		//	}
		
		
		String value = "12o34"; // char[] -> [0]:'1', [1]:'2', [2]:'o', [3]:'3', [4]:'4'
		char ch =' '; // 반복문 안에서, ch = value.charAt(i); 저장해서 간단하게 만들 수 있음 
		boolean isNumber = true;
		//반복문과 value.charAt(int i)를 이용해서 문자열의 문자를 하나씩 읽어서 검사한다.
		for(int i = 0; i < value.length(); i++){
			if('0' <= value.charAt(i) && value.charAt(i) <='9'){
				isNumber = true;
			}else{
				isNumber = false;
				break; //더이상 검사할 필요가 없기때문에
			}
		}
		if (isNumber){
			System.out.println(value+"는 숫자입니다.");
		}else{
			System.out.println(value+"는 숫자가 아닙니다.");
		}
		
		
		//[bonus] 펠린드롬
		int num = 12321;
		int temp = num;
		int result = 0;		//뒤에서부터 읽은 것 저장할 변수 
		
		result *= 10; 		//result = 0*10 =0
		result += temp%10;	//result = 1
		temp /= 10; 		//temp=num/10=1232
		
		result *= 10; 		//result = 1*10 = 10
		result += temp%10;	//result = 10+2 = 12
		temp /= 10; 		//temp=123
		
		result *= 10;		//result= 12*10 = 120
		result += temp%10;	//result=120+3 = 123
		temp /= 10;			//temp=12
		
		result *= 10;		//result=123*10 = 1230
		result += temp%10;	//result=1230+2 = 1232
		temp /= 10;			//temp=1
		
		result *= 10;		//result=1232*10 = 12320
		result += temp%10;	//result=12320+1 = 12321
		temp /= 10;			//temp=0 				--> temp가 0이 될 때 종료
		
		while(temp!=0){
			result *= 10;
			result += temp%10;
			temp /= 10;
		}
		
		//다른사람풀이
//		while(temp!=0){
//			result = result*10 + temp%10;
//			temp /= 10;
//		}
		
		
		if(num==result){
			System.out.println(num+"은(는) 펠린드롬입니다.");
		}else{
			System.out.println(num+"은(는) 펠린드롬이 아닙니다.");
		}
		

		/*
		계산기만들기 (입력받고->조건확인후->break) <- for,while은 조건확인후 입력받음
		1. 사용자로부터 숫자, 연산자, 숫자를 받아야 계산가능 (입력받고)
		2. 부호가 아니면 사용종료(조건) - break
		3. else로 사칙연산 결과를 활용해보렴....
		*/
		
		//1. 사용자로부터 숫자를 입력받는다.
		//2. 사용자로부터 부호를 입력받는다.
		//3. 사용자로부터 숫자를 입력받는다.
		//4. 연산을 수행하여 결과를 출력한다. 
		//5. 1~4를 무한반복해준다
		//단. 사용자가 입력한 부호가 사칙연산자가 아니면 종료하여라.
//
//		do{
//			System.out.println("첫번째 숫자를 입력하세요");
//			int firNum = sc.nextInt();
//			System.out.println("사칙연산을 입력하세요");
//			String buho = sc.next();
//			System.out.println("두번째 숫자를 입력하세요");
//			int secNum = sc.nextInt();
//			
//			if("+".equals(buho)){
//				System.out.println(firNum+secNum);
//			}else if("-".equals(buho)){
//				System.out.println(firNum-secNum);
//			}else if("*".equals(buho)){
//				System.out.println(firNum*secNum);
//			}else if("/".equals(buho)){
//				System.out.println((int)((float)firNum/secNum*100+0.5)/100f);
//			}else{
//				System.out.println("사칙연산 아님 종료");
//				break;
//			}
//			
//		}while(true);
//		
//		
		
		//[bonus] 숫자 맞추기 게임. 1과 100사이의 값을 반복적으로 입력해서 컴퓨터가 생각한 값을 맞추면 게임은 끝난다.
		//			사용자가 값을 입력하면, 컴퓨터는 자신이 생각한 값과 비교해서 결과를 알려준다.
		//			사용자가 컴퓨터가 생각한 숫자를 맞추면 게임이 끝나고 몇 번만에 숫자를 맞췄는지 알려준다.
		
		int com = (int)(Math.random()*100+1);
		int sido = 1;
		
		System.out.println(com);
		//1. 하나하나 적어보기
//		System.out.println("1에서 100사이의 값을 입력해주세요");
//		int user1 = sc.nextInt();
//		if( com==user1 ){
//			System.out.println("딩동댕! "+sido+"번만에 정답!");
//		}else{
//			System.out.println("1에서 100사이의 값을 입력해주세요");
//			int user2 = sc.nextInt();
//			sido++;
//			if( com==user2 ){
//				System.out.println("딩동댕! "+sido+"번만에 정답!");
//			}
//		}
		//고민
		//1. user1, user2 계속 변하는 변수명을 어떻게하지?
		//2. if-else 안에 반복문 넣는거..
		
		
		while(true){
			System.out.println("1에서 100사이의 값을 입력해주세요");
			int user = sc.nextInt();
			if( com==user ){									//while(!(com==user))못하는 이유: user변수가 while내에 존재
				System.out.println("딩동댕! "+sido+"번만에 정답!");	//출력문은 바깥에 하나 안에 하나 상관없다
				break;
			}else if( com>user ){
				System.out.println("더 큰 수를 입력해주세요");
			}else{
				System.out.println("더 작은 수를 입력해주세요");
			}
			sido++;
		}
		
		
		//다른 사람 풀이
//		int computerNumber = (int)(Math.random()*100)+1;
//		int userNumber = 0;									//userNumber != computerNumber
//		int trial = 0;
//		System.out.println(computerNumber);
//		
//		while(userNumber != computerNumber){
//			System.out.println("1과 100사이의 값을 입력하세요.");
//			userNumber = sc.nextInt();
//			if(computerNumber > userNumber){
//				System.out.println("더 큰 수를 입력하세요");
//			}else{
//				System.out.println("더 작은 수를 입력하세요"); //이사람 풀이대로하면 한번에 맞추면 더 작은수를 입력하세요가 나옴
//			}
//			trial++;
//		}
//		System.out.println("맞췄습니다.\n시도횟수는 "+trial+"번입니다.");
		
		
		//[bonus] 숫자로 이루어진 문자열 str이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드.
		//			만약 문자열 "12345"라면, '1+2+3+4+5"의 결과인 15를 출력.
		
		String str = "12345"; 
		int sumstr = 0;
		
//		sumstr += str.charAt(0)-'0';
//		sumstr += str.charAt(1)-'0';
//		sumstr += str.charAt(2)-'0';
//		sumstr += str.charAt(3)-'0';
//		sumstr += str.charAt(4)-'0';
		//시작 0, 끝4, 증감+1, 반복: sumstr += str.charAt(i)-'0';
		
		for(int i = 0; i < str.length(); i++){
			sumstr += str.charAt(i)-'0';
		}
		
		System.out.println(sumstr);
		
		
		
	}
}
