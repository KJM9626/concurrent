package tesst.designmodel;

public class DesignTest {
	private static DesignTest dtest=null;//懒汉模式
	private static final DesignTest ddtest=new DesignTest();//饿汉模式
	public  static class Singleton{//类及内部类
		private static DesignTest dddtest=new DesignTest();
	}
	private DesignTest() {
		// TODO Auto-generated constructor stub
	}
	public static DesignTest dgetInstance() {
		if(dtest==null) {
			synchronized (DesignTest.class) {//适用于多线程创建单例模式
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
