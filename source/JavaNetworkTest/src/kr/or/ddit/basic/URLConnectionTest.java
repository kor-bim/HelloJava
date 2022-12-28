package kr.or.ddit.basic;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class URLConnectionTest {
	public static void main(String[] args) throws IOException {
		// URLConnection => 애플리케이션과 URL간의 통신 연결을 위한 추상 클래스

		// 특징 서버(예: naver서버)의 정보외 파일 내용을 출력하는 예제
		URL url = new URL("https://www.naver.com/index.html");

		// Header 정보 가져오기

		// URLConnection객체 구하기
		URLConnection urlCon = url.openConnection();
		System.out.println("Content-Type : " + urlCon.getContentType());
		System.out.println("Encoding : " + urlCon.getContentEncoding());
		System.out.println("Content : " + urlCon.getContent());
		System.out.println();

		// 전체 Header 정보 출력하기
		Map<String, List<String>> headerMap = urlCon.getHeaderFields();

		// Header의 key값 구하기
		Iterator<String> iterator = headerMap.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " : " + headerMap.get(key));
		}
		System.out.println("================================================");
		// 해당 호스트의 페이지 내용 가져오기

		// 파일을 읽어오기 위한 스트림 객체 생성
		// 방법1. URLConnection의 getInputStream()메서드 이용하기
		// 방법2. URL객체의 openStream()메서드 이용하기
		// InputStream is = url.openConnection().getInputStream();
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is, "utf-8");
		int c;
		while ((c = isr.read()) != -1) {
			System.out.print((char) c);
		}
		// 스트림 닫기
		isr.close();
	}
}
