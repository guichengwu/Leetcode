package BinarySearch;

public class MySqrt {
	
	 public static int mySqrt4(int x) {
	        if(x <= 0) return 0;
	        int l = 1, r = x, res = 1;
	        while(l < r) {
	            int mid = (l + r) / 2;
	            if(mid > x/mid) {
	                r = mid;
	            } else {
	                res = mid;
	                l = mid + 1;
	            }
	        }
	        return res;
	    }
	 
		public static int mySqrt3(int x) {
			if (x <= 0) {
				return 0;
			}	
			int l = 1;
			int r = x;
			int result = 1;
			int mid;
			while (l < r) {
			    mid = (l + r) / 2;
				if (mid > x / mid) {
					result = mid;
					r = mid;
				} else {
					result = mid;
					l = mid + 1;
				}
			}
			
			return result;
		}
    public static int mySqrt(int x) {
    	if (x == 0) {
    		return 0;
    	}
    	
    	int low = 0;
    	int high = x;
    	
    	double diff = 0.001;
    	while (low <= high) {
    		double mid = low + (high-low)/2;
    		double current = mid * mid;
    		if (Math.abs(current - x) <= diff) {
    			return (int)mid;
    		} else if (x >= current + diff){
    			low = (int)mid+1;
    		} else if (x <= current - diff) {
    			high = (int)mid-1;
    		}	
    	}
    	return high;
    	
    }
    
    public static int sqrt(int x) {
		double diff = 0.01;		// 误差
		int low = 0;
		int high = x;
		
		while(low <= high){
			// 注意越界！所以用double来存
			double mid = low + (high-low)/2;
			if(Math.abs(mid*mid-x) <= diff){
				return (int)mid;
			}else if(x > mid*mid+diff){
				low = (int)mid+1;
			}else if(x < mid*mid-diff){
				high = (int)mid-1;
			}
		}
		
		// 当找不到时候，这是low,high指针已经交叉，取较小的，即high
		return high;
	}

    
  
    
    public static void main(String[] args) {
    	System.out.println(mySqrt3(2147483647));
    	System.out.println(Math.sqrt(2147395599));
    }

}
