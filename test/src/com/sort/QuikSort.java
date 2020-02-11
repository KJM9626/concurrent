package com.sort;

/**
 * @author 明
 *
 *快速排序也是基于分治算法得。步骤如下：

选择一个基准元素，通常选择第一个元素或者最后一个元素；
通过一趟排序讲待排序的记录分割成独立的两部分，其中一部分记录的元素值均比基准元素值小。另一部分记录的 元素值比基准值大；
此时基准元素在其排好序后的正确位置；
然后分别对这两部分记录用同样的方法继续进行排序，直到整个序列有序。
 */
public class QuikSort {
	private static int[] nums;

	public static void quikSort(int low,int high) {
		if(low>=high)
			return;
		int pivot=nums[low];//将最左元素赋值给基准元素
		int partition=partition(low, high, pivot);
		quikSort(low, partition-1);
		quikSort(partition+1, high);
	}
	
	/**
	 * @param low左元素下标
	 * @param high右元素下标
	 * @param pivot基准元素
	 * @return
	 */
	public static int partition(int low,int high,int pivot) {//将数组进行分割
		while(low<high) {
			while(low<high && pivot<=nums[high]) {//基准元素与右侧元素比较
				high--;
			}
			swap(low, high);
			
			while(low<high && pivot>=nums[low]) {//基准元素与左侧元素比较
				low++;
			}
			swap(low, high);
		}
		return low;//返回最后一个左元素下标
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
