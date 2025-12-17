

public class Reservation {
    private int id;
    private int userId;
    private int bookId;
    private String reserveDate;
    private String status;
    
    public Reservation(int id, int userId, int bookId, String reserveDate, String status) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.reserveDate = reserveDate;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getReserveDate() {
        return reserveDate;
    }

    public String getStatus() {
        return status;
    }

    public String toCSV() {
        return id + "," + userId + "," + bookId + "," + reserveDate + "," + status;
    }

    public static Reservation fromCSV(String line) {
        String[] parts = line.split(",");
        return new Reservation(
            Integer.parseInt(parts[0]),
            Integer.parseInt(parts[1]),
            Integer.parseInt(parts[2]),
            parts[3],
            parts[4]
        );
    }
}
