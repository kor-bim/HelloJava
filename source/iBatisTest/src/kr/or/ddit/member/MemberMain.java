package kr.or.ddit.member;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.service.IService;
import kr.or.ddit.service.ServiceImpl;

/*
	회원정보를 관리하는 프로그램을 작성하는데 
	아래의 메뉴를 모두 구현하시오. (CRUD기능 구현하기)
	(DB의 MYMEMBER테이블을 이용하여 작업한다.)
	
	* 자료 삭제는 회원ID를 입력 받아서 삭제한다.
	
	예시메뉴)
	----------------------
		== 작업 선택 ==
		1. 자료 입력			---> insert
		2. 자료 삭제			---> delete
		3. 자료 수정			---> update
		4. 전체 자료 출력	---> select
		5. 작업 끝.
	----------------------
	 
	   
// 회원관리 프로그램 테이블 생성 스크립트 
create table mymember(
    mem_id varchar2(8) not null,  -- 회원ID
    mem_name varchar2(100) not null, -- 이름
    mem_tel varchar2(50) not null, -- 전화번호
    mem_addr varchar2(128)    -- 주소
);

*/
public class MemberMain {

	private IService service;
	private Scanner scan;

	public MemberMain() {
		scan = new Scanner(System.in);
		service = ServiceImpl.getInstance();
	}

	/**
	 * 회원 관련 메뉴를 출력하는 메서드
	 */
	public void displayMemMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 자료 검색");
		System.out.println("  6. 이전으로.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	/**
	 * 프로그램 회원 시작메서드
	 */
	public void start() {
		int choice;
		do {
			displayMemMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 자료 입력
				insertMember();
				break;
			case 2: // 자료 삭제
				deleteMember();
				break;
			case 3: // 자료 수정
				updateMember();
				break;
			case 4: // 전체 자료 출력
				displayMemberAll();
				break;
			case 5: // 전체 자료 출력
				getSearchMember();
				break;
			case 6: // 작업 끝
				System.out.println();
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 6);
	}

	/**
	 * 회원 삭제 메서드
	 */
	private void deleteMember() {

		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요");
		System.out.print("회원 ID >>");
		String memId = scan.next();

		int cnt = service.deletMember(memId);
		if (cnt > 0) {
			System.out.println(memId + "회원의 정보를 삭제했습니다.");
		} else {
			System.out.println(memId + "회원의 삭제작업 실패!!");
		}

	}

	/**
	 * 회원 수정 메서드
	 */
	private void updateMember() {
		MemberVO mv = new MemberVO();
		boolean chk = false;// 기존회원 존재여부 체크
		String memId = "";

		do {
			System.out.println();
			System.out.println("수정할 회원 정보를 입력하세요");
			System.out.print("회원 ID >> ");
			memId = scan.next();
			chk = getMember(memId);

			if (!chk) {
				System.out.println("회원 ID가 " + memId + "인 회원은 없습니다.");
				System.out.println("다시 입력 해주세요.");
			}
		} while (chk == false);

		System.out.print("회원이름 >> ");
		String memName = scan.next();
		System.out.print("회원 전화번호 >> ");
		String memTel = scan.next();
		scan.nextLine();// 입력버퍼 바꾸기
		System.out.print("회원 주소 >> ");
		String memAddr = scan.nextLine();

		mv.setMemId(memId);
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		mv.setMemAddr(memAddr);
		int cnt = service.updateMember(mv);
		if (cnt > 0) {
			System.out.println(memId + "회원의 정보를 수정했습니다.");
		} else {
			System.out.println(memId + "회원의 수정작업 실패!!");
		}
	}

	/**
	 * 전체 회원을 출력하는 메서드
	 */
	private void displayMemberAll() {
		System.out.println();
		System.out.println("──────────────────────────────────────────────────────────────────");
		System.out.println("ID\t 이름\t   전화번호\t\t\t           주\t소");
		System.out.println("──────────────────────────────────────────────────────────────────");

		List<MemberVO> memList = service.displayMemberAll();
		for (MemberVO mv : memList) {
			System.out.println(
					mv.getMemId() + "\t" + mv.getMemName() + "\t" + mv.getMemTel() + "\t\t" + mv.getMemAddr());

		}
		System.out.println("──────────────────────────────────────────────────────────────────");
		System.out.println("출력작업 끝!!");
	}

	/**
	 * 회원을 추가하는 메서드
	 */
	private void insertMember() {
		MemberVO mv = new MemberVO();
		boolean chk = false;// 기존회원 존재여부 체크
		String memId = "";
		do {
			System.out.println();
			System.out.println("추가할 회원 정보를 입력하세요");
			System.out.print("회원 ID >>");
			memId = scan.next();
			chk = getMember(memId);

			if (chk) {
				System.out.println("회원 ID가 " + memId + "인 회원은 이미 존재합니다.");
				System.out.println("다시 입력 해주세요.");
			}
		} while (chk == true);

		System.out.print("회원이름 >> ");
		String memName = scan.next();
		System.out.print("회원 전화번호 >> ");
		String memTel = scan.next();
		scan.nextLine();// 입력버퍼 바꾸기
		System.out.print("회원 주소 >> ");
		String memAddr = scan.nextLine();

		mv.setMemId(memId);
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		mv.setMemAddr(memAddr);
		int cnt = service.insertMember(mv);
		if (cnt > 0) {
			System.out.println(memId + " 회원 추가 성공!");
		} else {
			System.out.println(memId + " 회원 추가 실패!");
		}
	}

	/**
	 * 회원 정보를 검색하는 메서드
	 */
	private void getSearchMember() {
		/**
		 * 검색할 회원ID, 회원이름, 전화번호, 주소를 입력하면 검색한 정보만 사용하여 검색하는 기능을 구현하시오.<br>
		 * 주소는 입력한 값이 포함만 되어도 검색되도록한다.<br>
		 * 입력을 하지 않을 자료는 엔터키로 다음 입력으로 넘긴다.<br>
		 */
		MemberVO mv = new MemberVO();
		scan.nextLine(); // 입력버퍼 지우기
		System.out.println();
		System.out.println("검색할 정보를 입력하세요");
		System.out.print("회원 아이디 >> ");
		String memId = scan.nextLine().trim();
		System.out.print("회원 이름 >> ");
		String memName = scan.nextLine().trim();
		System.out.print("회원 전화번호 >> ");
		String memTel = scan.nextLine().trim();
		System.out.print("회원 주소 >> ");
		String memAddr = scan.nextLine().trim();

		mv.setMemId(memId);
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		mv.setMemAddr(memAddr);

		// 입력한 정보로 검색한 내용을 출력하기

		System.out.println();
		System.out.println("──────────────────────────────────────────────────────────────────");
		System.out.println("ID\t 이름\t   전화번호\t\t\t           주\t소");
		System.out.println("──────────────────────────────────────────────────────────────────");

		List<MemberVO> memList = service.getSearchMember(mv);
		for (MemberVO memVO : memList) {
			System.out.println(memVO.getMemId() + "\t" + memVO.getMemName() + "\t" + memVO.getMemTel() + "\t\t"
					+ memVO.getMemAddr());

		}
		System.out.println("──────────────────────────────────────────────────────────────────");
		System.out.println("출력작업 끝!!");
	}

	/**
	 * 회원 ID를 이용하여 회원이 있는지 알려주는 메서드
	 * 
	 * @param memId
	 * @return chk
	 */
	private boolean getMember(String memId) {

		return service.getMember(memId);
	}

	public static void main(String[] args) {
		MemberMain memObj = new MemberMain();
		memObj.start();
	}

}
