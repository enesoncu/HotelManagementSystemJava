public class Customer extends Person {
    private int customerId;

    public Customer(String name, String contactNumber, int customerId) {
        super(name, contactNumber);
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return super.toString() + ", Customer ID: " + customerId;
    }
}
