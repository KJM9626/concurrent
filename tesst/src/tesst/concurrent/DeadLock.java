package tesst.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.InsufficientResourcesException;

/**
 * @author 明 
 * 死锁的经典例子
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
						System.out.println("转出账户：" + from.accountCode + "余额：" + from.getBalance() + ",转入账户："
								+ to.accountCode + "余额：" + to.getBalance() + ",转账金额为：" + amount);

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
						System.out.println("转出账户：" + to.accountCode + "余额：" + to.getBalance() + ",转入账户："
								+ from.accountCode + "余额：" + from.getBalance() + ",转账金额为：" + amount + "余额：");

					}

				}
			}
		} else {
			throw new RuntimeException("不能向自己转账");
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
		// 模拟多个线程对这两个账户进行转账操作
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			service.execute(new Runnable() {

				@Override
				public void run() {

					try {
						System.out.println("借钱：");
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
						System.out.println("还钱：");
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
				System.out.println("获得了LockA");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated
					e.printStackTrace();
				}
				synchronized (LockB.class) {
					System.out.println("等待获取LockB");
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
				System.out.println("获得了LockB");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated
					e.printStackTrace();
				}
				synchronized (LockA.class) {
					System.out.println("等待获取LockA");
				}
			}
		}

	}

}
