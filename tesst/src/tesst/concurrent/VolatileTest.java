package tesst.concurrent;

/**
 *volatile关键字的使用不适合用于写操作依赖于自身的变量的情况，一般用于标记量boolean值或单例模式的double check
 */
public class VolatileTest {

	private volatile int n=0;
	public synchronized void increase() {//不适合用于volatile关键字的使用，因为其写操作依赖于自身变量
		n++;
	}
	public static void main(String[] args) {
		VolatileTest test=new VolatileTest();
		for(int i=0;i<5;i++) {
			new Thread() {
				@Override
				public void run() {
					for(int j=0;j<6;j++) {
						test.increase();
					}
				};
			}.start();
		}
		while(Thread.activeCount()>1) {
			Thread.yield();
			System.out.println(test.n);
		}
	}
	
}
