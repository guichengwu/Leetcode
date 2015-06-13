package BitOperation;

public class BitWise {
    public static int rangeBitwiseAnd(int m, int n) {
    	
    	int i = 0;
    	while ( m != n) {
    		m >>= 1;
    		n >>= 1;
    		i++;
    	}
    	
    	return m << i;
        
    }
    
    public static void main(String[] args) {
    	System.out.println(rangeBitwiseAnd(86, 100));
    }

}
