package assignment;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
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

/**
 * 호텔 업무를 하기 위한 클래스
 * @author PC-25
 *
 */
public class HotelManage {
	
	private Scanner scan; 				// 입력을 받기 위한 Scanner객체의 참조 변수
	private Map<Integer, Room> roomMap;	// 객실의 목록을 저장할 수 있는 Map
	
	public HotelManage() {
		scan = new Scanner(System.in);
		roomMap = new HashMap<Integer, Room>();
	}
	
	/**
	 * 호텔 업무를  시작하는 메서드
	 * 업무를 시작하며 기존의 작업 내용을 저장한 파일을 불러옴.
	 * 프로젝트폴더/res/hotelManage.bin파일
	 */
	private void openHotel() {
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		loadFile();
		hotelMenu();
	}

	/**
	 * 기존 작업 파일을 읽어오는 메서드
	 * 파일 경로 : 프로젝트폴더/res/hotelManage.bin
	 */
	private void loadFile() {
		File file = new File("res/hotelManage.bin");
		try {
			ObjectInputStream ois = new ObjectInputStream(
										new BufferedInputStream(
											new FileInputStream(file)));
			Object obj;
			boolean chk = false; // 파일을 읽어왔는지 확인 true면 읽어옴.
			while((obj = ois.readObject()) != null) {
				roomMap = (Map<Integer, Room>)obj;
				chk = true;
			}
			if(!chk) {
				System.out.println("파일 읽기 실패!!!");
			}
			ois.close();
			
		} catch (IOException e) {
			System.out.println("파일 읽기 성공!");
		} catch(ClassNotFoundException e) {
		}
	}

	/**
	 * 호텔 업무 메뉴를 출력하는 메서드
	 */
	private void hotelMenu() {
		while(true) {
			System.out.println("*******************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃  3.객실상태  4.업무종료");
			System.out.println("*******************************************");
			System.out.println("메뉴선택 => ");
			selectOption();			
		}
	}

	/**
	 * 호텔 업무 메뉴를 선택하는 메서드
	 */
	private void selectOption() {
		int opt = 0;
		try {
			opt = scan.nextInt();
			
		}catch(InputMismatchException e){
			System.out.println();
			System.out.println("메뉴를 숫자로 입력해주세요");
			System.out.println();
			scan.nextLine();
			return;
		}finally {
			switch(opt) {
			case 1:
				checkIn(); 		// 객실 체크인
				break;
			case 2:
				checkOut();		// 객실 체크아웃
				break;
			case 3:
				roomStatus();	// 객실 상태	
				break;
			case 4:
				close();		//프로그램 종료
			default:
				System.out.println("메뉴를 다시 선택해주세요..");
			}
			
		}
		
	}

	/**
	 * 호텔의 문을 닫는 메서드
	 * 문을 닫기 전 업무 내용을 파일로 저장
	 */
	private void close() {
		saveFile();
		System.out.println("**************************");
		System.out.println("호텔 문을 닫았습니다.");
		System.out.println("**************************");
		System.exit(0);
	}

	/**
	 * 업무 내용을 파일로 저장하는 메서드
	 * 프로젝트폴더/res/hotelMnage.bin 파일로 저장.
	 */
	private void saveFile() {
		File file = new File("res/hotelManage.bin");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
										new BufferedOutputStream(
											new FileOutputStream(file)));
			
			oos.writeObject(roomMap);
			System.out.println("저장 완료!");
			oos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 호텔의 객실을 체크아웃하는 메서드
	 */
	private void checkOut() {
		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		int roomNum = 0;
		while(true) {
			System.out.print("객실 번호 입력 => ");
			
			try {
				roomNum = scan.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println();
				System.out.println("객실 번호를 숫자로 입력해주세요..");
				System.out.println();
				scan.nextLine();
			}	
		}
		if(roomMap.remove(roomNum) == null) {
			System.out.println("해당 객실의 체크인 내력이 없습니다.");
			return;
		}
		System.out.println("체크아웃 되었습니다.");
	}

	/**
	 * 객실의 투숙 상황을  출력하는 메서드
	 */
	private void roomStatus() {
		System.out.println();
		System.out.println("====================================");
		System.out.println(" 객실 번호\t\t투숙객");
		if(roomMap.isEmpty()) {
			System.out.println(" 객실의 체크인 내력이 존재하지 않습니다.");
		}
		Set<Integer> keyset = roomMap.keySet();
		Iterator<Integer> it = keyset.iterator();
		while(it.hasNext()) {
			int roomNum = it.next();
			System.out.println( roomNum + "호실\t\t"+ roomMap.get(roomNum).getCustomer());
		}
		System.out.println("====================================");
		System.out.println();
	}

	/**
	 * 호텔의 객실을 체크인하는 메서드
	 */
	private void checkIn() {
		System.out.println();
		System.out.println("어느방에 체크인 하시겠습니까?");
		int roomNum = 0;
		while(true) {
			System.out.print("객실 번호 입력 => ");
			
			try {
				roomNum = scan.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println();
				System.out.println("객실 번호를 숫자로 입력해주세요..");
				System.out.println();
				scan.nextLine();
			}	
		}
		System.out.println();
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 => ");
		String customer = scan.next();
		Room room = new Room(roomNum, customer);
		if(roomMap.containsKey(roomNum)) {
			System.out.println(roomNum + "호실에는 이미 사람이 있습니다.");
			return;
		}
		roomMap.put(roomNum, room);
		System.out.println("체크인 되었습니다.");
	}



	
	/**
	 * hotelManage클래스의 메인 메서드
	 * @param args
	 */
	public static void main(String[] args) {
		HotelManage hotel = new HotelManage();
		hotel.openHotel();
	}
	
}


/**
 * 호텔의 객실의 정보를 담고 있는 클래스
 * 객실 번호, 투숙객
 * @author PC-25
 *
 */
class Room implements Serializable{
	private int roomNum;		// 객실 번호
	private String customer;	// 투숙객
	
	public Room(int roomNum, String customer) {
		this.roomNum = roomNum;
		this.customer = customer;
	}
	
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}

}