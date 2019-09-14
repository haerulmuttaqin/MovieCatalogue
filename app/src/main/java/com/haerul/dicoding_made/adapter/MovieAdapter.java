package com.haerul.dicoding_made.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.haerul.dicoding_made.R;
import com.haerul.dicoding_made.data.model.Movie;
import com.haerul.dicoding_made.databinding.ItemMovieBinding;
import com.haerul.dicoding_made.view.MainViewModel;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.RecyclerViewAdapter> {
    private List<Movie.Result> mMovies;
    private MainViewModel mViewModel;

    public MovieAdapter(List<Movie.Result> mMovies, MainViewModel mViewModel) {
        this.mMovies = mMovies;
        this.mViewModel = mViewModel;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemMovieBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_movie, parent, false);
        return new RecyclerViewAdapter(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter holder, int position) {
        final Movie.Result item = mMovies.get(position);
        holder.bind(item, mViewModel);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class RecyclerViewAdapter extends RecyclerView.ViewHolder {
        ItemMovieBinding binding;

        public RecyclerViewAdapter(ItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(@NonNull Movie.Result item, MainViewModel mViewModel) {
            binding.setItem(item);
            binding.setViewModel(mViewModel);
            binding.executePendingBindings();
        }
    }
}