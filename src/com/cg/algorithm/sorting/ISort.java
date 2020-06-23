package com.cg.algorithm.sorting;

/**
 * Title: Sort.java Description: �����㷨�Ľӿ�
 * 
 * @author caigen
 * @created 2015��5��14�� ����8:35:11
 */
@FunctionalInterface
public interface ISort {
	public void sort(int[] a);

	/**
	 * Description:
	 * 
	 * @param a
	 */

	default void swap(int[] a, int j, int i) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
}
