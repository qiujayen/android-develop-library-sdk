package android.module.widget;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jay on 2018/2/5 上午10:58
 */
public abstract class RecyclerArrayAdapter<E> extends RecyclerView.Adapter<RecyclerViewHolder> {

    private final Context mContext;
    private final int mItemLayout;
    private final LayoutInflater mLayoutInflater;
    private List<E> mItems;

    public RecyclerArrayAdapter(Context context, @LayoutRes int itemLayout) {
        mContext = context;
        mItemLayout = itemLayout;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(mLayoutInflater.inflate(mItemLayout, parent, false));
    }

    public void setItems(List<E> items) {
        mItems = items;
    }

    public void addItem(E item) {
        if (mItems == null) {
            mItems = new ArrayList<>();
        }
        mItems.add(item);
    }

    public void removeItem(E item) {
        if (mItems == null) {
            mItems = new ArrayList<>();
        }
        mItems.remove(item);
    }

    public void removeItem(int position) {
        if (mItems == null) {
            mItems = new ArrayList<>();
        }
        mItems.remove(position);
    }

    public void addItems(List<E> items) {
        if (mItems == null) {
            mItems = new ArrayList<>();
        }
        mItems.addAll(items);
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }
}
