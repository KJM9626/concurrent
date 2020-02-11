package com.sort;

/**
 * @author 明
 *插入排序
 *在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排好顺序的，现在要把第n个数找到相应位置并插入，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
 */
public class InsertionSort {

	public static int[] insertionSort(int[] nums) {
		if(nums==null||nums.length==0)
			return nums;
		
		int len=nums.length;
		
		for(int i=1;i<len;i++) {
			int temp=nums[i];//待插入的元素的值
			int location=i-1;//与待插入的元素的值的下标
			while(location>=0 && nums[location]>temp) {
				nums[location+1]=nums[location];//当前比较的元素后移
				location--;//再与前一个元素进行比较
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
