public class StaffUtils {
    private StaffManager staffManager;

    public StaffUtils(StaffManager staffManager) {
        this.staffManager = staffManager;
    }

    public void saveStaffToCSV() {
        staffManager.saveToCSV();
    }

    public void loadStaffFromCSV() {
        staffManager.loadFromCSV();
    }
}
