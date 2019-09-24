package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    	CoffeeMachine devise = new CoffeeMachine();
	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Write action (buy, fill, take): ");
        String actions = scanner.next();
        switch (actions) {
            case "fill":
            	devise.fillOut();
	            break;
	        case "buy":
	        	devise.selectCoffee();
		        break;
	        case "take":
	        	devise.giveMoney();
		        break;
        }
    }

}
