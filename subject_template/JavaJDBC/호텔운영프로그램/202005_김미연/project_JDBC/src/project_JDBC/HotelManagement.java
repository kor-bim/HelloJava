package project_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import g_jdbcTest_util.JDBCUtil;

/**
 * 호텔 운영을 관리하는 프로그램 작성.(DB 이용)
 * 키값은 방번호 
 * @author 김미연
 * @since 2020.08.13
 */
public class HotelManagement {
	private Scanner sc = new Scanner(System.in); // 사용자로 부터 콘솔 입력 받기 위한 스캐너
	private RegEx rx = new RegEx(); // 정규화를 체크
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public static void main(String[] args) {
		new HotelManagement().startMenu(); // 시작메뉴 실행
	}
	
	/**
	 * 시작메뉴를 보여주기 위한 메서드
	 */
	private void startMenu() {
		int input = 0; // 사용자의 메뉴 입력 값 저장
		
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		
		while(true) { // '업무종료' 선택전까지 무한반복
			System.out.println();
			System.out.println("*******************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃  3.객실상태  4.업무종료");
			System.out.println("*******************************************");
			System.out.print("메뉴 선택 => ");
			try {
				input = sc.nextInt();
			}catch(InputMismatchException e) { // int값이 아닌 다른 자료형을 입력했을 때
				System.out.println("잘못입력 하였습니다. 다시 입력해주세요.");
				sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화, 무한루프 발생 방지
				continue; // 예외발생시 다시 입력 받는다.
			}finally {
				sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
			}
			
			switch(input) { // 입력값에 따라서 해당 메서드 호출
			case 1 : // 체크인을 선택했을 때
				checkIn(); // 체크인 메서드 호출
				break;
			case 2 : // 체크아웃을 선택했을 때
				checkOut(); // 체크아웃 메서드 호출
				break;
			case 3 : // 객실상태를 선택했을 때
				roomCondition(); // 객실상태 메서드 호출
				break;
			case 4 : // 업무종료를 선택했을 때
				end(); // 업무종료 메서드 호출
				break;
			default : // 위의 메뉴 입력 값외의 값을 입력했을 때
				System.out.println("잘못입력 하였습니다. 다시 입력해주세요.");
				break;
			}
		}
	}

	/**
	 * 객실에 체크인 하기 위한 메서드
	 */
	private void checkIn() {
		String roomNum = null; // 체크인할 객실 방번호
		String guests = null; // 체크인할 고객명
		
		while(true) {
			try {
				System.out.println("어느 방에 체크인 하시겠습니까? 형식 : 첫자리(1~9사이 숫자), 두번째자리(0~9), 세번째자리(0~9)");
				System.out.print("방번호 입력 => ");
				roomNum = sc.next();
				
				// 방번호 정규화 체크
				if(!rx.roomNumCheck(roomNum)) {
					System.out.println("형식에 맞지 않습니다. 다시 입력해주세요.");
					sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
					continue; // 잘못입력시 다시 입력받는다.
				}
				
				// 이미 체크인 된 방인지 확인
				if(checkInRoom(roomNum)) { // 해당 방번호가 이미 체크인 되어 있다.
					System.out.println(roomNum + "호는 이미 체크인된 방입니다.");
					System.out.println("다른 방을 입력해주세요.");
					sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
					continue;
				}
				
			}catch (NullPointerException e) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화, 무한루프 발생 방지
				continue; // 예외발생시 다시 입력 받는다.
			}finally {
				sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
			}
			break;
		}
		
		while(true) {
			try {
				System.out.println("누구를 체크인 하시겠습니까? 형식 : 한글이름 2자리 이상");
				System.out.print("이름 입력 => ");
				guests = sc.next();
				// 이름의 정규화 체크
				if(!rx.guestsCheck(guests)) {
					System.out.println("형식에 맞지 않습니다. 다시 입력해주세요.");
					sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
					continue; // 잘못입력시 다시 입력받는다.
				}
			}catch (NullPointerException e) { 
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화, 무한루프 발생 방지
				continue; // 예외발생시 다시 입력 받는다.
			}finally {
				sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
			}
			break;
		}
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO HOTEL_MNG (ROOM_NUM, GUEST_NAME) "
					   + "VALUES (?,?) ";
			
			// 실제값으로 ?를 채워주었다.
			pstmt = conn.prepareStatement(sql);
			int rn = Integer.parseInt(roomNum);
			pstmt.setInt(1, rn);
			pstmt.setString(2, guests);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("체크인 되었습니다.");
			}else {
				System.out.println("체크인 되지 않았습니다.");
			}
			
		}catch (SQLException e) {
			System.out.println("체크인 되지 않았습니다.");
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}

	/**
	 * 객실에 체크아웃 하기 위한 메서드
	 */
	private void checkOut() {
		String roomNum = null; // 체크아웃할 객실 방번호
		
		while(true) {
			try {
				System.out.println("어느 방을 체크아웃 하시겠습니까? 형식 : 첫자리(1~9사이 숫자), 두번째자리(0~9), 세번째자리(0~9)");
				System.out.print("방번호 입력 => ");
				roomNum = sc.next();
				
				// 방번호 정규화 체크
				if(!rx.roomNumCheck(roomNum)) {
					System.out.println("형식에 맞지 않습니다. 다시 입력해주세요.");
					sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
					continue; // 잘못입력시 다시 입력받는다.
				}
				
				// 해당방이 체크인된 방인지 확인
				if(!checkInRoom(roomNum)) { // 해당 방번호는 체크인 된 방이 아니다.
					System.out.println(roomNum + "호는 체크인 된 방이 아닙니다.");
					System.out.println("다른 방을 입력해주세요.");
					sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
					continue;
				}
				
			}catch(NullPointerException e){
				System.out.println("잘못입력하였습니다. 다시 입력해주세요.");
				sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
				continue;
			}finally {
				sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
			}
			break;
		}
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "DELETE FROM HOTEL_MNG WHERE ROOM_NUM = ? ";
			
			pstmt = conn.prepareStatement(sql);
			int rn = Integer.parseInt(roomNum);
			pstmt.setInt(1, rn);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(roomNum + "방이 체크아웃 되었습니다.");
			}else {
				System.out.println(roomNum + "방이 체크아웃 되지 않았습니다.");
			}
			
		}catch (SQLException e) {
			System.out.println(roomNum + "방이 체크아웃 되지 않았습니다.");
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}

	/**
	 * 객실상태를 보여주기 위한 메서드
	 */
	private void roomCondition() {
		
		try {
			conn = JDBCUtil.getConnection();
			
			stmt = conn.createStatement();
			 
			String sql = "SELECT * FROM HOTEL_MNG ";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String roomNum = rs.getInt(1)+"";
				String guests = rs.getString(2);
				
				System.out.println("방번호 : " + roomNum 
                                      + ", 투숙객 : " + guests);
				
			}
			System.out.println("----------------------------------------");
			
		}catch (SQLException e) {
			System.out.println("객실 상태를 확인 할 수 없습니다. ");
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}

	/**
	 * 호텔관리 운영 프로그램을 종료하기 위한 메서드
	 */
	private void end() {
		// 시스템 종료전 파일에 저장
		
		System.out.println();
		System.out.println("**************************");
		System.out.println("호텔 문을 닫았습니다.");
		System.out.println("**************************");
		System.exit(0); // 시스템 종료
	}
	
	/**
	 * 체크인 된 방인지 확인하는 메서드
	 * @param roomNum
	 * @return 체크인 된 방 : true, 아니면 false
	 */
	private boolean checkInRoom(String roomNum) {
		boolean chk = false;
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "SELECT * "
					     + "FROM HOTEL_MNG "
					    + "WHERE ROOM_NUM = ? "; 
			
			pstmt = conn.prepareStatement(sql); 
			
			int rn = Integer.parseInt(roomNum);
			pstmt.setInt(1, rn); 
			rs = pstmt.executeQuery();
			
			int cnt = 0;
			if(rs.next()) { 
				cnt = rs.getInt(1); 
			}
			
			if(cnt > 0) {
				chk = true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			chk = false;
		}finally {
			disconnect();
		}
		return chk;
		
	}
	
	/**
	 * 자원 반납 메서드
	 */
	private void disconnect() {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
	

/**
 * 호텔방 VO
 */
class HotelRoomVO {
	private String roomNum; // 방번호
	private String guests; // 투숙객
	
	public HotelRoomVO(String roomNum, String guests) {
		this.roomNum = roomNum;
		this.guests = guests;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getGuests() {
		return guests;
	}

	public void setGuests(String guests) {
		this.guests = guests;
	}
}

/**
 * 방번호와 투숙객의 정규화를 위한 클래스
 */
class RegEx{
	
	/**
	 * 방번호 정규화를 체크하는 메서드
	 * @param roomNum
	 * @return 정규화에 부합여부
	 */
	public boolean roomNumCheck(String roomNum) {
		// 앞자리 숫자는 0이 아닌 숫자이고 다음 두자리는 0~9사이인 3자리 숫자
		String roomNumregEx = "[1-9]{1}\\d{2}";
		return Pattern.matches(roomNumregEx, roomNum);
	}
	
	/**
	 * 투숙객명 정규화를 체크하는 메서드
	 * @param roomNum
	 * @return 정규화에 부합여부
	 */
	public boolean guestsCheck(String guests) {
		// 한글만 입력가능하고 최소 2자리 이상
		String guestsregEx = "[가-힗]{2,}";
		return Pattern.matches(guestsregEx, guests);
	}
}
