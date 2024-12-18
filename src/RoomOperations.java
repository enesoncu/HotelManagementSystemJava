public interface RoomOperations {
    void addRoom(Room room);
    void removeRoom(int roomNumber);
    void displayAvailableRooms();
    Room getRoomByNumber(int roomNumber);
}
