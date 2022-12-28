package d_array;

public class Array_01 {
	public static void main(String[] args) {
		/*
		1. 배열(array)이란?
		  - 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것
		
		2. 배열의 선언
		  - 원하는 타입의 변수를 선언하고 변수 또는 타입에 배열임을 의미하는 []를 붙이면 된다.
		  	변수타입[] 변수명; int[] arr; int의 형태를 가지고 있는 배열
		  	변수타입 변수명[]; int arr[]; -헷갈리게 생겨서 잘안씀
		  	
		3. 배열의 생성
		  - 배열을 선언한 다음에는 배열을 생성해야 한다.
		  - 배열을 생성하기 위해서는 연산자 'new'와 함께 배열의 타입과 크기를 지정해주면 된다.
		  	ex) 변수명 = new 변수타입[3];		int[] arr = new int [3];
			  	변수명 = new 변수타입[]{10,20,30,40};
		  	
		4. 배열의 초기화
		  - 배열은 생성과 동시에 자동적으로 자신의 타입에 해당되는 기본값으로 초기화 된다.
		
		+. 선언 및 초기화
		  - 변수타입[] 변수명 = new 변수타입[갯수];
		*/
		
		//1. int형 값을 4개 저장할 수 있는 변수 arr을 선언 및 생성해 주세요.
		int[] arr = new int [4]; // {0,0,0,0}
		//							 0 1 2 3 번 방(인덱스)
		
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
//		System.out.println(arr[3]);

		//시작0, 끝3, 증가1
		//수행문 System.out.println(arr[num]);
		
		for(int num = 0; num < arr.length; num++){ //arr.length: arr 방의 갯수 4개
			System.out.println(arr[num]);
		}
		
		//2. 0번 index에 10, 1번 index에 20, 2번 index에 30, 3번 index에 40
//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;
//		arr[3] = 40;
		
		//시작0, 끝3, 증가1
		//수행문arr[num] = (num+1)*10;
		for(int num = 0; num < arr.length; num++){ //arr.length = 4 = index의 갯수
			arr[num] = (num+1)*10;
		}
		
		for(int num = 0; num < arr.length; num++){ //arr.length: arr 방의 갯수 4개
			System.out.println(arr[num]);
		}
		
		//선언 및 생성 
		int[] arr2 = new int[]{1,3,5,7,9};
		int[] arr3 = {1,3,5,7,9}; 			//선언 및 생성 동시에 할때만 가능
		
		//1. arr3의 모든 방의 합계를 구하여라.
		//int[] arr3 = {1,3,5,7,9}
		
		int sum = 0;
		//sum += arr3[0];
		//sum += arr3[1];
		//sum += arr3[2];
		//sum += arr3[3];
		//sum += arr3[4];
		//시작0, 끝4, 증가 +1m
		//반복문 sum += arr3[num]
		
		for(int num = 0; num < arr3.length; num++){
			sum += arr3[num];
		}
		System.out.println(sum);
		
		//score관련 문제
		//1. 6과목의 점수(정수)를 저장할수 있는 변수 score를 선언 및 생성해 주세요.
		int[] score = new int[6];
		
		
		//2. score의 각 방을 0~100사이의 임의의 정수값으로 변경해 주세요.
		//score방의 갯수 6개 {0,0,0,0,0,0}
		//0~100 임의의 정수값
		//0<= score <101
		//(int)(Math.random()*101)
		
//		score[0] = (int)(Math.random()*101);
//		score[1] = (int)(Math.random()*101);
//		score[2] = (int)(Math.random()*101);
//		score[3] = (int)(Math.random()*101);
//		score[4] = (int)(Math.random()*101);
//		score[5] = (int)(Math.random()*101);
		
		//시작0 끝 5 증가 +1 반복 score[num] = (int)(Math.random()*101);
		for(int num=0;num < score.length; num++){	//배열.length; 배열의 인덱스 방 갯수 구하기 
			score[num] = (int)(Math.random()*101);
		}
		
		
		//3. score 각 방의 값을 출력하여라.
//		System.out.println("score["+num+"] : "+score[0]);
//		System.out.println("score["+num+"] : "+score[1]);
//		System.out.println("score["+num+"] : "+score[2]);
//		System.out.println("score["+num+"] : "+score[3]);
//		System.out.println("score["+num+"] : "+score[4]);
//		System.out.println("score["+num+"] : "+score[5]);
		
		//시작0, 끝5(=score.length), 증가+1
		//반복 System.out.println(score[num]);
		for(int num=0; num < score.length; num++){
			System.out.println("score["+num+"] : "+score[num]);
		}
		
		//4. score 각 방의 값들의 합계
		//합계가 나오면 sum을 생각해요
		int sumscore = 0;
		//sumscore += score[0]
		//sumscore += score[1]
		//sumscore += score[2]
		//sumscore += score[3]
		//sumscore += score[4]
		//sumscore += score[5]
		
		//시작0, 끝5(=score.length), 증가+1
		//반복 sumscore += score[num]
		
		for(int num=0;num < score.length;num++){
			sumscore += score[num];
		}
		System.out.println("sum : "+sumscore);
		
		
		//5. score값들의 평균
		//	  단. 소숫점 세번째 자리에서 반올림하여 두번째 자리까지 표현
		//평균=각 방의 합계/스코어인덱스(방)의 갯수
		
		//0단계. float average = 0f;
		//1단계. average = sumscore / score.length
		//			    	int   /  int  --> int하면 소숫점 표현이 안됨.
		//2단계. average = sumscore / (float)score.length
		//3단계. 반올림하기: (int)(( sumscore / (float)score.lenght * 100) + 0.5f ) / 100f
		
		float avg = (int)(( sumscore / (float)score.length * 100 ) + 0.5f ) / 100f;
		//float average = (int)(( (float) sumscore / score.length * 100) + 0.5f) / 100f;
		System.out.println("avg : "+avg);
		
		//6. score의 값들중 최댓값을 구해주세요.
		//	 단. 최댓값을 0으로 초기화 하지마세요.
		//처음에 했던 생각: 1) while 무한반복 break -> 왜안될까?
		//				2) if - else if
		
		int max = score[0]; // (max > score 나머지들)
		
//		if( max < score[1] ){
//			max = score[1];
//		}else if( max < score[2]){
//			max = score[2];
//		}else if( max < score[3]){
//			max = score[3];
//		}else if( max < score[4]){
//			max = score[4];
//		}else if( max < score[5]){
//			max = score[5];
//		}
		
		//시작: 1, 끝: 5, 증감: +1
		//반복문장: if( max < score[num]){
		//			max = score[num];
		//		 }
		
		for(int num = 1; num < score.length; num++){
			if( max < score[num]){
				max = score[num];
			}
		}
		System.out.println("max : "+max);
		
		
		
		//7. score의 값들중 최솟값을 구해주세요.
		//	단. 최솟값을 100으로 초기화 하지마세요.
		//int min = ?? (min < score 나머지들)
		
		int min = score[0];
		
//		if( min > score[1] ){
//			min = score[1];
//		}else if( min > score[2]){
//			min = score[2];
//		}else if( min > score[3]){
//			min = score[3];
//		}else if( min > score[4]){
//			min = score[4];
//		}else if( min > score[5]){
//			min = score[5];
//		}
		
		//시작: 1, 끝: 5, 증감: +1
		//반복문장: if( min > score[num]){
		//			min = score[num];
		//		 }
		
		for(int num = 1; num < score.length; num++){
			if( min > score[num]){
				min = score[num];
			}
		}
		System.out.println("min : "+min);
	
		
		
		
		
		
		
		
		
		
	}
}
