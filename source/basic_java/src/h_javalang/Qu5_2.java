package h_javalang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Qu5_2 {
	public static void main(String[] args) {
		String regEx1 = "[a-z]{2,3}"; // 문자열이 영어소문자 2개 또는 3개로 구성
		System.out.println(Pattern.matches(regEx1, "ssss"));

		// 1. 텍스터가 영문자가 3회 반복되고 이후에 숫자가 하나이상으로 구성
		Pattern p1 = Pattern.compile("[A-za-z]{3}\\d+");
		Matcher m = p1.matcher("dfD666");
		System.out.println(m.matches());

		String str1 = "[A-za-z]{3}\\d+";
		System.out.println(Pattern.matches(str1, "dfD666"));

		// 2. 텍스트가 핸드폰 번호 형태인 '숫자3개-숫자4개-숫자4개'로 구성
		Pattern p2 = Pattern.compile("[0-9]{3}-[0-9]{4}-[0-9]{4}");
		Matcher m2 = p2.matcher("010-8521-5518");
		System.out.println(m2.matches());

		// 3. 텍스트가 핸드폰 번호로 구성
		// 01다음 0,1,7,8,9 - 0을 제외한 숫자, 숫자3개 - 숫자4개

		Pattern p3 = Pattern.compile("01[0|1|7|8|9]-[1-9]\\d{3}-\\d{4}");
		Matcher m3 = p3.matcher("010-8521-5518");
		System.out.println(m3.matches());

		// 4. 텍스트가 주민등록번호로 구성
		// 년도 월일 - 1~4 숫자6개

		Pattern p4 = Pattern
				.compile("\\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])-[1-4]\\d{6}");
		Matcher m4 = p4.matcher("930312-1860315");
		System.out.println(m4.matches());

		// 5. 텍스트가 이메일로 구성
		// 시작은 영문자 이어야하고 특수기호는 -, _, \, . 4가지가 포함될 수 있다
		// @ 이후 영문자가 1개~7개가 포함될 수 있다
		// .이후 영문자가 2~3개 포함되어야 한다.
		// .KR이 없을 수도 하나 존재 할 수도 있다
		Pattern p5 = Pattern
				.compile("[A-Za-z0-9|(-)|_|(|)|(.)|]*@[a-z]{1,7}(.)[a-z]{2,3}");
		Matcher m5 = p5.matcher("gksqls1234@naver.com");
		System.out.println(m5.matches());
	}
}
