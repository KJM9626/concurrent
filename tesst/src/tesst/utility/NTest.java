package tesst.utility;


import java.util.Random;

public class NTest {
	public NTest() {
		String name="����";
	}
	static void change(NTest n) {
		n=new NTest();
	}
	public static void main(String[] args) {
//		int arr[][]=new int[3][];
//		arr[0]=new int[4];
//		arr[0][1]=2;
//		arr[0][2]=3;
//		arr[0][3]=1;
//		arr[1]=new int[2];
//		arr[1][1]=1;
//		arr[2]=new int[3];
//		arr[2][1]=2;
//		arr[2][2]=7;
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr[i].length;j++) {
//				if(arr[i][j]==0) {
//					System.out.println("����Ԫ��Ϊ��");
//				}else {
//					System.out.println(arr[i][j]);
//				}
//			}
//		}
//		NTest m=new NTest();
		Random r1=new Random();
		//����127-154���һ���������
//		int i=r1.nextInt(1)*27+127;
		int j=(int) (r1.nextDouble()*27.0+127.0);
		for(int a=0;a<10;a++) {
			System.out.println(j);
		}
		
		
		
	}

}
