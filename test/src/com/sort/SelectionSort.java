package com.sort;

/**
 * @author ��
 *ѡ������
 *ð����������һ��ȱ�㣬���磬���ǱȽϵ�һ����a1��ڶ�����a2��ʱ��ֻҪa1��a2��ͻύ��λ�ã��������ǲ�����ȷ��a2����С��Ԫ�أ�������滹�б�����С�ģ���Ԫ�ػ�����a2�ٴν��н������������ֽ����п��ܷ�����β���ȷ��a2������λ�á�
ѡ��������Ա������ֺķ�ʱ��Ľ����������ӵ�һ��Ԫ�ؿ�ʼ��ɨ�������������飬�ҵ���С��Ԫ�ط�֮�������һ��Ԫ�ؽ���λ�ã�Ȼ���ٴӵڶ���Ԫ�ؿ�ʼ������Ѱ����С��Ԫ����ڶ���Ԫ�ؽ���λ�ã��������ơ�

 */
public class SelectionSort {

	public static int[] selectionSort(int[] nums) {
		if(nums==null||nums.length==0)
			return nums;
		
		int min;
		int len=nums.length-1;
		for(int i=0;i<len;i++) {
			min=i;
			for(int j=i+1;j<=len;j++) {
				if(nums[j]<nums[min]) {
					min=j;
				}
			}
			
			if(min!=i) {
				int temp=nums[i];
				nums[i]=nums[min];
				nums[min]=temp;
			}
		}
		return nums;
	}
	
	public static void main(String[] args) {
		int[]nums={1,5,4,2,11,2,20,11,18};
		int[] bubbleSort = selectionSort(nums);
		for(int i:bubbleSort) {
			System.out.print(i+" ");
		}
	}
}
