package swrc.io.docklink.test.activities;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import swrc.io.docklink.BuildConfig;
import swrc.io.docklink.activities.MainActivity;

import static org.junit.Assert.assertNotNull;

/**
 * Created by HB on 2015/10/15.
*/
 @RunWith(RobolectricTestRunner.class)
 @Config(constants = BuildConfig.class,sdk = 21)
 public class MainActivityTest {
     MainActivity activity;
    @Before
    public void setUp() throws  Exception
    {
        activity = Robolectric.buildActivity(MainActivity.class).create().start().restart().get();
    }
    @Test
    public void test_shouldNotBeNull() throws Exception {
           assertNotNull(activity);
    }
}