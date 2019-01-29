package jdbc.project.vo;

public class BookVO {
	private String isbn;
	private String title;
	private String author;
	private int price;
	private int usable;
	
	public BookVO() {
		super();
	}

	public BookVO(String isbn, String title, String author, int price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public BookVO(String isbn, String title, String author, int price, int usable) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.usable = usable;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getUsable() {
		return usable;
	}

	public void setUsable(int usable) {
		this.usable = usable;
	}

	@Override
	public String toString() {
		String result = "";
		result += isbn + "\t";
		result += title + "\t";
		result += (author == null ? "정보없음":author) + "\t";
		result += (price == 0 ? "정보없음":price) + "\t";
		result += usable == 1 ? "대여 가능" : "대여 중";
		
		return result;
	}

}
