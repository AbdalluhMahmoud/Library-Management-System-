package com.mycompany.TextFiles;

import com.mycompany.model.Reservation;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ReservationService {

    private ReservationFileManager manager;
    private String fileName;
    
    public ReservationService(String fileName) {
        this.manager = new ReservationFileManager(fileName);
        this.fileName=fileName;
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
    public boolean reserveBook(int userId, int bookId) throws IOException {
        // 1. Generate a simple Reservation ID (using time is easiest)
        int reservationId = (int) (System.currentTimeMillis() / 1000);
        
        // 2. Get today's date
        LocalDate date = LocalDate.now();
        
        // 3. Format the CSV line: ID, UserID, BookID, Date, Status
        String line = reservationId + "," + userId + "," + bookId + "," + date + ",ACTIVE";
        
        // 4. Save to file
        FileHelper.appendLine(fileName, line);
        
        return true;
    }
}
