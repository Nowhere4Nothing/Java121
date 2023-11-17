public class testPrecedence {
	public static void main(String[] args) {
		System.out.println((15-6) * (3+11));
		int day = 3;
		System.out.println((float)++day * 2.5);

		int r=2;

		r *= 15 - day + 5;
		System.out.println(r);
		int b = 1, c=2;
		r += b = c;
		System.out.println(r);
		boolean f = true;
		//r = (int)f;
		//System.out.println(r);
	}
}