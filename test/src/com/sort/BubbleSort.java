package com.sort;

/**
 * @author 明
 *冒泡排序
 *对当前还未排好序的范围内的全部数，自上而下对相邻的俩个数依次进行比较和调整，让较大的数下沉,较小的数往上冒。
 *即：每当俩相邻的数比较后发现他们的排序与排序的要求相反时，就将他们交换。每次遍历都可确定一个最大值放到待排数组的末尾，下次遍历，对该最大值以及它之后的元素不再排序（已经排好）。

 */
public class BubbleSort {

	public static int[] bubbleSort(int[]nums) {
		if(nums==null||nums.length==0)
			return nums;
		
		for(int i=0;i<nums.length;i++) {//每一次外循环确定一个最大值
			for(int j=1;j<nums.length-i;j++) {
				if(nums[j-1]>nums[j]) {//前大于后，那么就交换顺序
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
