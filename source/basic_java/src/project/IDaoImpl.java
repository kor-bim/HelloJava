package project;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

public class IDaoImpl implements IDao {

	@Override
	public String logIn(Map<String, String> params) {//로그인

		String mem_id = params.get("mem_id");
		String mem_pass = params.get("mem_pass");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String logIn_ID = null;

		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.접속
			String url = "jdbc:oracle:thin:@localhost:1521/XE";
			String id = "YHB";
			String pw = "java";
			conn = DriverManager.getConnection(url, id, pw);

			// 3.질의
			stmt = conn.createStatement();
			String sql = "SELECT MEM_ID " + "FROM MEMBER " + "WHERE MEM_ID = '"
					+ mem_id + "' AND MEM_PASS = '" + mem_pass + "'";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				logIn_ID = rs.getString("MEM_ID");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("접속 실패");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("반환 실패");
			}
		}

		return logIn_ID;
	}

	@Override
	public String createMember(Map<String, String> params) {//회원가입
		String input_ID = null;
		String mem_id = params.get("mem_id");
		String mem_pass = params.get("mem_pass");
		String mem_name = params.get("mem_name");
		String mem_job = params.get("mem_job");

		Connection conn = null;
		Statement stmt = null;
		

		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.접속
			String url = "jdbc:oracle:thin:@localhost:1521/XE";//ㄴ
			String id = "YHB";
			String pw = "java";
			conn = DriverManager.getConnection(url, id, pw);

			// 3.질의
			stmt = conn.createStatement();
			String sql = "INSERT INTO MEMBER2 (MEM_ID,MEM_PASS,MEM_NAME,MEM_JOB) VALUES ('"+mem_id+"','"+mem_pass+"','"+mem_name+"','"+mem_job+"')";
		    //
			stmt.executeUpdate(sql);
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("접속 실패");
		} finally {
			try {

				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("반환 실패");
			}
		}

		return null; //
	}

	public ArrayList<MemberVO> select(){//조회
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.접속
			String url = "jdbc:oracle:thin:@localhost:1521/XE";
			String id = "YHB";
			String pw = "java";
			conn = DriverManager.getConnection(url, id, pw);

			// 3.질의
			stmt = conn.createStatement();
			String sql = "SELECT * FROM MEMBER2"; //테이블 조회
		    
			stmt.executeQuery(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MemberVO member = new MemberVO();
				member.setMem_id(rs.getString("MEM_ID")); //아이디
				member.setMem_pass(rs.getString("MEM_PASS")); //패스워드
				member.setMem_name(rs.getString("MEM_NAME")); //이름
				member.setMem_job(rs.getString("MEM_JOB")); //직업
				list.add(member); // 리스트에 추가
			}
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("접속 실패");
		} finally {
			try {

				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("반환 실패");
			}
		}
		return list;
	}

}



