import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    private LocalDateTime dateTime;

    // if a LocalDate gets passed to function, instead set a date with time (LocalDateTime)
    public Gigasecond(LocalDate moment) {
        this.dateTime = moment.atTime(0, 0, 0);
    }

    // if a date with time (LocalDateTime) gets passed,
    public Gigasecond(LocalDateTime moment) {
        this.dateTime = moment;
    }

    // add and return a gigasecond to the date with time
    public LocalDateTime getDateTime() {
        return this.dateTime.plusSeconds(1000000000);
    }
}
