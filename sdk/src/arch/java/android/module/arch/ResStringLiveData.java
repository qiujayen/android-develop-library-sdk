package android.module.arch;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

/**
 * Created by jay on 2018/2/7 上午10:31
 */
public class ResStringLiveData extends SingleLiveData<Integer> {

    public void observe(LifecycleOwner owner, final ResObserver observer) {
        super.observe(owner, new Observer<Integer>() {

            @Override
            public void onChanged(@Nullable Integer resId) {
                if (resId == null) {
                    return;
                }
                observer.onNewResString(resId);
            }
        });
    }

    public interface ResObserver {
        void onNewResString(@StringRes int resId);
    }
}
