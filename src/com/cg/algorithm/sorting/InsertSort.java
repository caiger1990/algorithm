package com.cg.algorithm.sorting;

/**
 * Title: InsertSort.java Description:
 * 
 * @author caigen
 * @created 2015年5月14日 下午8:02:40
 */

public class InsertSort implements ISort {
	/**
	 * Description:直接插入排序算法，复杂度O(n^2)，
	 * 
	 * @author caigen
	 * @created 2015年5月14日 下午8:38:25
	 * @param a
	 * @see com.cg.algorithm.sorting.ISort#sort(int[])
	 */

	public void sort(int[] a) {
		// TODO Auto-generated method stub
		if (a == null || a.length <= 1)
			return;
		// 循环n-1次
		for (int i = 1; i < a.length; i++) {
			insert(a, 0, i - 1, i);
			// int temp=a[i];
			// int j=i-1;
			// while(j>=0&&temp<a[j]){
			// a[j+1]=a[j];
			// j--;
			// }
			// a[j+1]=temp;
		}
	}

	/**
	 * Description: 用二分查找的方式在已排序好的前部分序列插入待排序元素
	 * 
	 * @param a
	 *            要排序的数组
	 * @param begin
	 *            排序好部分的开始，从0开始
	 * @param end
	 *            排序好部分的结尾，为要排序元素的前一个
	 * @param target
	 *            要排序元素的索引
	 */
	private void insert(int[] a, int begin, int end, int target) {
		while (begin < end) {
			int mid = (begin + end) / 2;
			if (a[mid] <= a[target])
				begin = mid + 1;
			else if (a[mid] > a[target])
				end = mid;
		}
		// 存储要插入的元素
		int temp = a[target];
		// 比较最后一个元素，确定要插入元素的位置
		if (a[end] <= a[target])
			end++;
		// 将插入位置开始的元素依次向后移动一位
		for (int j = target; j > end; j--) {
			a[j] = a[j - 1];
		}
		a[end] = temp;
	}

}
