package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC를 이용한 데이터베이스 처리 순서<br>
 * <br>
 * 순서 : JDBC드라이버 로딩 =>해당 DB접속 =>질의(SQL명령을 수행한다) =>질의 결과를 받아서 처리 =>종료(자원반납)<br>
 * <br>
 * 1.JDBC 드라이버 로딩(오라클 기준)<br>
 * JDBC 드라이버는 DB를 만든 회사에서 제공한다.<br>
 * Class.forName("oracle.jdbc.driver.OracleDriver");<br>
 * <br>
 * 2. 접속하기<br>
 * = 접속이 성공하면 Connection 객체가 생성된다.<br>
 * DriverManager.getConnection()메서드를 이용한다.<br>
 * <br>
 * 3. 질의<br>
 * Statement객체 또는 PreparedStatement 객체를 이용하여 SQL문장을 실행한다.<br>
 * <br>
 * 4. 결과<br>
 * 1) SQL문이 select일 경우 ResultSet 객체가 생성된다. ResultSet 객체에는 select한 결과가 저장된다.<br>
 * 2) SQL문이 insert, update, delete일 경우 정수값을 반환한다.<br>
 */
public class T01_JdbcTest {

	public static void main(String[] args) {
		// DB작업에 필요한 객체 변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; // 쿼리문이 select절 일경우에 사용

		try {
			// 1. 드라이버 로딩(옵션)
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. DB접속 (Connection 객체 생성)
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String user = "hanbin";
			String password = "java";
			conn = DriverManager.getConnection(url, user, password);

			// 3. Statement 객체 생성 (Connection 객체를 이용한다)
			stmt = conn.createStatement();

			// 4. SQL문을 Statement 객체를 이용하여 실행하고 실행결과를 ResultSet에 저장
			String sql = "SELECT * FROM LPROD";
			rs = stmt.executeQuery(sql);
			/**
			 * SQL문이 select (excuteQuery()메서드 호출)<br>
			 * insert, update, delete (excuteUpdate() 메서드 호출)<br>
			 */

			// 5. ResultSet 객체에 저장되어 있는 자료를 반복문과 next()메서드를 이용하여 차례로 읽어와 처리한다.
			System.out.println("실행한 쿼리문 : " + sql);
			System.out.println("========== 쿼리문 실행 결과 ==========");

			/**
			 * rs.next() => ResultSet 객체의 데이터를 가리키는 포인터를 다음 레코드로 이동시키고 <br>
			 * 그 곳에 자료가 있으면 true, 없으면 false를 반환한다.<br>
			 */
			while (rs.next()) {
				/**
				 * 컬럼의 자료를 가져오는 방법<br>
				 * 방법 1) rs.get자료형 이름("컬럼명")<br>
				 * 방법 2) rs.get자료형이름("컬럼번호"), 번호 1부터 시작<br>
				 */
				System.out.println("lprod_id : " + rs.getInt("lprod_id"));
				System.out.println("lprod_gu : " + rs.getInt("lprod_gu"));
				System.out.println("lprod_nm : " + rs.getInt("lprod_nm"));
				System.out.println("===================================");
			}

		} catch (SQLException e) {

		} catch (ClassNotFoundException e) {

		} finally {
			// 6. 종료 (사용했던 자원을 모두 반납한다)
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
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
	}
}