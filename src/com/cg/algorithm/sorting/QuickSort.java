package com.cg.algorithm.sorting;

import java.util.Arrays;

public class QuickSort implements ISort {
    public QuickSort() {
    }

    /**
     * Description:���������㷨��ʱ�临�Ӷ�O(nlogn)
     *
     * @param a
     * @author caigen
     * @created 2015��5��14�� ����8:39:52
     * @see com.cg.algorithm.sorting.ISort#sort(int[])
     */

    @Override
    public void sort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int begin = 0, end = a.length - 1;
        quickSort(a, begin, end);
    }

//    /**
//     * Description:
//     *
//     * @param a     Ҫ���������
//     * @param begin
//     * @param end
//     */
//    private void quickSort(int[] A, int begin, int end) {
//        if (begin >= end) {
//			return;
//		}
//        int index = partition(A, begin, end);
//        // �ݹ���ã�ÿ�ν���partitionʱ��begin��end���ڸ���
//        quickSort(A, begin, index - 1);
//        quickSort(A, index + 1, end);
//    }
//
    /**
     * Description: �ҵ�����Ϊbegin��Ԫ��������A������ú��λ��
     *
     * @param a     Ŀ������
     * @param lo ��ʼ���±�
     * @param hi   �������±�
     * @return ����begin��Ӧ������Ԫ��������λ��
     */
    private int partition1(int[] a, int lo, int hi) {
        int temp = a[lo];
        // ˫ָ����ȷ��temp������λ�ã���a[lo]Ϊ�ڱ�
        while (lo < hi) {
        	//�ȴӺ���ǰ��С��temp��
			while (lo < hi && a[hi] > temp) {
				hi--;
			}
			a[lo] = a[hi];
			//��ǰ�����Ҵ���temp��
			while (lo < hi && a[lo] <= temp) {
				lo++;
			}
			a[hi] = a[lo];
		}
        //������λ�ü�Ϊtemp����λ��
		a[lo] = temp;
		return lo;
    }

    public void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pos = partition(a, lo, hi);
        quickSort(a, lo, pos - 1);
        quickSort(a, pos + 1, hi);
    }

    private int partition(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return hi;
        }
        //˫ָ��
        int lt = lo, gt = hi, temp = a[lo];
		while (true) {
			//����ѭ��ʱ��ltָ�����temp��λ��
			while (lt < hi && a[lt] <= temp) {
				lt++;
			}
			//����ѭ��ʱ����gtָ��С��temp��λ��
			while (lo < gt && a[gt] > temp) {
				gt--;
			}
			//���lt��gt����������ѭ��
			if (lt >= gt) {
				break;
			}
			//������Сֵ
			swap(a, lt, gt);
		}
		//a[lo]����࣬��С��temp�Ľ���
        swap(a, lo, gt);
        return gt;
    }

	/**
	 * ��ָ���������������ɺ���ȵ�ֵ���м䣬
	 * @param a
	 * @param lo
	 * @param hi
	 */
	public void quickSortWith3way(int[] a, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int lt = lo, gt = hi, i = lo + 1, temp = a[lo];
		//����iλ��Ԫ��
		while (i <= gt) {
			//С��temp�Ľ��������tempֵa[lt]��i++��lt++
			if (a[i] < temp) {
				swap(a, i++, lt++);
			//����temp�Ľ������Ҷ˵�a[gt]��gt--
			} else if (a[i] > temp) {
				swap(a, i, gt--);
			//����temp�ģ�i++
			} else {
				i++;
			}
		}
		quickSortWith3way(a, lo, lt - 1);
		quickSortWith3way(a, gt + 1, hi);
	}


    public static void main(String[] args) {
        int[] a = new int[]{8, 7, 6, 6, 6, 7, 8, 5, 4, 3, 2, 1};
		new QuickSort().quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }


}
