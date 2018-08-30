package lamdas;

import java.math.BigInteger;
import java.util.function.*;

@FunctionalInterface
interface GreetingFunction {
	// only one abstratc method
	void sayMessage(String Message);

	default void fun() {
		//
	}

}

public class LambdaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GreetingFunction greeting = msg -> System.out.println("greeting lambda: " + msg);

		greeting.sayMessage("Yoyo");
		methodsAsLambdas();
	}

	public static void methodsAsLambdas() {
		IntFunction<String> intToString = num -> Integer.toString(num);
		System.out.println("expected value 3, actual value: " + intToString.apply(123).length());

		// static method reference using ::
		IntFunction<String> intToString2 = Integer::toString;
		System.out.println("expected value 4, actual value:  " + intToString2.apply(4567).length());

		// lambdas made using a constructor
		Function<String, BigInteger> newBigInt = BigInteger::new;
		System.out.println("expected value: 123456789, actual value: " + newBigInt.apply("123456789"));

		// example of a lambda made from an instance method
		Consumer<String> print = System.out::println;
		print.accept("Coming to you directly from a lambda...");

		// these two are the same using the static method concat
		UnaryOperator<String> greeting = x -> "Hello, ".concat(x);
		System.out.println(greeting.apply("World"));

		UnaryOperator<String> makeGreeting = "Hello, "::concat;
		System.out.println(makeGreeting.apply("Peggy"));
	}

}
