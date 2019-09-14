package com.haerul.dicoding_made.view;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
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

    public ObservableField<String> throwMessage;
    public MutableLiveData<Movie> movieData = new MutableLiveData<>();
    public MutableLiveData<TvShow> tvShowData = new MutableLiveData<>();

    private MainViewModel(ConnectionServer connectionServer) {
        super(connectionServer);
        throwMessage = new ObservableField<>(null);
    }

    public void getMovieResult() {
        setIsLoading(true);
        throwMessage.set(null);
        getConnectionServer().getMovies().enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(@NonNull Call<Movie> call, @NonNull Response<Movie> response) {
                setIsLoading(false);
                if (response.isSuccessful() && response.body() != null) {
                    movieData.setValue(response.body());
                    getNavigator().result(true, null);
                } else {
                    throwMessage.set("No result for movies!");
                    getNavigator().result(false, throwMessage.get());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Movie> call, @NonNull Throwable t) {
                t.printStackTrace();
                setIsLoading(false);
                throwMessage.set("Failed to connect!");
                getNavigator().result(false, throwMessage.get());
            }
        });
    }

    public void getTvShowResult() {
        setIsLoading(true);
        throwMessage.set(null);
        getConnectionServer().getTvShows().enqueue(new Callback<TvShow>() {
            @Override
            public void onResponse(@NonNull Call<TvShow> call, @NonNull Response<TvShow> response) {
                setIsLoading(false);
                if (response.isSuccessful() && response.body() != null) {
                    tvShowData.setValue(response.body());
                    getNavigator().result(true, null);
                } else {
                    throwMessage.set("No result for tv shows!");
                    getNavigator().result(false, throwMessage.get());
                }
            }

            @Override
            public void onFailure(@NonNull Call<TvShow> call, @NonNull Throwable t) {
                t.printStackTrace();
                throwMessage.set("Failed to connect!");
                getNavigator().result(false, throwMessage.get());
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
