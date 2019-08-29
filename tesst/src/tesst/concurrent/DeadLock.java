package tesst.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.InsufficientResourcesException;

/**
 * @author �� 
 * �����ľ�������
 */
public class DeadLock {
	class Account {
		private String accountCode;
		private double balance;

		public Account(String accountCode, double balance) {
			// TODO Auto-generated constructor stub
			this.accountCode = accountCode;
			this.balance = balance;
		}

		public double getBalance() {
			return balance;
		}

		public void in(double money) {
			this.balance += money;
		}

		public void out(double money) {
			this.balance -= money;
		}
	}

	public int getCode(Account account) {
		return System.identityHashCode(account);
	}

	public void transfer(Account from, Account to, double amount) throws Exception {
		int a = getCode(from);
		int b = getCode(to);
		if (a > b) {
			synchronized (from) {
				synchronized (to) {
					if (from.getBalance() < amount) {
						throw new InsufficientResourcesException();
					} else {
						Thread.sleep(3000);
						from.out(amount);
						to.in(amount);
						System.out.println("ת���˻���" + from.accountCode + "��" + from.getBalance() + ",ת���˻���"
								+ to.accountCode + "��" + to.getBalance() + ",ת�˽��Ϊ��" + amount);

					}

				}
			}
		}
		if (a < b) {
			synchronized (to) {
				synchronized (from) {
					if (to.getBalance() < amount) {
						throw new InsufficientResourcesException();
					} else {
						Thread.sleep(3000);
						to.out(amount);
						from.in(amount);
						System.out.println("ת���˻���" + to.accountCode + "��" + to.getBalance() + ",ת���˻���"
								+ from.accountCode + "��" + from.getBalance() + ",ת�˽��Ϊ��" + amount + "��");

					}

				}
			}
		} else {
			throw new RuntimeException("�������Լ�ת��");
		}
	}

	public static void main(String[] args) {
		/*
		 * Thread a=new Thread(new LockA()); Thread b=new Thread(new LockB());
		 * a.start(); b.start();
		 */
		final DeadLock lockA = new DeadLock();
		final Account from = lockA.new Account("6677", 8848);
		final Account to = lockA.new Account("7766", 987);
		// ģ�����̶߳��������˻�����ת�˲���
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			service.execute(new Runnable() {

				@Override
				public void run() {

					try {
						System.out.println("��Ǯ��");
						lockA.transfer(from, to, 65);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});

			service.execute(new Runnable() {

				@Override
				public void run() {

					try {
						System.out.println("��Ǯ��");
						lockA.transfer(to, from, 95);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}

	}

}

class LockA implements Runnable {

	@Override
	public void run() {
		System.out.println("LockA");
		while (true) {
			synchronized (LockA.class) {
				System.out.println("�����LockA");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated
					e.printStackTrace();
				}
				synchronized (LockB.class) {
					System.out.println("�ȴ���ȡLockB");
				}
			}
		}

	}

}

class LockB implements Runnable {

	@Override
	public void run() {
		System.out.println("LockB");
		while (true) {
			synchronized (LockB.class) {
				System.out.println("�����LockB");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated
					e.printStackTrace();
				}
				synchronized (LockA.class) {
					System.out.println("�ȴ���ȡLockA");
				}
			}
		}

	}

}
