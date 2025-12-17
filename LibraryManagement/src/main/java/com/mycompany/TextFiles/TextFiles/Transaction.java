

public class Transaction {
    private int transactionId;
    private int userId;
    private int bookId;
    private String borrowDate;
    private String dueDate;
    private String returnDate;
    private String status;
    
    public Transaction(int transactionId,int userId,int bookId,String borrowDate,String dueDate,String returnDate,String status){
        this.transactionId=transactionId;
        this.userId=userId;
        this.bookId=bookId;
        this.borrowDate=borrowDate;
        this.dueDate=dueDate;
        this.returnDate=returnDate;
        this.status=status;
    }
    
    public int getTransactionId(){return transactionId;}
    public int getUserId(){return userId;}
    public int getBookId(){return bookId;}
    public String getBorrowDate(){return borrowDate;}
    public String getDueDate(){return dueDate;}
    public String getReturnDate(){return returnDate;}
    public String getStatus(){return status;}
    
    public void setReturnDate(String returnDate){this.returnDate=returnDate;}
    public void setStatus(String status){this.status=status;}
    
    public String toCSV(){
        return transactionId+","+userId+","+bookId+","+borrowDate+","+dueDate+","+returnDate+","+status;
    }
    
    public static Transaction fromCSV(String line){
        String[] parts=line.split(",");
        return new Transaction(
            Integer.parseInt(parts[0]),
            Integer.parseInt(parts[1]),
            Integer.parseInt(parts[2]),
            parts[3],
            parts[4],
            parts[5],
            parts[6]
        );
    }
    
}
