import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RoomManager implements RoomOperations {
    private List<Room> rooms;

    public RoomManager() {
        this.rooms = new ArrayList<>();
    }

    @Override
    public void addRoom(Room room) {
        if (rooms.stream().noneMatch(r -> r.getNumber() == room.getNumber())) {
            rooms.add(room);
            System.out.println("Room added: " + room);
        } else {
            System.out.println("Room number already exists: " + room.getNumber());
        }
    }

    @Override
    public void removeRoom(int roomNumber) {
        rooms.removeIf(room -> room.getNumber() == roomNumber);
        System.out.println("Room removed: " + roomNumber);
    }

    @Override
    public void displayAvailableRooms() {
        rooms.stream()
                .filter(room -> "Available".equalsIgnoreCase(room.getStatus()))
                .forEach(System.out::println);
    }

    public void listAvailableRooms() {
        displayAvailableRooms();
    }

    public void listOccupiedRooms() {
        rooms.stream()
                .filter(room -> "Occupied".equalsIgnoreCase(room.getStatus()))
                .forEach(System.out::println);
    }

    public void updateRoomStatus(int roomNumber, String newStatus) {
        Room room = rooms.stream()
                .filter(r -> r.getNumber() == roomNumber)
                .findFirst()
                .orElse(null);
        if (room != null) {
            room.setStatus(newStatus);
            System.out.println("Room status updated: " + room);
        } else {
            System.out.println("Room not found: " + roomNumber);
        }
    }

    @Override
    public Room getRoomByNumber(int roomNumber) {
        return rooms.stream()
                .filter(room -> room.getNumber() == roomNumber)
                .findFirst()
                .orElse(null);
    }

    public void listAllRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            rooms.forEach(System.out::println);
        }
    }

    public void saveRoomsToCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("rooms.csv"))) {
            writer.write("RoomNumber,Type,Status\n"); // Başlık satırı
            for (Room room : rooms) {
                writer.write(room.getNumber() + "," + room.getType() + "," + room.getStatus() + "\n");
            }
            System.out.println("Rooms saved to CSV file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadRoomsFromCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader("rooms.csv"))) {
            String line;
            reader.readLine(); // Başlık satırını atla
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int number = Integer.parseInt(parts[0]);
                String type = parts[1];
                String status = parts[2];
                addRoom(new Room(number, type, status));
            }
            System.out.println("Rooms loaded from CSV file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
