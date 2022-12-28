package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		// InetAddress 클래스 => IP주소를 다루기 위한 클래스
		// Naver사이트의 IP정보 가져오기
		InetAddress naverIp = InetAddress.getByName("www.naver.com");
		// 호스트 이름은 머신이름, 도메인명, 또는 IP주소 문자열.
		System.out.println("Host Name => " + naverIp.getHostName());
		System.out.println("Host Address = > " + naverIp.getHostAddress());
		System.out.println();
		// 자기 자신의 컴퓨터의 IP주소 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 Host Name => " + localIp.getHostName());
		System.out.println("내 컴퓨터의 Host Address => " + localIp.getHostAddress());
		System.out.println();
		// Ip 주소가 여러개인 호스트의 정보 가져오기
		InetAddress[] naverIps = InetAddress.getAllByName("www.naver.com");
		for (InetAddress nIp : naverIps) {
			System.out.println(nIp.toString());
		}
	}
}