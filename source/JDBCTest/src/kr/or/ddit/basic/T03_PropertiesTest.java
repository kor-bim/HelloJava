package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 외부의 properties파일을 읽어와 Properties객체로 처리하기
 */
public class T03_PropertiesTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// 읽어온 정보를 저장할 Properties 객체 생성
		Properties prop = new Properties();

		// 읽어올 파일명을 이용한 File객체 생성
		File file = new java.io.File("res/db.properties");
		try {
			// 파일 읽기를 수행할 FileInputStream 객체 생성
			FileInputStream fis = new FileInputStream(file);

			// Properties객체로 파일 내용 읽기
			// 파일의 내용을 읽어와 key와 value값으로 분류한 후 Properties객체에 담아준다.
			prop.load(fis);
			// 읽어온 자료 출력하기

			// key값만 읽어와 Enumeration객체로 반환하기
			Enumeration<String> keys = (Enumeration<String>) prop.propertyNames();

			// key값 개수만큼 반복해서 값 출력하기

			// key.hasMoreElement(), 다음 포인터 위치에 자료가 있으면 true 없으면 false 반환
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				String value = prop.getProperty(key);
				System.out.println(key + " => " + value);
			}
			System.out.println("출력 끝...");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
