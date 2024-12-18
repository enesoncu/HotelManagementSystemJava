public class Staff extends Person {
    private String staffRole;

    public Staff(String name, String contactNumber, String staffRole) {
        super(name, contactNumber);
        this.staffRole = staffRole;
    }

    public String getStaffRole() {
        return staffRole;
    }

    public void setStaffRole(String staffRole) {
        this.staffRole = staffRole;
    }

    @Override
    public String toString() {
        return super.toString() + ", Role: " + staffRole;
    }
}
