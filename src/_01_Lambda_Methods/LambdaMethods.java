package _01_Lambda_Methods;

import java.util.List;
import java.util.Arrays;

public class LambdaMethods {
	public static void main(String[] args) {
		// 1. Look at the SpecialPrinter function interface.
	
		// Here is an example of calling the printCustomMessage method with a lambda.
		// This prints the passed string 10 times.
		printCustomMessage((s)->{
			for(int i = 0; i < 10; i++) {
				System.out.println(s);
			}
		}, "repeat");
		
		//2. Call the printCustomMessage method using a lambda so that the String prints backwards.
		printCustomMessage((s) -> {
			String backwards = "";
			for (int i = s.length() - 1; i >= 0; i--) {
				backwards += String.valueOf(s.charAt(i));
			}
			System.out.println(backwards);
		}, "sdrawkcab");
		
		//3. Call the printCustomMessage method using a lambda so that the String prints with a mix between upper an lower case characters.
		printCustomMessage((s) -> {
			String output = "";
			String u = s.toUpperCase();
			String l = s.toLowerCase();
			int length = s.length();
			for (int i = 0; i < length; i++) {
				output += String.valueOf(u.charAt(i)) + String.valueOf(l.charAt(i));
			}
			System.out.println(output);
		}, "Hallo24");
		
		//4. Call the printCustomMessage method using a lambda so that the String prints with a period in between each character.
		printCustomMessage((s) -> {
			String blocky = "";
			int length = s.length();
			for (int i = 0; i < length; i++) {
				blocky += String.valueOf(s.charAt(i)) + (i == length - 1 ? "" : ".");
			}
			System.out.println(blocky);
		}, "It's hard to speak");
		
		//5. Call the printCustomMessage method using a lambda so that the String prints without any vowels.
		printCustomMessage((s) -> {
			String copy = new String(s);
			List<Character> vowels = Arrays.asList(new Character[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'});
			int length = copy.length();
			for (int i = length - 1; i >= 0; i--) {
				if (vowels.contains(copy.charAt(i))) copy = copy.substring(0, i) + copy.substring(i + 1);
			}
			System.out.println(copy);
		}, "Acacia");
	}

	public static void printCustomMessage(SpecialPrinter sp, String value) {
		sp.printSpecial(value);
	}
}
	
