package project;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewClass {
	private IService service = new IServiceImpl();
	private String logIn_id;
	private String createMember;
	

	public void startMethod() {
		// TODO Auto-generated method stub
		System.out.println("어서오세요");
		System.out.println("고르세요");
		System.out.println("1. 회원가입"); // c
		System.out.println("2. 로그인");
		System.out.println("3. 조회");
		System.out.println("4. 종료");

		// 고르기
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt(); // try-catch
		// 메서드 이동
		switch (input) {
		case 1:
			// 회원가입
			createMember();
			break;

		case 2:
			// 로그인
			logIn();
			break;
		case 3:
			select();
			
			break;

		case 4:
			// 종료
			break;
		default:
			System.out.println("잘 좀 입력해라");
			break;
		}

	}

	

	private void select() {
		ArrayList<MemberVO> list = service.select();
		System.out.println("아이디 비밀번호 이름 직업");
		if(list!=null){
			for(MemberVO member : list){
				System.out.println(member.getMem_id()+" "+member.getMem_pass()+" "+member.getMem_name()+" "+member.getMem_job()+" ");
			}
		}else{
			System.out.println("list null!");

		}
		
	}



	private void logIn() {
		// id, pw
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요");
		String mem_id = sc.next();
		System.out.println("비밀번호를 입력해주세요");
		String mem_pass = sc.next();

		Map<String, String> params = new HashMap<>();
		params.put("mem_id", mem_id);
		params.put("mem_pass", mem_pass);

		logIn_id = service.logIn(params);

		if (logIn_id == null) {
			System.out.println("그런사람없다");
		} else {
			System.out.println(logIn_id + "회원님 어서오세요");
			// showMemList();
		}

	}

	private void createMember() {
		//
		Map<String, String> params = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 생성해주세요[영문자,숫자 4글자]");
		String mem_id = sc.next();
		params.put("mem_id", mem_id);

		// 비번입력
		System.out.println("비밀번호를 생성해주세요[영문자,숫자 8글자]");
		String mem_pass = sc.next();
		params.put("mem_pass", mem_pass);

		// 이름입력
		System.out.println("이름을 입력해주세요");
		String mem_name = sc.next();
		params.put("mem_name", mem_name);

		// 직업입력
		System.out.println("직업을 입력해주세요");
		String mem_job = sc.next();
		params.put("mem_job", mem_job);

		createMember = service.createMember(params);
	}

}
