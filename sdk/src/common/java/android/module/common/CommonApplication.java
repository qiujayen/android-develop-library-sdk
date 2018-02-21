package android.module.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.LinkedList;

/**
 * Created by jay on 2017/12/19 上午10:56
 */
public abstract class CommonApplication extends Application implements Application.ActivityLifecycleCallbacks {

    private LinkedList<Activity> mActivities = new LinkedList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(this);
    }

    public void onApplicationEnterForeground() {

    }

    public void onApplicationEnterBackground() {

    }

    // ------------------ ActivityLifecycleCallbacks API ------------------

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {
        mActivities.add(activity);
        onApplicationEnterForeground();
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        mActivities.remove(activity);
        if (mActivities.isEmpty()) {
            onApplicationEnterBackground();
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
