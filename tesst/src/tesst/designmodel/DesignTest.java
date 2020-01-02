package tesst.designmodel;

public class DesignTest {
	private static DesignTest dtest=null;//����ģʽ
	private static final DesignTest ddtest=new DesignTest();//����ģʽ
	public  static class Singleton{//�༰�ڲ���
		private static DesignTest dddtest=new DesignTest();
	}
	private DesignTest() {
		// TODO Auto-generated constructor stub
	}
	public static DesignTest dgetInstance() {
		if(dtest==null) {
			synchronized (DesignTest.class) {//�����ڶ��̴߳�������ģʽ
				if(dtest==null)
					dtest=new DesignTest();
			}
		}
		return dtest;
	}
	
	public static DesignTest ddgetInstance() {
		return ddtest;
	}
	
	public static DesignTest dddgetInstance() {
		return Singleton.dddtest;
	}
	

}
