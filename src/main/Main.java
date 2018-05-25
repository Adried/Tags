package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Model model = new Model();

		menu(model);
	}

	private static void menu(Model model) {
		Scanner scanner = new Scanner(System.in);
		int option = -1;
		List<String> result = new ArrayList<String>();

		while (option != 0) {
			System.out.println("----------------");
			System.out.println("OPTIONS");
			System.out.println("1- Generate tags");
			System.out.println("0- Exit");
			System.out.println("----------------");

			option = scanner.nextInt();

			switch (option) {
			case 1:
				System.out.println("Result :");
				result = model.randomTags();
				randomTags(result);
				break;
			case 0:
				System.out.println("Exiting");
				break;
			default:
				System.out.println("Ayy lmao");
				break;
			}
		}
		scanner.close();
	}

	private static void randomTags(List<String> result) {
		System.out.println("Anatomy  --> " + result.get(0));
		System.out.println("Clothing --> " + result.get(1));
		System.out.println("Action   --> " + result.get(2));
	}

}
