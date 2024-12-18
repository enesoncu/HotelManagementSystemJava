import java.util.ArrayList;
import java.util.List;

public class PersonManager {
    private List<Person> people;

    public PersonManager() {
        this.people = new ArrayList<>();
    }

    public void addPerson(String name, String contactNumber) {
        Person person = new Person(name, contactNumber);
        people.add(person);
    }

    public void listAllPeople() {
        if (people.isEmpty()) {
            System.out.println("No people available.");
        } else {
            people.forEach(System.out::println);
        }
    }

    public void saveToCSV() {
        // Use utility methods for saving to CSV
    }

    public void loadFromCSV() {
        // Use utility methods for loading from CSV
    }
}
