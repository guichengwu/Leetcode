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

	public synchronized BigInteger bigNumber(int num) {// ����BigInteger�����׳�

		ArrayList<BigInteger> list = new ArrayList<BigInteger>();// ������������
		list.add(BigInteger.valueOf(1));// �����������һ����ֵ
		for (int i = list.size(); i <= num; i++) {
			BigInteger firstfact = (BigInteger) list.get(i - 1); // ��õ�һ��Ԫ��
			BigInteger nextfact = firstfact.multiply(BigInteger.valueOf(i));// �����һ������
			// System.out.println("nextfact:" + nextfact);
			list.add(nextfact);
		}
		return list.get(num);// ���������е��±�Ϊnum��ֵ
	}

	public static void main(String[] args) {
		UniquePath62 path = new UniquePath62();
		System.out.println(path.uniquePaths(23, 12));
	}

}
