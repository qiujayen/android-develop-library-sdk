package android.module.widget;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * Created by jay on 2018/2/5 上午11:00
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews = new SparseArray<>();

    public RecyclerViewHolder(View itemView) {
        super(itemView);
    }

    public <V extends View> V getView(int resId) {
        View view = mViews.get(resId);
        if (view == null) {
            view = itemView.findViewById(resId);
            mViews.put(resId, view);
        }
        return (V) view;
    }

    public RecyclerViewHolder setText(int resId, CharSequence text) {
        TextView view = getView(resId);
        if (view != null) {
            view.setText(text);
        }
        return this;
    }
}
