package com.bellacorp.licenseapplication.network;

import com.bellacorp.licenseapplication.BuildConfig;
import com.tickaroo.tikxml.TikXml;
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private ApiService() { }

    private static class ApiServiceHolder {
        public static final ApiService INSTANCE = new ApiService();
    }

    public static ApiService get() {
        return ApiServiceHolder.INSTANCE;
    }

    public ServerApi create() {
        TikXml tikXml = new TikXml.Builder().exceptionOnUnreadXml(false).build();
        return new Retrofit.Builder()
                .addConverterFactory(TikXmlConverterFactory.create(tikXml))
                .baseUrl(BuildConfig.HOST)
                .client(new HttpClient().client)
                .build()
                .create(ServerApi.class);
    }
}
