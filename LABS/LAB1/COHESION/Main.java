// Book class with high cohesion
 class BookWithHighCohesion {
    private String title;
    private String author;

    public BookWithHighCohesion(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void printBookDetails() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

// A separate class for handling book storage

 class BookRepository {
    public void saveToDatabase(BookWithHighCohesion book) {
        // Code to save book details to a database
        System.out.println("Book saved to database: " + book.getTitle());
    }
}

// Usage example
public class Main {
    public static void main(String[] args) {
        BookWithHighCohesion book = new BookWithHighCohesion("1984", "George Orwell");
        book.printBookDetails();

        BookRepository bookRepository = new BookRepository();
        bookRepository.saveToDatabase(book);
    }
}