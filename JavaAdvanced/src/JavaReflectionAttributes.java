import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class JavaReflectionAttributes {

	public static void main(String[] args) throws ClassNotFoundException {
		Class student = Class.forName("Student");
		Method[] methods = student.getDeclaredMethods();

		ArrayList<String> methodList = new ArrayList<String>();
		for (Method met : methods) {
			methodList.add(met.getName());
		}
		Collections.sort(methodList);
		for (String name : methodList) {
			System.out.println(name);
		}

	}

}

class Student {
	private String name;
	private String id;
	private String email;

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void anothermethod() {

	}

}