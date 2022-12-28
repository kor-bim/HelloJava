package y_project;

import java.util.Vector;

public class DBClass {
	
	private Vector<ProductVO> proList = new Vector();//물품들을 저장

	public boolean addProdcut(String name, int price) {
		ProductVO pv1 = new ProductVO(name, price);
		boolean result = proList.add(pv1);
		return result;
	}
	
}
