package kr.or.ddit.basic;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		// URL 클래스 => 인터넷에서 존재하는 서버들의 자원에 접근할 수 있는 주소를 관리하는 클래스
		// http://ddit.or.kr:80/index.html?ttt=123
		URL url = new URL("http", "ddit.or.kt", 80, "main/index.html?ttt=123");

		System.out.println("전체 URL 주소 : http://ddit.or.kr:80/main/index.html?ttt=123#kkk");

		System.out.println("protocol : " + url.getProtocol());
		System.out.println("host : " + url.getHost());
		System.out.println("file : " + url.getFile()); // 쿼리 정보 포함
		System.out.println("query : " + url.getQuery());
		System.out.println("path : " + url.getPath()); // 쿼리 정보 미포함
		System.out.println("prot : " + url.getPort());
		System.out.println("ref : " + url.getRef());

		System.out.println(url.toExternalForm());
		System.out.println(url.toString());
		System.out.println(url.toURI().toString());

		// URL 예제
		/**
		 * http://java.sun.com/j2se/1.3/<br>
		 * docs/guide/collections/designfaq.html#28<br>
		 * ../../../demo/ifc/src/hello.java<br>
		 * file:///~/caldendar<br>
		 * mailto:java-net@abc.com<br>
		 */
	}
}
