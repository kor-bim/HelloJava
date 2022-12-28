package kr.or.ddit.basic;

import java.util.Arrays;

public class T07_wildCardTest {
	/**
	 * 모든 과정 등록
	 */
	public static void registerCourse(Course<?> course) {
		System.out.println(course.getName() + "수강생" + Arrays.toString(course.getStudents()));

	}

	/**
	 * 학생 과정
	 * 
	 * @param course
	 */
	public static void registerCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName() + "수강생" + Arrays.toString(course.getStudents()));

	}

	/**
	 * 직작인 과정
	 * 
	 * @param course
	 */
	public static void registerCourseWorker(Course<? super Worker> course) {
		System.out.println(course.getName() + "수강생" + Arrays.toString(course.getStudents()));

	}

	public static void main(String[] args) {

		Course<Person> personCourse = new Course<>("일반인과정", 5);
		personCourse.add(new Person("일반인1"));
		personCourse.add(new Worker("직장인1"));
		personCourse.add(new Student("학생1"));

		Course<Worker> workerCourse = new Course<>("직장인과정", 5);
		workerCourse.add(new Worker("직장인1"));

		Course<Student> studentCourse = new Course<>("학생과정", 5);
		studentCourse.add(new Student("학생1"));
		studentCourse.add(new HighStudent("고등학생1"));

		Course<HighStudent> highStudentCourse = new Course<>("고등학생과정", 5);
		highStudentCourse.add(new HighStudent("고등학생1"));

		registerCourse(personCourse);
		registerCourse(workerCourse);
		registerCourse(studentCourse);
		registerCourse(highStudentCourse);
		System.out.println("-----------------------------------------------");

		// registerCourseStudent(personCourse);
		// registerCourseStudent(workerCourse);
		registerCourseStudent(studentCourse);
		registerCourseStudent(highStudentCourse);
		System.out.println("-----------------------------------------------");

		registerCourseWorker(personCourse);
		registerCourseWorker(workerCourse);
		// registerCourseWorker(studentCourse);
		// registerCourseWorker(highStudentCourse);
	}
}

// 일반인
class Person {
	String name; // 이름

	public Person(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

}

// 근로자
class Worker extends Person {

	public Worker(String name) {
		super(name);
	}

}

// 학생
class Student extends Person {

	public Student(String name) {
		super(name);
	}

}

// 고등학생
class HighStudent extends Student {

	public HighStudent(String name) {
		super(name);
	}

}

// 수강코스
class Course<T> {
	private String name; // 코스명
	private T[] students; // 수강생

	public Course(String name, int capacity) {
		this.name = name;

		// 타입 파라미터로 배열을 생성시 오브젝트 배열을 생성후, 타입 파라미터 배열로 캐스팅 해야함.
		students = (T[]) (new Object[capacity]);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T[] getStudents() {
		return students;
	}

	public void add(T t) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) { // 아직 등록되지 않은 빈자리가 있는 경우
				students[i] = t;
				break;
			}
		}
	}

}