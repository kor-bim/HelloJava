package basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelPOI {
	public static void main(String[] args) {

		String[] content = new String[] {"1번",
				"홍길동", 
				"엑셀 POI",
		"저장될 내용 입니다."};

		//현재시간
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH-mm-ss");

		Workbook workbook = new HSSFWorkbook();

		// Sheet 생성
		Sheet sheet = workbook.createSheet("Sheet"); 
		// 컬럼 너비 설정
		sheet.setDefaultColumnWidth(20);

		// 제목 스타일 
		CellStyle HeadStyle = workbook.createCellStyle(); 
		HeadStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
		HeadStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); 
		HeadStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index); 
		HeadStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); 
		HeadStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN); 
		HeadStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); 
		HeadStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); 
		HeadStyle.setFillPattern(CellStyle.SOLID_FOREGROUND); 

		// 본문 스타일 
		CellStyle BodyStyle = workbook.createCellStyle(); 
		BodyStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
		BodyStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); 
		BodyStyle.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index); 
		BodyStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); 
		BodyStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN); 
		BodyStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); 
		BodyStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); 


		Row row = null;		// 1번째 행			
		Row row1 = null;	// 2번째 행			
		Cell cell = null;	// 열
		//----------------------------------------------------------

		row = sheet.createRow(0);	// 1번째 행 생성
		cell = row.createCell(0);	// 1번째 행의 0번째 셀
		cell.setCellValue("번 호");
		cell.setCellStyle(HeadStyle);

		cell = row.createCell(1);	// 1번째 행의 1번째 셀
		cell.setCellValue("이 름");
		cell.setCellStyle(HeadStyle);

		cell = row.createCell(2);	// 1번째 행의 2번째 셀
		cell.setCellValue("제 목");
		cell.setCellStyle(HeadStyle);

		cell = row.createCell(3);	// 1번째 행의 3번째 셀
		cell.setCellValue("내 용");
		cell.setCellStyle(HeadStyle);

	//	System.out.println(row.getRowNum() + "현재 행 길이");		// 현재 행의 길이
	//	System.out.println(row.getLastCellNum()+ "현재 셀 길이");	// 현재 셀의 길이

		// excel 파일 저장
		row1 = sheet.createRow(1);	// 2번째 행
		for (int i = 0; i < row.getLastCellNum(); i++) {	// 0부터 현재 셀 길 만큼
			cell = row1.createCell(i);
			cell.setCellValue(content[i]);
			cell.setCellStyle(BodyStyle);
		}

		try {
			
			File file = new File("D:/ExcelPOI"+sdf.format(date)+".xls");
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			System.out.println("D:/ExcelPOI"+sdf.format(date)+".xls 파일 생성 완료");
			workbook.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
