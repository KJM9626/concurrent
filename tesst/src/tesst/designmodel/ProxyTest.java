package tesst.designmodel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
	public static void main(String[] args) {
		Car car=new Car();
//		Move move=new Bike(car);
//		move.move();
		InvocationHandler handler=new MyInvocation(car);
		Move move=(Move) Proxy.newProxyInstance(Car.class.getClassLoader(), Car.class.getInterfaces(), handler);
		move.move();
	}

}
class Car implements Move{

	@Override
	public void move() {
		System.out.println("小车会跑");
		
	}
	
}
/*
 * class Bike implements Move{
 * 
 * private Car car; public Bike(Car car) { // TODO Auto-generated constructor
 * stub super(); this.car=car; }
 * 
 * @Override public void move() { // TODO Auto-generated method stub car.move();
 * } }
 */

class MyInvocation implements InvocationHandler{

	private Move move;
	public MyInvocation(Move move) {
		// TODO Auto-generated constructor stub
		this.move=move;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理类工作开始");
		Object result=method.invoke(move, args);
		System.out.println("代理类工作结束");
		return result;
	}
	
}

