//BOOK CLASS WITH POOR COHESION
public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void printBookDetails() {
        System.out.println("Title: " + title + ", Author: " + author);
    }

    // Poorly related method
    public void saveToDatabase() {
        // Code to save book details to a database
        System.out.println("Book saved to database.");
    }
}