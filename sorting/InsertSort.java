package algorithm.sorting;

/**        
 * Title: InsertSort.java    
 * Description: 
 * @author caigen       
 * @created 2015��5��14�� ����8:02:40    
 */

public class InsertSort implements ISort{
	/** 
	 * Description:ֱ�Ӳ��������㷨�����Ӷ�O(n^2)��
	 * @author caigen       
	 * @created 2015��5��14�� ����8:38:25      
	 * @param a     
	 * @see algorithm.sorting.ISort#sort(int[])     
	 */  
	    
	public void sort(int[] a) {
		// TODO Auto-generated method stub
		if(a==null||a.length<=1)
			return;
		//ѭ��n-1��
		for(int i=1;i<a.length;i++){
			insert(a, 0, i-1, i);
//			int temp=a[i];
//			int j=i-1;
//			while(j>=0&&temp<a[j]){
//				a[j+1]=a[j];
//				j--;
//			}
//			a[j+1]=temp;
		}
	}
	
	/**     
	 * Description: �ö��ֲ��ҵķ�ʽ��������õ�ǰ�������в��������Ԫ��
	 * @param a Ҫ���������
	 * @param begin ����ò��ֵĿ�ʼ����0��ʼ
	 * @param end ����ò��ֵĽ�β��ΪҪ����Ԫ�ص�ǰһ��
	 * @param target Ҫ����Ԫ�ص�����
	 */
	private void insert(int[] a,int begin,int end,int target){
		while(begin<end){
			int mid=(begin+end)/2;
			if(a[mid]<=a[target])
				begin=mid+1;
			else if(a[mid]>a[target])
				end=mid;
		}
		//�洢Ҫ�����Ԫ��
		int temp=a[target];
		//�Ƚ����һ��Ԫ�أ�ȷ��Ҫ����Ԫ�ص�λ��
		if(a[end]<=a[target])
			end++;
		//������λ�ÿ�ʼ��Ԫ����������ƶ�һλ
		for(int j=target;j>end;j--){
			a[j]=a[j-1];
		}
		a[end]=temp;
	}

}
