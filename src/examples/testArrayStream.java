//Created by T. Xia

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;


public class testArrayStream {
	public static void main(String[] args) {
		Integer[] data={3, 5, 1, 7, 2, 9, 6, 4, 8};
		
		System.out.printf("Sorted: %s\n", Arrays.stream(data)
			.sorted()
			.collect(Collectors.toList()));
		
		List<Integer> g3 = Arrays.stream(data)
				.filter(element -> element > 3)
				.collect(Collectors.toList());
		System.out.printf("Elements > 3: %s\n", g3);
		
		System.out.printf("Elements > 3 ordered in ascending: %s\n", g3.stream()
				.sorted()
				.collect(Collectors.toList()));
		
		int[] data2={6, 5, 3, 8, 7, 2};
		Arrays.stream(data2)
				.sorted()
				.forEach(element->System.out.printf("%d ", element));
		System.out.println();

		Integer[] data3={9, 8, 7, 6, 5, 4, 3, 2, 1};
		Arrays.stream(data3)
				.filter(element->element >= 2 && element <= 8)
				.sorted()
				.forEach(element->System.out.printf("%d ", element));
		System.out.println();

	}
}