package com.company;

import java.util.ArrayList;
import java.util.Scanner;

interface CoffeeDevice {
	public void setMenu();
	public void printState();
	public void selectCoffee();
	public void makeCoffee(Coffee coffee);
	public void fillOut();
	public void giveMoney();
}

public class CoffeeMachine implements CoffeeDevice{

	static int water = 1200;
	static int milk = 540;
	static int beans = 120;
	static int money = 550;
	static int cup = 9;
	static ArrayList<Coffee> menu = new ArrayList<Coffee>();


	public CoffeeMachine() {
		setMenu();
		printState();
	}

	@Override
	public void setMenu() {
		menu.add(new Coffee(200, 100, 12,9, "cappuccino"));
		menu.add(new Coffee(350, 75, 20,7, "latte"));
		menu.add(new Coffee(250, 0, 16,4, "espresso"));
	}

	public void printState() {
		System.out.printf("%d of water\n", water);
		System.out.printf("%d of milk\n", milk);
		System.out.printf("%d of coffee beans\n", beans);
		System.out.printf("%d of disposable cups\n", cup);
		System.out.printf("%d of money\n\n", money);
	}

	@Override
	public void selectCoffee() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
		String coffee = scanner.next();
		switch (coffee) {
			case "1":
				makeCoffee(menu.get(0));
				break;
			case "2":
				makeCoffee(menu.get(1));
				break;
			case "3":
				makeCoffee(menu.get(2));
				break;
		}
	}

	@Override
	public void makeCoffee(Coffee coffee) {

		if (coffee.water <= water &&
			coffee.milk <= milk &&
			coffee.beans <= beans &&
			cup > 0)
		{
			water -= coffee.water;
			milk -= coffee.milk;
			beans -= coffee.beans;
			money += coffee.cost;
			cup--;
		}
		printState();
	}

	@Override
	public void fillOut() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Write how many ml of water do you want to add: ");
		water += scanner.nextInt();
		System.out.print("Write how many ml of milk do you want to add: ");
		milk += scanner.nextInt();
		System.out.print("Write how many grams of coffee beans do you want to add: ");
		beans += scanner.nextInt();
		System.out.print("Write how many disposable cups of coffee do you want to add: ");
		cup += scanner.nextInt();
		printState();
	}

	@Override
	public void giveMoney() {
		System.out.printf("I gave you $%d\n\n", money);
		money = 0;
		printState();
	}
}
