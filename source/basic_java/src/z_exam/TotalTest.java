package z_exam;

public class TotalTest {//TotalTest 클래스가 MethodArea 영역에 할당되고 클래스변수와, 클래스 메서드가 같이 로드된다. // TotalTest=[클래스변수:없음 클래스메서드: main()]           
	public static void main(String[] args) {//CallStack영역에 main()가 쌓인다

		TvMaker.color = "Blue"; //TvMaker클래스가 MethodArea 영역에 할당되고 클래스변수와, 클래스 메서드가 같이 로드된다. // TvMaker=[클래스변수:color; inch; 클래스메서드: 없음]
								//TvMaker의 클래수 변수 color에 "Blue"를 저장한다.
		TvMaker tm = new TvMaker(); // 대입연산자로 인해 왼쪽영역부터 시작함. TvMaker클래스가 MethodArea 영역에 할당되지만 이미 있어서 넘어감. tm이라는 main의 지역변수를 선언함
								    // new로 인해 tm의 주소가 heap 영역에 생성됨 그리고 인스턴스변수와 인스턴스 매소드를 같이 생성됨. [인스턴스변수: name; age; 인스턴스메서드: TvMaker(), TvMaker(String name, int age)]
									//TvMaker클래스 생성자가 Callstack에 쌓임 작업이 끝나면 퇴근. 그리고 tm의 주소를 tm에다가 저장됨 
		tm.age = 30; // tm의 주소에 있는 인스턴스 변수 age에 30을 저장
		// 3. 메서드 호출
		// 3.1
		System.out.println(TvControll.channel);//TvControll클래스를  MethodArea 영역에 할당되고 클래스변수와, 클래스 메서드가 같이 로드된다. 
											   //TvMaker=[클래스변수:MAX_CHANNEL = 50; inch; MIN_CHANNEL = 1; channel = 15; 클래스메서드: volumeDown()]
											   //TvControll클래스의 클래스 변수를 불러와 channel를 출력한다.
		
		int a=TvControll.volumeDown();			   //TvControll클래스를  MethodArea 영역에 할당되지만 이미 있어서 넘어감.volumeDown()를 호출하여 CallStack영역에 쌓이고 실행함, 작업이 끝나면 퇴근
		//반환값이 있을 땐 지역변수를 새로 선언, 변수에 저장한다.
		
		System.out.println(TvControll.channel);//TvControll클래스를  MethodArea 영역에 할당되지만 이미 있어서 넘어감. TvControll클래스의 클래스 변수를 불러와 channel를 출력한다.

		// 3.2
		TvControll tc; //TvControll클래스를  MethodArea 영역에 할당되지만 이미 있어서 넘어감. tc라는 지역변수를 선언함
		tc = new TvControll(); //new로 인해 tc의 주소가 heap 영역에 생성됨 그리고 인스턴스변수와 인스턴스 매소드를 같이 생성됨. 
							   //[인스턴스변수: MAX_VOLUME = 100; MIN_VOLUME = 0; volume = 99; 인스턴스메서드: volumeUp()]
								//TvControll클래스 생성자가 Callstack에 쌓임 작업이 끝나면 퇴근. 그리고 tc의 주소를 tc에다가 저장됨 
		System.out.println(tc.volume); //참조변수 tc의 주소에 있는 인스턴스변수 volume를 출력함
		
		int b = tc.volumeUp(); //참조변수 tc의 주소에 있는 인스턴스메서드 volume()메소드를 호출하여 volume()를 호출하여 CallStack영역에 쌓이고 실행함, 작업이 끝나면 퇴근
		//반환값이 있을 땐 지역변수를 새로 선언, 변수에 저장한다.
		
		System.out.println(tc.volume); //참조변수 tc의 주소에 있는 인스턴스변수 volume를 출력함
		
		int c = tc.volumeUp(); //참조변수 tc의 주소에 있는 인스턴스메서드 volume()메소드를 호출하여 volume()를 호출하여 CallStack영역에 쌓이고 실행함, 작업이 끝나면 퇴근
		//반환값이 있을 땐 지역변수를 새로 선언, 변수에 저장한다.
		
		System.out.println(tc.volume); //참조변수 tc의 주소에 있는 인스턴스변수 volume를 출력함
 
		//
		Calc cc = new Calc(); //대입연산자로 인해 왼쪽영역부터 시작함. Calc클래스가 MethodArea 영역에 할당할당되고 클래스변수와, 클래스 메서드가 같이 로드된다. 
							  //Calc=[클래스변수:없음 클래스메서드:없음] ,cc이라는 main의 지역변수를 선언함. new로 인해 cc의 주소가 heap 영역에 생성됨 그리고 인스턴스변수와 인스턴스 매소드를 같이 생성됨.
							  //[인스턴스변수: 없음  인스턴스메서드:add(int , int ), add(long , int ), minus(int , int ) ] 두개의 add메서드는 이름이 같지만 매개변수 타입이달라
							  //오버로딩할 수 있음. Calc클래스 생성자가 Callstack에 쌓임 작업이 끝나면 퇴근. 그리고 cc의 주소를 cc에다가 저장됨
		System.out.println(cc.add(Integer.MAX_VALUE, 4)); //참조변수 cc의주소에 있는 add(int int)메서드를 호출하여 Integer.MAX_VALUE, 4인자값을 넘겨줌, 
														  //CallStack영역에 쌓이고 실행함 끝나면 퇴근함, 그리고 반환값을 출력한다
		System.out.println(cc.add(3L, Integer.MAX_VALUE)); //참조변수 cc의주소에 있는 add(long int)메서드를 호출하여 3L, Integer.MAX_VALUE인자값을 넘겨줌, 
		  													//CallStack영역에 쌓이고 실행함 끝나면 퇴근함, 그리고 반환값을 출력한다

	}
}

class TvMaker {
	// 1.
	// 1.1
	static String color; //클래스변수 color 초기값=null;
	static int inch; //클래스변수 inch 초기값:0;
	// 1.2
	String name = ""; //인스턴스변수 name = "";
	int age; //인스턴스변수 age 초기값:0;

	// 2.
	// 2.1
	TvMaker() {//기본 생성자. 인스턴스의 초기화목적에 사용한다. 매개변수의 갯수, 타입으로 구분함, 반환값이 없다
		this("man", 25); //this()는 생성자매서드를 다시 재귀호출하여 인자값으로 name과age를 "man", 25초기화함 Call Stack에 쌓아서 선작업 후 작업이 끝나면 전의 매서드가 실행됨. 
	}

	// 2.2
	TvMaker(String name, int age) {//매개변수를 받는 생성자 .두개의 TvMaker메서드는 이름이 같지만 매개변수 타입이달라 오버로딩함 매개변수를 받아 인스턴스 변수 name과 age를 인자값으로 초기화함
		this.name = name; //this는 인스턴스멤버를 뜻한다.
		this.age = age;
	}
}

class TvControll {
	final int MAX_VOLUME = 100; //인스턴스변수 MAX_VOLUME = 100;
	final int MIN_VOLUME = 0; //인스턴스변수MIN_VOLUME = 0;
	static final int MAX_CHANNEL = 50; //클래스 변수 MAX_CHANNEL = 50;
	static final int MIN_CHANNEL = 1; //클래스 변수 MIN_CHANNEL = 1;

	static int channel = 15; //클래스 변수channel = 15;
	int volume = 99; //클래스 변수volume = 99;

	// 4. return문 
	int volumeUp() { //반환값의 반환타입을 매서드이름앞에 붙혀준다. volumeUp()은 인스턴스매서드이다 매개변수가 없고 반환값이 있다.//반환값이 없을때는 void를 붙혀주고 생략이가능하다
		if (volume == MAX_VOLUME) { 
			volume = MIN_VOLUME;
		} else {
			volume++;
		}

		return volume;//매서드가 종료될때는 마지막문장이 끝난후랑 return문을 만났을때 이다. 반환값을 호출한곳으로 돌려준다
	}

	static int volumeDown() { //반환값의 반환타입을 매서드이름앞에 붙혀준다. volumeUp()은 클래스매서드이다 매개변수가 없고 반환값이 있다. //반환값이 없을때는 void를 붙혀주고 생략이가능하다
		if (channel == MAX_CHANNEL) { 
			channel = MIN_CHANNEL;
		} else {
			channel++;
		}
		return channel; //매서드가 종료될때는 마지막문장이 끝난후랑 return문을 만났을때 이다. 반환값을 호출한곳으로 돌려준다
	}
}

class Calc {
	// 5. 
	int add(int a, int b) { //add메서드는 이름이 같지만 매개변수의 갯수, 매개변수 타입이달라 오버로딩함, 반환타입은 상관이없다
		return a + b;
	}

	long add(long a, int b) {
		return a + b;
	}

	int minus(int a, int b) {
		return a + b;
	}
}