
public class JavaInheritance1 {

	public static void main(String[] args) {
		Man man = new Man();
		man.walk();
		man.fly();
		man.sing();

	}

}

class Animal {
	void walk() {
		System.out.println("I am walking");
	}
}

class Bird extends Animal {
	void fly() {
		System.out.println("I am flying");
	}
}

class Man extends Bird {
	void sing() {
		System.out.println("I am singing");
	}
}