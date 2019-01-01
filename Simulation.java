import java.io.IOException;

public class Simulation {

	public static void main(String[] args) throws IOException {
		Library l1 = new Library("Chemnitz Library", "Chemnitz");

		// For Client 1
		Books b1 = new Books("Do Androids Dream of Electric Sheep?", "by Philip K. Dick", "0198861732921", "2012",
				"Atul");
		Books b2 = new Books("C progrmming", "herbert Schildt", "0123861732921", "2002", "Atul");
		Books b3 = new Books("Clean Code", "Robert Cecil Martin", "019883473341", "2011", "Atul");
		Library.booksDatabase.put("0198861732921", b1);
		Library.booksDatabase.put("0123861732921", b2);
		Library.booksDatabase.put("019883473341", b3);
		System.out.println("Client 1:");
		System.out.println("--------------------------------------------");
		Client c1 = l1.clientCreation();
		c1.booklent("0198861732921");
		c1.booklent("0123861732921");
		c1.booklent("019883473341");

		// For Client 2
		b1 = new Books("Do Androids Dream of Electric Sheep?", "by Philip K. Dick", "0198861732921", "2012", "Kartik");
		Library.booksDatabase.put("0198861732921", b1);
		System.out.println("--------------------------------------------");
		System.out.println("Client 2:");
		Client c2 = l1.clientCreation();
		c2.booklent("0198861732921");
		System.out.println("--------------------------------------------");
	}

}
