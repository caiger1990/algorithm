package com.cg.algorithm.sorting;

/**
 * Title: BubbleSort.java Description:
 * 
 * @author caigen
 * @created 2015��5��14�� ����9:21:06
 */

public class BubbleSort implements ISort {

	/**
	 * Description:ð������
	 * 
	 * @author caigen
	 * @created 2015��5��14�� ����9:21:06
	 * @param a
	 * @see com.cg.algorithm.sorting.ISort#sort(int[])
	 */

	@Override
	public void sort(int[] a) {
		if (a == null || a.length <= 1)
			return;
		// ���һ�α����Ƿ��н�����û�����ʾ�������
		boolean isExchanged = true;
		for (int i = a.length - 1; i > 0 && isExchanged; i--) {
			isExchanged = false;
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;
					isExchanged = true;
				}
			}
		}
	}
}