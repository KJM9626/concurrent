package tesst.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock结合Condition接口可以实现synchronized的wait/notify线程间的等待通知机制
 */
public class ConditionTest {

	private static ReentrantLock lock = new ReentrantLock();
	private static Condition condition1 = lock.newCondition();

	public static void main(String[] args) throws InterruptedException {
		lock.lock();
		new Thread(new Signal()).start();
		System.out.println("主线程通知等待");
		condition1.await();
		lock.unlock();
		System.err.println("主线程恢复运行");
	}

	static class Signal implements Runnable {
		@Override
		public void run() {
			lock.lock();
			try {
				System.out.println("子线程通知");
				condition1.signal();
			} finally {
				lock.unlock();
			}

		}
	}
}
