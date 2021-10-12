package com.bellacorp.licenseapplication.job;

import android.util.Log;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.ViewModel;

import com.bellacorp.licenseapplication.Constant;
import com.bellacorp.licenseapplication.job.model.JobBody;
import com.bellacorp.licenseapplication.job.model.JobItem;
import com.bellacorp.licenseapplication.job.model.JobModel;
import com.bellacorp.licenseapplication.main.model.Body;
import com.bellacorp.licenseapplication.main.model.LicenseItem;
import com.bellacorp.licenseapplication.main.model.LicenseListResponse;
import com.bellacorp.licenseapplication.network.ServerRepository;
import com.bellacorp.licenseapplication.util.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobViewModel extends ViewModel {
    public ObservableArrayList<JobItem> jobItems = new ObservableArrayList<>();
    public int totalElement = 0;
    public int row = 1000;
    public int page = 1;
    public void fetchJobLister() {
        try {
            String decodedServiceKey = URLDecoder.decode(Constant.auth_key, "UTF-8");
            Logger.e("[INFO] page ==> " + page);
            ServerRepository.get()
                    .getApi()
                    .getJobList(decodedServiceKey, page, row)
                    .enqueue(new Callback<JobModel>() {
                        @Override
                        public void onResponse(Call<JobModel> call, Response<JobModel> response) {
                            if (response.isSuccessful()) {
                                if (response.body() != null && response.body().header != null && response.body().body != null) {
                                    JobBody body = response.body().body;
                                    if (body.items != null && body.items.item != null) {
//                                        Logger.e("[INFO] item size ==> " + filtered.size());
                                        jobItems.addAll(body.items.item);
                                        totalElement = body.totalCount;
                                    } else {
                                        Logger.e("[ERROR] No items");
                                    }
                                } else {
                                    Logger.e("[ERROR] It dose not have body!");
                                }
                            } else {
                                Logger.e("[ERROR] Network error!");
                            }
                        }

                        @Override
                        public void onFailure(Call<JobModel> call, Throwable t) {
                            Logger.e("[ERROR] " + t.getMessage());
                        }
                    });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void nextPage() {
        page += 1;
        fetchJobLister();
    }
}
