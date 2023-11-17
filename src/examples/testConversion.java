public class testConversion {
	public static void main(String[] args) {
		char c = 'A';
		int x = c;
		
		System.out.println(x);
		double d = c;
		System.out.println(d);
		
		//boolean b = true;
		//x = b;
		//System.out.println(x);
		
		long l = x;
		
		double f = 100.5;
		l = (long)f;
		
		char a = (char)(c+1);
		String s;
		s = c+c;
		System.out.println(s);
	}
}