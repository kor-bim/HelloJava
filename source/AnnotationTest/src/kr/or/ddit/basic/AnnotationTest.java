package kr.or.ddit.basic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTest {
	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		// PrintAnnotation의 static 변수값 출력
		System.out.println(PrintAnnotation.id);

		// reflection 기능을 이용하여 메서드 실행하기
		// 선언된 메서드 목록 가져오기
		Method[] declareMethods = Service.class.getDeclaredMethods(); // 메서드명 출력

		for (Method m : declareMethods) {
			System.out.println(m.getName());
			for (int i = 0; i < m.getDeclaredAnnotation(PrintAnnotation.class).count(); i++) {
				System.out.print(m.getDeclaredAnnotation(PrintAnnotation.class).value()); // value값 출력 : %, #
			}
			System.out.println(); // 줄바꿈
			
			//방법 1
			//m.invoke(new Service()); // reflection기능 이용한 메서드 실행
			
			//방법2
			Class<Service> klass = Service.class;
			Service service = (Service) klass.newInstance();
			m.invoke(service);
		}
	}
}
