import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Database.connectDB();

            if (!Database.doesTableExist("earthquakes"))
            {
                Database.createTableEarthquakes();

                List<Earthquake> earthquakes = EarthquakeHandler.ParseEarthquakesFromCSV("src/main/resources/Землетрясения.csv");

                for (Earthquake earthquake : earthquakes) {
                    Database.addEarthquake(earthquake);
                }
            }

            var eas = Database.getAllEarthquakes();
            var countsPerYear = EarthquakeHandler.getEarthquakeCountsPerYear(eas);

            EarthquakeChart.createAndShowChart(countsPerYear);

            var averageMagnitude = EarthquakeHandler.calculateAverageMagnitudeByState(eas, "West Virginia");
            System.out.println(averageMagnitude);

            var state = EarthquakeHandler.findStateWithDeepestEarthquake(eas, 2013);
            System.out.println(state);

        } catch (SQLException e) {
            System.err.println("Ошибка работы с базой данных: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        } finally {
            Database.closeDB();
        }
    }
}
