package z_exam;

public class Exam_04 {
	public static void main(String[] args) {
		/*[5-1]다음은 배열을 선언하거나 초기화한 것이다. 잘못된 것을 고르고 그 이유를 설명하시오. 4,5
		 * 1. int[] arr[];
		 * 2. int[] arr={1,2,3,};
		 * 3. int[] arr=new int[5];
		 * 4. int[] arr = new int[5]{1,2,3,4,5}
		 * 5. int arr[5];
		 * 6. int[] arr[] = new int[3][];
		 
		 * - 변수타입[][] 변수명;  int[][] arr;
		   - 변수타입 변수명[][];   	
		   - 변수타입[] 변수명[];
		 */
		//[5-2] 다음과 같은 배열이 있을 때,
		 //arr5[3].length;//의 값은 얼마인가?3
		 //arr5.length;//의 값은 얼마인가?3
		 
		int[][] arr ={{5,5,5,5,5},{10,10,10},{20,20,20,20},{30,30}};
		//System.out.println(arr[4][1]);//의 출력 결과는 얼마인가? 에러남 행의 갯수가 3개인데 4개는 오류
		
		
		//[5-3] 배열 arr에 담긴 모든 값을 더하는 프로그램을 완성하시오.
		
		int[] arr2={10,20,30,40,50};
		int sum = 0;
		for (int i = 0; i < arr2.length; i++) {
			sum+=arr2[i];
		}
		System.out.println("Sum = "+sum);
		
		//[5-4] 2차원 배열 arr에 담긴 모든 값의 총합과 평균을 구하는 프로그램을 완성하시오.
		int[][] arr3 = {{5,8,13,5,2},{22,13,28},{2,18,23,62}};
		int total =0;//합계를 저장하기 위한 변수
		float average =0; //평균을 저장하기 위한 변수
		int cnt=0;
		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr3[i].length; j++) { //arr3[i]는 i번째 행의 열
	
				total+=arr3[i][j];
				cnt++; //반복문이 한번 회전할 때 카운트증가
			}
		}
		average=(float)((int)(total/cnt*1000+0.5))/1000f;
		
		
		
		
		System.out.println("total = "+total);
		System.out.println("Average = "+average);
		
		/*[5-5]거스름돈을 몇 개의 동전으로 지불할 수 있는지를 계산하는 문제이다. 변수 money의 금액을
		 * 동전으로 지불할 수 있는지를 계산하는 문제이다. 변수 money의 금액을 동전으로 바꾸었을 때 각각
		 * 몇개의 동전이 필요한지 계산해서 출력하라. 단, 가능한 한 적은 수의 동전으로 거슬러 주어야한다.
		 * (1)에 알맞은 코드를 넣어서 프로그램을 완성하시오
		 */
		int[] coinUnit = {500,100,50,10};
		int money =2790;
		int cnt2;				
		for (int i = 0; i < coinUnit.length; i++) {      //반복문을 통해 
			cnt2=money/coinUnit[i];                      //i번째요소의 동전을 돈에 나눈몫을 새로운 변수에 저장한다.몫이 int형의 정수형으로 출력하게 한다. 
			money-=coinUnit[i]*cnt2;				 //그리고 다시 i번째 동전이 총 낼 수 있는 금액을 money의 값에서 차감하고 새로운값을  money에 저장한다
			System.out.println(coinUnit[i]+"원\t"+cnt2+"개");
		}
		
					
		
		
		/*[5-6]다음은 1과 9사이의 중복되지 않은 숫자로 이루어진 3자리 숫자라를 만들어내는 프로그램이다.
		 * *임의의 값을 사용했기 때문에 실행결과와 다를 수 있다.
		 */
		int[] ballArr = {1,2,3,4,5,6,7,8,9};
		int[] ball3 = new int[3];
		
//		//ballArr의 index순서대로 index의 요소와 임의의 요소를 골라서 값을 바꾼다.
//		for (int i = 0; i < ballArr.length; i++) {
//			int tmp=0;
//			int r=(int)(Math.random()*ballArr.length); // ball3의 임의의 숫자 인덱스번호를 새로운 변수 저장한다.
//			tmp=ball3[i];              // 자리를 바꾼다.
//			ball3[i]=ball3[r];			
//			ball3[r]=tmp;			   //자리를 바꾸는 이유는 후에 같은 자리의 인덱스번호가 와도 계속 자리를 바꾸기
//		}							   //때문에 중복된 숫자가 올 수가 없다. 
//		
		//ballArr의 앞에서 3개를 ball3로 복사한다.
		for (int i = 0; i < ball3.length; i++) {
			ball3[i]=ballArr[i];
		}
		//ball3의 값을 출력한다.
		for (int i = 0; i < ball3.length; i++) {
			System.out.print("ball["+(i+1)+"] ="+ball3[i]+"\t");
		}
		System.out.println();
		/*[5-7] 다음은 배열 answer에 담긴 데이터를 읽고 각 숫자의 개수를 세어서 개수만큼 '*'을 찍어서 
		 * 그래프를 그리는 프로그램이다.
		 */
		int[] answer = {1,4,3,2,1,2,3,2,1,4};
		int[] counter = new int[4];
		
		//answer의 요소들 중 1이면 counter의 0번방을 증가, 2이면 counter의 1번방을 증가
		//3이면 counter 2번방을 증가, 4이면 counter의 3번방을 증가.
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < counter.length; j++) {   // counter[answer[i]-1]++;
				if(answer[i]==j+1){
					counter[j]++;
				}
			}
		}
		
		//counter에 저장된 요소를 결과와 같이 출력하여라.
		for (int i = 0; i < counter.length; i++) {
			System.out.print(i+1+":"+(i+1)+"개");
			for (int j = 0; j < counter[i]; j++) { //범위를 counter의 i번째 요소 값의 범위를 두어서 별을 출력한다.
				System.out.print("*");
			}
			System.out.println();
			
		}
		//hide:answer의 값이 범위를 측정하여 최대 5개의 통계를 만들기
		
		/*[5-8] 문제 5-5에 동전의 개수를 추가한 프로그램이다. 커맨드라인으로부터 거슬러 줄 금액을 입력받아 계산한다. 
		 * 보유한 동전의 개수로 거스름돈을 지불할 수 없으면, '거스름돈이 부족합니다.'라고 출력하고 종료한다. 지불할 돈이 충분히 있으면, 
		 * 거스름돈을 지불한 만큼 가진 돈에서 빼고 남은 동전의 개수를 화면에 출력한다. (1)에 알맞은 코드를 넣어서 프로그램을 완성하시오.*/
		
		if (args.length!=1) {
			System.out.println("한개의 숫자만 입력해주세요");
			System.exit(0);
		}
//		 문자열을 숫자로 변환한다. 입력한 값이 숫자가 아닐 경우 예외가 발생한다.
		int money1 = Integer.parseInt(args[0]);
		System.out.println("money="+money1);
		int[] coinUnit1={500,100,50,10};
		int[] coin={5,5,5,5};
		
		for (int i = 0; i < coinUnit1.length; i++) {
			int coinNum =0;

			/*(1) 아래의 로직에 맞게 코드를 작성하시오.
			      1. 금액(money)을 동전단위로 나눠서 필요한 동전의 개수(coinNum)를 구한다.
			      2. 배열 coin에서 coinNum만큼의 동전을 뺀다.
			      (만일 충분한 동전이 없다면 배열 coin에 있는 만큼만 뺀다.)
			      3. 금액에서 동전의 개수(coinNum)와 동전단위를 곱한 값을 뺀다.*/
			coinNum=money1/coinUnit1[i];  
			
			if(coin[i]>=coinNum){
				coin[i]-=coinNum;	
			}else{
				coinNum=coin[i];
				coin[i]-=coin[i];
			}
			money1-=coinNum*coinUnit1[i];
			
			
			System.out.println(coinUnit1[i]+"원: "+coinNum);
		}
		if(money1>0){
			System.out.println("거스름돈이 부족합니다");
			System.exit(0);// 프로그램을 종료한다.
		}
		System.out.println("=남은 동전의 개수 =");
		
		for (int i = 0; i < coinUnit1.length; i++) {
			System.out.println(coinUnit1[i]+"원:"+coin[i]);
		}
		//[5-9] 주어진 배열을 시계방향으로 90도 회전시켜서 출력하는 프로그램을 완성 하시오.
		char[][] star={{'*','*',' ',' ',' '},{'*','*',' ',' ',' '},{'*','*','*','*','*'},{'*','*','*','*','*'}};
		char[][] result= new char[star[0].length][star.length];
		
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		
		
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				int a=j;
				int b=3-i;
				result[a][b]=star[i][j];
			}
		}
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
}

