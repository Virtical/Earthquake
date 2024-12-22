import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Earthquake {
    public String Id;
    public int Depth;
    public String Type;
    public double Magnitude;
    public String State;
    public LocalDateTime Time;

    public Earthquake(String id, int depth, String type, double magnitude, String state, LocalDateTime time) {
        Id = id;
        Depth = depth;
        Type = type;
        Magnitude = magnitude;
        State = state;
        Time = time;
    }

    public Earthquake(String[] line) {
        Id = line[0];
        Depth = Integer.parseInt(line[1]);
        Type = line[2];
        Magnitude = Double.parseDouble(line[3]);
        State = line[4];
        Time = parseDate(line[5]);
    }

    private LocalDateTime parseDate(String dateTimeStr) {
        if (dateTimeStr.contains("T")) {
            return ZonedDateTime.parse(dateTimeStr).toLocalDateTime();
        }

        String pattern = dateTimeStr.length() == 19 ? "yyyy-MM-dd HH:mm:ss" : "yyyy-MM-dd H:mm:ss";
        var formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(dateTimeStr, formatter);
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "id='" + Id + '\'' +
                ", depthMeters=" + Depth +
                ", magnitudeType='" + Type + '\'' +
                ", magnitude=" + Magnitude +
                ", state='" + State + '\'' +
                ", time=" + Time +
                '}';
    }
}
