import java.util.Scanner;

public class ThriceTurn {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		
		for (int i = 0; i <= 1000; i++) {
			int diceOne = 0;
			int diceTwo = 1;
			int diceThree = 2;
			int firstTripletWorth = 0;
			int rollNum = 1;
			int tally = 0;
			while (diceOne != diceTwo || diceTwo != diceThree || diceOne != diceThree) {

				diceOne = (int)((Math.random() * 6) + 1);
				System.out.println("Dice one: " + diceOne);
				diceTwo = (int)((Math.random() * 6) + 1);
				System.out.println("Dice two: " + diceTwo);
				diceThree = (int)((Math.random() * 6) + 1);
				System.out.println("Dice three: " + diceThree);
				int value = diceOne + diceTwo + diceThree;

				if (diceOne == diceTwo && diceTwo == diceThree && diceOne == diceThree) {
					firstTripletWorth = value;
				}
				if (rollNum % 3 == 0) {
					tally -= value;
				} else {
					tally += value;
				}
				

				rollNum++;
				System.out.println("Tally: " + tally);

			}
			System.out.println("Triplet Worth: " + firstTripletWorth + "\n");

			for (int i = 0; i <= firstTripletWorth; i++) {
				diceOne = (int)((Math.random() * 6) + 1);
				System.out.println("Dice one: " + diceOne);
				diceTwo = (int)((Math.random() * 6) + 1);
				System.out.println("Dice two: " + diceTwo);
				diceThree = (int)((Math.random() * 6) + 1);
				System.out.println("Dice three: " + diceThree);
				int value = diceOne * diceTwo * diceThree;

				tally += value;
				System.out.println("Tally: " + tally);
			}

			System.out.println("Roll or Retire: ");
			String gamble = scan.nextLine();

			int finalTally = 0;
			int secondTripletWorth = 0;
			rollNum = 0;
			if (gamble.equals("Roll") || gamble.equals("roll")) {
				while (diceOne != diceTwo || diceTwo != diceThree || diceOne != diceThree) {
					tally += Math.pow(3, rollNum);

					diceOne = (int)((Math.random() * 6) + 1);
					System.out.println("Dice one: " + diceOne);
					diceTwo = (int)((Math.random() * 6) + 1);
					System.out.println("Dice two: " + diceTwo);
					diceThree = (int)((Math.random() * 6) + 1);
					System.out.println("Dice three: " + diceThree);
					int value = diceOne + diceTwo + diceThree;

					if (diceOne == diceTwo && diceTwo == diceThree && diceOne == diceThree) {
						secondTripletWorth = value;
						if (secondTripletWorth == firstTripletWorth) {
							finalTally = tally * 3;
						} else {
							finalTally = secondTripletWorth;
						}
					} 

					rollNum++;
				}
			} else if (gamble.equals("Retire") || gamble.equals("retire")) {
				finalTally = tally;
			}
			
			System.out.println("Final Tally: " + finalTally);
		}
	}

}