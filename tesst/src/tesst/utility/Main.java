package tesst.utility;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
//		System.out.println("��·�ĳ���Ϊ��");
		int N=scan.nextInt();
//		System.out.println("��ǵĵ������Ϊ:");
		int M=scan.nextInt();
		int road[]=new int[N+1];
		for(int i=0;i<M;i++) {
			int m=scan.nextInt();
			int n=scan.nextInt();
			for(int j=m;j<=n;j++) {
				road[j]=1;
			}
		}
		
		int sum=0;
		for(int i=0;i<N+1;i++) {
			if(road[i]==0) {
				sum++;
			}
		}
		System.out.println(sum);

	}
	
}
