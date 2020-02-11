package com.sort;

/**
 * @author ��
 *��������
 *��Ҫ�����һ�����У�����ǰ��(n-1)[n>=2] �����Ѿ����ź�˳��ģ�����Ҫ�ѵ�n�����ҵ���Ӧλ�ò����룬ʹ����n����Ҳ���ź�˳��ġ���˷���ѭ����ֱ��ȫ���ź�˳��
 */
public class InsertionSort {

	public static int[] insertionSort(int[] nums) {
		if(nums==null||nums.length==0)
			return nums;
		
		int len=nums.length;
		
		for(int i=1;i<len;i++) {
			int temp=nums[i];//�������Ԫ�ص�ֵ
			int location=i-1;//��������Ԫ�ص�ֵ���±�
			while(location>=0 && nums[location]>temp) {
				nums[location+1]=nums[location];//��ǰ�Ƚϵ�Ԫ�غ���
				location--;//����ǰһ��Ԫ�ؽ��бȽ�
			}
			if(nums[location]<=temp) {
				nums[location+1]=temp;
			}
		}
		return nums;
	}
	
	public static void main(String[] args) {
		int[]nums={1,5,4,2,11,2,20,11,18};
		int[] bubbleSort = insertionSort(nums);
		for(int i:bubbleSort) {
			System.out.print(i+" ");
		}
	}
}
