import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Library extends Client {
	private static String name;
	private static String Location;
	static public Map<String, Books> booksDatabase = new HashMap<>();

	public Library(String name, String location) {
		Library.name = name;
		Location = location;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("----------------------------Library----------------------------");
		System.out.println("-> Create a library");
		ValidationAndClientCalling();
	}

	private static void ValidationAndClientCalling() throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Library Name: ");
		name = scanner.nextLine();
		while (name.equals("")) {
			System.out.print("Library Name: ");
			name = scanner.nextLine();
		}
		System.out.print("Library Location: ");
		Location = scanner.nextLine();
		while (Location.equals("")) {
			System.out.print("Library Location: ");
			Location = scanner.nextLine();
		}
		new Library(name, Location).clientCreation().ClientOperation();
		;
		scanner.close();
	}

	public Client clientCreation() throws IOException {
		Client c1 = new Client();
		return c1;
	}
}
