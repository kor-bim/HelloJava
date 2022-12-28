package f_OOP2;

public class ChildTest {
	public static void main(String[] args) {
		Child c = new Child();
		c.volume = 10;
		c.volume();
		System.out.println(c.volume);
		
		c.channel = 15;
		c.channel();
		System.out.println(c.channel);
	}
}
class Parent{
	int channel;
	void channel(){
		channel++;
	}
}

class Child extends Parent{
	int volume;
	int channel;
	void volume(){
		volume++;
	}
}
