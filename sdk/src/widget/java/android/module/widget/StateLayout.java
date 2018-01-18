package android.module.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jay on 2018/1/16 下午3:18
 */
public class StateLayout extends FrameLayout {
    private static final String TAG = "StateLayout";
    /**
     * 正常/默认 状态
     */
    public static final int STATE_NORMAL = -1;
    /**
     * 一般定义为空数据状态
     */
    public static final int STATE_EMPTY = 0;
    /**
     * 加载中状态
     */
    public static final int STATE_LOADING = 1;
    /**
     * 错误状态
     */
    public static final int STATE_ERROR = 2;

    private List<Integer> mStates = new ArrayList<>();
    private StateChangeListener mStateChangeListener;
    private SparseArray<View> mStateViewPool = new SparseArray<>();

    {
        addState(STATE_NORMAL, STATE_EMPTY, STATE_LOADING, STATE_ERROR);
    }

    public StateLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setState(Integer... states) {
        mStates = Arrays.asList(states);
    }

    public void addState(Integer... states) {
        mStates.addAll(Arrays.asList(states));
    }

    public void setStateChangeListener(StateChangeListener listener) {
        mStateChangeListener = listener;
    }

    public void setup() {
        int childCount = getChildCount();
        if (childCount > 1) {
            Log.e(TAG, "初始化子View只能有一个");
            View normalView = getChildAt(0);
            mStateViewPool.append(STATE_NORMAL, normalView);
        }
        if (mStateChangeListener != null) {
            for (Integer state : mStates) {
                View stateView = mStateChangeListener.onCreateStateView(state);
                mStateViewPool.append(state, stateView);
                addView(stateView);
            }
        }
    }

    public void setCurrentState(int state, Object data) {
        if (mStateChangeListener != null) {
            int size = mStateViewPool.size();
            for (int i = 0; i < size; i++) {
                int statePool = mStateViewPool.keyAt(i);
                View view = mStateViewPool.get(statePool);
                if (statePool == state) {
                    // 如果此次循环的状态与将要切换的状态一致，此状态对应的 View 置为可见状态
                    view.setVisibility(View.VISIBLE);
                    mStateChangeListener.onChangeView(view, data);
                } else {
                    view.setVisibility(View.GONE);
                }
            }
        }
    }

    public interface StateChangeListener {
        View onCreateStateView(int state);

        void onChangeView(View view, Object data);
    }
}
