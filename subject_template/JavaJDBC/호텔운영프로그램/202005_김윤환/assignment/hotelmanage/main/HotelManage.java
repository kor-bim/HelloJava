package assignment.hotelmanage.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import assignment.hotelmanage.service.IServiceHotelManage;
import assignment.hotelmanage.service.ServiceHotelManageImpl;
import assignment.hotelmanage.vo.RoomVO;

public class HotelManage {
	
	private Scanner scan;
	private IServiceHotelManage service;
	
	public HotelManage() {
		scan = new Scanner(System.in);
		service = new ServiceHotelManageImpl();
	}
	
	public void openHotel() {
		System.out.println("**********************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**********************");
		hotelMenu();
	}

	private void hotelMenu() {
		while(true){
			System.out.println("**************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println(" 1.체크인  2.체크아웃  3.객실 상태 조회  4.종료");
			System.out.println("**************************************");
			selectMenu();
		}
	}

	private void selectMenu() {
		System.out.print("메뉴 선택 =>");
		int select = 0;
		try {
			select = scan.nextInt();
			
		}catch(InputMismatchException e){
			System.out.println();
			System.out.println("메뉴를 숫자로 입력해주세요");
			System.out.println();
			scan.nextLine();
			return;
		}finally {
			switch(select) {
			case 1:				//체크인
				checkIn();
				break;
			case 2:				//체크아웃
				checkOut();
				break;
			case 3:				//객실 상태 조회
				roomStatus();
				break;
			case 4:				//종료
				closeHotel();
				break;
			default:
				System.out.println("메뉴를 다시 선택해주세요..");
			}	
		}
	}

	/**
	 * 호텔의 업무를 종료하는 메서드
	 */
	private void closeHotel() {
		System.out.println();
		System.out.println("**********************");
		System.out.println("호텔 문을 닫았습니다.");
		System.out.println("**********************");
		System.exit(0);
	}

	/**
	 * 호텔의 객실 상태를 조회하는 메서드
	 */
	private void roomStatus() {
		System.out.println();
		System.out.println("====================================================");
		System.out.println(" 객실번호\t\t투숙객");
		List<RoomVO> roomList = service.getroomStatus();
		if(roomList.isEmpty()) {
			System.out.println();
			System.out.println(" 체크인 내력이 존재하지 않습니다.");
			System.out.println("====================================================");
			System.out.println();
			return;
		}
		for(RoomVO room : roomList) {
			System.out.println(room.getRoom_num() +"\t\t" + room.getGuest_name());
		}
		System.out.println("====================================================");
		System.out.println();
		
	}

	/**
	 * 호텔의 객실을 체크아웃하는 메서드
	 */
	private void checkOut() {
		int roomNum = 0;
		System.out.println();
		System.out.println("어느 방을 체크아웃 하시겠습니까?");
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
		
		boolean chk = getRoom(roomNum);
		
		if(!chk) {
			System.out.println();
			System.out.println("체크인 내력이 없습니다.");
			System.out.println();
			return;
		}
		
		int cnt = service.checkOut(roomNum);
		
		if(cnt>0) {
			System.out.println();
			System.out.println("체크아웃 성공!");
			System.out.println();
		}else {
			System.out.println();
			System.out.println("체크아웃 실패!!!");
			System.out.println();
		}
	}

	/**
	 * 호텔의 객실을 체크인하는 메서드
	 */
	private void checkIn() {
		System.out.println();
		System.out.println("어느 방에 체크인 하시겠습니까?");
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
		String guestName = scan.next();
		
		boolean chk = getRoom(roomNum);
		
		if(chk) {
			System.out.println();
			System.out.println(roomNum + "호실은 이미 체크인되었습니다..");
			System.out.println();
			return;
		}
		
		int cnt = service.checkIn(new RoomVO(roomNum, guestName));
		
		if(cnt > 0 ) {
			System.out.println();
			System.out.println("체크인 성공!");
			System.out.println();
		}else {
			System.out.println();
			System.out.println("체크인 실패!!!");
			System.out.println();
		}
	}

	/**
	 * 호텔의 객실의 체크인 여부를 확인하는 메서드
	 * @param roomNum 호텔의 객실 번호
	 * @return	객실의 체크인 여부 true : 체크인 됨, false : 체크인 안됨.
	 */
	private boolean getRoom(int roomNum) {
		return service.getRoom(roomNum); //이미 체크인된 방인지 확인;
	}
	
	
	public static void main(String[] args) {
		HotelManage hotel = new HotelManage();
		hotel.openHotel();
	}
	
}
