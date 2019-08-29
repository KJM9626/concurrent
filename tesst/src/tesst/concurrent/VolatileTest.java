package tesst.concurrent;

/**
 *volatile�ؼ��ֵ�ʹ�ò��ʺ�����д��������������ı����������һ�����ڱ����booleanֵ����ģʽ��double check
 */
public class VolatileTest {

	private volatile int n=0;
	public synchronized void increase() {//���ʺ�����volatile�ؼ��ֵ�ʹ�ã���Ϊ��д�����������������
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
