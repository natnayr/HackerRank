import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaTryCatch {

	public static void main(String[] args) {
		Scanner in;

		try {

			in = new Scanner(System.in);
			int[] arr = new int[2];
			for (int i = 0; i < arr.length; i++) {

				if (!in.hasNext("[0-9]+")) {
					throw new InputMismatchException();
				}

				arr[i] = in.nextInt();
			}

			System.out.println(arr[0] / arr[1]);

			in.close();

		} catch (InputMismatchException e) {
			System.out.println(e.getClass().getName());
		} catch (ArithmeticException e) {
			System.out.println(e.getClass().getName() + ": / by zero");
		}

	}

}
