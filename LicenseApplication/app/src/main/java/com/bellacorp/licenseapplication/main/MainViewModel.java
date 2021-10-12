package com.bellacorp.licenseapplication.main;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.bellacorp.licenseapplication.Constant;
import com.bellacorp.licenseapplication.main.model.ExamSchedule;
import com.bellacorp.licenseapplication.main.model.ExamScheduleBody;
import com.bellacorp.licenseapplication.main.model.ExamScheduleItem;
import com.bellacorp.licenseapplication.network.ServerRepository;
import com.bellacorp.licenseapplication.main.model.Body;
import com.bellacorp.licenseapplication.main.model.LicenseItem;
import com.bellacorp.licenseapplication.main.model.LicenseListResponse;
import com.bellacorp.licenseapplication.util.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    public ObservableArrayList<LicenseItem> licenseItems = new ObservableArrayList<LicenseItem>();
    public ObservableField<String> searchText = new ObservableField<String>();
    public ObservableField<ExamScheduleItem> examScheduleItemPE = new ObservableField<>();
    public ObservableField<ExamScheduleItem> examScheduleItemMC = new ObservableField<>();
    public ObservableField<ExamScheduleItem> examScheduleItemCL = new ObservableField<>();
    public ObservableField<ExamScheduleItem> examScheduleItemEL = new ObservableField<>();

    public void fetchLicenseList(String job) {
        try {
            String decodedServiceKey = URLDecoder.decode(Constant.auth_key, "UTF-8");
            ServerRepository.get()
                    .getApi()
                    .getLicenseList(decodedServiceKey)
                    .enqueue(new Callback<LicenseListResponse>() {
                        @Override
                        public void onResponse(Call<LicenseListResponse> call, Response<LicenseListResponse> response) {
                            if (response.isSuccessful()) {
                                if (response.body() != null && response.body().header != null && response.body().body != null) {
                                    Body body = response.body().body;
                                    if (body.licenseList != null && body.licenseList.item != null) {
                                        List<LicenseItem> filtered = body.licenseList.item.stream().filter(licenseItem -> licenseItem.qualgbcd.equals("T")).collect(Collectors.toList());
                                        List<LicenseItem> filteredJob = filtered.stream().filter(item -> item.mdobligfldnm.contains(job)).collect(Collectors.toList());
                                        Logger.e("[INFO] item size ==> " + filtered.size() + ", " + body.licenseList.item.size());
                                        Logger.e("[INFO] job item size ==> " + filteredJob.size());
                                        licenseItems.addAll(filteredJob);
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
                        public void onFailure(Call<LicenseListResponse> call, Throwable t) {
                            Logger.e("[ERROR] " + t.getMessage());
                        }
                    });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void fetchExamScheduleEL() {
        String serviceKey = null;
        try {
            serviceKey = URLDecoder.decode(Constant.auth_key, "UTF-8");
            ServerRepository.get().getApi().getExamScheduleEL(serviceKey).enqueue(new Callback<ExamSchedule>() {
                @Override
                public void onResponse(Call<ExamSchedule> call, Response<ExamSchedule> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null && response.body().header != null && response.body().body != null) {
                            ExamScheduleBody body = response.body().body;
                            if (body.items != null && body.items.item != null) {
                                Logger.e("[INFO] item size ==> " + body.items.item.get(0).description);
                                examScheduleItemEL.set(body.items.item.get(0));
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
                public void onFailure(Call<ExamSchedule> call, Throwable t) {
                    Logger.e("[ERROR] " + t.getMessage());
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void fetchExamScheduleCL() {
        String serviceKey = null;
        try {
            serviceKey = URLDecoder.decode(Constant.auth_key, "UTF-8");
            ServerRepository.get().getApi().getExamScheduleCL(serviceKey).enqueue(new Callback<ExamSchedule>() {
                @Override
                public void onResponse(Call<ExamSchedule> call, Response<ExamSchedule> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null && response.body().header != null && response.body().body != null) {
                            ExamScheduleBody body = response.body().body;
                            if (body.items != null && body.items.item != null) {
                                Logger.e("[INFO] item size ==> " + body.items.item.get(0).description);
                                examScheduleItemCL.set(body.items.item.get(0));
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
                public void onFailure(Call<ExamSchedule> call, Throwable t) {
                    Logger.e("[ERROR] " + t.getMessage());
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void fetchExamScheduleMC() {
        String serviceKey = null;
        try {
            serviceKey = URLDecoder.decode(Constant.auth_key, "UTF-8");
            ServerRepository.get().getApi().getExamScheduleMC(serviceKey).enqueue(new Callback<ExamSchedule>() {
                @Override
                public void onResponse(Call<ExamSchedule> call, Response<ExamSchedule> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null && response.body().header != null && response.body().body != null) {
                            ExamScheduleBody body = response.body().body;
                            if (body.items != null && body.items.item != null) {
                                Logger.e("[INFO] item size ==> " + body.items.item.get(0).description);
                                examScheduleItemMC.set(body.items.item.get(0));
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
                public void onFailure(Call<ExamSchedule> call, Throwable t) {
                    Logger.e("[ERROR] " + t.getMessage());
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void fetchExamSchedulePE() {
        String serviceKey = null;
        try {
            serviceKey = URLDecoder.decode(Constant.auth_key, "UTF-8");
            ServerRepository.get().getApi().getExamSchedulePE(serviceKey).enqueue(new Callback<ExamSchedule>() {
                @Override
                public void onResponse(Call<ExamSchedule> call, Response<ExamSchedule> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null && response.body().header != null && response.body().body != null) {
                            ExamScheduleBody body = response.body().body;
                            if (body.items != null && body.items.item != null) {
                                Logger.e("[INFO] item size ==> " + body.items.item.get(0).description);
                                examScheduleItemPE.set(body.items.item.get(0));
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
                public void onFailure(Call<ExamSchedule> call, Throwable t) {
                    Logger.e("[ERROR] " + t.getMessage());
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
