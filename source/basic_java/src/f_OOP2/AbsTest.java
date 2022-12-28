package f_OOP2;

public class AbsTest {
	public static void main(String[] args) {

	}
}

abstract class Unit {
	int x;
	int y;

	abstract void move(int x, int y);
	
	void stop() {

	}
}

class Marine extends Unit {

	void stimPack() {

	}

	@Override
	void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}

class Tank extends Unit {

	void change() {

	}
	
	@Override
	void move(int x, int y){
		
	}
}

class Dropship extends Unit {

	void load() {

	}

	@Override
	void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
