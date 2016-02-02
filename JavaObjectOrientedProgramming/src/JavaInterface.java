import java.util.Scanner;

public class JavaInterface {

	public static void main(String[] args) {
		MyCalculator my_calculator = new MyCalculator();
		System.out.print("I implemented: ");
		ImplementedInterfaceNames(my_calculator);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(my_calculator.divisorSum(n) + "\n");
	}

	static void ImplementedInterfaceNames(Object o) {

		Class[] theInterfaces = o.getClass().getInterfaces();
		for (int i = 0; i < theInterfaces.length; i++) {
			String interfaceName = theInterfaces[i].getName();
			System.out.println(interfaceName);
		}
	}
}

class MyCalculator implements AdvancedArithmetic {

	@Override
	public int divisorSum(int n) {

		int totals = 0;
		for (int i = n; i > 0; i--) {
			if (n % i == 0) {
				totals += i;
			}
		}
		return totals;
	}

}

interface AdvancedArithmetic {
	public abstract int divisorSum(int n);
}