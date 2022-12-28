package d_array;

import java.util.Arrays;

public class Array_02_practice {
	public static void main(String[] args) {
		
		//아이디어:한줄출력 -> 한회전출력 -> 전체출력 
		//1. 배열 선언, 생성, 초기화
		int[] bb = new int[]{5,2,3,1,4};
		
		//2. 한줄출력 
		//if	: bb[0] > bb[1]		-> bb[1]에 있던 값이 bb[0]과 변경 
		//else	: bb[0] =< bb[1]	-> 아무일도 없음
//		if( bb[0] > bb[1]){
//			int temp = bb[0]; //bb[0]을 임시 저장할 변수 temp 생성
//			bb[0] = bb[1];
//			bb[1] = temp;
//			System.out.println(Arrays.toString(bb));
//		}else{
//			System.out.println(Arrays.toString(bb));
//		}
		//이 한줄 출력이 반복되면 한 회전이 됨
		//시작1, 끝4, 증가량1

		//3. 한회전출력 (한줄출력 반복)
//		for(int num = 0 ; num<bb.length -1; num++){ 
//			if(bb[num] > bb[num+1]){  
//				int temp = bb[num];
//				bb[num] = bb[num+1];
//				bb[num+1] = temp;
//				System.out.println(Arrays.toString(bb));
//			}else{
//				System.out.println(Arrays.toString(bb));
//			}
//		}
		
		//이 한회전 출력이 반복되면 전체출력이 됨 
		//시작 0, 끝4, 증가량1
		
		//4. 전체출력 (한회전출력 반복)
		for(int cycle = 1; cycle < bb.length; cycle++){
			System.out.println(cycle+"회전");
			for(int num = 0; num < bb.length -1-cycle; num++){ //-cycle을 추가함으로써 확정개념 확립
				if( bb[num] > bb[num+1] ){
					int temp = bb[num];
					bb[num] = bb[num+1];
					bb[num+1] = temp;
					
				}
				System.out.println(Arrays.toString(bb));
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//1) 배열의 선언 및 생성
//		int[] arr = {5,2,3,1,4};
		//       0,1,2,3,4 인덱스값 
		//2) 변수값 저장(랜덤으로 할때도 되게할거임)
		//힌트: arr.length를 이용해 어느수를 넣어도 되도록
		 
		/*
		 * 			5 2 3 1 4
		 * cycle1	2 5 3 1 4
		 * 
		 */

		
		
		
		
		
		
		
		
		
	}
}
