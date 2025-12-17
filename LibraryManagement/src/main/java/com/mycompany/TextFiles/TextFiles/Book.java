
public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private int year;
    private String status;
    public Book(int id, String title, String author, String genre, int year, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.status = status;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String toCSV() {
        return id + "," + title + "," + author + "," + genre + "," + year + "," + status;
    }
    
    public static Book fromCSV(String line) {
        String[] parts = line.split(",");
        int id = Integer.parseInt(parts[0]);
        String title = parts[1];
        String author = parts[2];
        String genre = parts[3];
        int year = Integer.parseInt(parts[4]);
        String status = parts[5];
        return new Book(id, title, author, genre, year, status);
    }
    
}
