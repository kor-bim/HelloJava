package d_array;

import java.util.Arrays;

public class Array_03 {
	public static void main(String[] args) {
		/*
		1. 다차원 배열
			- 자바에서는 1차원 배열뿐만 아니라 다차원 배열도 허용한다.
			
		2. 이차원배열의 선언
			- 변수타입[][] 변수명;  int[][] arr;
			- 변수타입 변수명[][];   	
			- 변수타입[] 변수명[];
		3. 이차원배열의 생성
			- 변수명 = new 변수타입[크기1][크기2];
			
		 */
		
		int[][] arr = new int[2][3];

	/*	{
			{0,0,0},
			{0,0,0}
		}
		
		*/
//		System.out.println(arr.length);
//		System.out.println(arr[1].length);
//		System.out.println(arr[1][1]);
//		
		
//		System.out.println(arr[0][0]);
//		System.out.println(arr[0][1]);
//		System.out.println(arr[0][2]);
//		System.out.println(arr[1][0]);
//		System.out.println(arr[1][1]);
//		System.out.println(arr[1][2]);
		
		for(int line = 0; line < arr.length; line++ ){
			for(int row = 0; row < arr[line].length; row++){
				System.out.println(arr[line][row]);
			}
		}
		
		
//		int[][] arr2 = new int[][]{{10,20,30},{40,50,60}}; new int[][]는 생략가능
		int[][] arr2 = {
						{10,20,30},
						{40,50,60}
					   };
		for(int line = 0; line < arr2.length; line++ ){
			for(int row = 0; row < arr2[line].length; row++){
				System.out.println(arr2[line][row]);
			}
		}
		System.out.println(arr2[0]);
		
		
		
		
		
		
		
		
		int[][] arr3 = new int[3][];  // 공간만 확보한 것
		System.out.println(arr3[0]); 
//		{
//			null,
//			null,
//			null,
//		}
		arr3[0] = new int[2];
//		{
//			{0,0},
//			null,
//			null
//		}
		arr3[1] = new int[3];
		arr3[2] = new int[4];
//		{
//			{0,0},
//			{0,0,0},
//			{0,0,0,0}
//		}
		
		
		
		
		
		//3. 변수 names를 선언하고 주변친구 6명의 이름으로 초기화 하여라.
		String[] names = {"이재형", "윤한빈", "이인철", "박지수", "임건", "서대철"};
		
		//4. 과목
		String[] subjects= {"국어", "수학", "영어", "사회", "과학","오라클", "자바"};
		
		//1. 6명의 7과목을 저장할 수 있는 배열 score를 선언 및 생성해주세요.
		int[][] score = new int[names.length][subjects.length];
		
		//2. score 각방을 0~100점사이의 임의의 정수의 값을 저장하여라.
		for(int i = 0; i < score.length; i++){
			for(int j = 0; j < score[i].length; j++){
				score[i][j] = (int)(Math.random()*101);
			}
		}
		
		
		//5.사람별 합계를 구하시오.
		int[] sum= new int[names.length];
		for (int i = 0; i < score.length; i++) {
			for(int j = 0; j < score[i].length; j++){
				sum[i]+=score[i][j];
			}
		}
		
		//6. 사람별 평균을 구하시오 소수점3번째 자리에서 반올림해서 소수점 2번째 자리까지 나타내시오.
		float[] average = new float[names.length];
		for (int i = 0; i < score.length; i++) {
			average[i] = (float)sum[i]/subjects.length;
			average[i] = ((int)(average[i]*100+0.5))/100f;
		}
		
		//7. 과목별 합계를 구하시오.
		int[] subsum = new int[subjects.length];
		for(int i = 0; i < subjects.length; i++){
			for(int j = 0; j < names.length; j++){
				subsum[i]+=score[j][i];
			}
		}

		//8. 과목별 평균을 구하시오.
		float[] subavr = new float[subjects.length];
		for(int i = 0; i < subjects.length; i++){
			subavr[i] = ((int)(((float)subsum[i]/names.length)*100+0.5))/100f;
		}
		
		//9. 사람별 석차를 구하시오.
		int rank[]=new int[names.length];
		for (int i = 0; i < rank.length; i++) {
			rank[i]=1;
			for (int j = 0; j < rank.length; j++) {
				if(average[i]<average[j]){
					rank[i]++;
				}
			}
		}
		
		
		
		String tmp;
		int tmp1=0;
		int tmp2=0;
		float tmp3=0;
		
		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < sum.length-i-1; j++) {
				if(sum[j]<sum[j+1]){
					
					tmp1=rank[j];
					rank[j]=rank[j+1];
					rank[j+1]=tmp1;
					
					
					
					
				}					
				
			}
		}
		
		

		/*0. 아래와 같이 출력해주세요
		0 0 0 0 0 0 0 
		0 0 0 0 0 0 0
		0 0 0 0 0 0 0
		0 0 0 0 0 0 0
		0 0 0 0 0 0 0
		0 0 0 0 0 0 0
		*/
		
		for(int i = 0; i<subjects.length; i++){
			System.out.print("\t"+subjects[i]);
		}
		System.out.print("\t"+"합계");
		System.out.print("\t"+"평균");
		System.out.println();
		for(int i = 0; i < score.length; i++){
			System.out.print(names[i]+ "\t");
			for(int j = 0; j < score[i].length; j++){
				System.out.print(score[i][j]+"\t");
			}
			System.out.print(sum[i]+"\t");
			System.out.print(average[i]+"\t");
			System.out.print(rank[i]);
			System.out.println();
		}
		System.out.print("과목별 합계");
		for(int i = 0 ; i<subjects.length; i++){
			System.out.print("\t"+subsum[i]);
		}
		System.out.println();
		System.out.print("과목별 평균");
		for(int i = 0; i < subjects.length; i++){
			System.out.print("\t"+subavr[i]);
			
			
			
			
		}
	}
}
