public class Room {
    private int number;
    private String type;
    private String status;

    public Room(int number, String type, String status) {
        this.number = number;
        this.type = type;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        // Define ANSI color codes
        String resetColor = "\u001B[0m";
        String availableColor = "\u001B[32m"; // Green
        String occupiedColor = "\u001B[31m";  // Red

        // Determine the color based on the status
        String color = "Available".equalsIgnoreCase(status) ? availableColor : occupiedColor;

        // Format the string with color
        return String.format("Room Number: %d, Type: %s, Status: %s%s%s",
                number, type, color, status, resetColor);
    }
}
