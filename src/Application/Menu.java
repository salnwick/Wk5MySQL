package Application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import DAO.MakeDAO;
import Entity.Makes;
import Entity.Models;

public class Menu {
	
	private MakeDAO makedao = new MakeDAO();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Makes", 
			"Display a Make",
			"Create New Make",
			"Delete Make"
			);
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if (selection.equals("1")) {
					displayMakes();
				} else if (selection.equals("2")) {
					displayMake();
				} else if (selection.equals("3")) {
					createMake();
				} else if (selection.equals("4")) {
					deleteMake();
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
				
			System.out.println("Please press enter to continue...");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n-----------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}

	private void displayMakes() throws SQLException {
		List<Makes> makesList = makedao.getMakes();
		for (Makes makes : makesList) {
			System.out.println(makes.getMake_id() + ": " + makes.getMake());
		}
	}
	
	private void displayMake() throws SQLException {
		System.out.print("Enter make id: ");
		int make_id = Integer.parseInt(scanner.nextLine());
		Makes make = makedao.getMakesById(make_id);
		System.out.println(make.getMake_id() + ": " + make.getMake());
		for (Models model : make.getModels()) {
			System.out.println("\tModels id: " + model.getModel_id() + " Name: " + model.getModel());
		}
	}
	
	private void createMake() throws SQLException {
		System.out.print("Enter new make:");
		String MakeName = scanner.nextLine();
		makedao.createNewMake(MakeName);
	}
	
	private void deleteMake() throws SQLException {
		System.out.print("Enter make id to delete:");
		int make_id = Integer.parseInt(scanner.nextLine());
		makedao.deleteMakeById(make_id);
	}

}
