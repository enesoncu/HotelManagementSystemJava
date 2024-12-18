import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationManager {
    private List<Reservation> reservations;

    public ReservationManager() {
        this.reservations = new ArrayList<>();
    }

    public void addReservation(String guestName, int roomNumber, String checkInDate, String checkOutDate) {
        Reservation reservation = new Reservation(guestName, roomNumber, checkInDate, checkOutDate);
        reservations.add(reservation);
        System.out.println("Reservation added: " + reservation);
    }

    public void listAllReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations available.");
        } else {
            reservations.forEach(System.out::println);
        }
    }

    public void saveToCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("reservations.csv"))) {
            writer.write("GuestName,RoomNumber,CheckInDate,CheckOutDate\n"); // Başlık satırı
            for (Reservation reservation : reservations) {
                writer.write(reservation.getGuestName() + "," +
                        reservation.getRoomNumber() + "," +
                        reservation.getCheckInDate() + "," +
                        reservation.getCheckOutDate() + "\n");
            }
            System.out.println("Reservations saved to CSV file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader("reservations.csv"))) {
            String line;
            reader.readLine(); // Başlık satırını atla
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String guestName = parts[0];
                int roomNumber = Integer.parseInt(parts[1]);
                String checkInDate = parts[2];
                String checkOutDate = parts[3];
                addReservation(guestName, roomNumber, checkInDate, checkOutDate);
            }
            System.out.println("Reservations loaded from CSV file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
