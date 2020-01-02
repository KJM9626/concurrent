package tesst.designmodel;

public class FactoryTest {

	// 简单工厂实现
	public static Drink getDrink(String name) {
		if ("A".equals(name)) {
			return new ACoffee();
		}
		if ("B".equals(name)) {
			return new BCoffee();
		}
		if ("C".equals(name)) {
			return new CCoffee();
		} else {
			throw new RuntimeException("没有找到相应的饮料");
		}
	}

	// 抽象工厂模式
	public static void main(String[] args) {
		DrinkFactory drink = new AmericaFactory();
		drink.getCola();
	}

}

abstract class Drink {
	public abstract String getName();
}

class ACoffee extends Drink {

	@Override
	public String getName() {
		return "A";
	}

}

class BCoffee extends Drink {

	@Override
	public String getName() {

		return "B";
	}

}

class CCoffee extends Drink {

	@Override
	public String getName() {

		return "C";
	}

}

interface DrinkFactory {
	void getTea();

	void getCoffee();

	void getCola();
}

class AmericaFactory implements DrinkFactory {

	@Override
	public void getTea() {
		System.out.println("美国茶");

	}

	@Override
	public void getCoffee() {
		// TODO Auto-generated method stub
		System.out.println("美国咖啡");

	}

	@Override
	public void getCola() {
		// TODO Auto-generated method stub
		System.out.println("美国可乐");
	}

}

class ChineseFactory implements DrinkFactory {

	@Override
	public void getTea() {
		// TODO Auto-generated method stub
		System.out.println("中国茶");
	}

	@Override
	public void getCoffee() {
		// TODO Auto-generated method stub
		System.out.println("中国咖啡");
	}

	@Override
	public void getCola() {
		// TODO Auto-generated method stub
		System.out.println("中国可乐");
	}

}
