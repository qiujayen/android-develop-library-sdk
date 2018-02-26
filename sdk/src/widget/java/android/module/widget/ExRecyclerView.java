package android.module.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by jay on 2018/2/25 下午2:16
 */
public class ExRecyclerView extends RecyclerView {
    private OnItemLongClickListener mOnItemLongClickListener;
    private OnItemClickListener mOnItemClickListener;
    private boolean isLoading;
    private OnLoadingListener mOnLoadingListener;

    public ExRecyclerView(Context context) {
        this(context, null);
    }

    public ExRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        SimpleOnItemTouchListener itemTouchListener = new SimpleOnItemTouchListener() {
            private GestureDetector mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent ev) {
                    if (mOnItemClickListener != null) {
                        View view = ExRecyclerView.this.findChildViewUnder(ev.getX(), ev.getY());
                        int position = ExRecyclerView.this.getChildAdapterPosition(view);
                        mOnItemClickListener.onItemClick(view, position);
                        return true;
                    }
                    return false;
                }

                @Override
                public void onLongPress(MotionEvent ev) {
                    if (mOnItemLongClickListener != null) {
                        View view = ExRecyclerView.this.findChildViewUnder(ev.getX(), ev.getY());
                        int position = ExRecyclerView.this.getChildAdapterPosition(view);
                        mOnItemLongClickListener.onItemLongClick(view, position);
                    }
                }
            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return mGestureDetector.onTouchEvent(e);
            }

        };
        addOnItemTouchListener(itemTouchListener);


        addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!recyclerView.canScrollVertically(1)
                        && !isLoading
                        && mOnLoadingListener != null
                        && dy > 0) {
                    isLoading = true;
                    mOnLoadingListener.onLoading();
                }
            }
        });
    }

    public void setLoading(boolean isLoading) {
        this.isLoading = isLoading;
    }

    public void setOnLoadingListener(OnLoadingListener listener) {
        mOnLoadingListener = listener;
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        mOnItemLongClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View v, int position);
    }

    public interface OnLoadingListener {
        void onLoading();
    }
}
