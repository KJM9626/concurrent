package tesst.utility;

public class Circle {
	private double centerX;
	private double centerY;
	private double r;
	public Circle() {}
	public Circle(double centerX,double centerY,double r) {
		this.centerX=centerX;
		this.centerY=centerY;
		this.r=r;
	}
	public double getCenterX() {
		return centerX;
	}
	public void setCenterX(double centerX) {
		this.centerX = centerX;
	}
	public double getCenterY() {
		return centerY;
	}
	public void setCenterY(double centerY) {
		this.centerY = centerY;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	

}
