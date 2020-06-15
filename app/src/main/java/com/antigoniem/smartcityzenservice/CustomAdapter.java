package com.antigoniem.smartcityzenservice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Model> items;

    CustomAdapter(List<Model> items) {
        this.items = new ArrayList<>();
        this.items.addAll(items);
    }

    public void updateItems(List<Model> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_list, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Model item = items.get(position);
        holder.bind(item.getTitle(), item.getValue());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        CustomViewHolder(View view) {
            super(view);
        }

        void bind(String title, String value) {
            ((TextView) itemView.findViewById(R.id.item_title)).setText(title);
            ((TextView) itemView.findViewById(R.id.item_value)).setText(value);
        }

    }
}