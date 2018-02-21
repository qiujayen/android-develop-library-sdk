package android.module.arch;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

/**
 * Created by jay on 2018/2/7 上午10:49
 */
public class ArchAndroidViewModel extends AndroidViewModel {

    protected ResStringLiveData mResStringLiveData = new ResStringLiveData();
    protected StringLiveData mStringLiveData = new StringLiveData();

    public ArchAndroidViewModel(@NonNull Application application) {
        super(application);
    }

    public ResStringLiveData getResStringLiveData() {
        return mResStringLiveData;
    }

    public StringLiveData getStringLiveData() {
        return mStringLiveData;
    }
}
