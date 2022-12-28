package f_OOP2;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class DrawShape extends Frame {
	public static void main(String[] args) {
		DrawShape ds = new DrawShape();

		// ds.paint();
	}

	DrawShape() {
		super("현무야 정신줄 놓지마...");
		setSize(500, 500);
		setBackground(Color.MAGENTA);
		setVisible(true);
		setResizable(false);
	}

	public void paint(Graphics g) {
		// 1.매개변수가 두개인 생성자를 이용하여 Circle객체를 만들어주세요
		Circle c = new Circle();
		// 2.g.drawOval() 원을 그려주세요
		g.drawOval(c.center.x, c.center.y, 2 * c.r, 2 * c.r);
		// 3.매개변수가 하나인 생성자를 이용하여 Triangle객체를 만들어주세요
		// 100,100 200,200 200,100
		Point[] ret = new Point[3];
		ret[0] = new Point(100, 100);
		ret[1] = new Point(200, 200);
		ret[2] = new Point(200, 100);

		Triangle t = new Triangle(ret);
		// 4.g.drawLine() 3개를 이용하여 삼각형을 그려주세요
		g.drawLine(t.p[0].x, t.p[0].y, t.p[1].x, t.p[1].y);

		g.drawLine(t.p[1].x, t.p[1].y, t.p[2].x, t.p[2].y);

		g.drawLine(t.p[2].x, t.p[2].y, t.p[0].x, t.p[0].y);
	}
}

/**
 * 점을 관리하기 위한 클래스
 * 
 * @author PC-NEW09
 * @since 2020.08.24
 */
class Point {
	int x; // 점의 x좌표
	int y; // 점의 y좌표

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Circle {
	// 1.반지름(정수)를 저장할 수 있는 변수 r을 선언해주세요
	int r;
	// 2.점하나를 저장할 수 있는 변수 center를 선언해주세요
	Point center;

	// 3. 매개변수가 두개인 생성자를 이용하여 r과 center를 초기화해주세요
	Circle(int r, Point center) {
		this.r = r;
		this.center = center;
	}

	// 4.기본생성자를 만들어주세요. 단, 매개변수가 두개인 생성자를 호출하여 좌표는 100,100 반지름은 50으로 초기화해주세요
	Circle() {
		this(50, new Point(100, 100));
	}

}

class Triangle {
	public int y;
	public int x;
	// 1. 점3개를 저장할 수 있는 변수 p를 선언해주세요
	Point[] p = new Point[3];

	// 2. 매개변수가 하나인 생성자를 만들어 주세요
	Triangle(Point[] p) {
		this.p = p;
	}

	// 3. 매개변수가 3개인 생성자를 만들어주세요
	Triangle(Point p1, Point p2, Point p3) {
		this.p[0] = p1;
		this.p[1] = p2;
		this.p[2] = p3;
	}

}