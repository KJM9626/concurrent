package com.sort;

/**
 * @author ��
 *ð������
 *�Ե�ǰ��δ�ź���ķ�Χ�ڵ�ȫ���������϶��¶����ڵ����������ν��бȽϺ͵������ýϴ�����³�,��С��������ð��
 *����ÿ�������ڵ����ȽϺ������ǵ������������Ҫ���෴ʱ���ͽ����ǽ�����ÿ�α�������ȷ��һ�����ֵ�ŵ����������ĩβ���´α������Ը����ֵ�Լ���֮���Ԫ�ز��������Ѿ��źã���

 */
public class BubbleSort {

	public static int[] bubbleSort(int[]nums) {
		if(nums==null||nums.length==0)
			return nums;
		
		for(int i=0;i<nums.length;i++) {//ÿһ����ѭ��ȷ��һ�����ֵ
			for(int j=1;j<nums.length-i;j++) {
				if(nums[j-1]>nums[j]) {//ǰ���ں���ô�ͽ���˳��
					int temp=nums[j-1];
					nums[j-1]=nums[j];
					nums[j]=temp;	
				}
			}
		}
		return nums;
	}
	
	public static void main(String[] args) {
		int[]nums={1,5,4,11,2,20,18};
		int[] bubbleSort = bubbleSort(nums);
		for(int i:bubbleSort) {
			System.out.print(i+" ");
		}
	}
}
