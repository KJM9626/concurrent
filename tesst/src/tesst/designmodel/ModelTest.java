package tesst.designmodel;

public class ModelTest {//ģ����Ʒ���
	public static void main(String[] args) {
		Model model=new BeiJing();
		model.init();
	}

}

abstract class Model{
	
	public void first() {
		System.out.println("�˶�Ա����");
	}
	public abstract void second();
	public abstract void third();
	public void fourth() {
		System.out.println("�˶�Ա�볡");
	}
	public void init() {
		first();
		second();
		third();
		fourth();
	}
}

class BeiJing extends Model{

	@Override
	public void second() {
		// TODO Auto-generated method stub
		System.out.println("�������˻���ݽ�Ŀ");
		
	}

	@Override
	public void third() {
		// TODO Auto-generated method stub
		System.out.println("�������˻��ȼ���");
	}
	
}

class Syney extends Model{
	@Override
	public void second() {
		// TODO Auto-generated method stub
		System.out.println("Ϥ����˻���ݽ�Ŀ");
		
	}

	@Override
	public void third() {
		// TODO Auto-generated method stub
		System.out.println("Ϥ����˻��ȼ���");
	}
}