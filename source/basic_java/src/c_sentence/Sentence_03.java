package c_sentence;

import java.util.Scanner;

public class Sentence_03 {
	public static void main(String[] args) {
		/*
		1. 사용자로부터 값을 입력받기
		  - Scanner
		*/
		Scanner sc = new Scanner(System.in); //java.util.scanner, 자동완성 안하면 맨위에 import가 안됨
//		System.out.println("문자열을 입력해주세요");
//		String input = sc.next(); // sc는 변수명이니까 변경가능
//		//환경을 얘가 구성하면 scanner가 환경을 참조함
//		//next() 사용자가 입력한 값을 받아주는 메소드, 문자열로 받아준다 (f2설명)
//		//콘솔창의 녹색글씨가 엔터치는 순간 next로 들어가서 input으로 들어가서 밑에서 출력되는거
//		//next();는 띄어쓰기, 엔터기준 / nextl(); 엔터만 기준으로잡음 
//		System.out.println(input);
		
//		System.out.println("숫자를 입력해주세요"); //주석처리안하고 실행돌리면 입력될때까지 기다림
//		int input = sc.nextInt(); //숫자말고 실수로 딴거치면 프로그램터짐. 이런거 고려해서 프로그램만들어야함
//		System.out.println("입력하신 숫자는 "+input+"입니다.");//문자열이 아니고 숫자자체로 인식
		
		//1. 사용자로부터 숫자 두개를 받아서 두 숫자 사이의 합을 출력해 주세요.
		//만약 1랑 5이라면 1+2+3+4+5
//		Scanner ran = new Scanner(System.in);
//		Scanner dom = new Scanner(System.in); //이거굳이안써도됨
//		System.out.println("첫번째 숫자를 입력해주세욤");
//		int input1 = sc.nextInt();
//		System.out.println("두번째 숫자도 입력해주세욜");
//		int input2 = sc.nextInt();
		
		// input1이랑 input2 사이의 합계 (이건 input1 < input2 일때)
//		int sum = 0;
		// sum += input1
		// sum += input1 + 1
		// ...
		// sum += input2
		// sum += _____ <- for문의 num값의 자리
		
		// 시작: input1, 끝: input2, 증가량 +1
		// 반복문장 sum += num1
		
//		for(int num = input1; num < (input2 + 1); num++){
//			sum += num;
//		}
//		System.out.println("두 숫자 사이의 합은 "+sum+"이랍니다람쥐");
		
		
		//for문이랑 while문은 한번도 실행이 안될수도있음
		//다음 꺼는 무조건 되게 하는거
		
		
		/*
		2. do-while
		  - while문의 변형으로 기본구조는 while문과 비슷하다.
		  	하지만 최소1회는 블럭{}을 수행하게 된다.
		  - 기본구조
		  	do{
		  		수행될 문장 //처음 한번은 조건에 상관없이 실행
		  	}while(조건식);
		*/
		
		//사용자로부터 입력받은 문자열을 출력하는 프로그램을 만든다.
		// 단. 사용자가 "exit"를 입력할때까지 무한 반복하게 해주세요.
//		String input3 = null;
//		do{
//			System.out.println("문자열을 입력해주쇼");
//			input3 = sc.next(); // String input3을 여기다가 쓰면 do안에서만 적용되기때문에 밖에서 초기화해줘야됨
//			System.out.println(input3);
//		}while(!"exit".equals(input3)); //equals쓸떄 무조건있어야하는것이면 문자가 앞에있어야댐 // 논리부정붙이는거 다시 이해하고 넘어가기
//										//null은 equals앞에 와서 비교할 수 없음
		
		/*
		계산기만들기 (입력받고->조건확인후->break) <- for,while은 조건확인후 입력받음
		1. 사용자로부터 숫자, 연산자, 숫자를 받아야 계산가능 (입력받고)
		2. exit입력시 사용종료(조건) - break
		*/
		
		//1. 사용자로부터 숫자를 입력받는다.
		
		//2. 사용자로부터 부호를 입력받는다.
		
		//3. 사용자로부터 숫자를 입력받는다.
		
		//4. 연산을 수행하여 결과를 출력한다. ->부호를 받으면 캐릭터인데 그걸 어떻게 연산에 넣어??
		
		//5. 1~4를 무한반복해준다
		//	 단. 사용자가 입력한 부호가 사칙연산자가 아니면 종료하여라.
		do{
			System.out.println("첫번째 숫자를 입력하세요");
			int firNum = sc.nextInt();
			System.out.println("사칙연산을 입력하세요");
			String buho = sc.next();
			System.out.println("두번째 숫자를 입력하세요");
			int secNum = sc.nextInt();
			
			if("+".equals(buho)){
				System.out.println(firNum+secNum);
			}else if("-".equals(buho)){
				System.out.println(firNum-secNum);
			}else if("*".equals(buho)){
				System.out.println(firNum*secNum);
			}else if("/".equals(buho)){
				System.out.println((int)((float)firNum/secNum*100+0.5)/100f);
			}else{
				System.out.println("사칙연산 아님 종료");
				break;
			}
			
		}while(true);
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
