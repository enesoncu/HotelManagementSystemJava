public class ReservationUtils {
    private ReservationManager reservationManager;

    public ReservationUtils(ReservationManager reservationManager) {
        this.reservationManager = reservationManager;
    }

    public void saveReservationsToCSV() {
        reservationManager.saveToCSV();
    }

    public void loadReservationsFromCSV() {
        reservationManager.loadFromCSV();
    }
}

