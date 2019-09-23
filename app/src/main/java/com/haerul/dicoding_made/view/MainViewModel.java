package com.haerul.dicoding_made.view;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.haerul.dicoding_made.base.BaseViewModel;
import com.haerul.dicoding_made.data.api.ConnectionServer;
import com.haerul.dicoding_made.data.model.Movie;
import com.haerul.dicoding_made.data.model.TvShow;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends BaseViewModel<MainViewModel.MainNavigator> {

    public MutableLiveData<Movie> movieData = new MutableLiveData<>();
    public MutableLiveData<TvShow> tvShowData = new MutableLiveData<>();

    private MainViewModel(ConnectionServer connectionServer) {
        super(connectionServer);
    }

    public void getMovieResult() {
        setIsLoading(true);
        getConnectionServer().getMovies().enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(@NonNull Call<Movie> call, @NonNull Response<Movie> response) {
                setIsLoading(false);
                if (response.isSuccessful() && response.body() != null) {
                    movieData.setValue(response.body());
                    getNavigator().result(true, null);
                } else {
                    getNavigator().result(false, "No data to fetch");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Movie> call, @NonNull Throwable t) {
                t.printStackTrace();
                setIsLoading(false);
                getNavigator().result(false, "Failed to connect");
            }
        });
    }

    public void getTvShowResult() {
        setIsLoading(true);
        getConnectionServer().getTvShows().enqueue(new Callback<TvShow>() {
            @Override
            public void onResponse(@NonNull Call<TvShow> call, @NonNull Response<TvShow> response) {
                setIsLoading(false);
                if (response.isSuccessful() && response.body() != null) {
                    tvShowData.setValue(response.body());
                    getNavigator().result(true, null);
                } else {
                    getNavigator().result(false, "No data to fetch");
                }
            }

            @Override
            public void onFailure(@NonNull Call<TvShow> call, @NonNull Throwable t) {
                t.printStackTrace();
                setIsLoading(false);
                getNavigator().result(false, "Failed to connect");
            }
        });
    }

    public void onMovieClick(Movie.Result movie) {
        getNavigator().onMovieClick(movie);
    }

    public void onTvShowClick(TvShow.Result tvShow) {
        getNavigator().onTvShowClick(tvShow);
    }

    public static class ModelFactory implements ViewModelProvider.Factory {
        private ConnectionServer connectionServer;

        public ModelFactory(ConnectionServer connectionServer) {
            this.connectionServer = connectionServer;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new MainViewModel(connectionServer);
        }
    }

    public interface MainNavigator {
        void result(boolean isSuccess, String message);

        void onMovieClick(Movie.Result obj);

        void onTvShowClick(TvShow.Result obj);
    }
}
