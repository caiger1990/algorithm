package algorithm.sorting;

/**        
 * Title: heapSort.java    
 * Description: 
 * @author caigen       
 * @created 2015��5��15�� ����8:52:22    
 */

public class HeapSort implements ISort 
{

	/** 
	 * Description:�������㷨�������ɶ�O(logn	),��ʱ�临�Ӷ�O(nlogn)
	 * @author caigen       
	 * @created 2015��5��15�� ����8:52:22      
	 * @param a     
	 * @see algorithm.sorting.ISort#sort(int[])     
	 */

	@Override
	//������ȫ������
	//��n��Ԫ�ص����鿴�ɶѵĲ��������i��Ԫ����һ�����ʣ�
	//i=0����iΪ���ڵ㣻
	//��2i+1<n����2i+1Ϊ�������ӣ���2i+2<n����Ϊi���Һ���
	//���ĸ��ڵ�Ϊ(i-1)/2
	public void sort(int[] a) {
		if(a==null||a.length<=1)
			return;
		//�Ȱ������ų����ѣ������һ��Ԫ��n-1�ĸ��ڵ㣨����������������ʼ���Ӻ���ǰ�������еķ���Ƚڵ��ų�����
		int n=a.length;
		for(int i=(n-1-1)/2;i>=0;i--)
			sift(a,i,n-1);
		//ÿ��ȥ����һ������Ԫ�ط���ĩβ��Ȼ���ʣ�µ�Ԫ�����ų�����
		for(int j=n-1;j>0;j--){
			int temp=a[0];
			a[0]=a[j];
			a[j]=temp;
			sift(a, 0, j-1);
		}
	}

	/**     
	 * Description: �����ڵ�Ϊbegin���������ų����ѣ����ڵ�ΪҪ�����Ԫ��
	 * @param a Ҫ���������
	 * @param begin ����Ҫ�����Ԫ�أ�Ϊ�����ĸ��ڵ�
	 * @param end   �ѵ����һ��Ԫ��
	 */
	private void sift(int[] a, int begin, int end){
		int i=begin,j=2*i+1;
		int temp=a[i];
		while(j<=end){
			//�Ƚ����ҽ���С����֤ƽ����
			if(j<end&&a[j]<a[j+1]){
				j++;
			}
			if(temp<a[j]){
				a[i]=a[j];
				//������Ԫ�ص���λ��j
				i=j;
				j=2*j+1;
			}
			else break;
		}
		a[i]=temp;
	}
	
}
