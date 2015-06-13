package DynamicProgramming;

import java.math.BigInteger;
import java.util.ArrayList;

public class UniquePath62 {

	public int uniquePaths(int m, int n) {

		return (bigNumber(m + n - 2).divide(bigNumber(m - 1))).divide(bigNumber(n - 1))
				.intValue();

	}
	
    
	public int[][] map;
	
	public int uniquePaths2(int m, int n) {
		
		map = new int[m+1][n+1];
		return getPath2(m, n);
	}
	public int getPath2(int m, int n) {
		if (m == 1 || n== 1) {
			return 1;
		}
		
		if (map[m][n] != 0)
			return map[m][n];
		
		int s = getPath2(m-1, n) + getPath2(m ,n - 1);
		map[m][n] = s;
		return s;
	}

	public synchronized BigInteger bigNumber(int num) {// 利用BigInteger类计算阶乘

		ArrayList<BigInteger> list = new ArrayList<BigInteger>();// 创建集合数组
		list.add(BigInteger.valueOf(1));// 往数组里添加一个数值
		for (int i = list.size(); i <= num; i++) {
			BigInteger firstfact = (BigInteger) list.get(i - 1); // 获得第一个元素
			BigInteger nextfact = firstfact.multiply(BigInteger.valueOf(i));// 获得下一个数组
			// System.out.println("nextfact:" + nextfact);
			list.add(nextfact);
		}
		return list.get(num);// 返回数组中的下标为num的值
	}

	public static void main(String[] args) {
		UniquePath62 path = new UniquePath62();
		System.out.println(path.uniquePaths(23, 12));
	}

}
