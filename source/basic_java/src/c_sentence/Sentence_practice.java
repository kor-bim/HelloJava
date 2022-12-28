package c_sentence;

public class Sentence_practice {
	public static void main(String[] args) {
		/*
		<중첩if문>
		if(조건식1){
			조건식1이 true일때 수행될 문장
			if(조건식2){
			조건식1과 조건식2이 true일때
			}
		}else{
		조건식1이 false일때 수행될 문장들을 적는다
		}
		*/
		
		System.out.println("[예제2-11] p.51");
		//[예제2-11] p.51
		int score = 93;
		//조건1: 90점이상
		//조건1을 만족하고 95점이상일때 score >= 95 면 +
		//조건1을 만족하고 90점이상일떄 scroe >= 90 면 -
		
		if(score >= 90){
			System.out.print("A");
			if(score >= 95){
				System.out.println("+");
			}else{
			System.out.println("-");	
			}
		}
		
		System.out.println("[문제2-10] p.55");
		System.out.println("(1)");
		
		//[문제2-19] p.55
		//1. 0이상 5이하에서 정수를 결과(012345)와 같이 출력
		for(int num = 0; num <6; num++){
			System.out.print(num);
		}
		System.out.println();
		System.out.println("(2)");
		//2. 0이상 5이하 정수를 결과 (54321)와 같이 출력
		for(int num = 5; num > -1; num--){
			System.out.print(num);
		}
		System.out.println();
		System.out.println("(3)");
		//3. 2이상 10이하에서 정수의 합계를 구하라
		int sum = 0;
		for(int num =2; num < 11; num++){
			sum += num;
		}
		System.out.println(sum);
		
		System.out.println("(4)");
		//4. 5이상 15미만에서 정수의 곱을 구하라 (overflow고려)
		long gob = 1;
		for(int num = 5; num < 15; num++){
			gob *= num;
		}
		System.out.println(gob);
		
		System.out.println();
		System.out.println("(5)");
		//5. 3이상 4462이하에서 짝수인 정수의 합
		int sum2 = 0;
		for(int num = 3; num < 4463 ; num++){
			if(num%2==0){
			sum2 += num;
			}
		}
		System.out.println(sum2);
		
		
		//6. 7초과 57미만에서 2또는 3의 배수인 정수의 합을 구하여라.
		int sum3 = 0;
		for(int num = 8; num < 57; num++){
			if(num%2 == 0 || num%3 == 0){
				sum3 += num;
			}
		}
		System.out.println(sum3);
		
		System.out.println("[예제 2-14] p.57");
		//구구단 2단~9단
		for(int dan=2; dan < 10; dan++){
			for(int num = 1 ; num < 10; num++){
				System.out.println(dan+"*"+num+"="+dan*num);
			}
		}
		
		System.out.println("[문제 2-14] p.57");
		
		
		//구구단 짝수단 출력 (구구단 한단 출력문 만들고, 전체 반복문을 만드는데, 전체 반복문안에 if를 넣어서 한단 출력문에서 짝수만 뽑도록)
		//구구단 한단 출력문 (2단)
		/*
		for(int num = 1; num < 10; num++){
		System.out.println(2 + " * " + num + " = " + 2*num);
		*/
		
		//구구단 전체 반복문 (2~9단)
		//시작2, 끝9, 증감 +1, 반복문 System.out.println(dan + " * " + num + " = " + 2*num);
		/*
		for(int dan = 2; dan < 9; dan++{
			for(int num = 1; num < 10; num++){
				System.out.println(dan + " * " + num + " = " + dan*num);
			}
		}
		*/
		
		//구구단 전체 반복문에서 짝수단만 출력
		for(int dan=2; dan < 10; dan++){
			if(dan%2 == 0){					// 밑의 for문 끝나면 if는 반복문이 아니기때문에 처음 for문으로 복귀
				for(int num = 1; num < 10; num++){
					System.out.println(dan+"*"+num+"="+dan*num);
				}
			}
		}
		
		
		System.out.println("[문제 2-14] p.57");
		//구구단 짝수단의 홀수곱 출력
		//{전체출력문+ 짝수단 조건(구구단 한단 출력문+ 홀수곱 조건)}
		for(int dan=2; dan < 10; dan++){
			if(dan%2 == 0){
				for(int num = 1; num < 10; num++){
					if(num%2 == 1){
						System.out.println(dan+"*"+num+"="+dan*num);
					}
				}
			}
		}
		
		System.out.println("[문제 2-21] p.58");
		/*
		 *
		 **
		 ***
		 ****
		 *****
		*/
		System.out.println("*");
		System.out.println("*"+"*");
		System.out.println("*"+"*"+"*");
		System.out.println("*"+"*"+"*"+"*");
		System.out.println("*"+"*"+"*"+"*"+"*");
			
		System.out.println("[연습문제4-7]");
		//[4-7] 1 + (1+2) + (1+2+3) + (1+2+3+4) + ... + (1+2+3+...+10)의 결과를 계산하시오.
		/*
			1
			1 + (1+2)
			1 + (1+2) + (1+2+3)
			...
			1 + (1+2) + (1+2+3) + ... + (1+2+3+4+5+6+7+8+9+10)
		*/
		
		
		System.out.println("[문제 2-22] p.59");
		//[2-22] while문을 이용, 1이상 100이하까지의 합계
		//시작1 끝100 증감1
		//반복문 sum4 += num

		int sum4 = 0;
		int num = 1;

		while(num < 101){
			sum4 += num;
			num++;
		}
		System.out.println(sum4);
		
		System.out.println("[문제 2-23] p.59");
		//[2-23] 1부터 1씩 증가하는 정수들을 더하였을 때 합계가 200을 넘게 되는 최초의 값과 합계를 구하여라
		//구해야할값: num1, sum5
		//1부터1씩증가하는 정수들 1+2+3+4+....+num >200
		int sum5 = 0;
		
		//시작1, 끝 num, 증감1
		//반복문 sum5 = num+
		int num1 = 1;
		while(true){
			sum5 += num1;
			if(sum5>200){
				break;
			}
			num1++;
		}
		System.out.println("최초의 값 = "+num1);
		System.out.println("합계 = "+sum5);
		
		System.out.println("[예제2-15] p.60");
		String str = "184520";
		int sum6 = 0;
		for(int count = 0; count < str.length();count++){
			sum6 += str.charAt(count)-'0';
		}
		System.out.println(sum6);
		
		
		
		
		
		
		
		
		

	
	}
}