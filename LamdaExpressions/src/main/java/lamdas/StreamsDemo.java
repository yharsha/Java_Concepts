package lamdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class StreamsDemo {

	public static void main(String[] args) {

		Arrays.asList("red", "green", "blue").stream().sorted().findFirst().ifPresent(System.out::println);
		Stream.of("apple", "pear", "banana", "cherry", "apricot").filter(fruit -> {
			return fruit.startsWith("a");
		}).forEach(fruit -> System.out.println("Starts with A: " + fruit));

		List<String> collected = Stream.of("Java", " Rocks").map(string -> string.toUpperCase()).collect(toList());
		System.out.println(collected.toString());

	}

}
