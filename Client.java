import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.Scanner;

public class Client {
	// help link
	// Map<String, String> userCityMapping = new HashMap<>();
	// https://www.callicoder.com/java-hashmap/
	static int overdue = 0;
	static long id = 1;
	static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	static BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	private static Scanner scanner;

	public void ClientOperation() throws IOException {
		mainmenu();
		scanner = new Scanner(System.in);
		while (true) {
			int selection = scanner.nextInt();
			switch (selection) {
			case 1:
				addBook();
				mainmenu();
				break;
			case 2:
				System.out.print("EAN Number: ");
				String ean = bufferedReader.readLine();
				new Client().booklent(ean);
				mainmenu();
				break;
			case 3:
				displayAllBooks();
				mainmenu();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Wrong input");
				break;
			}
		}
	}

	private static void mainmenu() {
		System.out.println("\n-----------------------------------------------\n");
		System.out.println("Please select one of the option\n");
		System.out.println("1: Contribute a book\n");
		System.out.println("2: Lent a book\n");
		System.out.println("3: Display all Books that are currently available\n");
		System.out.println("4: Exit\n");
		System.out.println("-----------------------------------------------");
	}

	public void booklent(String ean) throws IOException {
		if (overdue <= 19) {
			if (Library.booksDatabase.containsKey(ean)) {
				Books temp = Library.booksDatabase.get(ean);
				Library.booksDatabase.remove(ean);
				System.out.println("\"" + temp.getTitle() + "\"" + " is given to you");
				overdue++;
			} else {
				System.out.println("Sorry Your Books is not available");
			}
		} else {
			System.out.println("Sorry more than 19 books are already lent");
		}
	}

	static void displayAllBooks() {
		int count = 0;
		if (Library.booksDatabase.size() == 0) {
			System.out.println("No Book is avaiable to display");
		} else {
			System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
			for (Entry<String, Books> entry : Library.booksDatabase.entrySet()) {
				Books newBk = entry.getValue();
				System.out.println(count++ + ": " + newBk.getTitle() + ", " + newBk.getAuthor() + ", " + newBk.getAge()
						+ " , Contributed By: " + newBk.getContributor());
			}
			System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		}
	}

	private static void addBook() throws IOException {
		Books bk = new Books();
		System.out.print("Enter Your Name: ");
		bk.setContributor(bufferedReader.readLine());
		// title, author, contributor, and age
		System.out.println("Please Enter following information of the book\n");
		System.out.print("Title: ");
		bk.setTitle(bufferedReader.readLine());
		System.out.print("Author: ");
		bk.setAuthor(bufferedReader.readLine());
		System.out.print("EAN Number: ");
		String ean = bufferedReader.readLine();
		bk.setEanNum(ean);
		System.out.print("Age: ");
		bk.setAge(bufferedReader.readLine());

		// userCityMapping.put("John", "New York");

		if (bk.getTitle().equals("") || bk.getAge().equals("") || bk.getAuthor().equals("")
				|| bk.getContributor().equals("") || bk.getContributor().equals("") || bk.getEanNum().equals("")) {
			System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("Missing information");
			System.out.println("Book is not insert in the list");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		} else {
			Library.booksDatabase.put(ean, bk);
		}
	}
}
