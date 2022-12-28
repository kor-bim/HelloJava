package f_OOP2;

public class TimeTest {
	public static void main(String[] args) {
		TimeVO t = new TimeVO();

		// 시40 = 16;
		// 분 200분 == 19:20
		// 초 10000초 = 22:06:40
		t.setHour(40);
		t.setMinute(200);
		t.setSecond(10000);
		System.out.println(t);

		// 시22 22
		// 분100 23:40
		// 초10000 2:26:40
		
		t.setHour(22);
		t.setMinute(100);
		t.setSecond(10000);
		System.out.println(t);
	}
}

class TimeVO {
	private int hour; 	// 16,19,22  //22,22,23,2
	private int minute; // 20,6 	 //6,40,26
	private int second; // 40 		 //40,40

	void setHour(int hour) {
		this.hour = hour % 24;
	}

	void setMinute(int minute) {
		setHour(hour += minute / 60);
		this.minute = minute % 60;
	}

	void setSecond(int second) {
		setMinute(minute += second / 60);
		this.second = second % 60;
	}

	@Override
	public String toString() {
		return hour + ":" + minute + ":" + second;
	}
}