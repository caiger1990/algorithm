package algorithm.sorting;


/**        
 * Title: MergeSort.java    
 * Description: 
 * @author caigen       
 * @created 2015��5��14�� ����10:35:17    
 */

public class MergeSort implements ISort {

	/** 
	 * Description:�鲢�����㷨�����Ӷ�O(nlogn)~O(n^2),�ȶ���
	 * @author caigen       
	 * @created 2015��5��14�� ����10:35:17      
	 * @param a     
	 * @see algorithm.sorting.ISort#sort(int[])     
	 */

	@Override
	public void sort(int[] a) {
		if(a==null||a.length<=1)
			return;
		int begin=0,end=a.length-1;
		int[] b=new int[a.length];
		mergeSort(a,b,begin,end);
	}
	/**     
	 * Description: �ݹ���ý��з���	
	 * @param a  Ҫ���������	
	 * @param b	 ��������
	 * @param begin  �����鿪ʼ
	 * @param end    �������β 
	 */
	private void mergeSort(int[] a, int[] b,int begin, int end) {
		if(begin>=end)
			return;
		int mid=(begin+end)/2;
		mergeSort(a,b,begin,mid);
		mergeSort(a,b,mid+1,end);
		merge(a,b,begin,mid,end);
	}
	/**     
	 * Description: ���ø�������ϲ�����������
	 * @param a  Ҫ���������	
	 * @param b	 ��������
	 * @param begin  ��һ�������鿪ʼ
	 * @param mid	��һ���������β
	 * @param end    �ڶ����������β
	 */
	private void merge(int[] a, int[] b,int begin, int mid, int end) {
		if(begin>=end)
			return;
		int i=begin,j=mid+1,k=begin;
		while(i<=mid&&j<=end){
			if(a[i]<=a[j]){
				b[k++]=a[i++];
			}
			else if(a[i]>a[j]){
				b[k++]=a[j++];
			}
		}
		while(i<=mid)
			b[k++]=a[i++];
		while(j<=end)
			b[k++]=a[j++];
		for(int m=begin;m<=end;m++){
			a[m]=b[m];
		}
	}

}
