public class PersonUtils {
    private PersonManager personManager;

    public PersonUtils(PersonManager personManager) {
        this.personManager = personManager;
    }

    public void savePersonsToCSV() {
        personManager.saveToCSV();
    }

    public void loadPersonsFromCSV() {
        personManager.loadFromCSV();
    }
}

