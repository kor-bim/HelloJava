package c_sentence;

public class Sentence_01 {
	public static void main(String[] args) {
		/* 줄맞춤 잘해줄것
		1. 조건문(if문, switch문)
		  - 조건식과 문장을 포함하는 블록{}으로 구성되어 있다.
		  - 조건식의 연산결과에 따라 프로그램의 실행흐름을 변경할 수 있다.
		  - 조건을 만족할때만 수행
		  
		2. if문
		  - 구조 (기본)
		    if(조건식){
		    	조건식이 true일때 수행될 문장
		    }
		    
		  - 변형
		  	if(조건식){
		  		조건식이 true일때 수행
		  	}else{
		  		조건식이 false일때 수행
		  	}
		  	
		  - 2단변형: "양수","음수","0" 만들 수 있음
		  	if(조건식1){
		  		조건식1이 true일때 수행
		  	}else if(조건식2){
		  		조건식1 = false 이고 조건식2 = true
		  	}else{
		  		조건식1과 조건식2가 모두 false일때 수행
		  	}
		*/
		
		boolean power = true;
		// 기본if문 예제) power가 true이면 "켜져있음"을 출력.
		// 조건식 : power == true
		// 수행될 문장 : System.out.println("켜져있음")
		if(power == true){
			System.out.println("켜져있음");
		}
		
		// 변형if문 예제) true "켜져있음", true가 아닐 경우 "꺼져있음" 출력
		// boolean 타입의 장점을 이용하자면 (t/f만 결과값으로 나온다는 장점)
		if(power){
			System.out.println("켜져있음");
		}else{
			System.out.println("꺼져있음");
		}
		
		//-----
		int a1 = 10;
		// 2단변형 if문 예제) a1 > 0 "양수", a1 <0 "음수", a1 = 0 "0" 출력
		// if 	      조건식1: a1>0 , 수행될 문장: System.out.println("양수");
		// else if 조건식2: a1<0 , 수행될 문장: System.out.println("음수");
		// esle 		 둘다아닐때   수행될 문장 : System.out.println("0");
		if(a1>0){
			System.out.println("양수");
		}else if(a1<0){
			System.out.println("음수");
		}else{
			System.out.println("0");
		}
		
		
		//[문제 2-16] (p.50)
		//1. 변수 score 선언, 0이상 100이하의 정수중 임의의 값으로 초기화
		//문제: 0이상 100이하의 정수(int) -> 0 <= score <= 100
		//내가 한 풀이
		//Math.random()이용 
		//0 <= Math.random() < 1
		//0 <= Math.random()*101 < 101 (Math.random은 더블값이니 int로 캐스팅)
		//0 <= (int)(Math.random()*101 < 101
//		int score = (int)(Math.random()*101);
		
		//선생님풀이
		//0 <= Math.random() < 1
		//0 <= x < 101
		//정수의 개수 101개, 시작0 
		int score = (int)(Math.random()*101+0);
		System.out.println(score);
		
		//2. score의 값이 90점 이상이면 "A"출력, 80점이상 90점 미만 "B"출력,
		//   70점 이상 80점 미만 "C"를 출력, 60점 이상 70점 미만이면 "D"를 출력,
		//	 60점 미만이면 "F"를 출력. (if else if문을 이용하라)
		
		//처음 풀이 -- else if를 제대로 활용하지 못하고 else if랑 if랑 섞어쓴 나쁜 예!!!
		//조건식1: score >= 90 -> 수행될 문장 System.out.println("A");
		//조건식2: score >= 80 && score < 90 -> 수행될 문장 System.out.println("B");
		//조건식3: score >= 70 && score < 80 -> 수행될 문장 System.out.println("C");
		//조건식4: score >= 60 && score < 70 -> 수행될 문장 System.out.println("D");
		//다 아닐때								   수행될 문장 System.out.println("F");
//		if(score >= 90){
//			System.out.println("A");
//		}else if(score >= 80 && score < 90){
//			System.out.println("B");
//		}else if(score >= 70 && score < 80){
//			System.out.println("C");
//		}else if(score >= 60 && score < 70){
//			System.out.println("D");
//		}else{
//			System.out.println("F");
//		} // 이렇게 할 필요 없는 이유: 어짜피 위에 조건에서 하나씩 제외되면서 수행되니까
		
		//간단히할때
		//조건식1: score >= 90 -> 수행될 문장 System.out.println("A");
		//조건식2: score >= 80 -> 수행될 문장 System.out.println("B");
		//조건식3: score >= 70 -> 수행될 문장 System.out.println("C");
		//조건식4: score >= 60 -> 수행될 문장 System.out.println("D");
		//		전부 아닐 때		        수행될 문장 System.out.println("F");

		if(score >= 90){
			System.out.print("A"); //+-값이 바로 붙을 수 있도록 println아닌 print로
			
			//95이상이면 "+" 95미만이면 "-"
			if(score >= 95){				//이미 score는 90이상인 애들만 이 조건문으로 들어옴
				System.out.println("+");	//그중 95이상이면 "+"
			}else{
				System.out.println("-");	//그게 아니면(90이상, 95미만) "-"
			}
		}else if(score >= 80){		//else(score < 90) && 조건(score>=80)
			System.out.print("B");
			if(score >= 85){
				System.out.println("+");
			}else{
				System.out.println("-");
			}
		}else if(score >= 70){		//else(score < 80) && 조건(score>=70)
			System.out.print("C");
			if(score >= 75){
				System.out.println("+");
			}else{
				System.out.println("-");
			}
		}else if(score >= 60){		//else(score < 70) && 조건(score>=60)
			System.out.print("D");
			if(score >= 65){
				System.out.println("+");
			}else{
				System.out.println("-");
			}
		}else{						//score<60
			System.out.println("F");
		}
		
		/*
		3. switch-case문
		  - 조건의 경우의 수가 많을때는 if문 보다는 switch문을 사용하는 것이 좋다.
		  - 조건의 결과값으로 int형 범위의 정수값을 허용한다.
		  - 구조
		  	int a = 10;
		  	
		  	switch(조건식-int형의 연산결과값이나 변수){
		  	case 값1 : // 조건식의 값 == 값1
		  		조건식 == 값1일때 수행될 문장
		  		break; // 값이 맞으면 그만하고 나가, 만약 break없으면 값1 or 값2가 되버림
		  	case 값2 : // 조건식의 값 == 값2
		  		조건식 == 값2일때 수행될 문장
		  		break; // break없으면 앞에서 맞으면 계속 맞는 줄알고 오류나옴
		  	default :
		  		조건식과 만족하는 값이 없을때 수행될 문장.
		  	}
		*/
		
		//[문제 2-17] (p. 53)
		//1. 변수 random 선언, 1이상 5이하의 임의의 정수로 초기화
		// 문제: 1 <= random <= 5
		// 공식쓸수있게 변형: 1<= random < 6
		// 정수의 개수:6-1=5개, 시작하는 수:1 -> 공식에 대입
		// 공식: (int)(Math.random()*정수의개수+시작하는수)
		
		int random = (int)(Math.random()*5+1);
		System.out.println(random);
		
		//2. random의 값이 1이면 "32평 아파트 당첨", 2이면 "자동차 당첨",
		//	 3이면 "노트북 당첨", 4이면 "자전거 당첨", 5이면"다음 기회에"를 출력
		switch(random){
		case 1 :
			System.out.println("32평 아파트 당첨");
			break;
		case 2 :
			System.out.println("자동차 당첨");
			break;
		case 3 :
			System.out.println("노트북 당첨");
			break;
		case 4 :
			System.out.println("자전거 당첨");
			break;
		default :
			System.out.println("다음 기회에");
//			break; // 생략가능
		}
		
		//[문제 2-118] (p.553)
		//1. 변수 score 선언, 0이상 100이하의 정수중 임의의 값으로 초기화
		//문제: 0이상 100이하의 정수(int) -> 0 <= score <= 100
		//2. score의 값이 90점 이상이면 "A"출력, 80점이상 90점 미만 "B"출력,
		//   70점 이상 80점 미만 "C"를 출력, 60점 이상 70점 미만이면 "D"를 출력,
		//	 60점 미만이면 "F"를 출력. (if else if문을 이용하라)
		
		//소수점짜르는 것처럼 10의자리 이용하는건가?
		// 100  A
		//90~99 A
		//80~89 B
		//70~79 C
		//60~69 D
		// 그외    F
		
		switch(score/10){
		case 10: case 9 :
			System.out.println("A");
			break;
		case 8 :
			System.out.println("B");
			break;
		case 7 :
			System.out.println("C");
			break;
		case 6 :
			System.out.println("D");
			break;
		default :
			System.out.println("F");
		}
	}
	

}
