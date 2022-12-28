package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	
	// class가 로딩될때 단 한번만 실행하도록 하는 static블럭을 사용한다.
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 완료!!");
	
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!!");
			e.printStackTrace();
		}
	}
	
	
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe", 
					"yyh", 
					"java");
		}catch(SQLException e) {
			System.out.println("DB 접속 실패!!");
			e.printStackTrace();
			return null;
		}
	}
}
