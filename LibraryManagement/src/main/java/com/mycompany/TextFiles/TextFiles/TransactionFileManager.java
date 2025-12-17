import java.io.*;
import java.util.*;

public class TransactionFileManager {
    private String fileName;
    
    public TransactionFileManager(String fileName){
        this.fileName=fileName;
    }
    
    public List<Transaction> loadTransactions() throws IOException{
        List<String> lines = FileHelper.readFile(fileName);
        List<Transaction> transactions = new ArrayList<>();

        for(String line : lines){
            if(!line.trim().isEmpty()){
                transactions.add(Transaction.fromCSV(line));
            }
        }
        return transactions;
    }
    
    public void saveTransactions(List<Transaction> transactions) throws IOException{
        List<String> lines = new ArrayList<>();
        for(Transaction t : transactions){
            lines.add(t.toCSV());
        }
        FileHelper.writeFile(fileName, lines);
    }
    
    public void addTransaction(Transaction transaction) throws IOException{
        FileHelper.appendLine(fileName, transaction.toCSV());
    }
    
    public Transaction findById(int transactionId) throws IOException{
        List<Transaction> transactions = loadTransactions();
        for(Transaction t : transactions){
            if(t.getTransactionId()==transactionId){
                return t;
            }
        }
        return null;
    }
    
    public List<Transaction> findByUserId(int userId) throws IOException{
        List<Transaction> result = new ArrayList<>();
        List<Transaction> transactions = loadTransactions();

        for(Transaction t : transactions){
            if(t.getUserId()==userId){
                result.add(t);
            }
        }
        return result;
    }
    
    public List<Transaction> findByBookId(int bookId) throws IOException{
        List<Transaction> result = new ArrayList<>();
        List<Transaction> transactions = loadTransactions();

        for(Transaction t : transactions){
            if(t.getBookId()==bookId){
                result.add(t);
            }
        }
        return result;
    }
    
    public boolean updateTransaction(Transaction updatedTransaction) throws IOException{
        List<Transaction> transactions = loadTransactions();
        boolean updated=false;

        for(int i=0;i<transactions.size();i++){
            if(transactions.get(i).getTransactionId()==updatedTransaction.getTransactionId()){
                transactions.set(i, updatedTransaction);
                updated=true;
                break;
            }
        }

        if(updated){
            saveTransactions(transactions);
        }
        return updated;
    }
    
}

