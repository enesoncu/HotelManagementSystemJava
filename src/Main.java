import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RoomManager roomManager = new RoomManager();
        PersonManager personManager = new PersonManager();
        StaffManager staffManager = new StaffManager();
        ReservationManager reservationManager = new ReservationManager();

        RoomUtils roomUtils = new RoomUtils(roomManager);
        PersonUtils personUtils = new PersonUtils(personManager);
        StaffUtils staffUtils = new StaffUtils(staffManager);
        ReservationUtils reservationUtils = new ReservationUtils(reservationManager);

        // Load data from CSV files
        roomUtils.loadRoomsFromCSV();
        personUtils.loadPersonsFromCSV();
        staffUtils.loadStaffFromCSV();
        reservationUtils.loadReservationsFromCSV();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nHotel Management System");
            System.out.println("1. Room Operations");
            System.out.println("2. Person Operations");
            System.out.println("3. Staff Operations");
            System.out.println("4. Reservation Operations");
            System.out.println("5. Save and Exit");
            System.out.print("Please choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    roomOperations(roomManager, scanner);
                    break;
                case 2:
                    personOperations(personManager, scanner);
                    break;
                case 3:
                    staffOperations(staffManager, scanner);
                    break;
                case 4:
                    reservationOperations(reservationManager, scanner);
                    break;
                case 5:
                    saveAllData(roomUtils, personUtils, staffUtils, reservationUtils);
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void roomOperations(RoomManager roomManager, Scanner scanner) {
        int choice;
        do {
            System.out.println("\nRoom Operations");
            System.out.println("1. View All Rooms");
            System.out.println("2. View Available Rooms");
            System.out.println("3. View Occupied Rooms");
            System.out.println("4. Add Room");
            System.out.println("5. Remove Room");
            System.out.println("6. Update Room Status");
            System.out.println("7. Save Rooms to CSV");
            System.out.println("8. Back to Main Menu");
            System.out.print("Please choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    roomManager.listAllRooms();
                    break;
                case 2:
                    roomManager.listAvailableRooms();
                    break;
                case 3:
                    roomManager.listOccupiedRooms();
                    break;
                case 4:
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter room type (Single/Double/Suite): ");
                    String roomType = scanner.nextLine();
                    System.out.print("Enter room status (Available/Occupied): ");
                    String roomStatus = scanner.nextLine();
                    roomManager.addRoom(new Room(roomNumber, roomType, roomStatus));
                    System.out.println("Room added successfully!");
                    break;
                case 5:
                    System.out.print("Enter room number to remove: ");
                    int removeRoomNumber = scanner.nextInt();
                    roomManager.removeRoom(removeRoomNumber);
                    System.out.println("Room removed successfully!");
                    break;
                case 6:
                    System.out.print("Enter room number to update status: ");
                    int updateRoomNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new status (Available/Occupied): ");
                    String newStatus = scanner.nextLine();
                    roomManager.updateRoomStatus(updateRoomNumber, newStatus);
                    System.out.println("Room status updated successfully!");
                    break;
                case 7:
                    System.out.println("Saving rooms to CSV...");
                    roomManager.saveRoomsToCSV();
                    break;
                case 8:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 8);
    }

    private static void personOperations(PersonManager personManager, Scanner scanner) {
        int choice;
        do {
            System.out.println("\nPerson Operations");
            System.out.println("1. View All Guests");
            System.out.println("2. Add Guest");
            System.out.println("3. Back to Main Menu");
            System.out.print("Please choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    personManager.listAllPeople();
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String contactNumber = scanner.nextLine();
                    personManager.addPerson(name, contactNumber);
                    break;
                case 3:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 3);
    }

    private static void staffOperations(StaffManager staffManager, Scanner scanner) {
        int choice;
        do {
            System.out.println("\nStaff Operations");
            System.out.println("1. View All Staff");
            System.out.println("2. Add Staff");
            System.out.println("3. Back to Main Menu");
            System.out.print("Please choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    staffManager.listAllStaff();
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String contactNumber = scanner.nextLine();
                    System.out.print("Enter role: ");
                    String role = scanner.nextLine();
                    staffManager.addStaff(name, contactNumber, role);
                    break;
                case 3:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 3);
    }

    private static void reservationOperations(ReservationManager reservationManager, Scanner scanner) {
        int choice;
        do {
            System.out.println("\nReservation Operations");
            System.out.println("1. View All Reservations");
            System.out.println("2. Add Reservation");
            System.out.println("3. Back to Main Menu");
            System.out.print("Please choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reservationManager.listAllReservations();
                    break;
                case 2:
                    System.out.print("Enter guest name: ");
                    scanner.nextLine();
                    String guestName = scanner.nextLine();
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter check-in date: ");
                    String checkInDate = scanner.nextLine();
                    System.out.print("Enter check-out date: ");
                    String checkOutDate = scanner.nextLine();
                    reservationManager.addReservation(guestName, roomNumber, checkInDate, checkOutDate);
                    break;
                case 3:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 3);
    }

    private static void saveAllData(RoomUtils roomUtils, PersonUtils personUtils, StaffUtils staffUtils, ReservationUtils reservationUtils) {
        roomUtils.saveRoomsToCSV();
        personUtils.savePersonsToCSV();
        staffUtils.saveStaffToCSV();
        reservationUtils.saveReservationsToCSV();
        System.out.println("All data saved successfully.");
    }
}
