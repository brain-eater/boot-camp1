package boot_camp.activity_log;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityLogTest {
    @Test
    void shouldGiveActivityLogUnTimedActivity() {
        ActivityLog<UnTimedActivity> activityLog = new ActivityLog<>();
        activityLog.add(new UnTimedActivity("Activity 1"));
        activityLog.add(new UnTimedActivity("Activity 2"));
        activityLog.add(new UnTimedActivity("Activity 3"));
        activityLog.add(new UnTimedActivity("Activity 4"));
        List<UnTimedActivity> expected = new ArrayList<>();
        expected.add(new UnTimedActivity("Activity 1"));
        expected.add(new UnTimedActivity("Activity 2"));
        expected.add(new UnTimedActivity("Activity 3"));
        expected.add(new UnTimedActivity("Activity 4"));
        assertEquals(expected, activityLog.display());
    }


    @Test
    void shouldGiveActivityLogTimedActivity() {
        ActivityLog<TimedActivity> activityLog = new ActivityLog<>();
        activityLog.add(new TimedActivity("Activity 1", new Date()));
        activityLog.add(new TimedActivity("Activity 2", new Date()));
        activityLog.add(new TimedActivity("Activity 3", new Date()));
        activityLog.add(new TimedActivity("Activity 4", new Date()));
        List<TimedActivity> expected = new ArrayList<>();
        expected.add(new TimedActivity("Activity 1", new Date()));
        expected.add(new TimedActivity("Activity 2", new Date()));
        expected.add(new TimedActivity("Activity 3", new Date()));
        expected.add(new TimedActivity("Activity 4", new Date()));
        assertEquals(expected, activityLog.display());
    }

}