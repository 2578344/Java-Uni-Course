package ae1;

public class Part1 {

    public static void swap(Integer[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void quickSort(Integer[] A, int p, int r){
        if (p < r){
   
            int q = partition(A,p,r);
            
            quickSort(A, p, q-1);
            quickSort(A, q+1, r); 
        }
    }
    public static int partition(Integer[] A, int p, int r){
        int x = A[r];
        int i = p-1;
        for(int j = p; j <= r; j++){
            if (A[j] < x){
                i++;
                swap(A,i,j);
            }
        }
        swap(A,i+1,r);
    return (i+1);
    }
	public static void insertionSort(Integer[] A,int p, int r) {
		for (int j = p+1; j <= r; j++) {
			int key = A[j];
			int i = j-1;
			while(i >= 0 && A[i] > key) {
				A[i+1] = A[i];
				i = i-1;
			}
			A[i+1] = key;
		}
		
	}
    public static void quickSortCutoff(Integer[] A, int p, int r){
        if (p < r){
            if(r - p < 10){
                insertionSort(A,p,r);
                return;
            }
            else{
            int q = partition(A,p,r);
            
            quickSortCutoff(A, p, q-1);
            quickSortCutoff(A, q+1, r); }
        }
    }
    public static void getMedian(Integer[] A, int p, int r){
        int mid = (p + r)/2;
        if(A[mid] < A[p]){
            swap(A, p, mid);
        }
        else if(A[r] < A[p]){
            swap(A, p, r);
        }
        else if(A[mid] < A[r]){
            swap(A, mid, r);
        }
    }
    public static void quickSortMedian(Integer[] A, int p, int r){
        if (p >= r){
            return;}
        else{
            getMedian(A, p, r);
            int partition = partition(A,p,r);
            
            quickSortMedian(A, p, partition-1);
            quickSortMedian(A, partition+1, r);}
        
    }
    public static void quickSort3Way(Integer[] A, int p, int r){
        if (p >= r){
            return;}
 
        
            int pi[] = partition3Way(A,p,r);
            
            quickSort3Way(A, p, pi[0]-1);
            quickSort3Way(A, pi[1]+1, r); 
        
    }
    public static int[] partition3Way(Integer[] A, int p, int r){
        int pi = A[p];
        int mid = p;
        int start = p;
        int end = r;
        
        while(mid <= end){
            if(A[mid] < pi){
                swap(A,mid,start);
                start++;
                mid++;
            }
            else if(A[mid] > pi){
                swap(A,mid,end);
                end--;
            }
            else{
                mid++;
            }
        }
        int[] result = {start,end};
    return result;
    }
}
