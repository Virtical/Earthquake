import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EarthquakeHandler {
    public static List<Earthquake> ParseEarthquakesFromCSV(String filePath) {
        List<Earthquake> earthquakes = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                var earthquake = new Earthquake(line);
                earthquakes.add(earthquake);
            }
        } catch (IOException | com.opencsv.exceptions.CsvValidationException e) {
            e.printStackTrace();
        }

        return earthquakes;
    }
}
