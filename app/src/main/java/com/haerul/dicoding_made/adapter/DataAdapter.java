package com.haerul.dicoding_made.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haerul.dicoding_made.R;
import com.haerul.dicoding_made.data.Data;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    
    private final Context context;
    private List<Data> data;
    private ItemClickListener onItemClickListener;
    
    public DataAdapter(Context context, List<Data> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data data = this.data.get(position);
        holder.txtTitle.setText(data.getTitle());
        holder.txtYear.setText(String.valueOf(data.getYear()));
        holder.imgBanner.setImageResource(data.getBanner());
        holder.rating.setRating(data.getRating());
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtTitle;
        private TextView txtYear;
        private ImageView imgBanner;
        private RatingBar rating;

        ViewHolder(View view) {
            super(view);
            txtTitle = view.findViewById(R.id.title);
            txtYear = view.findViewById(R.id.year);
            imgBanner = view.findViewById(R.id.banner);
            rating = view.findViewById(R.id.ratingBar);
        
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onClick(v, getAdapterPosition());
        }
    }

    public void setItemClickListener(ItemClickListener clickListener) {
        onItemClickListener = clickListener;
    }

    public interface ItemClickListener {
        void onClick(View v, int i);
    }
}
