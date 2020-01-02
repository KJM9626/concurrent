package tesst.sort;

//AbstractAutowireCapableBeanFactory
//Aware
public class SortTest {

	/**
	 * @param arr 冒泡排序
	 */
	public static void bubbleSort(int[] arr) {
		int temp = 0;
		boolean flag = true;
		int len = arr.length;
		for (int i = 0; i < len && flag; i++) {
			flag = false;// 没有排序前初始化为false
			for (int j = 0; j < len - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					flag = true;// 排序后将标志设为true，下次进行排序将不再对已排序的数组操作
				}
			}
		}
	}

	/**
	 * @param arr 选择排序
	 */
	public static void selectedSort(int[] arr) {
		int len = arr.length;
		int temp = 0;
		for (int i = 0; i < len - 1; i++) {
			int k = i;
			for (int j = len - 1; j > i; j--) {// 从后往前比
				if (arr[j] < arr[k]) {// 如果后面有数比前面的数小，那么交换
					k = j;
				}

			}
			temp = arr[k];
			arr[k] = arr[i];
			arr[i] = temp;
		}
	}

	public static void insertSort(int[] arr) {
		int len = arr.length;
		int temp = 0;
		int j = 0;
		for (int i = 1; i < len; i++) {
			temp = arr[i];// 从第二个元素依次开始与前面已排列的元素比较
			for (j = i; j > 0 && temp < arr[j - 1]; j--) {
				// 如果插入的元素鼻已排序的元素都小，那么将已排序的数组后移一位
				arr[j] = arr[j - 1];
			}
			arr[j] = temp;// 此时的j不一定为0
		}
	}

	/**
	 * @param arr 希尔排序
	 */
	public static void shellSort(int[] arr) {
		int len = arr.length;
		int temp = 0;
		int j = 0;
		for (int increment = len / 2; increment > 0; increment /= 2) {
			for (int i = increment; i < len; i++) {
				temp = arr[i];
				for (j = i; j >= increment; j -= increment) {
					if (temp < arr[j - increment]) {
						arr[j] = arr[j - increment];
					} else {
						break;
					}
				}
				arr[j] = temp;
			}
		}
	}

	public static void quick(int[] arr) {
		if (arr.length > 0) {
			quickSort(arr, 0, arr.length - 1);
		}
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		int middle = getMiddle(arr, low, high);// 将数组一分为二
		quickSort(arr, low, middle - 1);// 对低字段进行递归排序
		quickSort(arr, middle + 1, high);// 对高字段进行递归排序
	}

	private static int getMiddle(int[] arr, int low, int high) {
		int temp = arr[low];
		while (low < high) {
			while (low < high && arr[high] > temp) {
				high--;
			}
			arr[low] = arr[high];// 如果比中轴小的数则左移
			while (low < high && arr[low] < temp) {
				low++;
			}
			arr[high] = arr[low];// 如果比中轴大的数则右移
		}
		arr[low] = temp;// 中轴记录到尾
		return low;// 返回中轴的位置
	}
	

	public static void main(String[] args) {
		int arr[] = new int[] { 2, 3, 1, 6, 4, 8, 3, 9, 0, 15, 23, 24, 56, 45, 31, 23 };
//		bubbleSort(arr);
//		selectedSort(arr);
//		insertSort(arr);
//		shellSort(arr);
		quick(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}
}
