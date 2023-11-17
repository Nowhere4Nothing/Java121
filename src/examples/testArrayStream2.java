//Created by T. Xia

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;


public class testArrayStream2 {
	public static void main(String[] args) {
		String[] data={"Red", "Blue", "Green", "Yellow", "Orange", "Grey"};
		
		System.out.printf("Original: %s\n", Arrays.asList(data));
		
		System.out.printf("Uppercase: %s\n",
			Arrays.stream(data)
			.map(String::toUpperCase)
			.collect(Collectors.toList()));
		
		System.out.printf("Greater: %s\n",
			Arrays.stream(data)
			.map(String::toUpperCase)
			.filter(s->s.compareToIgnoreCase("N") > 0)
			.sorted(String.CASE_INSENSITIVE_ORDER)
			.collect(Collectors.toList()));
		
		System.out.printf("Greater: %s\n",
			Arrays.stream(data)
			.map(String::toUpperCase)
			.filter(s->s.compareToIgnoreCase("N") > 0)
			.sorted(String.CASE_INSENSITIVE_ORDER.reversed())
			.collect(Collectors.toList()));
		

	}
}