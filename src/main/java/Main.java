import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Database.connectDB();

            Database.createTableEarthquakes();

            List<Earthquake> earthquakes = EarthquakeHandler.ParseEarthquakesFromCSV("src/main/resources/Землетрясения.csv");

            for (Earthquake earthquake : earthquakes) {
                Database.addEarthquake(earthquake);
            }

            System.out.println("Все землетрясения успешно добавлены в базу данных!");

        } catch (SQLException e) {
            System.err.println("Ошибка работы с базой данных: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        } finally {
            Database.closeDB();
        }
    }
}
