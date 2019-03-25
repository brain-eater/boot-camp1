package boot_camp.activity_log;

import java.util.Objects;

public class UnTimedActivity implements Activity {
    private String activity;

    public UnTimedActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnTimedActivity that = (UnTimedActivity) o;
        return Objects.equals(activity, that.activity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activity);
    }
}
