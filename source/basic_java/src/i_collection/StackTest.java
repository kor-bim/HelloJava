package i_collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		
		s.push("0");
		s.push("1");
		s.push("2");
		
		System.out.println("==============Stack==============");
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		
		while(!s.empty()){
			System.out.println(s.pop());
		}
		
		System.out.println("==============Queue==============");
		Queue<String> qu = new LinkedList<>();
		qu.offer("0");
		qu.offer("1");
		qu.offer("2");
		
		while(!qu.isEmpty()){
			System.out.println(qu.poll());
		}
	}
}
