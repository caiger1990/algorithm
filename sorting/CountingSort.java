package algorithm.sorting;
/*
 *���������㷨��ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(n)
 *�㷨˼·����֪����Ҫ�����������Ԫ�صĴ��·�Χʱʹ�ã��÷�Χ��ϵ��Ͱ����b�Ĵ�С��������max-min+1��Ҳ���Ժ�a������ͬ�Ĵ�С
 *		        1.������Ԫ��һ����k����ͬ��ֵ����ô����һ��Ͱ�������洢��Щ��ͬԪ�صĸ�����������a��{2,4,1,3,2,3,6}��
 *			 һ����6-1+1=6�����ܲ�ͬ��ֵ��max-min+1������ô����һ����СΪ6������b������aͳ��a��Ԫ�ظ�����¼��b��
 *			 �õ�b��{0,1,2,2,1,0,1}��
 *				2.����һ����b��Ԫ��ת��Ϊb[a[j]]��ʾa��<=a[j]��Ԫ�صĸ�����{0,1,3,5,6,0,7}����ʱb[a[j]]-1��ʾa[j]��λ�ã�
 *			 ���췵������c����a[j]����b[a[j]]-1����c�У�ͬʱ����b[a[j]],ÿ��һ��b[a[j]]--��
 *				3.������������b����������a��Ԫ�أ���ô���Բ�������c����������ֱ�ӹ���a������b[j]�Ĵ�С��a[0]��ʼ����
 *			 
 */

public class CountingSort implements ISort {

	@Override
	public void sort(int[] a) {
		int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
		//�ҵ�������С
		for(int i:a){
			if(i > max){
				max = i; 
			} 
			if(i < min){
				min = i;
			}
		}
		int[] b = new int[max-min+1];
		//ͳ��a[j]������Ӧ��b�У�i-min���Դ����и��������
		for(int i : a){
			b[i-min]++;
		}
		int t = 0;
		for(int j = min; j < b.length+min; j++){
			while(b[j-min] > 0){
			    a[t++] = j;
			    b[j-min]--;
			}
		}
		
//		//b[j]��ʾa��<=j��Ԫ�صĸ���
//		for(int j = 1; j < b.length; j++){
//			b[j] = b[j] + b[j-1];
//		}
//		//
//		int c[] = new int[a.length];
//		for(int k = 0;k < a.length; k++){
//			c[b[a[k]]-1] = b[a[k]];
//			b[a[k]]--;
//		}
//		return c;
		
	}
	
}
