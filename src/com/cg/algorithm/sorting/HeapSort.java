package com.cg.algorithm.sorting;

import java.util.Arrays;

/**
 * Title: heapSort.java Description:
 *
 * @author caigen
 * @created 2015��5��15�� ����8:52:22
 */

public class HeapSort implements ISort {

    /**
     * Description:�������㷨�������ɶ�O(logn ),��ʱ�临�Ӷ�O(nlogn)
     *
     * @param a
     * @author caigen
     * @created 2015��5��15�� ����8:52:22
     * @see com.cg.algorithm.sorting.ISort#sort(int[])
     */

    @Override
    // ������ȫ������
    // ��n��Ԫ�ص����鿴�ɶѵĲ��������i��Ԫ����һ�����ʣ�
    // i=0����iΪ���ڵ㣻
    // ��2i+1<n����2i+1Ϊ�������ӣ���2i+2<n����Ϊi���Һ���
    // ���ĸ��ڵ�Ϊ(i-1)/2
    public void sort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        // �Ȱ������ų����ѣ������һ��Ԫ��n-1�ĸ��ڵ㣨����������������ʼ���Ӻ���ǰ�������еķ���Ƚڵ��ų�����
        int n = a.length;
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            sift(a, i, n - 1);
        }
        // ÿ��ȥ����һ������Ԫ�ط���ĩβ��Ȼ���ʣ�µ�Ԫ�����ų�����
        for (int j = n - 1; j > 0; j--) {
            int temp = a[0];
            a[0] = a[j];
            a[j] = temp;
            sift(a, 0, j - 1);
        }
    }

    /**
     * Description: �����ڵ�Ϊbegin���������ų����ѣ����ڵ�ΪҪ�����Ԫ��
     *
     * @param a     Ҫ���������
     * @param begin ����Ҫ�����Ԫ�أ�Ϊ�����ĸ��ڵ�
     * @param end   �ѵ����һ��Ԫ��
     */
    private void sift(int[] a, int begin, int end) {
        int i = begin, j = 2 * i + 1;
        int temp = a[i];
        while (j <= end) {
            // �Ƚ����ҽ���С����֤ƽ����
            if (j < end && a[j] < a[j + 1]) {
                j++;
            }
            if (temp < a[j]) {
                a[i] = a[j];
                // ������Ԫ�ص���λ��j
                i = j;
                j = 2 * j + 1;
            } else {
                break;
            }
        }
        a[i] = temp;
    }

	/**
	 * Ĭ�����ֵ���ϣ������Ϊ�������Ԫ�أ�����Ҳ������
	 * ���ʣ��������һ���ܹ����������ȫ�����������Ԫ�أ��������а��ղ㼶�洢����ʹ������ĵ�һ��λ��0��Ϊ�˸��õ��������ʣ�
	 * ��i���ڵ㣨������ǵ�һ���ڵ㣩�ĸ��ڵ�Ϊi/2�����ӽ��2i�����ӽ��2i+1
	 * �ȹ������ѣ�Ȼ��ÿ��ȡ������㽻��ĩβ��㣬�Ƴ�ĩβ�ڵ��ָ����ѽṹ��ֱ���ѿա�
	 * @param a
	 */
	public void heapSort(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		int n = a.length - 1;
		//�����һ����Ҷ�ӽ�㿪ʼ�³����������ѣ���ɺ�a[1]Ϊ���Ԫ��
		for (int k = n / 2; k >= 1; k--) {
			sink(a, k, n);
		}
		for (int i = n; i > 1; i--) {
			swap(a, i, 1);
			sink(a, 1, i-1);
		}
	}

	/**
	 * ��Ҷ�ӽ���ϸ������ڴ�ĩ������Ԫ��
	 * @param a
	 * @param k
	 */
	public void swim(int[] a, int k) {
		while (k > 1 && a[k] > a[k / 2]) {
			swap(a, k, k / 2);
			k = k / 2;
		}
	}

	/**
	 * �Ӹ�����³�Ԫ�أ�ɾ���ڵ�ʱ����ĩβ�ڵ��滻ɾ���ڵ�Ȼ���³�
	 *
	 * @param a ����Ѷ�Ӧ�����飬a[0]Ϊ�գ���a[1]��ʼ
	 * @param k ���³��Ľڵ�
	 * @param n �������һ���ڵ�
	 */
	public void sink(int[] a, int k, int n) {
		while (2 * k < n) {
			int j = 2 * k;
			if (a[j + 1] > a[j]) {
				j++;
			}
			if (a[k] >= a[j]) {
				break;
			}
			swap(a, k, j);
			k = j;
		}
	}

	public static void main(String[] args) {
		int[] a = new int[]{0, 6, 4, 3, 1, 7, 9, 4, 3, 2, 1};
		new HeapSort().heapSort(a);
		System.out.println(Arrays.toString(a));
	}


}
