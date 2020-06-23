package com.cg.algorithm.sorting;

import java.util.Arrays;

/**
 * Title: InsertSort.java Description:
 *
 * @author caigen
 * @created 2015��5��14�� ����8:02:40
 */

public class InsertSort implements ISort {
    /**
     * Description:ֱ�Ӳ��������㷨�����Ӷ�O(n^2)��
     *
     * @param a
     * @author caigen
     * @created 2015��5��14�� ����8:38:25
     * @see com.cg.algorithm.sorting.ISort#sort(int[])
     */

    @Override
    public void sort(int[] a) {
        // TODO Auto-generated method stub
        if (a == null || a.length <= 1) {
            return;
        }
        // ѭ��n-1��
        for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j = i - 1;
			while (j >= 0 && temp < a[j]) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = temp;
        }
    }

    /**
     * Description: �ö��ֲ��ҵķ�ʽ��������õ�ǰ�������в��������Ԫ��
     *
     * @param a      Ҫ���������
     * @param begin  ����ò��ֵĿ�ʼ����0��ʼ
     * @param end    ����ò��ֵĽ�β��ΪҪ����Ԫ�ص�ǰһ��
     * @param target Ҫ����Ԫ�ص�����
     */
    private void insert(int[] a, int begin, int end, int target) {
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (a[mid] <= a[target]) {
				begin = mid + 1;
			} else if (a[mid] > a[target]) {
				end = mid;
			}
        }
        // �洢Ҫ�����Ԫ��
        int temp = a[target];
        // �Ƚ����һ��Ԫ�أ�ȷ��Ҫ����Ԫ�ص�λ��
        if (a[end] <= a[target]) {
			end++;
		}
        // ������λ�ÿ�ʼ��Ԫ����������ƶ�һλ
        for (int j = target; j > end; j--) {
            a[j] = a[j - 1];
        }
        a[end] = temp;
    }


	public static void insertSort(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		for (int i = 1; i < a.length; i++) {
			//��a[i]���뵽������õĲ���
			int temp = a[i], j = i;
			while (j-- > 0 && a[j] > temp) {
				a[j + 1] = a[j];
			}
			a[j+1] = temp;
		}
	}
	public static void main(String[] args) {
		int[] a = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
		insertSort(a);
		System.out.println(Arrays.toString(a));
	}

}
