import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static Map<Integer, Long> getEarthquakeCountsPerYear(List<Earthquake> earthquakes) {
        return earthquakes.stream()
                .collect(Collectors.groupingBy(eq -> eq.Time.getYear(), Collectors.counting()));
    }

    public static double calculateAverageMagnitudeByState(List<Earthquake> earthquakes, String state) {
        if (earthquakes == null || earthquakes.isEmpty()) {
            throw new IllegalArgumentException("Список землетрясений пуст или равен null.");
        }

        return earthquakes.stream()
                .filter(eq -> eq.State.equals(state))
                .mapToDouble(eq -> eq.Magnitude)
                .average()
                .orElse(0.0);
    }

    public static String findStateWithDeepestEarthquake(List<Earthquake> earthquakes, Integer year) {
        if (earthquakes == null || earthquakes.isEmpty()) {
            throw new IllegalArgumentException("Список землетрясений пуст или равен null.");
        }

        return earthquakes.stream()
                .filter(eq -> eq.Time.getYear() == year)
                .max(Comparator.comparingInt(eq -> eq.Depth))
                .map(eq -> eq.State)
                .orElse("Не найдено");
    }
}
