package domRead;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test {
	public static void main(String ar[]) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document xml = null;
			File file = new File("D://A_TeachingMaterial/3.HignJava/LHK/abc.xml");
			xml = documentBuilder.parse(file);
			// Root엘리먼트 획득
			Element element = xml.getDocumentElement();
			// Root엘리먼트의 자식 노드목록 획득(blog xml 태그)
			NodeList list = element.getChildNodes();
			// 자식노드가 1개이상일경우
			if (list.getLength() > 0) {
				// 반복문 이용
				for (int i = 0; i < list.getLength(); i++) {
					// blog xml태그의 자식태그 한번 더 획득
					NodeList childlist = list.item(i).getChildNodes();
					// 마찬가지로 자식노드 1개이상일경우
					if (childlist.getLength() > 0) {
						for (int j = 0; j < childlist.getLength(); j++) {
							// blog xml 태그내에 존재하는 태그들의 태그명 + 태그에 속하는 내용 출력
							if (Node.TEXT_NODE != childlist.item(j).getNodeType()) {
								System.out.println(
										childlist.item(j).getNodeName() + ":" + childlist.item(j).getTextContent());
							}
						}
						System.out.println();
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
