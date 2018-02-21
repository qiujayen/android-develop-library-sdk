package android.module.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by jay on 2018/2/7 上午11:59
 */
public abstract class CommonFragment extends Fragment {

    public void startActivity(Class<Activity> cls) {
        startActivity(new Intent(getContext(), cls));
    }

    public void startActivity(Class<Activity> cls, Bundle options) {
        startActivity(new Intent(getContext(), cls), options);
    }
}
