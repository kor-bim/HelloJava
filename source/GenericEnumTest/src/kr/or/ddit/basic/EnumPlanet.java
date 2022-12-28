package kr.or.ddit.basic;

public class EnumPlanet {

	public enum KM {
		수성(2439), 금성(6052), 지구(6371), 화성(3390), 목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622);
		private int num;

		KM(int data) {
			num = data;
		}

		public int getInt() {
			return num;
		}
	}

	static void getArea() {
		for (KM km : KM.values()) {
			System.out.println(km + "의 면적 : " + String.format("%.2f", 4 * Math.pow(km.num, 2) * Math.PI) + "km²");
		}
	}

	public static void main(String[] args) {
		getArea();
	}
}
