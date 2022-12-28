package i_collection;

public class Collection_01 {
	public static void main(String[] args) {
		/*                                                                       
		1. collection framework                  
			-Collection
				: 데이터 그룹
			-Framework
				: 일을하기 위한 틀
				: 표준화가 가능하다.
				
		2. 핵심 interface
			-List
				: 순서가 있다.
				: 데이터의 중복을 허용한다.
				: ArrayList, Vector, Stack, LinkedList (구현체)
				: 대기표 명단
			-Set
				: 순서가 없다.
				: 데이터의 중복을 허용하지 않는다.
				: HashSet, TreeSet(데이터검색 용도)
				: 집합의 의미
			-Map
			 	: 키와 값으로 이루어져 있디.
				: 순서가 없다.
				: 키는 중복을 허용하지 않고 값을 중복을 허용한다.
				: HashTable, HashMap, TreeMap (구현체)
				: 우편번호, 지역번호
		3. ArrayList
			- 배열을 사용하였을 때 길이를 한 번 정하면 변경이 불가한 단점을 보완하기 위해 만들어 졌다.
			- 매서드들
				: add() => 객체를 추가한다.
				: remove() => 객체를 제거한다.
				: get(int index) => index번째 객체를 얻어온다
				: set(int index, Object obj) => index번째 객체를 교체한다. //객체의요소의 값을 바꾸는게아니라 주소자체를 바꾸는 것  
		4. LinkedList
			- 자신의 데이터와 다음 데이터의 주소를 가지고 있다.
			- 이전 요소를 찾을수 없다.
		5. DoubleLinkedList
			- 자신의 데이터와 이전 테이터의 주소, 다음 데이터의 주소를 가지고 있다.
			
		6. Stack
			- First In Last Out : FILO
			- push() : 객체추가
			- pop() : 추출
			- search() : 원하는 객체를 찾는다.
			- peek() : 가장 위의 객체를 가져온다.
		7. Queue
			- First In First Out : FIFO
			- offer() : 객체추가
			- poll() : 추출
	  	
	  	8. HashSet
	  		- 새로운 요소를 추가하기 위해 add, addAll메서드를 사용할 때 중복추가가 되지 않는다.
	  		    중복추가될때는 실패하게 된다.
	  		    
	  	9. Map<Object, Object>
	  		- key와 value로 이루어져 있다
	  		- 순서가 없기 때문에 키는 중복을 비허용하고 값을 중복을 허용한다.
	  		- 키와 값이 type으로 Object형태 이지만 일반적으로는 키의 경우는 String으로 많이 사용한다.
	  		- method들
	  			- put() : 객체를 추가
	  			- get(key의 값) : 원하는 객체의 값을 가져온다.
	  			- remove(key)
				
		 */
	}
}
