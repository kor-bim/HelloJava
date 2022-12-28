package d_array;

import java.util.Arrays;

public class Array_02 {
	public static void main(String[] args) {
		/*
		1. 정렬(sort)
		  - 어떤 데이터를 빠르고 쉽게 찾을 목적으로 일정한 순서대로 데이터를 가지런히 나열하는 작업.
		  - 버블정렬, 선택정렬, 삽입정렬  (기사시험단골: 버블, 선택)
		  
		2. 버블정렬(bubble sort)
		  - 인접한 데이터 간에 교환이 계속해서 일어난다.
		  - 한 회전이 끝나면 가장 큰값이 뒤쪽에 확정된다.
		  - 회전수 = 인덱스값 - 1
		  - 회전 도중 정렬이 완성되어도 컴퓨터는 모르기때문에 계속 끝까지 회전한다.
		  
		  
		3. 선택정렬 (select sort)
		  - 한 회전이 끝나면 가장 작은 값이 앞쪽에 확정된다.
		  - 회전수 = 인덱스값 -1

		*/
		/*
		5 2 3 1 4
		
		-- 1회전(기준이 0번 index)
		1. 기준방에서부터 최솟값을 가지고 있는 index를 찾는다. (3)
		2. 기준 index와 최솟값이 있는 index의 값을 바꿔준다.
		1 2 3 5 4
		
		-- 2회전(기준이 1번 index)
		1. 기준방에서부터 최솟값을 가지고 있는 index를 찾는다. (1)
		2. 기준 index와 최솟값이 있는 index의 값을 바꿔준다.
		1 2 3 5 4
		
		-- 3회전(기준이 2번 index)
		1. 기준방에서부터 최솟값을 가지고 있는 index를 찾는다. (2)
		2. 기준 index와 최솟값이 있는 index의 값을 바꿔준다.
		1 2 3 5 4
		
		-- 4회전(기준이 3번 index)
		1. 기준방에서부터 최솟값을 가지고 있는 index를 찾는다. (4)
		2. 기준 index와 최솟값이 있는 index의 값을 바꿔준다.
		1 2 3 4 5
		*/
		
		int[] sort = {5,2,3,1,4};
		for(int j = 0; j < sort.length-1; j++){
			int min = sort[j];
			int minBang =  j;
			
			for(int i = j+1; i < sort.length; i++){
				if(sort[i]<min){
					min=sort[i];
					minBang = i;
				}
			}
			int temp = sort[j];
			sort[j]= sort[minBang];
			sort[minBang] = temp;
			
			System.out.println(Arrays.toString(sort));
		}
		//시작 : 0 끝 : sort.length-1, 증가량 1
		
		/*
		 * 삽입정렬 insert sort
		 * 
		 * 5 2 3 1 4
		 * 1회전  2 5 3 1 4
		 * 2회전  2 3 5 1 4
		 * 3회전  1 2 3 5 4
		 * 4회전  1 2 3 4 5
		 * 
		 * 자리를 찾을 때마다 기존의 번호를 하나씩 미루는것 
		 */
	}
		
}
