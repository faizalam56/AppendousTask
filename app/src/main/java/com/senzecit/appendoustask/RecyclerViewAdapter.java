package com.senzecit.appendoustask;

import android.support.v4.view.GravityCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import com.senzecit.appendoustask.asymmetricgridview.AGVRecyclerViewAdapter;
import com.senzecit.appendoustask.asymmetricgridview.AsymmetricItem;
import com.senzecit.appendoustask.model.DemoItem;

import java.util.List;



class RecyclerViewAdapter extends AGVRecyclerViewAdapter<ViewHolder> {
    private final List<DemoItem> items;

    RecyclerViewAdapter(List<DemoItem> items) {
        this.items = items;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("RecyclerViewActivity", "onCreateView");
        return new ViewHolder(parent, viewType);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("RecyclerViewActivity", "onBindView position=" + position);
        holder.bind(items.get(position));
    }

    @Override public int getItemCount() {
        return items.size();
    }

    @Override public AsymmetricItem getItem(int position) {
        return items.get(position);
    }

    @Override public int getItemViewType(int position) {
        return position % 2 == 0 ? 1 : 0;
    }
}

class ViewHolder extends RecyclerView.ViewHolder {
    private final TextView textView;

    ViewHolder(ViewGroup parent, int viewType) {
        super(LayoutInflater.from(parent.getContext()).inflate(
                viewType == 0 ? R.layout.adapter_item : R.layout.adapter_item_odd, parent, false));
        if (viewType == 0) {
            textView = (TextView) itemView.findViewById(R.id.textview);
        } else {
            textView = (TextView) itemView.findViewById(R.id.textview_odd);
        }
    }

    void bind(DemoItem item) {
        textView.setText(String.valueOf(item.getPosition()));
    }
}
