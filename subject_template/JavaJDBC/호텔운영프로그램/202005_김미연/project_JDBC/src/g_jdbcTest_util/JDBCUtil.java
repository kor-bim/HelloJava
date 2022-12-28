package g_jdbcTest_util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 반복되는 중복 코드를 줄이기 위해 사용
 */
public class JDBCUtil {
	
	static {
		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver"); // forName() : static 메서드 / 드라이버 로딩에 문제가 생기면 ClassNotFound 예외 발생
			System.out.println("드라이버 로딩 완료!");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!!!");
			e.printStackTrace();
		}
	}
	
	// static 메서드 : 객체를 생성하지 않아도 호출 가능 장점
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","KMY","java");
		}catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
			return null;
		}
	}

}
