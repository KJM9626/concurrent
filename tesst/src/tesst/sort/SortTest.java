package tesst.sort;

//AbstractAutowireCapableBeanFactory
//Aware
public class SortTest {

	/**
	 * @param arr ð������
	 */
	public static void bubbleSort(int[] arr) {
		int temp = 0;
		boolean flag = true;
		int len = arr.length;
		for (int i = 0; i < len && flag; i++) {
			flag = false;// û������ǰ��ʼ��Ϊfalse
			for (int j = 0; j < len - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					flag = true;// ����󽫱�־��Ϊtrue���´ν������򽫲��ٶ���������������
				}
			}
		}
	}

	/**
	 * @param arr ѡ������
	 */
	public static void selectedSort(int[] arr) {
		int len = arr.length;
		int temp = 0;
		for (int i = 0; i < len - 1; i++) {
			int k = i;
			for (int j = len - 1; j > i; j--) {// �Ӻ���ǰ��
				if (arr[j] < arr[k]) {// �������������ǰ�����С����ô����
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
			temp = arr[i];// �ӵڶ���Ԫ�����ο�ʼ��ǰ�������е�Ԫ�رȽ�
			for (j = i; j > 0 && temp < arr[j - 1]; j--) {
				// ��������Ԫ�ر��������Ԫ�ض�С����ô����������������һλ
				arr[j] = arr[j - 1];
			}
			arr[j] = temp;// ��ʱ��j��һ��Ϊ0
		}
	}

	/**
	 * @param arr ϣ������
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
		int middle = getMiddle(arr, low, high);// ������һ��Ϊ��
		quickSort(arr, low, middle - 1);// �Ե��ֶν��еݹ�����
		quickSort(arr, middle + 1, high);// �Ը��ֶν��еݹ�����
	}

	private static int getMiddle(int[] arr, int low, int high) {
		int temp = arr[low];
		while (low < high) {
			while (low < high && arr[high] > temp) {
				high--;
			}
			arr[low] = arr[high];// ���������С����������
			while (low < high && arr[low] < temp) {
				low++;
			}
			arr[high] = arr[low];// �������������������
		}
		arr[low] = temp;// �����¼��β
		return low;// ���������λ��
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
