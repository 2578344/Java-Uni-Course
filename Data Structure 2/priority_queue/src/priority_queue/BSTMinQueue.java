package priority_queue;



public class BSTMinQueue {

    private Node root;
    //• INSERT(Q,x): insert the element x into the queue Q.
    //• MIN(Q): returns the element of Q with the smallest key.
    //• EXTRACT-MIN (Q): removes and returns the element of Q with the smallest key.  
    public int size = 0;

    public  class Node
    {
    	private int key;
    	private Node left, right, p;
    
    	public Node(int key) {
    		this.key = key;
    		this.left = null;
    		this.right = null;
    		this.p = null;
    	}
    }
    
    public BSTMinQueue(){
        this.root = null;
    }
    
    private Node minimumBST(Node x){
        while (x.left != null){
            x = x.left;
        }
        return x;
    }
    
    public Node getRoot(){
        return this.root;
    }
    
    private void insertBST(Node z){
        this.size++;
        Node y = null;
        Node x = this.root;
        
        while(x != null){
            y = x;
            if (z.key < x.key){
                x = x.left;
            }
            else{
                x = x.right;
            }
        }
        z.p = y;
        if (y == null){
            this.root = z;
        }
        else if (z.key < y.key){
            y.left = z;
        }
        else {
            y.right = z;
        }
    }
    
	public void inOrder(Node root)
	{
		if (root == null) {
			//System.out.println("nothing here..");
			return;
		}

		inOrder(root.left);
		System.out.print(root.key + " ");
		inOrder(root.right);
	}
	
	private void transplant(Node u, Node v){
	    if(u.p == null){
	        this.root = v;
	    }
	    else if (u == u.p.left){
	        u.p.left = v;
	    }
	    else{
	        u.p.right = v;
	    }
	    if(v != null){
	        v.p = u.p;
	    }
	}
	
	private void delete(Node z){
	    size--;
	    if(z.left == null){
	        transplant(z,z.right);
	    }
	    else if (z.right == null){
	        transplant(z,z.left);
	    }
	    else {
	        Node y = minimumBST(z.right);
	        if(y.p != z){
	            transplant(y,y.right);
	            y.right = z.right;
	            y.right.p = y;
	        }
	        transplant(z,y);
	        y.left = z.left;
	        y.left.p = y;
	    }
	}
    //////////////////methods for queue
    public void min(){
        Node minVal = minimumBST(this.root);
        System.out.println(minVal.key);
    }
    
    public void insert(int key){
        Node z = new Node(key);
        insertBST(z);
    }
    
    public int extractMin(){
        Node minVal = minimumBST(this.root);
        delete(minVal);
        return minVal.key;
    }
    
 
}
