package lamdas;

import java.util.function.*;

public class LamdaImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//examples of functional interfaces in java8

		Predicate<String> stringLen = (s) -> s.length() < 10;
		System.out.println(stringLen.test("global"));

		Consumer<String> consumerStr = (s) -> System.out.println(s.toLowerCase());
		consumerStr.accept("ADFDHFOJdsfkjdhshgfhdsLUO");

		Function<Integer, String> converter = (num) -> Integer.toString(num);
		System.out.println("len of 26:" + converter.apply(26).length());

		Supplier<String> s = () -> "Java is funn";
		System.out.println(s.get());
		
	      //Binary Operator example
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("add 10 + 25: " + add.apply(10, 25));
        
        //Unary Operator example
        UnaryOperator<String> str  = (msg)-> msg.toUpperCase();
        System.out.println(str.apply("This is my message in upper case"));
	}

}
