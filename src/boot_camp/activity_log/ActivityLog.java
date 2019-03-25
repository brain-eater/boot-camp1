package boot_camp.activity_log;

import java.util.*;

public class ActivityLog<ActivityType extends Activity> {

    private List<ActivityType> activities;

    public ActivityLog() {
        this.activities = new ArrayList<>();
    }

    public void add(ActivityType latestActivity) {
        this.activities.add(latestActivity);
    }


    public List<ActivityType> display() {
        return this.activities;
    }
}
