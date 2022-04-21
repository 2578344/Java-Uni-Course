package priority_queue;



public class HeapMinQueue {
    private int[] heap;
    private int heapSize;
    private int size;
    
    public HeapMinQueue(int size){
        this.size = size;
        this.heap = new int[size];
        this.heapSize = 0;
    }
    
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private int left(int i){
        return (2* i) +1;
    }
    
    private int right(int i){
        return (2* i) +2;
    } 
    
    private int parent(int i){
        return (i-1)/2;
    }
    
    private void minHeapify(int arr[],int i){
        int l = left(i);
        int r = right(i);
        int smallest = i;
        int parent = this.parent(i);
        if (l < this.heapSize && arr[l] < arr[parent]){
            smallest = l;
        }
        else if (r < this.heapSize && arr[r] < arr[smallest] ) {
            smallest = r;
        }
        if (smallest != i){
            swap(arr,i,smallest);
            minHeapify(arr,smallest);
        }
    }
    
    public int Min(){
        return this.heap[0];
    }
    
    public int extractMin(){
        if(heapSize-1 < 0){
            System.out.println("Underflow");
            return -1;
        }
        int ele = this.heap[0];
        this.heap[0] = this.heap[this.heapSize-1];
        this.heapSize --;
        minHeapify(this.heap,0);
        return ele;
        
    }
    
    
 public void insert(int val) {
     if(this.heapSize-1 == size){
         System.out.println("Overflow");
         return;
     }
     this.heapSize ++;
     this.heap[this.heapSize-1] = val;
     buildHeap(this.heap);
     
 }       
    
     public void print(){
         for (int i = 0; i < heapSize; i ++){
         System.out.println(heap[i]);}        
     }  
   
 private void buildHeap(int arr[]) 
    {

	for (int i = this.heapSize; i >= 0; i--) { 
		minHeapify(arr, i); 
	    } 
 }   
   
   
     
}
