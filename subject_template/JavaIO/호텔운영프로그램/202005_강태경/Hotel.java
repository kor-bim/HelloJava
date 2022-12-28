package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hotel {
	static Map<String, String> roomMap = new HashMap<>();
	
	Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {

		Object obj = null;
		
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream("D:\\D_Other/Hotel2Obj.txt")));
			while((obj = ois.readObject()) != null) {
				roomMap = (Map<String, String>) obj;
			}
			ois.close();
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}
		
		Hotel ht = new Hotel();
		ht.hotelStart();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("D:\\D_Other/Hotel2Obj.txt")));
			oos.writeObject(roomMap);
			oos.close();
		} catch (IOException e) {
		} 
	}
	
	/**
	 * 호텔 영업시작을 위한 메서드
	 */
	private void hotelStart() {	
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		selectMenu();
	}
	/**
	 * 업무 선택을 위한 메서드
	 */
	private void selectMenu() {
		int select;
		while(true) {
			System.out.println("**************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.print("1. 체크인");
			System.out.print("  2. 체크아웃");
			System.out.print("  3. 객실상태");
			System.out.print("  4. 업무종료");
			System.out.println("\n**************************");
			try {
				select = sc.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("1~4 사이만 입력해주세요.");
				sc.nextLine();
				continue;
			}
			switch (select) {
			case 1:
				checkIn();// 체크인 메서드
				break;
			case 2:
				checkOut();// 체크아웃 메서드
				break;

			case 3:
				roomStatus();// 객실상태
				break;

			case 4:
				System.out.println("호텔 문을 닫았습니다.");
				return;// 업무종료

			default:
				break;
			}
		}

	}
	

	/**
	 * 객실상태를 조회하기 위한 메서드
	 */
	private void roomStatus() {

		System.out.println("======================");
		System.out.println("방번호\t이름");
		System.out.println("======================");


		Set<String> roomSet = roomMap.keySet();
		
		for(String roomNum : roomSet) {
			System.out.print(roomNum);
			System.out.println("\t"+roomMap.get(roomNum));
		}
		
		System.out.println("======================");
		System.out.println("사용중인 모든 방을 조회했습니다.");


	}


		

	/**
	 * 체크아웃을 하기위한 메서드
	 */
	private void checkOut() {
		String roomNum;
		while(true) {
			System.out.println("어느방을 체크아웃 하시겠습니까?");
			System.out.print("방번호 입력 : ");
			try {
				roomNum = sc.next();
				break;
			}catch (Exception e) {
				System.out.println("잘못된 형식입니다. 다시 입력해주세요.");
				sc.nextLine();
				continue;
			}
		}
		
		
		if(roomMap.remove(roomNum)!=null) {
			System.out.println("체크아웃되었습니다. ");
		} 
		
	}

	/** 
	 * 체크인을 하기위한 메서드
	 */
	private void checkIn() {
		String roomNum;
		while(true) {
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 : ");
		try {
			roomNum = sc.next();
			break;
		}catch (Exception e) {
			sc.nextLine();
			continue;
		}
		}
		
		
		if(roomMap.get(roomNum)!=null) {
			
			System.out.println(roomNum+"방에는 이미 사람이 있습니다. ");
		} else {
			String name;
			while(true) {
				System.out.println("누구를 체크인 하시겠습니까?");
				System.out.print("이름 입력 : ");
				try {
					name = sc.next();
					break;
				}catch (Exception e) {
					System.out.println("다시 입력해주세요.");
					sc.nextLine();
					continue;
				}
			}
			roomMap.put(roomNum,name);
			
			System.out.println("체크인 되었습니다.");
		}
	}


}