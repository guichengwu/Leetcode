package Array;

public class CountPrimes {
	 public static int countPrimes(int n) {
	        boolean[] primes = new boolean[n];
	        for (int i = 0; i < primes.length; i++) {
	        	primes[i] = true;
	        }
	        
	        for (int i = 2; i < n; i++) {
	        	int k = 2;
	        	int num = k * i;
	        	while(num < n) {
	        		primes[num] = false;
	        		k++;
	        		num = k * i;
	        	}
	        }
	        
	        int count = 0;
	        for (int i = 2; i < primes.length; i++) {
	        	if (primes[i] == true) {
	        		count++;
	        	}
	        }
	        
	        return count;
	    }
    
    public static void main(String[] args) {
    	System.out.println(countPrimes(49979));
    }
}
