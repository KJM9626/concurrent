package tesst.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock���Condition�ӿڿ���ʵ��synchronized��wait/notify�̼߳�ĵȴ�֪ͨ����
 */
public class ConditionTest {

	private static ReentrantLock lock = new ReentrantLock();
	private static Condition condition1 = lock.newCondition();

	public static void main(String[] args) throws InterruptedException {
		lock.lock();
		new Thread(new Signal()).start();
		System.out.println("���߳�֪ͨ�ȴ�");
		condition1.await();
		lock.unlock();
		System.err.println("���ָ̻߳�����");
	}

	static class Signal implements Runnable {
		@Override
		public void run() {
			lock.lock();
			try {
				System.out.println("���߳�֪ͨ");
				condition1.signal();
			} finally {
				lock.unlock();
			}

		}
	}
}
