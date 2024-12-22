import java.sql.*;

public class Database {
    public static Connection connection;
    public static Statement statement;

    public static void connectDB() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/database.db");
        statement = connection.createStatement();
    }

    public static void createTableEarthquakes() throws SQLException {
        statement.execute("CREATE TABLE IF NOT EXISTS earthquakes (" +
                "id TEXT PRIMARY KEY, " +
                "depth INTEGER, " +
                "type TEXT, " +
                "magnitude REAL, " +
                "state TEXT, " +
                "time TIMESTAMP)");
    }

    public static void addEarthquake(Earthquake earthquake) throws SQLException {
        String sql = "INSERT INTO earthquakes (id, depth, type, magnitude, state, time) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, earthquake.Id);
            preparedStatement.setInt(2, earthquake.Depth);
            preparedStatement.setString(3, earthquake.Type);
            preparedStatement.setDouble(4, earthquake.Magnitude);
            preparedStatement.setString(5, earthquake.State);
            preparedStatement.setTimestamp(6, Timestamp.valueOf(earthquake.Time));
            preparedStatement.executeUpdate();
        }
    }

    public static void closeDB() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Error closing database: " + e.getMessage());
        }
    }
}
