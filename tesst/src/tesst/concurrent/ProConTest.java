package tesst.concurrent;

import java.util.ArrayList;

public class ProConTest {
	public static void main(String[] args) throws InterruptedException {
		/*
		 * MyRun run = new MyRun(); Thread t1 = new Thread(run.runA); Thread t2 = new
		 * Thread(run.runB);
		 * //��ʱ����t2�߳��Ѿ�notify���ѵȴ��е��߳��ˣ��������notify��wait��ִ�У��ͻ��������֮��wait�����ܱ����� //
		 * t2.start(); // Thread.sleep(2000); // t1.start(); t1.start();
		 * Thread.sleep(2000); t2.start();
		 */
		String lock=new String("a");
		ArrayList<Integer>list=new ArrayList<>();
		Producer producer=new Producer(lock, list);
		Consumer consumer=new Consumer(lock, list);
		Thread[] t1=new ProThread[3];
		Thread[] t2=new ConThread[3];
		for(int i=0;i<3;i++) {
			t1[i]=new ProThread(producer);
			t1[i].setName("������"+(i+1));
			t2[i]=new ConThread(consumer);
			t2[i].setName("������"+(i+1));
			t1[i].start();
			t2[i].start();
		}
	}

}

/*
 * class MyRun { private String lock = new String(""); public Runnable runA =
 * new Runnable() {
 * 
 * @Override public void run() {
 * 
 * try { synchronized (lock) { System.out.println("wait begin..."); lock.wait();
 * System.out.println("wait stop..."); } } catch (InterruptedException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); }
 * 
 * } };
 * 
 * public Runnable runB = new Runnable() {
 * 
 * @Override public void run() { synchronized (lock) {
 * System.out.println("notify begin..."); lock.notify();
 * System.out.println("notify stop..."); }
 * 
 * } }; }
 */

class Producer {
	private String lock;
	private ArrayList<Integer>list;

	public Producer(String lock,ArrayList<Integer>list) {
		this.lock=lock;
		this.list=list;

	}

	public void setValue() {

		synchronized (lock) {
		try {
				while(!list.isEmpty()) {
					lock.wait();
				}
				int value=10;
				System.out.println("set��ֵΪ��"+value);
				list.add(value);
				lock.notifyAll();
			}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} 
	}
}

class Consumer {
	private String lock;
	private ArrayList<Integer>list;

	public Consumer(String lock, ArrayList<Integer>list) {
		this.lock = lock;
		this.list=list;
	}

	public void getValue() {

		synchronized (lock) {
		try {
				while(list.isEmpty()) {
					lock.wait();
				}
				System.out.println("get��ֵΪ��"+list.get(0));
				list.clear();
				lock.notifyAll();
			}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} 
	}
}

class ProThread extends Thread{
	private Producer producer;
	public ProThread(Producer producer) {
		super();
		this.producer=producer;
	}
	@Override
	public void run() {
		while(true) {
		producer.setValue();
		}
	}
}

class ConThread extends Thread{
	private Consumer consumer;
	public ConThread(Consumer consumer) {
		super();
		this.consumer=consumer;
	}
	@Override
	public void run() {
		while(true) {
			consumer.getValue();
		}
	}
}