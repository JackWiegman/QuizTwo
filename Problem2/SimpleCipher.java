import java.util.Scanner;

public class SimpleCipher {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter message: ");
		String message = scan.nextLine();
		System.out.println("Shift amount: ");
		int shift = scan.nextInt();

		String chipherMessage = "";
		for (int i = 0; i < message.length(); i++) {
			char letter = message.charAt(i);
			int letterValue = (int) letter;
			int chipherValue = letterValue + shift;

			if (chipherValue > 122) {
				chipherValue = (chipherValue - 122) + 97;
			}
			 chipherMessage = chipherMessage + ((char)chipherValue);

		}
		System.out.println("Chiphered message: " + chipherMessage);


	}

}