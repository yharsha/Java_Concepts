package semaphore_12;





/**
class Person {
	public void talk() {
		System.out.print("I am a Person ");
	}
}

class Student extends Person {
	public void talk() {
		System.out.print("I am a Student ");
	}
}

public class TestClass {
	public static void main(String args[]) {
		Person p = new Student();
		p.talk();
	}
}
**/
/**
 * class A { final public int GetResult(int a, int b) { return 0; } }
 * 
 * class B extends A { public int GetResult(int a, int b) { return 1; } }
 * 
 * public class TestClass { public static void main(String args[]) { B b = new
 * B(); System.out.println("x = " + b.GetResult(0, 1)); } }
 **/

/**
 * public class TestClass { static String value = "testify"; static int value1 =
 * 25;
 * 
 * static { value1 = 50; System.out.println(value); System.out.println(value1);
 * }
 * 
 * public static void main(String args[]) { }
 * 
 * }
 **/
/**
 * class A1 { public int i; protected int j; }
 * 
 * class B2 extends A1 { int j;
 * 
 * void display() { super.j = 3; super.i = 10; System.out.println(i + " " + j);
 * } }
 * 
 * public class TestClass {
 * 
 * public static void main(String args[]) {
 * 
 * B2 obj = new B2(); obj.i = 1; obj.j = 2; obj.display(); } }
 **/