package Math;

public class ReverseInt {
	public static int reverse(int x) {
        boolean positive = true;
        long result = 0;
        if (x < 0) {
            positive = false;
            x= (-1) * x;
        }
        
        while (x > 0) {
            int digit = x % 10;
            x = x / 10;
            

            result += digit;
            if (x > 0) {
                result = result * 10;
            }
        }
        if (result > Integer.MAX_VALUE)
            return 0;
        if (positive) {
        		return (int)result;
        } else {
            return (int)((-1) * result);
        }
    }
	
	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
		System.out.println(Integer.MAX_VALUE);
	}

}
