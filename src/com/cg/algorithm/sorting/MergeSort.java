package com.cg.algorithm.sorting;

import java.util.Arrays;

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
     * @param a
     * @author caigen
     * @created 2015��5��14�� ����10:35:17
     * @see com.cg.algorithm.sorting.ISort#sort(int[])
     */
    @Override
    public void sort(int[] a) {
        if (a == null || a.length <= 1) {
			return;
		}
        int begin = 0, end = a.length - 1;
        mergeSort(a, begin, end);
    }

    /**
     * Description: �ݹ���ý��з��飬�Զ�����
     *
     * @param a     Ҫ���������
     * @param begin �����鿪ʼ
     * @param end   �������β
     */
    private void mergeSort(int[] a, int begin, int end) {
        if (begin >= end) {
			return;
		}
        int mid = (begin + end) / 2;
        mergeSort(a, begin, mid);
        mergeSort(a, mid + 1, end);
        merge(a, begin, mid, end);
    }

    /**
     * Description: ���ø�������ϲ�����������
     *
     * @param a     Ҫ���������
     * @param begin ��һ�������鿪ʼ
     * @param mid   ��һ���������β
     * @param end   �ڶ����������β
     */
    private static void merge(int[] a, int begin, int mid, int end) {
		if (begin >= end || end > a.length) {
			return;
		}
        int i = begin, j = mid + 1, k = 0, b[] = new int[end - begin + 1];
        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }
        // ����ʣ�µ�Ԫ��
        while (i <= mid) {
			b[k++] = a[i++];
		}
        while (j <= end) {
			b[k++] = a[j++];
		}
        // ��b��Ԫ����ӵ�a��
        for (int m = 0; m <= end - begin; m++) {
            a[begin + m] = b[m];
        }
    }

	/**
	 * ��2^n���������±�ʵ�ַ��飬�Ե�����
	 * @param a
	 */
	public static void mergeSortWithLoop(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		int n = a.length;
		for (int d = 1; d < n; d <<= 1) {
			//ÿ��ȡ���ڵ�������кϲ�
			for (int i = 0; i < n; i += (d * 2)) {
				int hi = Math.min(i + d * 2 - 1, n - 1);
				//�ҳ�merge�����Ĳ������жϱ߽�
				merge(a, i, i + d - 1, hi);
			}
		}
	}



	public static void main(String[] args) {
		int[] a = new int[]{8, 7, 6, 6, 6, 7, 8, 5, 4, 3, 2, 1};
		System.out.println(Arrays.toString(a));
	}

}
