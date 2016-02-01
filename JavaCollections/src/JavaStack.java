import java.util.LinkedList;
import java.util.Scanner;

public class JavaStack {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			LinkedList<Character> stack = new LinkedList<Character>();

			String line = in.nextLine();
			for (int i = 0; i < line.length(); i++) {
				char ch = line.charAt(i);
				if (stack.isEmpty() || ch == '{' || ch == '[' || ch == '(') {
					stack.push(ch);
				} else {

					switch (ch) {
					case '}':
						if (stack.peek() == '{') {
							stack.pop();
						}
						break;

					case ')':
						if (stack.peek() == '(') {
							stack.pop();
						}
						break;

					case ']':
						if (stack.peek() == '[') {
							stack.pop();
						}
						break;

					default:
						stack.push(ch);

					}
				}
			}

			System.out.println(stack.isEmpty());

		}

		in.close();
	}

}
