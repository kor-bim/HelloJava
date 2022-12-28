package javatopdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class MakePdfFile {

	public static void main(String[] args) {

		//1. Document객체를 생성하여 문서의 크기, 좌우상하의 여백을 지정한다. 
		Document document = new Document(PageSize.A4, 40, 40, 30, 30);
		try {
			//2. PdfWriter객체를 생성하여 document파일과 연결하고 파일을 쓸 경로를 지정한다.
			PdfWriter writer = PdfWriter.getInstance(document, 
													new FileOutputStream("D:\\pdfTest.pdf"));
			
			//한글 호환을 위해 폰트파일을 저장하고 경로를 지정한다.
			String fontname = "D:\\fonts\\malgun.ttf";
			
			//3. 기본이 되는 BaseFont를 지정한다.
			BaseFont bfont = BaseFont.createFont(fontname, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			
			//BaseFont이면서 크기가 20pt인 Font 지정
			Font font1 = new Font(bfont, 20);
			
			//BaseFont이면서 크기가 25pt이고 진한, 글씨가 있는 Font 지정
			Font font2 = new Font(bfont, 25, Font.BOLD, new BaseColor(120, 230, 200));
			
			//4. 문서를 연다.
			document.open();
			
			//5. 문서에 내용을 첨부한다.
			document.add(new Paragraph("Hello World!", font2));
			document.add(new Paragraph("Java에서 생성한 PDF파일 입니다.", font1));
			
			//6. 문서를 닫는다.
			document.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//정상 종료가 되면 콘솔창에 구문이 출력된다.
		System.out.println("작업 완료");
	}
}
