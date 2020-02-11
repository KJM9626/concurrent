package com.sort;

/**
 * @author ��
 *�鲢����ĺ���˼���ǽ��������������鲢����һ��������
 */
public class MergeSort {

	private int[] nums;
	public MergeSort(int[] nums) {
		this.nums=nums;
	}
	
	/**
	 * ������nums�е����˽��кϲ���lowBound--midΪ��λ�Σ�mid+1--highBoundΪ��λ��
	 * @param workSpace�����鲢������
	 * @param lowBound�ϲ��ε���ʼ�±�
	 * @param mid�ϲ��ε��е��±�
	 * @param highBound�ϲ��εĽ����±�
	 */
	private void merge(int[] workSpace,int lowBound,int mid,int highBound) {
		int lowBegin=lowBound;//��λ�ε���ʼ�±�
		int lowEnd=mid;//��λ�εĽ����±�
		int highBegin=mid+1;
		int highEnd=highBound;
		int j=0;//workspace���±�ָ��
		int len=highBound-lowBound+1;//�鲢��Ԫ�ص�����
		
		while(lowBegin<=lowEnd&&highBegin<=highEnd) {
			if(nums[lowBegin]<nums[highBegin]) {//�����߽�С����һ�����뵽workSpace
				workSpace[j++]=nums[lowBegin++];
			}else {
				workSpace[j++]=nums[highBegin++];
			}
		}
		//һ�������Ԫ�ؼ��뵽workSpace�к󣬽�ʣ���Ԫ��Ҳ���뵽workSpace��
		while(lowBegin<=lowEnd) {
			workSpace[j++]=nums[lowBegin++];
		}
		while(highBegin<=highEnd) {
			workSpace[j++]=nums[highBegin++];
		}
		
		for(j=0;j<len;j++) {//���鲢�õ�Ԫ�ظ��Ƶ�nums��
			nums[lowBound++]=workSpace[j];
		}
	}
	
	private void recursiveMergeSort(int[] workSpace,int lowBound,int highBound) {
		if(lowBound==highBound) {//�ö�ֻ��һ��Ԫ�أ�����
			return;
		}
		int mid=(highBound+lowBound)/2;
		recursiveMergeSort(workSpace, lowBound, mid);//�Ե�λ�ν��й鲢����
		recursiveMergeSort(workSpace, mid+1, highBound);//�Ը�λ�ν��й鲢����
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
