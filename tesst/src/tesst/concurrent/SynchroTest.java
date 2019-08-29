package tesst.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class SynchroTest {
	public static void main(String[] args) {
		Runnable ticket = new BTicket();
		Thread t1 = new Thread(ticket);
		Thread t2 = new Thread(ticket);
		Thread t3 = new Thread(ticket);
		Thread t4 = new Thread(ticket);
		Thread t5 = new Thread(ticket);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}

class ATicket implements Runnable {

	int ticket_amount = 30;
	int n = 0;

	@Override
	public void run() {

		while (true) {

			try {
				Thread.sleep(2 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (this) {
				if (ticket_amount > 0) {
					System.out.println("继续卖票");
					System.out.println(
							Thread.currentThread().getName() + ": 当前卖了" + (++n) + "张票，还剩票数：" + (--ticket_amount));
				}
			}

		}

	}

}

class BTicket implements Runnable {
	int ticket_amount = 30;
	int n = 0;
	ReentrantLock rlock = new ReentrantLock();

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(2 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rlock.lock();// 如果被其它资源锁定，会在此等待锁释放，达到暂停的效果
			if (ticket_amount > 0) {
				System.out.println("继续卖票");
				System.out.println(Thread.currentThread().getName() + ": 当前卖了" + (++n) + "张票，还剩票数：" + (--ticket_amount));

			}
			rlock.unlock();
		}

	}
}