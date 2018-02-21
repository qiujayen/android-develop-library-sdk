package android.module.arch;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

/**
 * Created by jay on 2018/2/7 上午11:05
 */
public class EventLiveData<V> extends SingleLiveData<EventLiveData.Event<V>> {
    public void observe(LifecycleOwner owner, final EventObserver<V> observer) {
        super.observe(owner, new Observer<Event<V>>() {

            @Override
            public void onChanged(@Nullable Event<V> event) {
                if (event == null) {
                    return;
                }
                observer.onViewModelPostEvent(event);
            }
        });
    }

    public interface EventObserver<V> {
        void onViewModelPostEvent(Event<V> event);
    }

    @Override
    public void setValue(@Nullable Event<V> vEvent) {
        super.setValue(vEvent);
    }

    public static class Event<V> {
        public int code;
        public String message;
        public V value;
    }
}
