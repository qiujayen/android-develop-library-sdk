package android.module.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by jay on 2018/1/18 下午2:59
 */
public final class SPUtils {
    private SPUtils() {

    }

    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPreferences getSharedPreferences(Context context, String name, int mode) {
        return context.getSharedPreferences(name, mode);
    }

    public static String getString(Context context, String key, String defValue) {
        return getDefaultSharedPreferences(context).getString(key, defValue);
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        return getDefaultSharedPreferences(context).getBoolean(key, defValue);
    }
}