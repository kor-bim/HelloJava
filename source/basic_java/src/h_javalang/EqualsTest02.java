package h_javalang;

import java.io.Serializable;

public class EqualsTest02 {
	public static void main(String[] args) {

		Person p1 = new Person(9303121860315L);
		Person p2 = new Person(9303121860315L);

		System.out.println(p1 == p2); // false
		System.out.println(p1.equals(p2)); // false
		System.out.println(p1);
		System.out.println(p1.hashCode());
		
	}
}

class Person implements Serializable{
	long regNo;

	Person(long regNo) {
		this.regNo = regNo;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Person && obj != null) {
			result = this.regNo == ((Person) obj).regNo;
		}
		return result;
	}

	@Override
	public String toString() {
		return "Person [regNo=" + regNo + "]";
	}

}
