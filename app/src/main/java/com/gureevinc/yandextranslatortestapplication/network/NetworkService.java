package com.gureevinc.yandextranslatortestapplication.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

import static com.gureevinc.yandextranslatortestapplication.StaticVariables.BASE_URL;

public class NetworkService {

    public static volatile NetworkService instance;
    private Retrofit retrofit;

    private NetworkService() {
        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());
        Gson gson = new GsonBuilder().create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(rxAdapter)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

    }

    public static NetworkService getInstance() {
        NetworkService result = instance;
        if (result != null) {
            return result;
        }
        synchronized (NetworkService.class) {
            if (instance == null) {
                instance = new NetworkService();
            }
            return instance;
        }
    }

    public JSONPlaceHolderApi getJsonPlaceHolderApi() {
        return retrofit.create(JSONPlaceHolderApi.class);
    }
}

