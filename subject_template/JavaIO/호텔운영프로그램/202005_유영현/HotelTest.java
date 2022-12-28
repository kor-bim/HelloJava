package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelTest {
	private Map<Integer, Hotel> roomMap = new HashMap<Integer, Hotel>();
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		HotelTest ht = new HotelTest();
		ht.hotelStart();
	}
	
	/**
	 * 호텔을 운영하기위한 메서드
	 * @author PC-16
	 */
	private void hotelStart() {	
		System.out.println("*****************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("*****************\n");
		hotelMenu();
	}
	
	/**
	 * 호텔메뉴를 보기 위한 메서드
	 * @author PC-16
	 */
	private void hotelMenu() {
		int hotelinput = 0;
		while(true) {
			System.out.println("************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.print("1.체크인");
			System.out.print("  2.체크아웃");
			System.out.print("  3.객실상태");
			System.out.print("  4.업무종료");
			System.out.println("\n************************************");
			System.out.print("메뉴선택 => ");
			
			Scanner sc = new Scanner(System.in);
			try {				
				hotelinput = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("메뉴선택시 숫자를 입력해주세요\n");
				continue;
			}
			
			switch (hotelinput) {
			case 1: //체크인
				CheckIn();
				break;
				
			case 2: //체크아웃
				CheckOut(); 
				break;

			case 3: //객실상태
				RoomCondition();
				break;

			case 4: //업무종료
				System.out.println();
				System.out.println("*****************");
				System.out.println("호텔 문을 닫았습니다.");
				System.out.println("*****************");
				save(roomMap); //업무종료후 저장하기위한 메서드
				return;

			default :
				System.out.println();
				System.out.println("1 ~ 4번 중 선택해주세요");
				continue;
			}
		}

	}
	
	/**
	 * 체크인을 하기위한 메서드
	 * @author PC-16
	 */
	private void CheckIn() {
		int roomNum=0;
		
		while(true) {
			System.out.println();
			System.out.println("어느방에 체크인 하시겠습니까?");
			System.out.print("방번호 입력 => ");
			
			Scanner sc = new Scanner(System.in);
			
			try {
				roomNum = sc.nextInt();
				break;
			}catch (InputMismatchException e) { //Scanner할때 많이 발생하는 예외
				System.out.println();
				System.out.println("에러발생! 방번호는 숫자만 입력해주세요.");
				continue;
			}
		}
		System.out.println();
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 => ");
		String name = sc.next(); //String타입으로 리턴해준다
		
		if(roomMap.get(roomNum)!=null) {
			System.out.println(roomNum+"방에는 이미 사람이 있습니다. ");
			System.out.println();
		} else {
			roomMap.put(roomNum, new Hotel(roomNum, name));
			System.out.println("체크인 되었습니다.");
			System.out.println();
		}
	}
		
	/**
	 * 체크아웃을 하기위한 메서드
	 * @author PC-16
	 */
	private void CheckOut() {
		int roomNum = 0;
		while(true) {
			System.out.println();
			System.out.println("어느방을 체크아웃 하시겠습니까?");
			System.out.print("방번호 입력 => ");
			try {
				roomNum = sc.nextInt();
				break;
			}catch (InputMismatchException e) {
				System.out.println("잘못된 형식입니다. 숫자로만 입력해주세요.");
				sc.nextLine();
				continue;
			}
		}
		if(roomMap.remove(roomNum) == null) {
			roomMap.remove(roomNum);//리스트의 객체를 삭제하는데 사용되는 메소드
			System.out.println(roomNum + "방에는 체크인한 사람이 없습니다.");
			System.out.println();
		}else {
			System.out.println(roomNum + "방이 체크아웃되었습니다.");
			System.out.println();
		}
		
	}
	
	
	/**
	 * 객실상태를 보기위한 메서드
	 * @author PC-16
	 */
	private void RoomCondition() {
		
		Set<Integer> roomSet = roomMap.keySet();
		
		System.out.println();
		System.out.println("----------------------------");
		System.out.println(" 현재 이용하는 객실 과 사용자 입니다. ");
		System.out.println("----------------------------");
		if(roomSet.size()==0) {
			System.out.println(" 사용중인 방이 없습니다.");
		} else {
//			Iterator<Integer> it = roomSet.iterator();
			for(Integer info : roomSet) {
//				int roomNum = it.next();
				System.out.println(	"방번호 : " + roomMap.get(info).getRoomNum() + ", " + "투숙객 : " + roomMap.get(info).getName());
			}
		}
		System.out.println("----------------------------");
		System.out.println();
	}
	
	/**
	 * 파일 생성하는 메서드
	 */
	public HotelTest(){
		
		File file = new File("d:/D_Other/hotelbox.txt");
		
		try {
			ObjectInputStream ois = 
					new ObjectInputStream(
						new BufferedInputStream(// BufferedInputStream 객체를 생성.
							new FileInputStream("d:/D_Other/hotelbox.txt"))); // FileInputStream 으로 "hotelbox.txt" 파일의 객체를 생성 
			
			Map<Integer, Hotel> Hotel2 = (Map<Integer, Hotel>) ois.readObject(); //객체에서 Object를 읽는다.
			
			roomMap = Hotel2;
			
		}catch(FileNotFoundException e) {
//			e.printStackTrace();
		}catch(IOException e) {
//			e.printStackTrace();
		}catch(ClassNotFoundException e) {
//			e.printStackTrace();
		}
	}
	
	
	/**
	 * 기록을 저장하는 메서드
	 */
	private void save(Map<Integer, Hotel> roommap) {
		
		File file = new File("d:/D_Other/hotelbox.txt");
		
		try {
			ObjectOutputStream oos = 
					new ObjectOutputStream(
						new BufferedOutputStream( //BufferedOutputStream 객체를 생성
							new FileOutputStream("d:/D_Other/hotelbox.txt")));  // FileInputStream 으로 출력할 파일 "hotelbox.txt" 객체를 생성
			
			Set<Integer> roomkey = roommap.keySet();
			
			if(roomkey.size() == 0) {
				System.out.println("저장된 기록이 존재하지 않습니다.");
			}else {
				oos.writeObject(roommap); //Obj 객체를 스트림에 쓴다.
				oos.flush(); // 현제 버퍼에 저장되어 있는 내용을 클라이언트로 전송하고 버퍼를 비운다.
				oos.close(); //열린파일을 닫는다.
			}
			
			
		}catch (FileNotFoundException e) { //파일을 입력받아 출력 시키는 프로그램을 실행할 때 나타나는 오류
			e.printStackTrace();
			
		}catch (IOException e) { //IOException에 대한 예외 처리까지 해 주어야만 컴파일 할 수 있다.
			e.printStackTrace();
		}
	}

}

class Hotel implements Serializable{ //직렬화  : 자바 시스템 내부에서 사용되는 Object 또는 Data를 외부의 자바 시스템에서도 사용할 수 있도록 byte 형태로 데이터를 변환하는 기술.
	private Integer roomNum; //방번호
	private String name; //이름

	public Hotel(Integer roomNum, String name) {
		super();
		this.roomNum = roomNum;
		this.name = name;
	}

	//방번호
	public Integer getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}

	//이름
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hotel [roomNum=" + roomNum + ", name=" + name + "]";
	}
	
}
