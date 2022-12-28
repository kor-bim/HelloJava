package f_OOP2;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnnoInner {
	public static void main(String[] args) {
		Button bt1 = new Button();
		ActionListener e1 = new EventHandler();
		bt1.addActionListener(e1);
	}
}
//인터페이스타입의 참조변수로 그를 구현한 구현체에 인스턴스를 참조할수 있다.
class EventHandler implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("1번 버튼누름");
	}
	
}

