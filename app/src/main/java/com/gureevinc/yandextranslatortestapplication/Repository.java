package com.gureevinc.yandextranslatortestapplication;

import android.content.Context;

import androidx.room.Room;

import com.gureevinc.yandextranslatortestapplication.network.NetworkService;
import com.gureevinc.yandextranslatortestapplication.sqlite.RoomDB;

import static com.gureevinc.yandextranslatortestapplication.StaticVariables.DB_NAME;

public class Repository {

    private static volatile Repository REPOSITORY;
    private NetworkService networkService;
    private RoomDB roomDB;

    public NetworkService getNetworkService() {
        return networkService;
    }

    public RoomDB getRoomDB() {
        return roomDB;
    }

    private Repository(Context context) {
        networkService = NetworkService.getInstance();
        roomDB = Room.databaseBuilder(context.getApplicationContext(),RoomDB.class,DB_NAME).build();
    }

    public static Repository getInstance(Context context) {
        Repository result = REPOSITORY;
        if(result!=null){
            return result;
        }
        synchronized (Repository.class){
            if(result==null){
                REPOSITORY = new Repository(context);
            }
            return REPOSITORY;
        }
    }


}
