package android.module.arch;


import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

/**
 * Created by jay on 2018/2/7 上午10:28
 */
public class StringLiveData extends SingleLiveData<String> {

    public void observe(LifecycleOwner owner, final StringObserver observer) {
        super.observe(owner, new Observer<String>() {

            @Override
            public void onChanged(@Nullable String str) {
                if (str == null) {
                    return;
                }
                observer.onNewString(str);
            }
        });
    }

    public interface StringObserver {
        void onNewString(String str);
    }
}
