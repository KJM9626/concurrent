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
					System.out.println("������Ʊ");
					System.out.println(
							Thread.currentThread().getName() + ": ��ǰ����" + (++n) + "��Ʊ����ʣƱ����" + (--ticket_amount));
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
			rlock.lock();// �����������Դ���������ڴ˵ȴ����ͷţ��ﵽ��ͣ��Ч��
			if (ticket_amount > 0) {
				System.out.println("������Ʊ");
				System.out.println(Thread.currentThread().getName() + ": ��ǰ����" + (++n) + "��Ʊ����ʣƱ����" + (--ticket_amount));

			}
			rlock.unlock();
		}

	}
}