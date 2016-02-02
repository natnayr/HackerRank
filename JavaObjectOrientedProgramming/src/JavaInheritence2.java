
public class JavaInheritence2 {
	public static void main(String[] argh) {
		Adder X = new Adder();
		System.out.println("My superclass is: " + X.getClass().getSuperclass().getName());
		System.out.print(X.add(10, 32) + " " + X.add(10, 3) + " " + X.add(10, 10) + "\n");

	}
}

class Adder extends Arithmetic {

}

class Arithmetic {
	public static int add(int i, int j) {
		return i + j;
	}
}