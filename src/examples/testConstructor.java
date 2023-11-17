
class MyData {
	private	int data[];
/*	
	public MyData() {
		
	}
	
	public MyData(int len, int val) {
		data = new int[len];
		for(int i=0; i<len; i++)
			data[i] = val;
	}
*/	
	public void print() {
		if(data != null) {
			for(int i=0; i<data.length; i++)
				System.out.print(data[i] + " ");
			System.out.println();
		}
	}
}

public class testConstructor {
	public static void main(String[] args) {
		MyData d1 = new MyData();
		d1.print();
	}
}