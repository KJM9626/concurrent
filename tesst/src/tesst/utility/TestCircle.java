package tesst.utility;

import java.util.Scanner;

public class TestCircle {
	public static void main(String[] args) {
		Circle c1=new Circle();
		scanCircle(c1);
		Circle c2=new Circle();
		scanCircle(c2);
		Circle c3=new Circle();
		scanCircle(c3);
		judgeCircle(c1, c2);
		judgeCircle(c1, c3);
		judgeCircle(c2, c3);
		
	}
	private static Circle scanCircle(Circle circle) {
		System.out.println("请输入圆的横纵坐标以及半径：");
		Scanner scan=new Scanner(System.in);
		double x=scan.nextDouble();
		double y=scan.nextDouble();
		double r=scan.nextDouble();
		circle.setCenterX(x);
		circle.setCenterY(y);
		circle.setR(r);
		return circle;
	}
	public static void judgeCircle(Circle c1,Circle c2) {
		switch (cal(c1,c2)) {
		case 0:
			System.out.println("两个圆不相交");
			break;
		case 1:
			System.out.println("两个圆相交");
			break;

		default:
			break;
		}
	}
	private static int cal(Circle c1,Circle c2) {
		double i;
		i=Math.sqrt((c1.getCenterX()-c2.getCenterX())*(c1.getCenterX()-c2.getCenterX())+(c1.getCenterY()-c2.getCenterY())*(c1.getCenterY()-c2.getCenterY()));
		if(i>c1.getR()-c2.getR())
			return 1;
		else {
			return 0;
		}
	}
}
