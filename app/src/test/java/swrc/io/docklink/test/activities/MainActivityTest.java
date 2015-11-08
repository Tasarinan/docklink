package swrc.io.docklink.test.activities;

import android.content.Intent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import swrc.io.docklink.BuildConfig;
import swrc.io.docklink.R;
import swrc.io.docklink.activities.DisplayMessageActivity;
import swrc.io.docklink.activities.MainActivity;


/**
 * Created by HB on 2015/10/15.
*/
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {
    @Test
    public void testMainActivity() {
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        //mainActivity.findViewById(R.id.send).performClick();

        Intent expectedIntent = new Intent(mainActivity,DisplayMessageActivity.class);
       // ShadowActivity shadowActivity = Shadows.shadowOf(mainActivity);
        //Intent actualIntent = shadowActivity.getNextStartedActivity();
       // Assert.assertEquals(expectedIntent, actualIntent);

    }
}


