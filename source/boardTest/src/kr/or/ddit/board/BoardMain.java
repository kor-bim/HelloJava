package kr.or.ddit.board;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.service.IService;
import kr.or.ddit.service.ServiceImpl;

public class BoardMain {

	private IService service;
	private Scanner scan;

	public BoardMain() {
		scan = new Scanner(System.in);
		service = ServiceImpl.getInstance();
	}

	/**
	 * 게시물 관련 메뉴를 출력하는 메서드
	 */
	private void displayBoardMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 전체 목록 출력");
		System.out.println("  2. 글 작성");
		System.out.println("  3. 글 삭제");
		System.out.println("  4. 글 수정");
		System.out.println("  5. 글 검색");
		System.out.println("  6. 이전으로.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	/**
	 * 프로그램 게시물 시작 메서드
	 */
	private void start() {
		int choice;
		do {
			displayBoardMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 전체 자료 출력
				displayBoardAll();
				break;
			case 2: // 글 작성
				insertBoard();
				break;
			case 3: // 글 삭제
				deleteBoard();
				break;
			case 4: // 글 수정
				updateBoard();
				break;
			case 5: // 글 검색
				getSearchBoard();
				break;
			case 6: // 작업 끝
				System.out.println();
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 6);
	}

	private void getSearchBoard() {
		BoardVO bv = new BoardVO();
		scan.nextLine(); // 입력버퍼 지우기
		System.out.println();
		System.out.println("검색할 정보를 입력하세요");
		System.out.print("글 제목 >> ");
		String title = scan.nextLine().trim();
		System.out.print("작성자 >> ");
		String writer = scan.nextLine().trim();
		System.out.print("작성 날짜 (YYYYMMDD) >> ");
		String date = scan.nextLine().trim();
		System.out.print("글 내용 >> ");
		String content = scan.nextLine().trim();

		bv.setBoardTitle(title);
		bv.setBoardWriter(writer);
		bv.setBoardContent(content);
		bv.setBoardDate(date);
		// 입력한 정보로 검색한 내용을 출력하기

		System.out.println();
		System.out.println("──────────────────────────────────────────────────────────────────");
		System.out.println("ID\t 이름\t   전화번호\t\t\t           주\t소");
		System.out.println("──────────────────────────────────────────────────────────────────");

		List<BoardVO> boardList = service.getSearchBoard(bv);
		for (BoardVO bv2 : boardList) {
			System.out.println("──────────────────────────────────────────");
			System.out.println("글 번호" + bv2.getBoardNo());
			System.out.println("글 제목: " + bv2.getBoardTitle());
			System.out.println("작성일자: " + bv2.getBoardDate());
			System.out.println("작성자: " + bv2.getBoardWriter());
			System.out.println("글 내용: " + bv2.getBoardContent());
			System.out.println("──────────────────────────────────────────");
		}
		System.out.println("──────────────────────────────────────────────────────────────────");
		System.out.println("출력작업 끝!!");
	}

	private void updateBoard() {
		boolean check = false; // 기존회원 존재여부 체크
		BoardVO bv = new BoardVO();
		String board_writer = "";
		int cnt = 0;
		do {
			System.out.println();
			System.out.println("수정할 작성자를 입력하세요.");
			System.out.print("작성자 이름 >> ");

			board_writer = scan.next();
			scan.nextLine();

			check = getBoard_writer(board_writer);

			if (!check) {
				System.out.println(board_writer + "님의 게시글은 없습니다.");
				System.out.println("다시 입력해주세요.");
			}

		} while (!check);

		System.out.print("게시글 제목 : ");
		String board_title = scan.nextLine();
		bv.setBoardTitle(board_title);

		System.out.print("게시글 내용 : ");
		String board_content = scan.nextLine();
		bv.setBoardContent(board_content);

		bv.setBoardWriter(board_writer);

		cnt = service.updateBoard(bv);
		if (cnt > 0) {
			System.out.println(board_writer + "의 게시물 수정 완료");
		} else {
			System.out.println(board_writer + "의 게시물 수정 실패");
		}
	}

	private boolean getBoard_writer(String writer) {
		return service.getBoard_writer(writer);
	}

	private void deleteBoard() {
		System.out.println();
		System.out.println("삭제할 작성자 이름을 입력하세요");
		System.out.print("작성자 이름 >>");
		String writer = scan.next();

		int cnt = service.deletBoard(writer);
		if (cnt > 0) {
			System.out.println(writer + "님의 글을 삭제했습니다.");
		} else {
			System.out.println(writer + "님의 삭제작업 실패!!");
		}

	}

	private void insertBoard() {
		BoardVO bv = new BoardVO();
		try {
			scan.nextLine();
			System.out.print("게시글 제목 : ");
			String board_title = scan.nextLine().trim();
			bv.setBoardTitle(board_title);

			System.out.print("게시글 작성자 : ");
			String board_writer = scan.next();
			scan.nextLine();
			bv.setBoardWriter(board_writer);

			System.out.print("게시글 내용 : ");
			String board_content = scan.nextLine();
			bv.setBoardContent(board_content);
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
		if (service.insertBoard(bv) > 0) {
			System.out.println("새로운 게시글 등록 완료");
		} else {
			System.out.println("새로운 게시글 등록 실패");
		}
	}

	private void displayBoardAll() {

		List<BoardVO> boardList = service.displayBoardAll();

		System.out.println("─────────────게시판───────────────");
		if (boardList.size() == 0) {
			System.out.println("게시글이 없습니다.");
		}
		for (BoardVO bv : boardList) {
			System.out.print("글 번호: " + bv.getBoardNo() + "\t");
			System.out.println("글 제목: " + bv.getBoardTitle() + "\t");
			System.out.println("작성자: " + bv.getBoardWriter() + "\t");
			System.out.println("─────────────────────────────────────");
		}

		System.out.println();
		System.out.println("=====================================");
		System.out.print("열람 번호를 입력(뒤로가기 0번) >> ");
		int choice = scan.nextInt();

		switch (choice) {
		case 0:
			return;
		default:
			System.out.println("다시 입력해주세요");
			break;
		}

		int BoardNo = boardList.get(choice - 1).getBoardNo();
		List<BoardVO> selectList = service.selectBoard(BoardNo);

		for (BoardVO bv : selectList) {
			System.out.println("──────────────────────────────────────────");
			System.out.println("글 번호: " + bv.getBoardNo());
			System.out.println("글 제목: " + bv.getBoardTitle());
			System.out.println("작성일자: " + bv.getBoardDate());
			System.out.println("작성자: " + bv.getBoardWriter());
			System.out.println("글 내용: " + bv.getBoardContent());
			System.out.println("──────────────────────────────────────────");
		}
	}
	
	public static void main(String[] args) {
		BoardMain brm = new BoardMain();
		brm.start();
	}
}