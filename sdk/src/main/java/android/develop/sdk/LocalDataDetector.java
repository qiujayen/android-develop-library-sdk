package android.develop.sdk;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jay on 2018/2/25 上午10:27
 */
public abstract class LocalDataDetector {

    protected final SharedPreferences mSharedPreferences;

    protected LocalDataDetector(Application application, String name) {
        mSharedPreferences = application.getSharedPreferences(name, Context.MODE_PRIVATE);

    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        mSharedPreferences.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        mSharedPreferences.unregisterOnSharedPreferenceChangeListener(listener);
    }
}
