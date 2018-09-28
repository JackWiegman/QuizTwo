import java.util.Scanner;

public class CeasarCipher {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Message: ");
		String message = scan.nextLine();
		System.out.println("Code word: ");
		String codeWord = scan.nextLine();

		int messageLength = message.length();
		int codeLength = codeWord.length();
		int codeRepeatNum = messageLength / codeLength;
		int codeRepeatRemainder = messageLength % codeLength;

		String codeInMessage = "";
		for (int i = 0; i <= codeRepeatNum; i++) {
			if (i == codeRepeatNum) {
				codeInMessage = codeInMessage + codeWord.substring(0, codeRepeatRemainder);
			} else {
				codeInMessage = codeInMessage + codeWord;
			}
		}
		
		String finalMessage = "";
		for (int i = 0; i < codeInMessage.length(); i++) {
			char codeMessageLetter = codeInMessage.charAt(i);
			int codeMessageLetterValue = (int) codeMessageLetter;
			int codeMessageLetterShiftValue = codeMessageLetterValue - 96;
			char messageLetter = message.charAt(i);
			int messageLetterValue = (int) messageLetter;

			int finalLetterValue = messageLetterValue + codeMessageLetterShiftValue;
			if (finalLetterValue > 122) {
				finalLetterValue = (finalLetterValue - 122) + 97;
			}
			finalMessage = finalMessage + ((char)finalLetterValue);
		}
		
		System.out.println("Encrypted Message: " + finalMessage);
	}

}