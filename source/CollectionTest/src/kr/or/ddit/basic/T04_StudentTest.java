package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다. 생성자는 학번, 이름,
 * 국어, 영어, 수학 점수만 매개변수를 받아서 처리한다.
 * 
 * 이 Student 객체들은 List에 저장하여 관리한다. List에 저장한 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분과 총점의
 * 역순으로 정렬하는 부분을 프로그램 하시오. (총점이 같으면 학번의 내림차순으로 정렬되도록 한다. 학번 정렬 기준은 Student 클래스
 * 자체에서 제공하도록 하고, 총점 정렬기준은 외부클래스에서 제공하도록 한다.)
 */
public class T04_StudentTest {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("20200001","윤한빈",90,70,60));
		list.add(new Student("20200123","이재형",21,30,60));
		list.add(new Student("20200182","이인철",60,72,60));
		list.add(new Student("20200987","장지수",60,72,60));
		list.add(new Student("20200456","임건",10,60,60));
		int count = 1;
		
		Collections.sort(list);
		for(Student std : list) {
			System.out.println(std);
		}
		
		System.out.println("================================================================================");
		Collections.sort(list, new SortDesc());
		for(Student std : list) {
			std.setRank(count);
			count++;
			System.out.println(std);
		}
	}
}

class Student implements Comparable<Student> {
	private String num; // 학번
	private String name;
	private int korean;
	private int english;
	private int math;
	private int sum;
	private int rank;

	public Student(String num, String name, int korean, int english, int math) {
		super();
		this.num = num;
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.sum = korean+english+math;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", korean=" + korean + ", english=" + english + ", math="
				+ math + ", sum=" + sum + ", rank=" + rank + "]";
	}

	@Override
	public int compareTo(Student std) {
		return getNum().compareTo(std.getNum());
	}
}

class SortDesc implements Comparator<Student> {

	@Override
	public int compare(Student std1, Student std2) {
		if (std1.getSum() > std2.getSum()) {
			return -1;
		} else if (std1.getSum() == std2.getSum()) {
			return std1.getNum().compareTo(std2.getNum())*-1;
		} else {
			return 1;
		}
	}
}
