import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StaffManager {
    private List<Staff> staffList;

    public StaffManager() {
        this.staffList = new ArrayList<>();
    }

    public void addStaff(String name, String contactNumber, String role) {
        Staff staff = new Staff(name, contactNumber, role);
        staffList.add(staff);
        System.out.println("Staff added: " + staff);
    }

    public void listAllStaff() {
        if (staffList.isEmpty()) {
            System.out.println("No staff available.");
        } else {
            staffList.forEach(System.out::println);
        }
    }

    public void saveToCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("staff.csv"))) {
            writer.write("Name,ContactNumber,Role\n"); // Başlık satırı
            for (Staff staff : staffList) {
                writer.write(staff.getName() + "," + staff.getContactNumber() + "," + staff.getStaffRole() + "\n");
            }
            System.out.println("Staff saved to CSV file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader("staff.csv"))) {
            String line;
            reader.readLine(); // Başlık satırını atla
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                String contactNumber = parts[1];
                String role = parts[2];
                addStaff(name, contactNumber, role);
            }
            System.out.println("Staff loaded from CSV file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
