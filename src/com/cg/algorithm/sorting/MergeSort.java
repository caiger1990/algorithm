package com.cg.algorithm.sorting;

/**
 * Title: MergeSort.java Description:
 * 
 * @author caigen
 * @created 2015��5��14�� ����10:35:17
 */

public class MergeSort implements ISort {

	/**
	 * Description:�鲢�����㷨��ʱ�临�Ӷ�O(nlogn)~O(n^2),�ռ临�Ӷȣ�O(n),�ȶ���
	 * 
	 * @author caigen
	 * @created 2015��5��14�� ����10:35:17
	 * @param a
	 * @see com.cg.algorithm.sorting.ISort#sort(int[])
	 */
	@Override
	public void sort(int[] a) {
		if (a == null || a.length <= 1)
			return;
		int begin = 0, end = a.length - 1;
		mergeSort(a, begin, end);
	}

	/**
	 * Description: �ݹ���ý��з���
	 * 
	 * @param a
	 *            Ҫ���������
	 * @param b
	 *            ��������
	 * @param begin
	 *            �����鿪ʼ
	 * @param end
	 *            �������β
	 */
	private void mergeSort(int[] a, int begin, int end) {
		if (begin >= end)
			return;
		int mid = (begin + end) / 2;
		mergeSort(a, begin, mid);
		mergeSort(a, mid + 1, end);
		merge(a, begin, mid, end);
	}

	/**
	 * Description: ���ø�������ϲ�����������
	 * 
	 * @param a
	 *            Ҫ���������
	 * @param b
	 *            ��������
	 * @param begin
	 *            ��һ�������鿪ʼ
	 * @param mid
	 *            ��һ���������β
	 * @param end
	 *            �ڶ����������β
	 */
	private void merge(int[] a, int begin, int mid, int end) {
		if (begin >= end)
			return;
		int i = begin, j = mid + 1, k = 0, b[] = new int[end - begin + 1];
		while (i <= mid && j <= end) {
			if (a[i] <= a[j]) {
				b[k++] = a[i++];
			} else if (a[i] > a[j]) {
				b[k++] = a[j++];
			}
		}
		// ����ʣ�µ�Ԫ��
		while (i <= mid)
			b[k++] = a[i++];
		while (j <= end)
			b[k++] = a[j++];
		// ��b��Ԫ����ӵ�a��
		for (int m = 0; m <= end - begin; m++) {
			a[begin + m] = b[m];
		}
	}

}
