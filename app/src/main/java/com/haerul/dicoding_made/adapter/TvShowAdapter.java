package com.haerul.dicoding_made.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.haerul.dicoding_made.R;
import com.haerul.dicoding_made.data.model.TvShow;
import com.haerul.dicoding_made.databinding.ItemTvshowBinding;
import com.haerul.dicoding_made.view.MainViewModel;

import java.util.List;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.RecyclerViewAdapter> {
    private List<TvShow.Result> mTvShows;
    private MainViewModel mViewModel;

    public TvShowAdapter(List<TvShow.Result> mTvShows, MainViewModel mViewModel) {
        this.mTvShows = mTvShows;
        this.mViewModel = mViewModel;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemTvshowBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_tvshow, parent, false);
        return new RecyclerViewAdapter(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter holder, int position) {
        final TvShow.Result item = mTvShows.get(position);
        holder.bind(item, mViewModel);
    }

    @Override
    public int getItemCount() {
        return mTvShows.size();
    }

    public class RecyclerViewAdapter extends RecyclerView.ViewHolder {
        ItemTvshowBinding binding;

        public RecyclerViewAdapter(ItemTvshowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(@NonNull TvShow.Result item, MainViewModel mViewModel) {
            binding.setItem(item);
            binding.setViewModel(mViewModel);
            binding.executePendingBindings();
        }
    }
}
