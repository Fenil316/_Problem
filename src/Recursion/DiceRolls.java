package Recursion;

import java.util.ArrayList;
import java.util.List;

public class DiceRolls {
	
	static int count = 0;
	
	public static void main(String[] args) {
		// You have 3 dices and each dice has 3 values. Print all the possibilities.
		
		/*
		 * Logic here being,
		 * 
		 * choose -> Choose each dice at a time to explore values from 1...6
		 * explore -> Explore possibilities of values for the chosen die,
		 * unchoose -> After exploring all the values, move to the prev die
		 * 
		 * base case: If there you are done with choosing a perticular value for the 3rd die, print it out
		 * */
		printDiceRolls(4);
	}

	private static void printDiceRolls(int i) {
		List<Integer> list = new ArrayList<Integer>();
		int diceSum = 9;
		helperDiceRoll(i, list);
		System.out.println("--------------------------Dice Sum-------------------------");
		helperDiceSum(i, diceSum, list);
		System.out.println("Total Calls Made: " + count);
	}

	private static void helperDiceRoll(int i, List<Integer> list) {
		if(i == 0) {
			System.out.println(list);
		} else {
			// Die has 6 values, for each of the possible value, choose the value and go to the next die
			for(int j=1; j<=6; j++) {
				// choose:
				list.add(j);
				// After adding that die, explore the options for that die..
				helperDiceRoll(i-1, list);
				// After exploring all the dice values for the last die added, 
				// remove the last one added and go back to the second last
				list.remove(list.size() - 1);
			}
		}
	}
	
	private static void helperDiceSum(int i, int diceSum, List<Integer> list) {
		count++;
		if(diceSum <= 0) {
			if(diceSum == 0)
				System.out.println(list);
		} else if(i == 0) {
			System.out.println(list);
		}
		else {
			// Die has 6 values, for each of the possible value, choose the value and go to the next die
			for(int j=1; j<=6; j++) {
				// choose:
				list.add(j);
				// After adding that die, explore the options for that die..
				if(diceSum - j >= 0)
					helperDiceSum(i-1, diceSum - j, list);
				// After exploring all the dice values for the last die added, 
				// remove the last one added and go back to the second last
				list.remove(list.size() - 1);
			}
		}
	}

}
