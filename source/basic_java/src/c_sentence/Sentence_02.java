package c_sentence;

public class Sentence_02 {
	public static void main(String[] args) {
		/*
		1. 반복문( for, while, do-while)
		  - 어떤 작업이 반복적으로 수행되도록 할때 사용된다
		  - 반복문은 주어진 조건이 만족하는 동안 문장을 반복수행한다.
		  - for문:	반복횟수를 알고 있을때
		  - while문:	반복횟수를 모를 때 -> 문제 난이도가 더 높다
		
		2. for문
		  - 기본구조
		  for(초기화;조건식;증감식){
		  		조건식이 만족할때 수행될 문장;
		  }
		
		*/
		
		//0~9까지 출력해주세요
//		System.out.println(0);
//		System.out.println(1);
//		System.out.println(2);
//		System.out.println(3);
//		System.out.println(4);
//		System.out.println(5);
//		System.out.println(6);
//		System.out.println(7);
//		System.out.println(8);
//		System.out.println(9);
		//초기화 , 조건식 , 증감식 , 수행문장
		// 0	  9		1	  System.out.println(num);
		
		for(int num = 0 ; num < 10; num++){
			System.out.println(num);
		}
		// 수행순서
		// 초기화 -> 조건식 -> 실행 -> 증감식 
		// -> 조건식가서 조건확인 -> 실행 -> 증감 -> 조건식가서 조건확인 ... -> 조건안맞을때 끝남
		
		//1. 5~16까지의 합을 구하여라
		int sum = 0;
//		sum += 5; // sum = sum+5 // sum = 0 + 5 (이제 sum=5)
//		sum += 6; // sum = sum+6 // sum = 5 + 6 (이제 sum=5+6)
//		sum += 7; // sum = sum+7 // sum = 5+6 + 7 (이제 sum=5+6+7)
//		sum += 8;
//		sum += 9;
//		sum += 10;
//		sum += 11;
//		sum += 12;
//		sum += 13;
//		sum += 14;
//		sum += 15;
//		sum += 16; // sum = sum+16 // sum = (5+6+7+.....+ 16) 
		//시작 : 5, 끝 : 16, 증가량 :	1, 수행문장 sum += num;
		
		for(int num = 5; num < 17; num++){
			sum += num;
		}
		System.out.println(sum); //126
		
		//[문제 2-19] (p.55)
		//1. 0이상 5이하에서 정수를 결과(012345)와 같이 출력
		//내 풀이
		//System.out.print(0);
		//System.out.print(1);
		//System.out.print(2);
		//System.out.print(3);
		//System.out.print(4);
		//System.out.print(5);
		
		//시작: 0 (초기화:int num2 = 0)
		//끝: 5 (조건식:num2 < 6)
		//증가량: 1(증감식: num2++)
		//수행: System.out.print(num2);
		for(int num2 = 0; num2 < 6; num2++){
			System.out.print(num2);
		}
		System.out.println();
		
		
		//2. 0이상 5이하에서 정수를 결과(543210)와 같이 출력
		//내풀이
		//System.out.print(5);
		//System.out.print(4);
		//System.out.print(3);
		//System.out.print(2);
		//System.out.print(1);
		//System.out.print(0);
		
		//시작: 5 (초기화:int num3 = 5) 
		//끝: 0 (조건식:num3 > -1)
		//감소량: -1 (증감식: num3--)
		//수행문장 System.out.print(num3)
		for(int num3 = 5; num3 > -1; num3--){
			System.out.print(num3);
		}
		System.out.println();
		
		
		//3. 2이상 10이하에서 정수의 합계를 구하라
		//내풀이
		int sum2 = 0;
//		sum2 += 2;  //sum2 = sum + 2
//		sum2 += 3;  //sum2 = sum + 3
//		sum2 += 4;
//		sum2 += 5;
//		sum2 += 6;
//		sum2 += 7;
//		sum2 += 8;
//		sum2 += 9;
//		sum2 += 10; //sum2 = sum + 10
		//시작: 2		(초기화: int num4 = 2)
		//끝: 10		(조건식: num4 < 11)
		//증가량: 1	(증감식: num4++)
		//			(수행문장:	sum2 += num4)
		for(int num4 = 2; num4 < 11; num4++){
			sum2 += num4; // sum2 = sum2 + num4; 
		}
		System.out.println(sum2); //54 
		
		
		//4. 5이상 15미만에서 정수의 곱을 구하라 (overflow고려)
		long multiply = 1;   // 오버플로우 고려해서 long으로
//		multiply *= 5; // (multiply = multiply * 5)
//		multiply *= 6;
//		multiply *= 7;
//		multiply *= 8;
//		multiply *= 9;
//		multiply *= 10;
//		multiply *= 11;
//		multiply *= 12;
//		multiply *= 13;
//		multiply *= 14;
		
		//시작:	5	(초기화: int num5 = 5)
		//끝:	14	(조건식: num5 < 15)
		//증가량:	1	(증감식: num5++)
		//			(수행문장:multiply *= num5)
		for(int num5 = 5; num5 < 15; num5++){
			multiply *= num5;
		}
		System.out.println(multiply); //3633428800
		
		
		//5. 3이상 4462이하에서 짝수인 정수의 합
		int sum3 = 0;
//		sum3 += 3;
//		sum3 += 4;
//		sum3 += 5;
//		sum3 += 6;
//		...
//		sum3 += 4462;
		
		//내가 푼 풀이 -- 문제에 충실한 방법이 아님 왜냐면 문제는 시작이 3부터니깐
		//시작:	4		(초기화: int num6 = 4)
		//끝:	4462	(조건식: num6 < 4463 && num6%2 == 0)
		//증가량:	2		(증감식: num6 +=2) //num6 = num6 + 2
		//				(수행문장:sum3 += num6)
//		for(int num = 4; num < 4463 && num%2 ==0; num +=2){
//			sum3 += num;	//근데 왜 sum3 += (num += 2)는 안되는 이유 -> 위에 증감식에서 증가량 설정해줬는데 여기서 또썼기때문에
//		}
//		System.out.println(sum3); //4979590 (답은 맞지만 문제에 적합한 방법은 아님)
		
		//다른 풀이
		//(1) 먼저 '3부터 42까지의 합'을 구해준다
		//초기값: 3				(초기화: int num = 3;)
		//조건식: 42				(조건식: num < 43)
		//증감식: 1				(증감식: num++)
		//						(수행식: sum3 += num6) //sum3은 위에서 설정해줌
		
		//for문+if문: 3~42까지 중 짝수의 합
		for(int num = 3; num < 43; num++){
			if(num%2==0){ //짝수인 값
			sum3 += num;
			}
		} 
		//진행순서: 초기화 -> 조건확인 -> if 조건 확인 -> true -> sum3 +=num -> num++ -> 조건 -> if ....
		//								   -> false -> for문복귀 -> num++ -> 조건 -> if....
		System.out.println(sum3); //460
		
		
		//6. 7초과 57미만에서 2또는 3의 배수인 정수의 합을 구하여라.
		//8, 9, 10, 12,...
		int sum4 = 0;
//		sum4 += 8;
//		sum4 += 9;
//		sum4 += 10;
//		...
//		sum4 += 56;
		
		//1. 7초과 57미만 정수의 합 구하는 반복문
		//시작: 8		(초기화: int num = 8) 
		//조건식: 56	(조건식: num < 57)
		//증가량: 1	(증감식: num++)
		//수행문장:	(sum+=num;)
		for(int num = 8;num < 57;num++){
			if(num%2==0 || num%3==0){ //둘중 하나만 true여도 true
				sum4+=num;
			}
		}
		System.out.println(sum4); //1040
		
		// 구구단 2단 출력하기 -> 그리고 2단~9단 출력하기
//		2 * 1 = 2 (2*1) 출력문(2 + " * " + 1 + " = " + 2*1)
//		2 * 2 = 4 (2*2) 출력문(2 + " * " + 2 + " = " + 2*2)
//		2 * 3 = 6		출력문(2 + " * " + 3 + " = " + 2*3)
//		2 * 4 = 8
//		2 * 5 = 10
//		...
//		2 * 9 = 18		출력문(2 + " * " + 9 + " = " + 2*9)
					  //반복문(2 + " * " + n + " = " + 2*n
		
//		System.out.println(2 + " * " + 1 + " = " + 2*1);
//		System.out.println(2 + " * " + 2 + " = " + 2*2);
//		System.out.println(2 + " * " + 3 + " = " + 2*3);
//		System.out.println(2 + " * " + 4 + " = " + 2*4);
//		System.out.println(2 + " * " + 5 + " = " + 2*5);
//		System.out.println(2 + " * " + 6 + " = " + 2*6);
//		System.out.println(2 + " * " + 7 + " = " + 2*7);
//		System.out.println(2 + " * " + 8 + " = " + 2*8);
//		System.out.println(2 + " * " + 9 + " = " + 2*9);

		//구구단 2단
		//시작: 1		초기화: int num = 1
		//끝: 9		조건식: num < 10
		//증가량: 1	증감식: num++
		//수행문장:	System.out.println(2 + " * " + num + " = " + 2*num);
		
//		for(int num = 1; num < 10; num++){
//			System.out.println(2 + " * " + num + " = " + 2*num);
//		} 
//		구구단 3단
//		System.out.println(3 + " * " + 1 + " = " + 3*1);
//		System.out.println(3 + " * " + 2 + " = " + 3*2);
//		System.out.println(3 + " * " + 3 + " = " + 3*3);
//		System.out.println(3 + " * " + 4 + " = " + 3*4);
//		System.out.println(3 + " * " + 5 + " = " + 3*5);
//		System.out.println(3 + " * " + 6 + " = " + 3*6);
//		System.out.println(3 + " * " + 7 + " = " + 3*7);
//		System.out.println(3 + " * " + 8 + " = " + 3*8);
//		System.out.println(3 + " * " + 9 + " = " + 3*9);
		
		//구구단 3단
		//시작: 1		초기화: int num = 1
		//끝: 9		조건식: num < 10
		//증가량: 1	증감식: num++
		//수행문장:	System.out.println(3 + " * " + num + " = " + 3*num);
//		for(int num = 1; num < 10; num++){
//			System.out.println(3 + " * " + num + " = " + 3*num);
//		}
		
//		구구단 4단
//		System.out.println(4 + " * " + 1 + " = " + 4*1);
//		System.out.println(4 + " * " + 2 + " = " + 4*2);
//		System.out.println(4 + " * " + 3 + " = " + 4*3);
//		System.out.println(4 + " * " + 4 + " = " + 4*4);
//		System.out.println(4 + " * " + 5 + " = " + 4*5);
//		System.out.println(4 + " * " + 6 + " = " + 4*6);
//		System.out.println(4 + " * " + 7 + " = " + 4*7);
//		System.out.println(4 + " * " + 8 + " = " + 4*8);
//		System.out.println(4 + " * " + 9 + " = " + 4*9);
		
		//시작: 1		초기화: int num = 1
		//끝: 9		조건식: num < 10
		//증가량 1		증감식: num++
		//			수행문장: System.out.println(4 + " * " + num + " = " + 4*num);
//		for(int num = 1; num < 10; num++){
//			System.out.println(4 + " * " + num + " = " + 4*num);
//		}
		
//		구구단 5단
//		System.out.println(5 + " * " + 1 + " = " + 5*1);
//		System.out.println(5 + " * " + 2 + " = " + 5*2);
//		System.out.println(5 + " * " + 3 + " = " + 5*3);
//		System.out.println(5 + " * " + 4 + " = " + 5*4);
//		System.out.println(5 + " * " + 5 + " = " + 5*5);
//		System.out.println(5 + " * " + 6 + " = " + 5*6);
//		System.out.println(5 + " * " + 7 + " = " + 5*7);
//		System.out.println(5 + " * " + 8 + " = " + 5*8);
//		System.out.println(5 + " * " + 9 + " = " + 5*9);
		
//		구구단 6단
//		System.out.println(6 + " * " + 1 + " = " + 6*1);
//		System.out.println(6 + " * " + 2 + " = " + 6*2);
//		System.out.println(6 + " * " + 3 + " = " + 6*3);
//		System.out.println(6 + " * " + 4 + " = " + 6*4);
//		System.out.println(6 + " * " + 5 + " = " + 6*5);
//		System.out.println(6 + " * " + 6 + " = " + 6*6);
//		System.out.println(6 + " * " + 7 + " = " + 6*7);
//		System.out.println(6 + " * " + 8 + " = " + 6*8);
//		System.out.println(6 + " * " + 9 + " = " + 6*9);

//		구구단 7단
//		System.out.println(7 + " * " + 1 + " = " + 7*1);
//		System.out.println(7 + " * " + 2 + " = " + 7*2);
//		System.out.println(7 + " * " + 3 + " = " + 7*3);
//		System.out.println(7 + " * " + 4 + " = " + 7*4);
//		System.out.println(7 + " * " + 5 + " = " + 7*5);
//		System.out.println(7 + " * " + 6 + " = " + 7*6);
//		System.out.println(7 + " * " + 7 + " = " + 7*7);
//		System.out.println(7 + " * " + 8 + " = " + 7*8);
//		System.out.println(7 + " * " + 9 + " = " + 7*9);
		
//		구구단 8단
//		System.out.println(8 + " * " + 1 + " = " + 8*1);
//		System.out.println(8 + " * " + 2 + " = " + 8*2);
//		System.out.println(8 + " * " + 3 + " = " + 8*3);
//		System.out.println(8 + " * " + 4 + " = " + 8*4);
//		System.out.println(8 + " * " + 5 + " = " + 8*5);
//		System.out.println(8 + " * " + 6 + " = " + 8*6);
//		System.out.println(8 + " * " + 7 + " = " + 8*7);
//		System.out.println(8 + " * " + 8 + " = " + 8*8);
//		System.out.println(8 + " * " + 9 + " = " + 8*9);
		
//		구구단 9단
//		System.out.println(9 + " * " + 1 + " = " + 9*1);
//		System.out.println(9 + " * " + 2 + " = " + 9*2);
//		System.out.println(9 + " * " + 3 + " = " + 9*3);
//		System.out.println(9 + " * " + 4 + " = " + 9*4);
//		System.out.println(9 + " * " + 5 + " = " + 9*5);
//		System.out.println(9 + " * " + 6 + " = " + 9*6);
//		System.out.println(9 + " * " + 7 + " = " + 9*7);
//		System.out.println(9 + " * " + 8 + " = " + 9*8);
//		System.out.println(9 + " * " + 9 + " = " + 9*9);
		
//		for(int num = 1; num < 10; num++){
//			System.out.println(2 + " * " + num + " = " + 2*num);
//		}
//		
//		for(int num = 1; num < 10; num++){
//			System.out.println(3 + " * " + num + " = " + 3*num);
//		}
//		
//		for(int num = 1; num < 10; num++){
//			System.out.println(4 + " * " + num + " = " + 4*num);
//		}
//		
//		for(int num = 1; num < 10; num++){
//			System.out.println(5 + " * " + num + " = " + 5*num);
//		}
//		
//		for(int num = 1; num < 10; num++){
//			System.out.println(6 + " * " + num + " = " + 6*num);
//		}
//		
//		for(int num = 1; num < 10; num++){
//			System.out.println(7 + " * " + num + " = " + 7*num);
//		}
//		
//		for(int num = 1; num < 10; num++){
//			System.out.println(8 + " * " + num + " = " + 8*num);
//		}
//		
//		for(int num = 1; num < 10; num++){
//			System.out.println(9 + " * " + num + " = " + 9*num);
//		}	
		

		//구구단 2단~9단
		//시작:2	(초기화: int dan = 2)
		//끝:9	(조건식: dan < 10)
		//증가:1	(증감식: dan++) 
		//수행구문: for(int num = 1; num < 10; num++{
		//			System.out.println(dan + " * " + num + " = " + dan*num);
		//		 }
		
		for(int dan = 2;dan <10; dan++){
			for(int num = 1; num < 10; num++){
				System.out.println(dan + " * " + num + " = " + dan*num);
			}
		}
		
		
		/*
		3. while문
		  - 반복횟수를 알수 없을때 많이 사용. (알때 사용해도 상관없으나 for문이 더 편함)
		  - 조건식과 수행해야할 블럭{}만으로 구성되어 있다.
		  - 기본구조
		  	while(조건식){
		  		조건식이 true일때 수행될 문장
		  	}
		*/

		//1. 1~10까지 출력
//		for(int i = 1; i < 11; i++){
//			System.out.println(i);
//		}
		
		int number = 1;					//초기화를 바깥에
		while(number < 11){				//조건식
			System.out.println(number);	//수행될문장
			number++;					//증감식
		}
		
		
		//2. 3~15까지의 합계를 구해주세요
		int sum5 = 0;
		//sum5 += 3
		//...
		//sum5 += 15
		//시작3 끝15 증감 +1
		//수행문장: sum5 += 3부터15
		
		int number2 = 3;				//초기화
		while (number2 < 16){			//조건식
			sum5 += number2;			//수행될 문장
			number2++;					//증감식
		}
		System.out.println(sum5);		//문제에서 원하는거 3~15까지의 합계
		
		
		//3. 1~100까지의 정수중 4의 배수의 합계를 구하여라
		//문제에서 뽑아낼거
		//while문 내 변하는 수 number3: 0 <= number3 <= 100 
		//시작 1 끝100 증감 +1
		//조건 number3%4 == 0
		//수행문장: sum6 += 1부터 100
		
		//풀이
		int sum6 = 0;
		int number3 = 1;
		while (number3 < 101){
			if(number3%4 ==0){  
				sum6 += number3;
			}
			number3++;
		}
		System.out.println(sum6);
		
		
		//4. 구구단을 while문을 만을 이용하여 만들어주세요  --- 다시해보기
//		for(int dan2 = 2; dan2 < 10; dan2++){
//			for(int gob2 = 1; gob2 < 10 ; gob2++){
//				System.out.println(dan +"*"+gob2+"="+dan*gob2);
//			}
//		}

		//5. 5~? 합계를 구하였을때 합계가 100이상이 되는 ?의 값을 구하여라 (정답은 15인데 16이 나올것, 이유찾아서 수정)
		//시작:5 끝:? 증감식:+1
		//조건: 5+6+7+...+? >= 100  
		
		//
		//sum += 5;
		//sum += 6;
		//...
		//sum += ?; 이게 100이상이 되야하잖아
		int sum7 = 0;
		int num4 = 5;				//초기화
		while(num4>4){		//조건식 //근데 끝을 모르잖아??
			sum7 += num4;		//수행문장
			num4++;	//증감식
			if(sum7>=100){
				break;//이럴떄나가라?
			}
		}
		System.out.println(sum7);
		
		//선생님풀이
		//시작:5, 끝:?, 증가량:1씩, 조건: 합이 100미만
		
		int sum8 = 0;
		int num5 = 4;
		while(sum8 < 100){
			num5++;
			sum8 += num5;
		}
		System.out.println(num5);//15
		
		//다른 자세한 풀이
		int sum9 = 0;
		int num6 = 5;
		while(true){				//while이 무한으로 돌게하도록
			sum9 += num6;
			if(sum9 >= 100){		//sum9가 100이상이 되면 반복 멈춤
				break;				//break: 가장 가까운 반복문을 나가라
			}
			num6++;					
		}
		System.out.println(num6);//15 	//위에서 내가 처음해본거 다시 풀어보기
		
		
		//break친구
		//0부터 9까지 정수중 짝수만 출력
//		int num7 = 0;
//		while(num7 < 10){
//			if(num7%2==0){
//				System.out.println(num7);
//			}
//			num7++;
//		}
//		
//		int num8 = -1;
//		while(num8 < 9){
//			num8++;			//왜증감식이 위의 식과 다르게 이자리에 있을까?
//			if(num8%2!=0){
//				continue;
//			}
//			System.out.println(num8);
//		}
		
		for (int i = 0; i < 10; i++) {
			if(i%2 != 0){
				continue;			//조건이 맞으면->continue->증감식
			}						//조건을 안맞으면 if로 안가니까 출력으로
			System.out.println(i);
		}
		
		
		
		
		
		
		
		
		
		
		
		}
	}

