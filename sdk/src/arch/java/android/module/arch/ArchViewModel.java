package android.module.arch;

import android.arch.lifecycle.ViewModel;

/**
 * Created by jay on 2018/2/7 上午10:51
 */
public class ArchViewModel extends ViewModel {
    protected ResStringLiveData mResStringLiveData = new ResStringLiveData();
    protected StringLiveData mStringLiveData = new StringLiveData();

    public StringLiveData getStringLiveData() {
        return mStringLiveData;
    }

    public ResStringLiveData getResStringLiveData() {
        return mResStringLiveData;
    }
}
