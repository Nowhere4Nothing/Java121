//Created by T. Xia

import java.util.Arrays;
import java.util.stream.IntStream;


public class testIntStream {
	public static void main(String[] args) {
		int[] data={3, 5, 1, 7, 2, 9, 0};
		
		System.out.println("data=");
		IntStream.of(data).forEach(element->System.out.printf("%d ", element));
		System.out.println();
		
		System.out.printf("%nCount: %d%n", IntStream.of(data).count());
		
		System.out.printf("Min: %d\n", IntStream.of(data).min().getAsInt());

		System.out.printf("Max: %d\n", IntStream.of(data).max().getAsInt());

		System.out.printf("Sum: %d\n", IntStream.of(data).sum());
		
		System.out.printf("Average: %.2f\n", IntStream.of(data).average().getAsDouble());
		
		System.out.printf("Sum via reduce method: %d\n", IntStream.of(data).reduce(0, (x, y)-> x+ y));
		
		System.out.printf("Sum of squares via reduce method: %d\n", IntStream.of(data).reduce(0, (x, y)-> x+ y * y));

		System.out.printf("Product via reduce method: %d\n", IntStream.of(data).reduce(1, (x, y)-> x * y));
				
		System.out.printf("Even values displayed in sorted order: ");
		IntStream.of(data)
				.filter(element -> element % 2 == 0)
				.sorted()
				.forEach(element->System.out.printf("%d ", element));
		System.out.println();
				
		System.out.printf("Odd values multiplied by 10 displayed in sorted order: ");
		IntStream.of(data)
			.filter(element-> element % 2 != 0)
			.map(element->element * 10)
			.sorted()
			.forEach(element->System.out.printf("%d ", element));
		System.out.println();

		System.out.printf("Sum of integers from 1 to 9, exclusive: %d\n", IntStream.range(1,10).sum());
		
		System.out.printf("Sum of integers from 1 to 10, inclusive: %d\n", IntStream.rangeClosed(1,10).sum());
	}
}