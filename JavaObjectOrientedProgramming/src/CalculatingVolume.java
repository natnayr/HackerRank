import java.io.IOException;
import java.security.Permission;
import java.util.Scanner;

public class CalculatingVolume {
	public static void main(String[] args) {
		Do_Not_Terminate.forbidExit();
		try {
			Calculate cal = new Calculate();
			int T = cal.getINTVal();
			while (T-- > 0) {
				double volume = 0.0d;
				int ch = cal.getINTVal();
				if (ch == 1) {

					int a = cal.getINTVal();
					volume = Calculate.get_Vol().main(a);

				} else if (ch == 2) {

					int l = cal.getINTVal();
					int b = cal.getINTVal();
					int h = cal.getINTVal();
					volume = Calculate.get_Vol().main(l, b, h);

				} else if (ch == 3) {

					double r = cal.getDoubleVal();
					volume = Calculate.get_Vol().main(r);

				} else if (ch == 4) {

					double r = cal.getDoubleVal();
					double h = cal.getDoubleVal();
					volume = Calculate.get_Vol().main(r, h);

				}
				cal.output.display(volume);
			}

		} catch (NumberFormatException e) {
			System.out.print(e);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Do_Not_Terminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}

	}
}

class Calculate {

	public Outputer output;
	public static Object obj;
	public Scanner in = new Scanner(System.in);

	public Calculate() {
		in = new Scanner(System.in);
	}

	public int getINTVal() throws IOException {
		int input = in.nextInt();
		if (input <= 0)
			throw new NumberFormatException("All the values must be positive");

		return input;
	}

	public double getDoubleVal() throws IOException {
		double input = in.nextDouble();
		if (input <= 0)
			throw new NumberFormatException("All the values must be positive");

		return input;
	}

	public static Volume get_Vol() {
		return new Volume();
	}

}

class Volume {
	Shape shape;

	public double main(int a) {
		shape = new Cube(a);
		return shape.getVolume();
	}

	public double main(int l, int b, int h) {
		shape = new Cuboid(l, b, h);
		return shape.getVolume();
	}

	public double main(double r) {
		shape = new Hemisphere(r);
		return shape.getVolume();
	}

	public double main(double r, double h) {
		shape = new Cylinder(r, h);
		return shape.getVolume();
	}

}

class Cube extends Shape {
	private double length;

	Cube(double length) {
		this.length = length;
	}

	@Override
	public double getVolume() {
		return Math.pow(length, 3);
	}
}

class Cuboid extends Shape {
	private int length;
	private int breath;
	private int height;

	Cuboid(int length, int breath, int height) {
		this.length = length;
		this.breath = breath;
		this.height = height;
	}

	@Override
	public double getVolume() {
		return length * breath * height;
	}
}

class Hemisphere extends Shape {

	public double radius;

	Hemisphere(double radius) {
		this.radius = radius;
	}

	@Override
	public double getVolume() {
		return Math.PI * Math.pow(radius, 3) * 4 / 3 / 2;
	}
}

class Cylinder extends Shape {
	public double radius;
	public double height;

	Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}

	@Override
	public double getVolume() {
		return Math.PI * Math.pow(radius, 2) * this.height;
	}
}

abstract class Shape {
	public abstract double getVolume();

}

class Outputer {
	public static void display(double number) {
		System.out.println(String.format("%.3f", number));
	}
}

class Do_Not_Terminate {

	public static class ExitTrappedException extends SecurityException {
	}

	public static void forbidExit() {
		final SecurityManager securityManager = new SecurityManager() {
			@Override
			public void checkPermission(Permission permission) {
				if (permission.getName().contains("exitVM")) {
					throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);
	}
}// end of Do_Not_Terminate