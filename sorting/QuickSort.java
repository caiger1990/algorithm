package algorithm.sorting;

public class QuickSort implements ISort {
	public QuickSort() {
		// TODO Auto-generated constructor stub
	}
	/** 
	 * Description:���������㷨��ʱ�临�Ӷ�O(nlogn)
	 * @author caigen       
	 * @created 2015��5��14�� ����8:39:52      
	 * @param a     
	 * @see algorithm.sorting.ISort#sort(int[])     
	 */  
	    
	@Override
	public void sort(int[] a) {
		// TODO Auto-generated method stub
		if(a==null||a.length<=1)
			return;
		int begin=0,end=a.length-1;
		quickSort(a, begin, end);
	}
	/**     
	 * Description: 
	 * @param a Ҫ���������
	 * @param begin
	 * @param end     
	 */
	private void quickSort(int[] A,int begin, int end){
		if(begin>=end)
			return;
		int index=partition(A,begin,end);
		//�ݹ���ã�ÿ�ν���partitionʱ��begin��end���ڸ���
		quickSort(A,begin,index-1);
		quickSort(A,index+1,end);
	}
/**     
	 * Description: �ҵ�����Ϊbegin��Ԫ��������A������ú��λ��
	 * @param A	Ŀ������
	 * @param begin	��ʼ���±�
	 * @param end	�������±�
	 * @return  ����begin��Ӧ������Ԫ��������λ��
	 */
	private int partition(int[] a, int begin, int end) {
		int temp=a[begin];
		//˫ָ����ȷ��temp������λ��
		while(begin<end){
			while(begin<end&&temp<a[end])//ȡ<������
				end--;
			a[begin]=a[end];
			while(begin<end&&temp>=a[begin])//<=������
				begin++;
			a[end]=a[begin];
		}
		a[begin]=temp;
		return begin;
	}
	@SuppressWarnings("unused")
	private  void quickSort1(int[] A, int begin, int end) {
		if(begin>=end)
			return;
		//�洢�������Ĳ���
		int i=begin,j=end,temp=A[i];
		while(i<j){
			while(temp<=A[j]&&i<j){
				j--;
			}
			//������һ��������ѭ��ʱ��Ҫ�ж�����һ������
			//if(i<j){
				//swap(A,i,j);
				A[i]=A[j];
				//i++;
			//}
			while(temp>=A[i]&&i<j){
				i++;
			}
			//if(i<j){
				//swap(A,i,j);
				A[j]=A[i];
				//j--;
			//}
		}
		A[i]=temp;
		quickSort1(A,begin,i-1);
		quickSort1(A,i+1,end);
		return;
	}
	@SuppressWarnings("unused")
	private static void swap(int[] A,int a,int b){
		A[a]=A[a]^A[b];
		A[b]=A[a]^A[b];
		A[a]=A[a]^A[b];
	}
}
