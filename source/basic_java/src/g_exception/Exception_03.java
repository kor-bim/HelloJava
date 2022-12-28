package g_exception;

public class Exception_03 {
	public static void main(String[] args) {

		Exception e1 = new Exception("상헌아 지각하지마");
		try {
			throw e1;
		} catch (Exception e) {
			System.out.println("예외 발생시키기 성공");
			e.printStackTrace();
			System.out.println(e.getMessage());// 이유만 뽑아올 메세지
		}
		try {
			RuntimeException re = new RuntimeException("이유");
			throw re;
		} catch (RuntimeException re) {
			System.out.println("ff");
		}
		
		/*
		컴파일러가 예외처리를 강제하지 않는 경우
			- RuntimeException과 그 자손들
			- Error
		
		이 두가지를 'unChecked'예외라고 부른다.
		 */
	}
}
