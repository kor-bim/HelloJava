package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * db.bundleerties파일의 내용으로 DB정보를 설정하는 방법<br>
 * 방법 2. ResourceBundle 객체 이용하기
 */
public class JDBCUtil3 {
	static ResourceBundle bundle; // bundleerties 객체 변수 선언
	static {
		try {
			bundle = ResourceBundle.getBundle("db");
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로딩 실패!");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(bundle.getString("url"), bundle.getString("user"),
					bundle.getString("pass"));
		} catch (SQLException e) {
			System.out.println("DB 연결실패!!");
			return null;
		}
	}

	public static void disConnect(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
			}
	}
}
