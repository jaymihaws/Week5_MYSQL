package appliaction;

import java.sql.SQLException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.FoodsDao;
import entity.Foods;

public class Menu {

	private FoodsDao foodsDao = new FoodsDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList("Display All Foods", 
			"Display a Food", 
			"Add Food", 
			"Update Food", 
			"Delete Food");

	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try { 
				if (selection.equals("1")) {
					showFoods();
				} else if (selection.equals("2")) {
					showFoodItem();
				} else if (selection.equals("3")) {
					addFood();
				} else if (selection.equals("4")) {
					deleteFood();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Press enter to continue.");
			scanner.nextLine();
			
		} while (!selection.equals("-1"));
	}

	private void printMenu() {
		System.out.println("Select an Option:\n--------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ")" + options.get(i));
		}
	}
	
	
	private void showFoods() throws SQLException {
		List<Foods> foods = foodsDao.displayFoods();
		for (Foods food : foods) {
			System.out.println(food.getFoodId() + ": " + food.getFoodName());		
		}
	}
	
	private void showFoodItem() throws SQLException {
		System.out.println("Enter food id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Foods food = foodsDao.getFoodById(id); 
		System.out.println(food.getFoodId() + ": " + food.getFoodName() + ", " + food.getCuisine());
	}
	
	private void addFood() throws SQLException {
		System.out.println("Enter new foods name: ");
		String name = scanner.nextLine();
		System.out.println("Enter new foods cuisine: ");
		String cuisine = scanner.nextLine();
		foodsDao.createNewFood(name, cuisine);
	}
	
	private void deleteFood() throws SQLException {
		System.out.println("Enter food id to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		foodsDao.deleteFoodById(id);

	}
}
