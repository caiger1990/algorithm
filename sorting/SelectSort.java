package algorithm.sorting;

/**        
 * Title: SelectSort.java    
 * Description: 
 * @author caigen       
 * @created 2015��5��14�� ����9:39:54    
 */

public class SelectSort implements ISort {

	/** 
	 * Description:ֱ��ѡ�����򣬸��Ӷ�O(n^2),���ȶ�
	 * @author caigen       
	 * @created 2015��5��14�� ����9:39:54      
	 * @param a     
	 * @see algorithm.sorting.ISort#sort(int[])     
	 */

	@Override
	public void sort(int[] a) {
		if(a==null||a.length<=1)
			return;
		//ѭ��n-1��
		for(int i=0;i<a.length-1;i++)
		{
			int min=i;
			//�ҳ���Сֵ������
			for(int j=i+1;j<a.length;j++){
				if(a[min]>a[j])
					min=j;
			}
			//�����������λ��
			int temp=a[i];
			a[i]=a[min];
			a[min]=temp;
		}
	}

}
