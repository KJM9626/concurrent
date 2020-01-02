package tesst.designmodel;

public class StrategyTest {
	public static void main(String[] args) {
		FlyStrategy fs=new FlyStrategy(new FlyWithRocket());
		fs.getFlyStrategy();
	}

}
interface Fly{
	void fly();
}
class FlyWithSwing implements Fly{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("fly with swing");
	}
	
}

class FlyWithRocket implements Fly{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("fly with rocket");
	}
	
}

class FlyStrategy{
	private Fly fly;
	public FlyStrategy(Fly fly) {
		// TODO Auto-generated constructor stub
		this.fly=fly;
	}
	public void getFlyStrategy() {
		fly.fly();
	}
}