package android.module.common;

import android.develop.sdk.R;
import android.module.widget.ExRecyclerView;
import android.module.widget.RecyclerViewHolder;
import android.module.widget.StateLayout;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jay on 2018/2/13 下午12:28
 */
public abstract class RecyclerViewFragment extends CommonFragment {


    private StateLayout mStateLayout;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ExRecyclerView mRecyclerView;

    public View onCustomView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = onCustomView(inflater, container, savedInstanceState);
        if (view == null) {
            return inflater.inflate(R.layout.common_fragment_recycler_view, container, false);
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mStateLayout = (StateLayout) view.findViewById(R.id.state_layout);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        mRecyclerView = (ExRecyclerView) view.findViewById(R.id.recycler_view);

        setup();
    }

    private void setup() {
        if (mRecyclerView != null) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setAdapter(mAdapter);

            mRecyclerView.setOnItemClickListener(new ExRecyclerView.OnItemClickListener() {
                @Override
                public void onItemClick(View v, int position) {
                    RecyclerViewFragment.this.onItemClick(v, position);
                }
            });

            mRecyclerView.setOnItemLongClickListener(new ExRecyclerView.OnItemLongClickListener() {
                @Override
                public void onItemLongClick(View v, int position) {
                    RecyclerViewFragment.this.onItemLongClick(v, position);
                }
            });
        }
    }

    protected void onItemClick(View view, int position) {

    }

    protected void onItemLongClick(View view, int position) {

    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        mRecyclerView.setAdapter(adapter);
    }

    public StateLayout getStateLayout() {
        return mStateLayout;
    }

    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return mSwipeRefreshLayout;
    }

    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

    }

    public int getItemCount() {
        return 0;
    }

    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<RecyclerViewHolder>() {

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return RecyclerViewFragment.this.onCreateViewHolder(parent, viewType);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            RecyclerViewFragment.this.onBindViewHolder(holder, position);
        }

        @Override
        public int getItemCount() {
            return RecyclerViewFragment.this.getItemCount();
        }
    };
}
