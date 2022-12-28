package g_exception;

import java.sql.SQLException;

public class Exception_04 {
	public static void main(String[] args) {
		Controller.idCheck();
	}

}

class Controller {
	static void idCheck() {
		Service.idCheck();
	}
}

class Service {
	static void idCheck() {
		try {
			Dao.idChek();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Dao {
	static void idChek() throws SQLException {
		SQLException se = new SQLException("ORA-00001 : (unique constraint violated)");
		throw se;
	}
}
