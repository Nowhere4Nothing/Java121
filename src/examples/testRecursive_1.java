public class testRecursive_1 {
	private static int callTimes;
	
	public long factorial_loop(long n) {
		long result = 1;
		for(long i=n; i>= 1; i--)
			result *= i;
		return result;
	}
	
	public long factorial(long n) {
		System.out.println("+++Stack order " + (++callTimes) + ": calling factorial(" + n + ")");
		if(n <= 1) {
			System.out.println("---Stack order " + (callTimes--) + ": return factorial(" + n + ")");
			return 1;
		}
		else {
			System.out.println("...Stack order " + (callTimes) + ": executing " + n + " * factorial(" + (n-1) + ")");
			long temp = factorial(n-1);
			System.out.println("---Stack order " + (callTimes--) + ": return factorial(" + n + " * factorial(" + (n-1) + ") = " + n + " * " + temp + " = " + (n * temp));
			return n * temp;
		}
	}

	
	public static void main(String[] args) {
		System.out.println("Length=" + args.length);
		
		if(args.length != 1) {
			System.out.println("Usage: java testRecursive_1 number");
		}
		else {
			long n = Long.parseLong(args[0]);
			if(n >= 0) { //n! when n>=0
				testRecursive_1 ts = new testRecursive_1();
				System.out.printf("Factorial of %d = %d\n", n, ts.factorial(n));
			} //n < 0
			else {
				System.out.printf("Cannot calculate its factorial when n=%d < 0.\n", n);
			}
		}
	}
}