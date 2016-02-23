package com.example.caiosanchez.recyclerviewexample.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.caiosanchez.recyclerviewexample.IAdapterOnClickListener;
import com.example.caiosanchez.recyclerviewexample.Model.Item;
import com.example.caiosanchez.recyclerviewexample.R;

import java.util.List;

/**
 * Created by Caio Sanchez on 23/02/2016.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private final List<Item> values;
    private final IAdapterOnClickListener delegate;

    public RecycleViewAdapter(List<Item> mItems, IAdapterOnClickListener mDelegate) {
        values = mItems;
        delegate = mDelegate;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.item = values.get(position);
        holder.contentView.setText(values.get(position).content);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != delegate) {
                    delegate.onClickItem(holder.item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView contentView;
        public Item item;

        public ViewHolder(View view) {
            super(view);
            contentView = (TextView) view.findViewById(R.id.content);
        }
    }
}
