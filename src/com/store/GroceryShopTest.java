package com.store;

import java.util.Scanner;

public class GroceryShopTest {

	public static void main(String[] args) {
		GroceryShop grocery = new GroceryShop();
		System.out.println("****** The application has the following features ********");
		System.out.println("\t1. Read, validate and store all items");
		System.out.println("\t2. Calculate and store shop price for all items");
		System.out.println("\t3. Display all items");
		System.out.println("\t4. Sell an item");
		System.out.println("\t5. Display all items wiht lowest factory price");
		System.out.println("\t6. Sort and display sorted items");
		System.out.println("\t7. Exit from application");
		while (true) {
			System.out.print("Please input a choice to proceed:\t");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			switch (option) {
			case 1:
				validateAndStoreItems(sc, grocery);
				break;
			case 2:
				calculateStoreShopPrice(sc, grocery);
				break;
			case 3:
				displayAllItems(grocery);
				break;
			case 4:
				sellItem(sc, grocery);
				break;
			case 5:
				displayFactoryItems(grocery);
				break;
			case 6:
				displaySortedItems(grocery);
				break;
			case 7:
				sc.close();
				System.gc();
				System.exit(0);
			default:
				System.out.println("Please enter a valid choice");
				break;
			}
		}
	}

	private static void displaySortedItems(GroceryShop grocery) {

	}

	private static void sellItem(Scanner sc, GroceryShop grocery) {
		System.out.println("Please enter the item Id:\t");
		int item = sc.nextInt();
		for (int i = 0; i < grocery.number; i++) {
			if (item == grocery.itemId[i]) {
				if (grocery.qtyInStck[i] != 0) {
					System.out.println("Item Sold");
					grocery.qtyInStck[i] = grocery.qtyInStck[i] - 1;
				} else if (grocery.qtyInStck[i] == 0) {
					System.out.println("Item is not in-stock");
				}
			} else {
				System.out.println("Item is not in-stock");
			}
		}
	}

	private static void displayFactoryItems(GroceryShop grocery) {
		for (int i = 0; i < grocery.number; i++) {
			if (grocery.factoryPrice[i] == grocery.minFctValue) {
				System.out.println("Item Name:\t" + grocery.itemName[i]);
				System.out.println("Item Id:\t" + grocery.itemId[i]);
				System.out.println("Quantity in-stock:\t" + grocery.qtyInStck[i]);
				System.out.println("Factory Price:\t" + grocery.factoryPrice[i]);
				System.out.println("Shop Price:\t" + grocery.shopPrice[i]);
			}
		}
	}

	private static void displayAllItems(GroceryShop grocery) {
		System.out.println("Item Name\tItem Id\tItem in-stock\tFacoryPrice\tShop Price");
		for (int i = 0; i < grocery.number; i++) {
			System.out.println(grocery.itemName[i] + "\t\t" + grocery.itemId[i] + "\t\t" + grocery.qtyInStck[i] + "\t\t"
					+ grocery.factoryPrice[i] + "\t\t" + grocery.shopPrice[i]);
		}
	}

	private static void calculateStoreShopPrice(Scanner sc, GroceryShop grocery) {
		System.out.println("Please enter the discount percentage:\t");
		double discount = sc.nextDouble();
		for (int i = 0; i < grocery.number; i++) {
			grocery.shopPrice[i] = (grocery.factoryPrice[i] * discount)/100;
		}
	}

	private static void validateAndStoreItems(Scanner sc, GroceryShop grocery) {
		System.out.println("Please enter the following item details");
		System.out.print("Please enter the item name");
		String name = sc.next();
		System.out.print("Please enter the item Id");
		int id = sc.nextInt();
		int i = 0;
		while (id < grocery.minIdValue || id > grocery.maxIdValue) {
			System.out.println("Enter a item Id within " + grocery.minIdValue + " and " + grocery.maxIdValue);
			id = sc.nextInt();
		}
		System.out.print("Please enter the quantity in-stock:\t");
		int qty = sc.nextInt();
		System.out.print("Please enter the factory price:\t");
		double price = sc.nextDouble();
		while (price < grocery.minFctValue || price > grocery.maxFctValue) {
			System.out.println("Enter a factory price within " + grocery.minFctValue + "and " + grocery.maxFctValue);
			price = sc.nextDouble();
		}
		grocery.itemName[i] = name;
		grocery.itemId[i] = id;
		grocery.qtyInStck[i] = qty;
		grocery.factoryPrice[i] = price;
		i++;
	}
}
