package tesst.designmodel;

public class ModelTest {//模板设计方法
	public static void main(String[] args) {
		Model model=new BeiJing();
		model.init();
	}

}

abstract class Model{
	
	public void first() {
		System.out.println("运动员进场");
	}
	public abstract void second();
	public abstract void third();
	public void fourth() {
		System.out.println("运动员离场");
	}
	public void init() {
		first();
		second();
		third();
		fourth();
	}
}

class BeiJing extends Model{

	@Override
	public void second() {
		// TODO Auto-generated method stub
		System.out.println("北京奥运会表演节目");
		
	}

	@Override
	public void third() {
		// TODO Auto-generated method stub
		System.out.println("北京奥运会点燃火炬");
	}
	
}

class Syney extends Model{
	@Override
	public void second() {
		// TODO Auto-generated method stub
		System.out.println("悉尼奥运会表演节目");
		
	}

	@Override
	public void third() {
		// TODO Auto-generated method stub
		System.out.println("悉尼奥运会点燃火炬");
	}
}