package Homework;
/*
문제)

호텔 운영을 관리하는 프로그램 작성.(Map이용)
 - 키값은 방번호 
 
실행 예시)

**************************
호텔 문을 열었습니다.
**************************

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 1 <-- 입력

어느방에 체크인 하시겠습니까?
방번호 입력 => 101 <-- 입력

누구를 체크인 하시겠습니까?
이름 입력 => 홍길동 <-- 입력
체크인 되었습니다.

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 1 <-- 입력

어느방에 체크인 하시겠습니까?
방번호 입력 => 102 <-- 입력

누구를 체크인 하시겠습니까?
이름 입력 => 성춘향 <-- 입력
체크인 되었습니다

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 3 <-- 입력

방번호 : 102, 투숙객 : 성춘향
방번호 : 101, 투숙객 : 홍길동

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 2 <-- 입력

어느방을 체크아웃 하시겠습니까?
방번호 입력 => 101 <-- 입력
체크아웃 되었습니다.

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 1 <-- 입력

어느방에 체크인 하시겠습니까?
방번호 입력 => 102 <-- 입력

누구를 체크인 하시겠습니까?
이름 입력 => 허준 <-- 입력
102방에는 이미 사람이 있습니다.

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 2 <-- 입력

어느방을 체크아웃 하시겠습니까?
방번호 입력 => 101 <-- 입력
101방에는 체크인한 사람이 없습니다.

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 3 <-- 입력

방번호 : 102, 투숙객 : 성춘향

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 4 <-- 입력

**************************
호텔 문을 닫았습니다.
**************************
*/

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelIo {
	

	private Scanner scan = new Scanner(System.in);
	private static Map<String, Room> hotelManagement = new HashMap<>();;

	public static void main(String[] args) {
		
		try {
			
			// 객체를 파일에 저장
			// OutputStream을 직접 상속받지만 기반 스트림을 필요로 하는 보조스트림, 객체 생성 시 입출력할 스트림 지정해야함
			FileOutputStream fos = new FileOutputStream("D:\\D_Other\\testtest.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\JavaOracle\\A.TeachingMaterial\\3.high_java\\other\\test2.txt"));

			
			// 쓰기 작업
			// 직렬화
			oos.writeObject(hotelManagement);
			
			// 아웃풋 스트림객체 닫아주기
			oos.close();
		
			// 호텔관리프로그램 객체 생성 및 시작메서드 호출
			HotelIo pb = new HotelIo();
			pb.hotelManagementStart();
			
			///////////////////////////////////////////////////////////////////////////////////////
			// 저장한 객체 출력
			// 입력용 스트림 객체 생성 
			FileInputStream fis = new FileInputStream("D:\\D_Other\\testtest.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			// 읽어올 객체 저장
			Object obj = null;
			
			try {
				// readObject()메서드로 자료를 읽어옴, 더이상 읽어 올 자료가 없으면 null 반환
				while((obj=ois.readObject())!=null) {
				// 읽어온 데이터를 원래 객체형으로 변환 후 사용
					Map<String, Room> hotelManagement = (Map<String, Room>) obj; 
				}
				// 인풋 스트림객체 닫아주기
				ois.close();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			}catch (IOException e) {
				e.printStackTrace();
			}
			
	}
		
		
		

	


	
	// 메뉴 출력하는 메서드
	private void displayMenu() {
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.print("1.체크인  ");
		System.out.print("2.체크아웃  ");
		System.out.print("3.객실상태  ");
		System.out.println("4.업무종료");
		System.out.print("메뉴선택>> ");
	}
	
	
	// 프로그램을 시작하는 메서드
		public void hotelManagementStart(){
			System.out.println("****************************");
			System.out.println("호텔 문을 열었습니다");
			System.out.println("****************************");
			
			while(true){
				
				displayMenu();  // 메뉴 출력
				
				int menuSelect = scan.nextInt();   // 메뉴 번호 입력
				
				switch(menuSelect){
					case 1 :
						checkIn();		// 체크인
						break;
					case 2 :
						checkOut();		// 체크아웃
						break;
					case 3 :
						roomCheck();	// 객실상태 확인
						break;
					case 4 :			// 업무 종료
						System.out.println("프로그램을 종료합니다...");
						
						System.out.println("****************************");
						System.out.println("호텔 문을 닫았습니다");
						System.out.println("****************************");
						return;
					default :
						System.out.println("잘못 입력했습니다. 다시 입력하세요.");
				} // switch문
			} // while문
		} // 메서드





	/** 등록
	 * 새로운 투숙객을 체크인 등록하는 메서드
	 */
	private void checkIn() {
		System.out.println();
		System.out.println("어느 방에 체크인 하시겠습니까?");
		System.out.print("방 번호 입력  => ");	
		String roomNum = scan.next();
		
		// 이미 체크인 완료된 방인지 체크
		if(hotelManagement.get(roomNum)!=null) {
			System.out.println("이미 체크인 완료된 방입니다.");
			return;
		}
		System.out.println("이름>> ");
		String name = scan.next();
		
		hotelManagement.put(roomNum, new Room(roomNum, name));
		System.out.println(roomNum+" 체크인 완료 되었습니다.");
		
	}
	
	
	
	
	
	
	/** 삭제
	 * 체크인 완료된 룸을 체크아웃하는 메서드
	 */
	private void checkOut() {
		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방 번호 입력=> ");
		String roomNum = scan.next();
		
		if(hotelManagement.remove(roomNum)==null) {
			System.out.println(roomNum+"은 체크인 된 내역이 없습니다.");
		}else {
			System.out.println(roomNum+"의 체크아웃이 완료 되었습니다.");
		}
		System.out.println("체크 아웃 작업 완료...");
	}
	
	
	
	
	
	
	
	/** 전체 객실 조회
	 * 전체 객실 상태 확인을 위한 메서드
	 */
	private void roomCheck() {
		Set<String> keySet = hotelManagement.keySet();
		System.out.println("=======================================");
		System.out.println(" \t 객실번호 \t 투숙객 \t ");
		System.out.println("=======================================");

		if(keySet.size()==0) {
			System.out.println("등록된 전화번호 정보가 없습니다.");
		}else {
			Iterator<String> it = keySet.iterator();
			int cnt = 0;
			while(it.hasNext()) {
				cnt++;
				String roomNum = it.next();
				Room r = hotelManagement.get(roomNum);
				System.out.println(" "+cnt+"\t"+r.getRoomNum()+"\t"+r.getName());
				
			}
			System.out.println("=======================================");
			System.out.println("출력 완료");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

/**
 * 호텔 룸 정보를 저장할 수 있는 VO클래스
 * @author ju901
 *
 */
class Room implements Serializable{
	private String roomNum; // 방번호
	private String name; // 투숙객
	
	
	
	public Room(String roomNum, String name) {
		super();
		this.roomNum = roomNum;
		this.name = name;
	}
	
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "room [roomNum=" + roomNum + ", name=" + name + "]";
	}
	

	
	
	
}
