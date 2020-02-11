package com.sort;

/**
 * @author 明
 *归并排序的核心思想是将两个有序的数组归并到另一个数组中
 */
public class MergeSort {

	private int[] nums;
	public MergeSort(int[] nums) {
		this.nums=nums;
	}
	
	/**
	 * 将数组nums中的两端进行合并，lowBound--mid为低位段，mid+1--highBound为高位段
	 * @param workSpace辅助归并的数组
	 * @param lowBound合并段的起始下标
	 * @param mid合并段的中点下标
	 * @param highBound合并段的结束下标
	 */
	private void merge(int[] workSpace,int lowBound,int mid,int highBound) {
		int lowBegin=lowBound;//低位段的起始下标
		int lowEnd=mid;//低位段的结束下标
		int highBegin=mid+1;
		int highEnd=highBound;
		int j=0;//workspace的下标指针
		int len=highBound-lowBound+1;//归并的元素的总数
		
		while(lowBegin<=lowEnd&&highBegin<=highEnd) {
			if(nums[lowBegin]<nums[highBegin]) {//将两者较小的那一个加入到workSpace
				workSpace[j++]=nums[lowBegin++];
			}else {
				workSpace[j++]=nums[highBegin++];
			}
		}
		//一个数组的元素加入到workSpace中后，将剩余的元素也加入到workSpace中
		while(lowBegin<=lowEnd) {
			workSpace[j++]=nums[lowBegin++];
		}
		while(highBegin<=highEnd) {
			workSpace[j++]=nums[highBegin++];
		}
		
		for(j=0;j<len;j++) {//将归并好的元素复制到nums中
			nums[lowBound++]=workSpace[j];
		}
	}
	
	private void recursiveMergeSort(int[] workSpace,int lowBound,int highBound) {
		if(lowBound==highBound) {//该段只有一个元素，返回
			return;
		}
		int mid=(highBound+lowBound)/2;
		recursiveMergeSort(workSpace, lowBound, mid);//对低位段进行归并排序
		recursiveMergeSort(workSpace, mid+1, highBound);//对高位段进行归并排序
		merge(workSpace, lowBound, mid, highBound);
	}
	public void mergeSort() {
		int[] workSpace=new int[nums.length];
		recursiveMergeSort(workSpace, 0, workSpace.length-1);
	}
	
	public static void main(String[] args) {
		int[] nums={6,2,7,4,8,1,5,3};
		MergeSort mergeSort = new MergeSort(nums);
		mergeSort.mergeSort();
		for(int i:nums) {
			System.out.print(i+" ");
		}
	}
}
