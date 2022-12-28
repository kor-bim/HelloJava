package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *호텔 운영을 관리하는 프로그램 작성.(Map이용)
 - 키값은 방번호 
 
(단, 종료시 파일로 저장하고 프로그램 실행시 파일로부터 데이터를 불러올 수 있도록 처리한다.)

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
public class HotelManagement_StorageFunction {
	
	Scanner sc;
	
	private Map<Integer, HotelCostomer> HotelCostomerMap = new HashMap<Integer, HotelCostomer>();
	
	
	
	
	
	
	/**
	 * 메인 메서드
	 * @throws EOFException 
	 */
	public static void main(String[] args){
		HotelManagement_StorageFunction ht = new HotelManagement_StorageFunction();
		ht.selectMenu();
	}
	
	
	
	/**
	 * 메뉴를 선택하는 메서드
	 */
	private void mainMenu() {
		System.out.println("*******************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
		System.out.println("*******************************************");
		System.out.println();
	}
	
	
	/**
	 * 시작화면 메서드
	 */
	private void selectMenu() {
		
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		System.out.println();
		
		
		int menuInput = 0;
		
		while(true) {
			
			sc = new Scanner(System.in);
			
			mainMenu();
			System.out.print("메뉴선택 => ");
			
			try {
				menuInput = sc.nextInt();				
			}catch(InputMismatchException e) {
				System.out.println("메뉴번호는 숫자로 입력해주세요.");
				continue;
			}
			
			switch(menuInput) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				viewRooms();
				break;
			case 4:
				System.out.println("업무를 종료합니다.");
				save(HotelCostomerMap);
				return;
			default:
				System.out.println("1~4사이의 숫자를 입력해주세요.");
				continue;
			}
		}
	}
	

	
	
	
	/**
	 * 생성자
	 * 시작하자마자 파일의 정보를 불러온다.
	 * 불러온 정보를 map에 등록한다.
	 */
	public HotelManagement_StorageFunction(){
		
		//File file = new File("d:/D_Other/HotelInfo/hotelinfo.txt");
		
		try {
			// 파일을 불러서 읽을수 있도록 하는 FileInputStream객체 선언 및 생성
			//FileInputStream fis = new FileInputStream(file);
			
			// 파일을 불러올때 Object형태로 받아올수 있도록 하는 ObjectInputStream객체를 선언 및 생성
			//ObjectInputStream ois = new ObjectInputStream(fis);
			
			// 또는 해당 객체를 아래와 같은 디자인 패턴을 사용하여 생성한다.
			ObjectInputStream ois = 
					new ObjectInputStream(
						new BufferedInputStream(
							new FileInputStream("d:/D_Other/HotelInfo/hotelinfo.txt")));
			
			
			
			// readObject()메서드로 받아온 정보를 map객체에 저장
			Map<Integer, HotelCostomer> HotelCostMap = new HashMap<>();
			try {
				HotelCostMap = (Map<Integer, HotelCostomer>) ois.readObject();
				ois.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
			
			// 또는 파일의 유무를 판별하여 데이터를 불러온다.
//			Map<Integer, HotelCostomer> HotelCostMap = new HashMap<>();
//			
//			Object obj;
//			try {
//				while((obj = ois.readObject()) != null) {
//					HotelCostMap = (Map<Integer, HotelCostomer>) obj;
//				}
//				ois.close();
//				
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
			
			
			
			
			
			
			// 저장된 정보를 본래의 객체에 저장한다.
			HotelCostomerMap = HotelCostMap;
			
		}catch(FileNotFoundException e) {
			//e.printStackTrace();
		}catch(IOException e) {
			//e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	/**
	 * 프로그램 종료전 호텔이용 기록을 저장하는 메서드
	 * map에 남아있는 정보를 외부파일에 저장한다.
	 */
	private void save(Map<Integer, HotelCostomer> hotelcosmap) {
		
		//File file = new File("d:/D_Other/HotelInfo/hotelinfo.txt");
		
		try {
			//FileOutputStream fos = new FileOutputStream(file);
			//ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			
			// 또는 해당 객체를 아래와 같은 디자인 패턴을 사용하여 생성한다.
			ObjectOutputStream oos = 
					new ObjectOutputStream(
						new BufferedOutputStream(
							new FileOutputStream("d:/D_Other/HotelInfo/hotelinfo.txt")));
			
			
			
			
			oos.writeObject(hotelcosmap);
			
			oos.flush();
			oos.close();
			
			
			// 확인용 명령문
//			// map객체에 저장된 정보를 Set형태의 객체에 옮긴다.
//			Set<Integer> costkey = hotelcosmap.keySet();
//			
//			
//			// 아무 데이터도 넣지 않았다면 그대로 유지
//			if(costkey.size() == 0) {
//				System.out.println("저장된 기록이 존재하지 않습니다.");
//			}else {
//				// Set에 있는 key값들과 일치하는 키값을 가진 map의 정보를 가지고 온다.
//				for(Integer info : costkey) {
//					
//					// 현재 예약 리스트에 있는 정보를 출력한다.(확인용)
//					System.out.println("방번호 : " + HotelCostomerMap.get(info).getRoomNum()
//							+ "호\t이름 : " + HotelCostomerMap.get(info).getName());
//				}
//			}
			
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	/**
	 * 고객이 방을 체크인 하는 메서드
	 * 체크인시 이미 체크인된 방은 체크인을 할 수 없다.
	 */
	private void checkIn(){
		
		int selRoomN = 0;
		while(true) {
			
			sc = new Scanner(System.in);
			
			System.out.println("어느방에 체크인 하시겠습니까?");
			System.out.print("방번호 입력 => ");
			try {
				selRoomN = sc.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println("방 번호는 숫자로 입력해주세요.");
				continue;
			}

		}
		
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 => ");
		String name = sc.next();
		
		if(HotelCostomerMap.get(selRoomN) != null) {
			System.out.println(selRoomN + "호는 이미 예약되어있습니다.");
		}else {
			HotelCostomerMap.put(selRoomN, new HotelCostomer(selRoomN, name));
			System.out.println("호텔 예약이 성공적으로 완료되었습니다.");			
		}
		
	}
	
	
	
	/**
	 * 고객이 방을 체크아웃 하는 메서드
	 */
	private void checkOut(){
		
		int selRoomN = 0;
		while(true) {
			
			System.out.println("어느방을 체크아웃 하시겠습니까?");
			System.out.print("방번호 입력 => ");
			
			sc = new Scanner(System.in);
			try {
				selRoomN = sc.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println("체크아웃할 방 번호는 숫자로 입력해주세요.");
				continue;
			}
		}
		
		if(HotelCostomerMap.get(selRoomN) != null) {
			HotelCostomerMap.remove(selRoomN);
			System.out.println(selRoomN + "호의 체크아웃에 성공했습니다.");
		}else {
			System.out.println(selRoomN + "호에는 체크인한 사람이 없습니다.");
		}
	}
	
	
	
	
	/**
	 * 현재 고객이 체크인한 모든 방을 보여주기
	 */
	private void viewRooms(){
		Set<Integer> roomSet = HotelCostomerMap.keySet();
		
		if(roomSet.size() == 0) {
			System.out.println("예약한 고객이 없습니다.");
		}else {
			for(Integer info : roomSet) {

				System.out.println("방번호 : " + HotelCostomerMap.get(info).getRoomNum()
						+ "호\t이름 : " + HotelCostomerMap.get(info).getName());
			}			
		}
	}

}





/**
 * 투숙객의 정보를 저장하는 VO
 */
class HotelCostomer implements Serializable{ // 직렬화
	private int roomNum;
	private String name;
	
	
	
	
	public HotelCostomer(int selRoomN, String name) {
		super();
		this.roomNum = selRoomN;
		this.name = name;
	}



	
	
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
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
		return "HotelCostomer [name=" + name + ", roomNum=" + roomNum + "]";
	}
}



	















