package com.sort;

/**
 * @author ��
 *
 *��������Ҳ�ǻ��ڷ����㷨�á��������£�

ѡ��һ����׼Ԫ�أ�ͨ��ѡ���һ��Ԫ�ػ������һ��Ԫ�أ�
ͨ��һ�����򽲴�����ļ�¼�ָ�ɶ����������֣�����һ���ּ�¼��Ԫ��ֵ���Ȼ�׼Ԫ��ֵС����һ���ּ�¼�� Ԫ��ֵ�Ȼ�׼ֵ��
��ʱ��׼Ԫ�������ź�������ȷλ�ã�
Ȼ��ֱ���������ּ�¼��ͬ���ķ���������������ֱ��������������
 */
public class QuikSort {
	private static int[] nums;

	public static void quikSort(int low,int high) {
		if(low>=high)
			return;
		int pivot=nums[low];//������Ԫ�ظ�ֵ����׼Ԫ��
		int partition=partition(low, high, pivot);
		quikSort(low, partition-1);
		quikSort(partition+1, high);
	}
	
	/**
	 * @param low��Ԫ���±�
	 * @param high��Ԫ���±�
	 * @param pivot��׼Ԫ��
	 * @return
	 */
	public static int partition(int low,int high,int pivot) {//��������зָ�
		while(low<high) {
			while(low<high && pivot<=nums[high]) {//��׼Ԫ�����Ҳ�Ԫ�رȽ�
				high--;
			}
			swap(low, high);
			
			while(low<high && pivot>=nums[low]) {//��׼Ԫ�������Ԫ�رȽ�
				low++;
			}
			swap(low, high);
		}
		return low;//�������һ����Ԫ���±�
	}
	
	public static void swap(int low,int high) {
		int temp=nums[low];
		nums[low]=nums[high];
		nums[high]=temp;
	}
	public static void main(String[] args) {
		nums= new int[]{57,28,68,59,52,72,28,59,96,33,24,19};
		quikSort(0, nums.length-1);
		for(int i:nums) {
			System.out.print(i+" ");
		}
	}
}
