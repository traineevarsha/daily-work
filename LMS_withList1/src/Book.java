class Book {
	private int id;
	String title;
	private float price;
	private String author;
	private STATUS status;

	public Book(int id, String title, float price, String author) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.author = author;
		this.status = STATUS.AVAILABLE;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public float getPrice() {
		return price;
	}

	public String getAuthor() {
		return author;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Book ID: " + id + "\nTitle: " + title + "\nPrice: " + price + "\nAuthor: " + author + "\nStatus: "
				+ status;
	}
}