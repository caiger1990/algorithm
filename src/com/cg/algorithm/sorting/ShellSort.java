package com.cg.algorithm.sorting;

/**
 * Title: ShellSort.java Description:
 * �ֽ���С���������ǲ��������һ�֣����ռ��d���з����������ÿ������֮��d--��֪��d=1�������һ��
 * ʱ�临�Ӷȣ�O(nlogn)~O(n^2)�����ȶ���һ�β������ȶ��ģ����Ƕ�β����ı����λ��
 * 
 * @author caigen
 * @created 2015��5��14�� ����8:14:54
 */

public class ShellSort implements ISort {
	@Override
	public void sort(int[] a) {
		if (a == null || a.length <= 1)
			return;
		int n = a.length;
		for (int d = n / 2; d > 0; d /= 2) {
			for (int i = d; i < n; i++) {
				int temp = a[i], j;
				for (j = i - d; j >= 0 && temp < a[j]; j -= d) {
					a[j + d] = a[j];
				}
				a[j + d] = temp;
			}
		}
	}
}
