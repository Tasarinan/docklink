package swrc.io.docklink;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by dvkx47 on 2015/10/6.
 */
public class DocklinkApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
       // Parse.initialize(this);
        Parse.initialize(this, "jHrGjuHhdVZIoy1Hk7f15GsWU2nf2VnjCMrIMC6x", "wSc5CLAMi7Q84sYkvXGB17seG3kEVKXTbz0XNmhm");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
