package priority_queue;

public class Cost {
    public static int calculateCost(BSTMinQueue T){
        int cost = 0;
        
        while(T.size > 1){
            int x = T.extractMin();
            int y = T.extractMin();
            cost += x+y;
            T.insert(x+y);
        }
        return cost;
    } 
}
