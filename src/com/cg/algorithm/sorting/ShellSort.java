package com.cg.algorithm.sorting;

/**
 * Title: ShellSort.java Description:
 * �ֽ���С���������ǲ��������һ�֣����ռ��d���з����������ÿ������֮��d/2��֪��d=1�������һ��
 * ʱ�临�Ӷȣ�O(nlogn)~O(n^2)�����ȶ���һ�β������ȶ��ģ����Ƕ�β����ı����λ��
 * ͨ�����ֵ��߼�������ѭ���еĽ�������
 *
 * @author caigen
 * @created 2015��5��14�� ����8:14:54
 */

public class ShellSort implements ISort {
    @Override
    public void sort(int[] a) {
        if (a == null || a.length <= 1) {
			return;
		}
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

	public static void shellSort(int[] a) {
		if (a == null || a.length <= 1) {
			return;
		}
        int n = a.length;
		//ִ��log(N)��
        for (int d = n >> 1; d > 0; d >>= 1) {
            //ÿ����dΪ����������a[i]��ÿ����n/d����Ա����dΪ������ӵڶ����һ����ĩβִ�в������
            for (int i = d; i < n; i ++) {
                int temp = a[i], j = i - d;
                while (j >= 0 && a[j] > temp) {
                    a[j+d] = a[j];
                    j -= d;
                }
                a[j+d] = temp;
            }
        }
	}

    public static void main(String[] args) {
        int[] a = new int[]{8, 7, 6,6,6,7,8, 5, 4, 3, 2, 1};
        shellSort(a);
        System.out.println(a);
    }

}
