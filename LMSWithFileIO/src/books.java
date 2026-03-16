
public class books {
	
	int id;
	String title;
	String author;
	float price;
	boolean reserved;
	
	 books(int id, String title, String author, float price) {
	        this.id = id;
	        this.title = title;
	        this.author = author;
	        this.price = price;
	        this.reserved = false;
	    }
	@Override
	public String toString() {
		 String json = """
				    {
				        "id": %d,
				        "title": "%s",
				        "author": "%s",
				        "price": %.2f
				    }
				    """;

				    return json.formatted(id, title, author, price);
		
	}
}