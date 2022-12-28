package f_OOP2;

public class PolyTest {
	public static void main(String[] args) {
		// 1.SmartTV 3대를 저장
		SmartTv stv1 = new SmartTv();
		SmartTv stv2 = new SmartTv();
		SmartTv stv3 = new SmartTv();
		// 2.AfreecaTv 2대를 저장해주세요
		AfreecaTv atv1 = new AfreecaTv();
		AfreecaTv atv2 = new AfreecaTv();
		AfreecaTv[] atv = new AfreecaTv[] { atv1, atv2 };
		// 3.DMBTv 2대를 저장해주세요
		DMBTv dtv1 = new DMBTv();
		DMBTv dtv2 = new DMBTv();
		DMBTv dtv3 = new DMBTv();

		TV[] t = new TV[] { stv1, stv2, stv3, atv1, atv2, dtv1, dtv2, dtv3 };
		t[2] = (TV) stv3; // up-casting
		TV t2 = t[3];

		SmartTv st2 = (SmartTv) t2;// down-casting //업-다운 가능 , 바로 업x-다운 불가능
		st2.internet();														
		
		SmartTv tt = (SmartTv)new TV();

	}
}

class TV {
	String color;
	int volume;

	void changeColor() {
		this.color = color;
	}
}

class SmartTv extends TV {
	void internet() {

	}
}

class AfreecaTv extends TV {
	void starBallon() {

	}
}

class DMBTv extends TV {
	void antena() {

	}
}