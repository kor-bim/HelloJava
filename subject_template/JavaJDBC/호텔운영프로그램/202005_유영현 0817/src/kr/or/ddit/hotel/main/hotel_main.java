package kr.or.ddit.hotel.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
import kr.or.ddit.hotel.vo.HotelVO;
import kr.or.ddit.util.JDBCUtil3;

public class hotel_main {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/**
	 * 자원을 모두 반납하는 메서드
	 */
	private void disConnect() {
		try {
			if(rs != null) { rs.close(); }
			if(stmt != null) { stmt.close(); }
			if(pstmt != null) { pstmt.close(); }
			if(conn != null) { conn.close(); }
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Scanner sc;
	
	public hotel_main() {
		sc = new Scanner(System.in);
	}
	
	
	/**
	 * 메인 메서드
	 */
	public static void main(String[] args){
		hotel_main ht = new hotel_main();
		ht.hotelMenu();
	}
	
	
	
	/**
	 * 시작화면 메서드
	 */
	private void hotelStart() {	
		System.out.println("*****************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("*****************\n");
		hotelMenu();
	}
	
	
	/**
	 * 메뉴를 선택하는 메서드
	 */
	private void hotelMenu() {
		int hotelinput = 0;
		while(true) {
			System.out.println("************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.print("1.체크인");
			System.out.print("  2.체크아웃");
			System.out.print("  3.체크인정보수정");
			System.out.print("  4.객실상태");
			System.out.print("  5.업무종료");
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
				checkIn();
				break;
				
			case 2: //체크아웃
				checkOut(); 
				break;

			case 3:
				RoomCondition();
				break;

			case 4: 
				viewRooms();
				break;
				
			case 5: 
				System.out.println();
				System.out.println("*****************");
				System.out.println("호텔 문을 닫았습니다.");
				System.out.println("*****************");
				return;

			default :
				System.out.println();
				System.out.println("1 ~ 5번 중 선택해주세요");
				continue;
			}
		}

	}



	/**
	 *  체크인 하는 메서드
	 */
	private void checkIn() {
		
		int room_num = 0;
		boolean roomCheck_res = false;
		while(true) {
			try {
				System.out.println();
				System.out.print("체크인 할 방번호를 입력해주세요. >> ");
				room_num = sc.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println("방번호는 숫자로 입력해주세요.");
			}			
		}
		
		
		roomCheck_res = roomNumCheck(room_num);
		if(roomCheck_res == false) {
			
			HotelVO hv = new HotelVO();
			
			System.out.println();
			System.out.print("이름을 작성해주세요. >> ");
			String guest_name = sc.next();
			
			hv.setRoom_num(room_num);
			hv.setGuest_name(guest_name);
			
			
			int res = 0;
			try {
				conn = JDBCUtil3.getConnection();
				String sql = "insert into hotel_mng(room_num, guest_name) "
						   + "values(?,?)";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, hv.getRoom_num());
				pstmt.setString(2, hv.getGuest_name());
				
				res = pstmt.executeUpdate();
				
				if(res > 0) {
					System.out.println("체크인 완료");
				}else {
					System.out.println("체크인 실패!");
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				disConnect();
			}
		}else {
			System.out.println("사용하실 방번호는 체크인이 되어있습니다.");
		}
	}
	
	
	
	
	
	/**
	 * 방의 유무를 체크하는 메서드
	 * @param room_num
	 * @return
	 */
	private boolean roomNumCheck(int room_num) {
		
		boolean roomCheck = false;
		try {
			conn = JDBCUtil3.getConnection();
			String sql = "select * "
					   + "from hotel_mng "
					   + "where room_num = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, room_num);
			
			
			int res = pstmt.executeUpdate();
			if(res > 0) {
				roomCheck = true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return roomCheck;
	}

	
	
	
	
	

	/**
	 *  체크아웃 하는 메서드
	 */
	private void checkOut() {
		
		int room_num = 0;
		boolean roomCheck_res = false;
		while(true) {
			try {
				System.out.println();
				System.out.print("체크아웃을 하실 방번호를 입력해주세요. >> ");
				room_num = sc.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println("방번호는 숫자만 입력해주세요.");
			}			
		}
		
		roomCheck_res = roomNumCheck(room_num);
		if(roomCheck_res == true) {
			
			
			int res = 0;
			try {
				conn = JDBCUtil3.getConnection();
				String sql = "delete from hotel_mng "
						   + "where room_num = ? ";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, room_num);
				
				res = pstmt.executeUpdate();
				
				if(res > 0) {
					System.out.println("체크아웃 완료");
				}else {
					System.out.println("체크아웃 실패");
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				disConnect();
			}
		}else {
			System.out.println("입력하신 방번호는 체크인 되어있지 않은 방입니다.");
		}
	}


	

	/**
	 * 체크인 정보를 수정하는 메서드
	 */
	private void RoomCondition() {
		
		int room_num = 0;
		boolean roomCheck_res = false;
		while(true) {
			try {
				System.out.println();
				System.out.print("체크인 정보를 수정 하실 방번호를 입력해주세요. >> ");
				room_num = sc.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println("방번호는 숫자로 입력해주세요.");
			}	
		}
		
		roomCheck_res = roomNumCheck(room_num);
		if(roomCheck_res == true) {
			
			HotelVO hv = new HotelVO();
			
			System.out.print("변경할 이름을 작성해주세요. >> ");
			String guest_name = sc.next();
			hv.setGuest_name(guest_name);
			hv.setRoom_num(room_num);
			
			
			int res = 0;
			try {
				conn = JDBCUtil3.getConnection();
				String sql = "update hotel_mng "
						   + "set guest_name = ? "
						   + "where room_num = ? ";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, hv.getGuest_name());
				pstmt.setInt(2, hv.getRoom_num());
				
				res = pstmt.executeUpdate();
				
				if(res > 0) {
					System.out.println("체크인 정보수정 완료");
				}else {
					System.out.println("체크인 정보수정 실패");
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				disConnect();
			}
			
		}else {
			System.out.println("입력하신 방번호는 체크인 되어있지 않은 방입니다.");
		}
	}



	/**
	 * 모든 투숙객의 정보를 출력하는 메서드
	 */
	private void viewRooms() {
		
		try {
			conn = JDBCUtil3.getConnection();
			String sql = "select * "
					   + "from hotel_mng ";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs != null) {
				
				System.out.println("---------------------------------------");
				System.out.println("방번호\t\t이름");
				System.out.println("---------------------------------------");
				while(rs.next()) {
					HotelVO hv = new HotelVO();
					
					hv.setRoom_num(rs.getInt("ROOM_NUM"));
					hv.setGuest_name(rs.getString("GUEST_NAME"));
					
					System.out.println(hv.getRoom_num() + "\t\t" + hv.getGuest_name());
					
				}
				System.out.println("---------------------------------------");
				System.out.println("출력 완료");
			}else {
				System.out.println("현재 사용하는 사람이 없습니다.");
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	}




	
	
}
