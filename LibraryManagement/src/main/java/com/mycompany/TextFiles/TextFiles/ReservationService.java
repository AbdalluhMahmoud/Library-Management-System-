import java.io.*;
import java.util.*;

public class ReservationService {

    private ReservationFileManager manager;

    public ReservationService(String fileName) {
        this.manager = new ReservationFileManager(fileName);
    }

    private int generateNewId() throws IOException {
        List<Reservation> reservations = manager.loadReservations();
        int max = 0;
        for(Reservation r : reservations){
            if(r.getId() > max){
                max = r.getId();
            }
        }
        return max + 1;
    }

    public void reserveBook(int userId, int bookId, String date) throws IOException {
        int id = generateNewId();
        Reservation r = new Reservation(id, userId, bookId, date, "ACTIVE");
        manager.addReservation(r);
    }

    public List<Reservation> getUserReservations(int userId) throws IOException {
        List<Reservation> result = new ArrayList<>();
        List<Reservation> reservations = manager.loadReservations();

        for(Reservation r : reservations){
            if(r.getUserId() == userId){
                result.add(r);
            }
        }
        return result;
    }

    public boolean cancelReservation(int reservationId) throws IOException {
        List<Reservation> reservations = manager.loadReservations();
        boolean updated = false;

        for(int i = 0; i < reservations.size(); i++){
            if(reservations.get(i).getId() == reservationId){
                Reservation r = reservations.get(i);
                reservations.set(i, new Reservation(
                    r.getId(),
                    r.getUserId(),
                    r.getBookId(),
                    r.getReserveDate(),
                    "CANCELLED"
                ));
                updated = true;
                break;
            }
        }

        if(updated){
            manager.saveReservations(reservations);
        }
        return updated;
    }
}
