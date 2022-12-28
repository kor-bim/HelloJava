package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hotel {
	Scanner sc = new Scanner(System.in);
	

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public static void main(String[] args) {
		Hotel ht = new Hotel();
		ht.hotelStart();
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
		System.out.println(" 방번호\t이름");
		System.out.println("======================");
		try {
			conn = JDBCUtil2.getConnection();
			String sql = "select * from hotel_mng ";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int roomNum = rs.getInt("room_num");
				String guestName = rs.getString("guest_name");
				
				System.out.println(roomNum+"\t"+guestName);
			}
			System.out.println("======================");
			System.out.println("출력 작업 끝.");
			
		} catch (SQLException e) {
			System.out.println("객실자료 가져오기 실패!");
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}
		
		

	/**
	 * 체크아웃을 하기위한 메서드
	 */
	private void checkOut() {
		int roomNum;
		while(true) {
			try {
				System.out.println("어느방을 체크아웃 하시겠습니까?");
				System.out.print("방번호 입력 : ");
				roomNum = sc.nextInt();
				
				conn = JDBCUtil.getConnection();
				
				String sql = "delete from hotel_mng "
							+ " where room_num = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, roomNum);
				
				int cnt = pstmt.executeUpdate();
				
				if(cnt>0) {
					System.out.println(roomNum + "번 방 체크아웃 완료.");
				} else {
					System.out.println(roomNum + "번 방 체크아웃 실패");
				}
				
				break;
			}catch (InputMismatchException e) {
				System.out.println("잘못된 형식입니다. 숫자로만 입력해주세요.");
				sc.nextLine();
				continue;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
		
	}

	/**
	 * 체크인을 하기위한 메서드
	 */
	private void checkIn() {
		boolean chk = false;
		int roomNum = 0;
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 : ");
		do {
			try {
				roomNum = sc.nextInt();
				
				chk = checkRoom(roomNum);
				if(chk) {
					System.out.println(roomNum +"번 방은 이미 사용중입니다.");
					System.out.println("다시 입력해 주세요."); 
				}
				
			}catch (InputMismatchException e) {
				System.out.println("잘못된 형식입니다. 숫자로만 입력해주세요.");
			}
		} while(chk == true);

		String name = null;
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 : ");
		try {
			name = sc.next();
		}catch (Exception e) {
			System.out.println("다시 입력해주세요.");
			sc.nextLine();
		}
		
		
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = "insert into hotel_mng (room_num, guest_name) "
					+ " values (?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomNum);
			pstmt.setString(2, name);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println(name+"님 체크인 되었습니다.");
			} else {
				System.out.println("체크인 실패.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}



	}
	
	/**
	 * roomNum를 이용하여 객실이 사용중인지 알려주는 메서드
	 * @param roomNum
	 * @return true : 사용중, false : 비어있음.
	 */
	private boolean checkRoom(int roomNum) {
		boolean chk = false;
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "select room_num from hotel_mng "
					   + " where room_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				chk = true;
			} else {
				chk = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return chk;
	}
	
	/**
	 * 자원 반납용 메서드
	 */
	private void disconnect() {
		
		if(rs != null) try {rs.close();} catch (SQLException e) {}
		if(stmt != null) try {stmt.close();} catch (SQLException e) {}
		if(pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		if(conn != null) try {conn.close();} catch (SQLException e) {}
		
		
	}
	
	
	
	
}
