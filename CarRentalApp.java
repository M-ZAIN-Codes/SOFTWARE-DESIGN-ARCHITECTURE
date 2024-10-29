import java.util.List;
import java.util.ArrayList;
import java.util.Date;

// DateRange class definition
class DateRange {
    private Date startDate;
    private Date endDate;

    public DateRange(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "From: " + startDate + " To: " + endDate;
    }
}

// PDF class definition
class PDF {
    private String content;

    public PDF(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "PDF Content: " + content;
    }
}

// Simulated ResultSet class
class ResultSet {
    // Placeholder for database query results
}

// Booking class definition
class Booking {
    String bookingID;
    String userID;
    String carModel;
    String status;
    DateRange rentalPeriod;

    public Booking(String bookingID, String userID, String carModel, String status, DateRange rentalPeriod) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.carModel = carModel;
        this.status = status;
        this.rentalPeriod = rentalPeriod;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingID + ", User ID: " + userID + ", Car Model: " + carModel +
               ", Status: " + status + ", Rental Period: " + rentalPeriod;
    }
}

// User class definition
class User {
    String userID;
    String name;
    String email;
    String phoneNum;
    private List<Booking> rentalHistory; // Track rental history

    public User(String userID, String name, String email, String phoneNum) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.rentalHistory = new ArrayList<>();
    }

    public void addBookingToHistory(Booking booking) {
        rentalHistory.add(booking);
    }

    public List<Booking> getRentalHistory() {
        return rentalHistory;
    }

    @Override
    public String toString() {
        return "User ID: " + userID + ", Name: " + name + ", Email: " + email + ", Phone: " + phoneNum;
    }
}

// BookingHistoryController class definition
class BookingHistoryController {
    public void viewBookingHistory(User user) {
        List<Booking> bookings = user.getRentalHistory();
        System.out.println("Rental History for User: " + user.userID);
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public void viewBookingDetails(Booking booking) {
        if (booking != null) {
            System.out.println("Booking Details: " + booking);
        } else {
            System.out.println("Booking not found.");
        }
    }

    public boolean cancelBooking(User user, String bookingID) {
        List<Booking> bookings = user.getRentalHistory();
        for (Booking booking : bookings) {
            if (booking.bookingID.equals(bookingID)) {
                booking.status = "Cancelled";
                System.out.println("Cancelled booking with ID: " + bookingID);
                return true;
            }
        }
        return false;
    }

    public PDF downloadAgreement(Booking booking) {
        return new PDF("Rental Agreement for Booking ID: " + booking.bookingID); // Replace with actual logic
    }
}

// Main class to demonstrate functionality
public class CarRentalApp {
    public static void main(String[] args) {
        // Create users
        User user1 = new User("U001", "Alice Johnson", "alice@example.com", "123-456-7890");

        // Create sample bookings
        Booking booking1 = new Booking("B001", user1.userID, "Toyota Camry", "Confirmed", 
                                        new DateRange(new Date(), new Date(System.currentTimeMillis() + 86400000))); // 1 day later
        Booking booking2 = new Booking("B002", user1.userID, "Honda Accord", "Confirmed", 
                                        new DateRange(new Date(), new Date(System.currentTimeMillis() + 172800000))); // 2 days later

        // Add bookings to user's rental history
        user1.addBookingToHistory(booking1);
        user1.addBookingToHistory(booking2);

        // Create a booking history controller
        BookingHistoryController controller = new BookingHistoryController();

        // View rental history for user1
        controller.viewBookingHistory(user1);

        // View details for a specific booking
        controller.viewBookingDetails(booking1);

        // Cancel a booking
        controller.cancelBooking(user1, "B001");

        // Download an agreement
        PDF agreement = controller.downloadAgreement(booking2);
        System.out.println(agreement);
    }
}
