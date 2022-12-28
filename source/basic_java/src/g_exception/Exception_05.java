package g_exception;

public class Exception_05 {
	public static void main(String[] args) {
		try {
			copyFiles();
			install();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			deleteFiles();
		}
	}

	static void copyFiles() {

	}

	static void install() {

	}

	static void deleteFiles() {

	}
}
