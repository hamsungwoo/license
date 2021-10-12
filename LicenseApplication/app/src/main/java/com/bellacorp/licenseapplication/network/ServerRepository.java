package com.bellacorp.licenseapplication.network;

import android.content.Context;

public class ServerRepository {
    private ServerApi mServerApi = null;

    private ServerRepository() {
        if (mServerApi == null) {
            mServerApi = ApiService.get().create();
        }
    }

    private static class ServerRepositoryHolder {
        public static final ServerRepository INSTANCE = new ServerRepository();
    }

    public static ServerRepository get() { return ServerRepositoryHolder.INSTANCE; }
    public ServerApi getApi() {
        return mServerApi;
    }
}
