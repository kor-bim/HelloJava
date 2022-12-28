package javaCollectionFramework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.JDBCUtil;

public class hotel_JDBC {

	// create table hotel(
	// ho_guest varchar2(100) not null,
	// ho_room varchar2(50) not null);

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Scanner scan = new Scanner(System.in);

	// 프로그램을 시작하는 메서드
	public void hotelStart() {

		while (true) {

			displayMenu(); // 메뉴보여주기

			int menuNum = scan.nextInt(); // 메뉴 번호 입력받기

			switch (menuNum) {
			case 1:
				chek_in(); // 체크인
				break;
			case 2:
				chek_out(); // 체크아웃
				break;
			case 3:
				guestAll(); // 객실상태(손님의 수, 방번호, 투숙객이름)
				break;
			case 4:
				System.out.println("호텔문을 닫았습니다.");
				return;
			default:
				System.out.println("잘못 입력했습니다. 다시입력하세요.");
			} // switch끝나는 부분
		} // while끝나는 부분
	}

	
	// 객실상태 출력
	private void guestAll() {
		System.out.println();
		System.out.println("방번호\t 손님이름");
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM HOTEL";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String room = rs.getString("ho_room");
				String guest = rs.getString("ho_guest");

				System.out.println(room + "\t" + guest);
				System.out.println("===================================================");
			}

		} catch (SQLException e) {
			System.out.println("자료 가져오기 실패");
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	

	

	// 체크아웃
	private void chek_out() {
		System.out.println();
		System.out.println("체크아웃할 방번호를 입력하세요");
		String room = scan.next();

		try {
			conn = JDBCUtil.getConnection();
			String sql = " DELETE FROM HOTEL WHERE ho_room = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, room);

			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println(room + "체크아웃 성공");
			} else {
				System.out.println(room + "체크아웃 실패");
			}
		} catch (SQLException e) {
			System.out.println(room + "체크아웃 실패");
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 체크인
	private void chek_in() {
		boolean chk = false;
		String room;

		do {
			System.out.println("숙박할 방의 번호를 입력하세요.");
			System.out.println("방 번호>> ");
			room = scan.next();

			// 방중복확인
			chk = getRoom(room);

			if (chk == true) {
				System.out.println(room + "은 이미 체크인된 방입니다.");
				System.out.println("다시 입력해주세요");
			}
		} while (chk == true);

		System.out.print(" 손님 이름 >> ");
		String guest = scan.next();

		try {
			conn = JDBCUtil.getConnection(); 
			String sql = "INSERT INTO HOTEL (ho_guest, ho_room) VALUES(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, guest);
			pstmt.setString(2, room);

			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println(room + "체크인 성공");
			} else {
				System.out.println(room + "체크인 실패");
			}
		} catch (SQLException e) {
			System.out.println(room + "체크인 실패");
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 체크인 중복체크
	private boolean getRoom(String room) {
		boolean ch = false;

		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT COUNT(*) AS CNT FROM hotel WHERE ho_room = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, room);

			rs = pstmt.executeQuery();

			int cnt = 0;
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
			if (cnt > 0) {
				ch = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			ch = false;
		} finally {
			disconnect();
		}
		return ch;
	}

	// 메뉴보여주기
	private void displayMenu() {

		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인\t2.체크아웃\t3.객실상태 \t4.업무종료");
		System.out.print("메뉴선택 ==>");

		System.out.println("========================호텔 문을 열었습니다.========================");

	}

	// 자료 반납
	private void disconnect() {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e2) {
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e2) {
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e2) {
			}
	}

	public static void main(String[] args) {
		hotel_JDBC hojdbc = new hotel_JDBC();
		hojdbc.hotelStart();
	}

}
