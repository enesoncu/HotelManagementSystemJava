import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EntityUtils<T> {
    public void saveToCSV(List<T> entities, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (T entity : entities) {
                writer.write(entity.toString());
                writer.newLine();
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> loadFromCSV(String fileName, EntityParser<T> parser) {
        List<T> entities = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                entities.add(parser.parse(line));
            }
            System.out.println("Data loaded from " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entities;
    }

    public interface EntityParser<T> {
        T parse(String line);
    }
}

