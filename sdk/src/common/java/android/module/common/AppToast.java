package android.module.common;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by jay on 2018/1/19 上午9:31
 */
public final class AppToast {

    private static AppToast sInstance = null;
    private Toast mToast;

    private AppToast() {
    }

    private static AppToast getInstance() {
        if (sInstance == null) {
            sInstance = new AppToast();
        }
        return sInstance;
    }

    private void _show(Context context, CharSequence text) {
        if (TextUtils.isEmpty(text)) return;
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        mToast.show();
    }

    public static void show(Context context, int resId) {
        show(context, context.getString(resId));
    }

    public static void show(Context context, CharSequence text) {
        getInstance()._show(context, text);
    }
}
