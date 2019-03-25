package boot_camp.activity_log;

import java.util.Date;
import java.util.Objects;

public class TimedActivity implements Activity {

    private final String activity;
    private final Date date;

    public TimedActivity(String activity, Date date) {
        this.activity = activity;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimedActivity that = (TimedActivity) o;
        return Objects.equals(activity, that.activity) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activity);
    }
}
