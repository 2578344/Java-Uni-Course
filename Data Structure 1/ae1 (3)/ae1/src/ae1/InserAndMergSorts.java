package ae1;

public class InserAndMergSorts {

	public static void insertionSort(Integer[] arr) {
		for (int j = 1; j < arr.length; j++) {
			int key = arr[j];
			int i = j-1;
			while(i >= 0 && arr[i] > key) {
				arr[i+1] = arr[i];
				i = i-1;
			}
			arr[i+1] = key;
		}
		
	}
    public static void mergeSort(Integer[] arr,int l, int r){
        if(l<r){
        int m = l+(r-l)/2;
        mergeSort(arr,l,m);
        mergeSort(arr,m+1,r);
        merge(arr,l,m,r); }
    }
    
    public static void merge(Integer[] arr, int l, int m, int r){
        //size of array
        int n1 = m-l+1;
        int n2 = r-m;
        
        //temp arrays
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        
        //copy elements
        for (int i = 0; i < n1; i++){
            arr1[i] = arr[l+i];
        }
        
        for (int i = 0; i < n2; i++){
            arr2[i] = arr[m+1+i];
        }
        
        int i = 0;
        int j = 0;
        
        //index of given array
        int k = 0;
        //merge arrays
        while(i < n1 && j < n2){
            if(arr1[i] <= arr2[j] ){
                arr[k] = arr1[i];
                i++;
            }
            else{
                arr[k] = arr2[j];
                j++;
            }
        }
        
        //if something has been left
        while(i < n1){
            arr[k] = arr1[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = arr2[j];
            j++;
            k++;
        }        
    }
}
