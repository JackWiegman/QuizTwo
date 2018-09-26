import java.util.Scanner;

public class ThriceSimulation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		double sumTally = 0.0;
		double totalRolls = 1000.0;
		for (int i = 0; i <= totalRolls; i++) {
			int diceOne = 0;
			int diceTwo = 1;
			int diceThree = 2;
			int firstTripletWorth = 0;
			int rollNum = 1;
			int tally = 0;
			while (diceOne != diceTwo || diceTwo != diceThree || diceOne != diceThree) {

				diceOne = (int)((Math.random() * 6) + 1);
				//System.out.println("Dice one: " + diceOne);
				diceTwo = (int)((Math.random() * 6) + 1);
				//System.out.println("Dice two: " + diceTwo);
				diceThree = (int)((Math.random() * 6) + 1);
				//SSystem.out.println("Dice three: " + diceThree);
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
				//System.out.println("Tally: " + tally);

			}
			//System.out.println("Triplet Worth: " + firstTripletWorth + "\n");

			for (int j = 0; j <= firstTripletWorth; j++) {
				diceOne = (int)((Math.random() * 6) + 1);
				//System.out.println("Dice one: " + diceOne);
				diceTwo = (int)((Math.random() * 6) + 1);
				//System.out.println("Dice two: " + diceTwo);
				diceThree = (int)((Math.random() * 6) + 1);
				//System.out.println("Dice three: " + diceThree);
				int value = diceOne * diceTwo * diceThree;

				tally += value;
				//System.out.println("Tally: " + tally);
			}


			int finalTally = 0;
			int secondTripletWorth = 0;
			rollNum = 0;
			while (diceOne != diceTwo || diceTwo != diceThree || diceOne != diceThree) {
				tally += Math.pow(3, rollNum);

				diceOne = (int)((Math.random() * 6) + 1);
				//System.out.println("Dice one: " + diceOne);
				diceTwo = (int)((Math.random() * 6) + 1);
				//System.out.println("Dice two: " + diceTwo);
				diceThree = (int)((Math.random() * 6) + 1);
				//System.out.println("Dice three: " + diceThree);
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
	
			
			sumTally += finalTally;
			//System.out.println(finalTally);
			//System.out.println("NEW TURN");
		}


		double averageTally = sumTally / totalRolls;
		System.out.println("Sum of Tallys: " + sumTally);
		System.out.println("totalRolls: " + totalRolls);
		System.out.println("Average score: " + averageTally);

	}

}