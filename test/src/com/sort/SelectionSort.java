package com.sort;

/**
 * @author 明
 *选择排序
 *冒泡排序中有一个缺点，比如，我们比较第一个数a1与第二个数a2的时候，只要a1比a2大就会交换位置，但是我们并不能确定a2是最小的元素，假如后面还有比它更小的，该元素还会与a2再次进行交换，而且这种交换有可能发生多次才能确定a2的最终位置。
选择排序可以避免这种耗费时间的交换操作，从第一个元素开始，扫描整个待排数组，找到最小的元素放之后再与第一个元素交换位置，然后再从第二个元素开始，继续寻找最小的元素与第二个元素交换位置，依次类推。

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
