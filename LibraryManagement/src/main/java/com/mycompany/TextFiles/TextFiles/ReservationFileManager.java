import java.io.*;
import java.util.*;

public class ReservationFileManager {

    private String fileName;

    public ReservationFileManager(String fileName) {
        this.fileName = fileName;
    }

    public List<Reservation> loadReservations() throws IOException {
        List<String> lines = FileHelper.readFile(fileName);
        List<Reservation> reservations = new ArrayList<>();

        for(String line : lines){
            if(!line.trim().isEmpty()){
                reservations.add(Reservation.fromCSV(line));
            }
        }
        return reservations;
    }

    public void saveReservations(List<Reservation> reservations) throws IOException {
        List<String> lines = new ArrayList<>();
        for(Reservation r : reservations){
            lines.add(r.toCSV());
        }
        FileHelper.writeFile(fileName, lines);
    }

    public void addReservation(Reservation r) throws IOException {
        FileHelper.appendLine(fileName, r.toCSV());
    }
}
