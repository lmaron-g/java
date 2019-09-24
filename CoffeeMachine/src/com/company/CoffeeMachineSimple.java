package com.company;

import java.util.Scanner;

public class CoffeeMachineSimple {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Write how many ml of water the coffee machine has: ");
		int water = scanner.nextInt();
		System.out.print("Write how many ml of milk the coffee machine has: ");
		int milk = scanner.nextInt();
		System.out.print("Write how many grams of coffee beans the coffee machine has: ");
		int beans = scanner.nextInt();
		System.out.print("Write how many cups of coffee you will need: ");
		int persons = scanner.nextInt();

		int possible_cups = water / 200;
		possible_cups = Math.min(possible_cups, (milk / 50));
		possible_cups = Math.min(possible_cups, (beans / 15));

		if (possible_cups == persons)
			System.out.print("Yes, I can make that amount of coffee\n");
		else if (possible_cups > persons)
			System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", possible_cups - persons);
		else
			System.out.printf("No, I can make only %d cup(s) of coffee", possible_cups);
	}
}
