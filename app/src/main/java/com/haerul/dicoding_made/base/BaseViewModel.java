package com.haerul.dicoding_made.base;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;

import com.haerul.dicoding_made.data.api.ConnectionServer;

import java.lang.ref.WeakReference;

public abstract class BaseViewModel<N> extends ViewModel {

    private final ObservableBoolean isLoading = new ObservableBoolean(false);
    private final ObservableBoolean isConnecting = new ObservableBoolean(false);

    private WeakReference<N> navigator;

    private ConnectionServer connectionServer;

    public BaseViewModel(ConnectionServer connectionServer) {
        this.connectionServer = connectionServer;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public ObservableBoolean getIsLoading() {
        return isLoading;
    }

    public void setIsLoading(boolean isLoading) {
        this.isLoading.set(isLoading);
    }

    public N getNavigator() {
        return navigator.get();
    }

    public void setNavigator(N navigator) {
        this.navigator = new WeakReference<>(navigator);
    }

    public ObservableBoolean getIsConnecting() {
        return isConnecting;
    }

    public void setIsConnecting(boolean isConnecting) {
        this.isConnecting.set(isConnecting);
    }

    public ConnectionServer getConnectionServer() {
        return connectionServer;
    }
}
