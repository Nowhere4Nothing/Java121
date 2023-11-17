import java.math.BigInteger;
import java.sql.Timestamp;

public class testRecursive_2 {
	private static int callTimes;
	private static BigInteger TWO = BigInteger.valueOf(2);
	
	public long fibinacci_loop(long n) {
		long res = 0;
		long a = 0, b =1;
		for(int i = 2; i <= n; i++) {
			res = a + b;
			a = b;
			b = res;
		}
		
		return res;
	}
	
	public long fibonacci(long n) {
		//System.out.println("+++Stack order " + (++callTimes) + ": calling fibonacci(" + n + ")");
		if(n <= 1) {
			//System.out.println("---Stack order " + (callTimes--) + ": return fibonacci(" + n + ")");
			return n;
		}
		else {
			//System.out.println("...Stack order " + (callTimes) + ": executing fibonacci(" + (n-1) + ") + fibonacci(" + (n-2) + ")");

			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
	
	public BigInteger fibonacci(BigInteger num) {
		if(num.equals(BigInteger.ZERO) || num.equals(BigInteger.ONE))
			return num;
		else
			return fibonacci(num.subtract(BigInteger.ONE)).add(fibonacci(num.subtract(TWO)));
	}

	
	public static void main(String[] args) {
		//System.out.println("Length=" + args.length);
		
		if(args.length != 1) {
			System.out.println("Usage: java testRecursive_1 number");
		}
		else {
			long n = Long.parseLong(args[0]);
			BigInteger num = BigInteger.valueOf(n);
			if(n >= 0) { //n! when n>=0
				testRecursive_2 ts = new testRecursive_2();
				Long datetime = System.currentTimeMillis();
				Timestamp timestamp = new Timestamp(datetime);
				System.out.println("Before fibonacci(long), time stamp: " + timestamp);
				System.out.printf("fibonacci of %d = %d\n", n, ts.fibonacci(n));
				
				datetime = System.currentTimeMillis();
				timestamp = new Timestamp(datetime);
				
				System.out.println("Before fibonacci(loop), time stamp: " + timestamp);
				System.out.printf("fibonacci of %d = %d\n", n, ts.fibonacci_loop(n));
				
				datetime = System.currentTimeMillis();
				timestamp = new Timestamp(datetime);
				System.out.println("After fibonacci(loop), time stamp: " + timestamp);
				
				/*
				System.out.println("Before fibonacci(BigInteger), time stamp: " + timestamp);
				
				System.out.printf("fibonacci of %d = %d\n", n, ts.fibonacci(num));

				datetime = System.currentTimeMillis();
				timestamp = new Timestamp(datetime);
				System.out.println("After fibonacci(BigInteger), time stamp: " + timestamp);
				*/
			} //n < 0
			else {
				System.out.printf("Cannot calculate its fibonacci when n=%d < 0.\n", n);
			}
		}
	}
}