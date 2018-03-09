package java8learn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice {

	public static void main(String[] args) {
		List<Integer> number1 = Arrays.asList(1,2,3,4);
		List<Integer> number2 = Arrays.asList(7,8);
		
		List<int []> result = number1.stream().flatMap(i -> {
             return number2.stream().map(j -> new int[] {i, j});
		}).filter(i -> (i[0] + i[1]) % 3 == 0).collect(Collectors.toList());
		
		result.stream().map((int[] i) -> "(" + i[0] + "," + i[1] + ")").forEach(System.out::println);

	}
}
