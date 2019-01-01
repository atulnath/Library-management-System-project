
public class Books {
	// title, author, contributor, and age
	private String title;
	private String author;
	private String ContributorName;
	private String EanNum;

	public Books() {
	}

	public Books(String title, String author, String EanNum, String age, String ContributorName) {
		this.title = title;
		this.author = author;
		this.ContributorName = ContributorName;
		this.EanNum = EanNum;
		this.age = age;
	}

	public String getEanNum() {
		return EanNum;
	}

	public void setEanNum(String EanNum) {
		this.EanNum = EanNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContributor() {
		return ContributorName;
	}

	public void setContributor(String contributor) {
		ContributorName = contributor;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	private String age;
}
