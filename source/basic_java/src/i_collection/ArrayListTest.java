package i_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		
		//C
		List<Integer> list1 = new ArrayList<>();
		list1.add(new Integer(5));
		list1.add(2);
		list1.add(3);
		list1.add(1);
		list1.add(4);
		
		List<Integer> list2 = new ArrayList<>(list1.subList(1, 4));
		
		System.out.println(list1);
		System.out.println(list2);
		
		//R
		int a = list1.get(2);
		System.out.println(a);
		
		//D
		list1.remove(2);
		System.out.println(list1);
		
		//U
		int change = new Integer(10);
		int after = list1.set(1, change);
		
		System.out.println("바뀌기전 : "+after+", 바뀐값 "+change);
		System.out.println(list1);
		
		//정렬
		Collections.sort(list1);
		System.out.println(list1);
		
		
		
	}
	
}
