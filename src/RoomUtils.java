public class RoomUtils {
    private RoomManager roomManager;

    public RoomUtils(RoomManager roomManager) {
        this.roomManager = roomManager;
    }

    public void saveRoomsToCSV() {
        roomManager.saveRoomsToCSV();
    }

    public void loadRoomsFromCSV() {
        roomManager.loadRoomsFromCSV();
    }
}
