package f_OOP2;

public class SingletonTest {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
	}
}

final class Singleton{
	private static Singleton s;
	private Singleton(){
		
	}
	
	static Singleton getInstance(){
		if(s==null){
			s = new Singleton();
		}
		return s;
	}
	
}
