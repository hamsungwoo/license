package com.bellacorp.licenseapplication.detail;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.bellacorp.licenseapplication.Constant;
import com.bellacorp.licenseapplication.detail.model.ExamFee;
import com.bellacorp.licenseapplication.detail.model.ExamFeeBody;
import com.bellacorp.licenseapplication.detail.model.ExamFeeItem;
import com.bellacorp.licenseapplication.main.model.ExamSchedule;
import com.bellacorp.licenseapplication.main.model.ExamScheduleBody;
import com.bellacorp.licenseapplication.main.model.ExamScheduleItem;
import com.bellacorp.licenseapplication.detail.model.LicenseDetail;
import com.bellacorp.licenseapplication.detail.model.LicenseDetailBody;
import com.bellacorp.licenseapplication.detail.model.LicenseDetailItem;
import com.bellacorp.licenseapplication.detail.model.LicenseQualInfo;
import com.bellacorp.licenseapplication.detail.model.LicenseQualInfoBody;
import com.bellacorp.licenseapplication.detail.model.LicenseQualInfoItem;
import com.bellacorp.licenseapplication.main.model.LicenseItem;
import com.bellacorp.licenseapplication.network.ServerRepository;
import com.bellacorp.licenseapplication.util.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LicenseDetailViewModel extends ViewModel {
    public ObservableField<LicenseItem> currentItem = new ObservableField<>();
    public ObservableField<LicenseDetailItem> licenseDetailItems = new ObservableField<>();
    public ObservableField<ExamFeeItem> examFeeItem = new ObservableField<>();
    public ObservableField<ExamScheduleItem> examScheduleItem = new ObservableField<>();
    public ObservableField<LicenseQualInfoItem> licenseQualInfoItem = new ObservableField<>();

    public void fetchExamFee(LicenseItem item) {
        String serviceKey = null;
        try {
            serviceKey = URLDecoder.decode(Constant.auth_key, "UTF-8");
            ServerRepository.get().getApi().getExamFee(serviceKey, item.jmcd).enqueue(new Callback<ExamFee>() {
                @Override
                public void onResponse(Call<ExamFee> call, Response<ExamFee> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null && response.body().header != null && response.body().body != null) {
                            ExamFeeBody body = response.body().body;
                            if (body.items != null && body.items.item != null) {
                                Logger.e("[INFO] item size ==> " + body.items.item.get(0).contents);
                                examFeeItem.set(body.items.item.get(0));
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
                public void onFailure(Call<ExamFee> call, Throwable t) {
                    Logger.e("[ERROR] " + t.getMessage());
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void fetchLicenseDetail(LicenseItem item) {
        String serviceKey = null;
        try {
            serviceKey = URLDecoder.decode(Constant.auth_key, "UTF-8");
            ServerRepository.get().getApi().getLicenseDetail(serviceKey, item.seriescd).enqueue(new Callback<LicenseDetail>() {
                @Override
                public void onResponse(Call<LicenseDetail> call, Response<LicenseDetail> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null && response.body().header != null && response.body().body != null) {
                            LicenseDetailBody body = response.body().body;
                            if (body.items != null && body.items.item != null) {
                                List<LicenseDetailItem> license = body.items.item.stream()
                                        .filter(licenseDetailItem -> licenseDetailItem.jmNm.replace(" ", "").trim().equals(item.jmfldnm.replace(" ", "").trim()))
                                        .collect(Collectors.toList());

                                Logger.e("[INFO] license ==> " + license.get(0).instiNm);
                                licenseDetailItems.set(license.get(0));
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
                public void onFailure(Call<LicenseDetail> call, Throwable t) {
                    Logger.e("[ERROR] " + t.getMessage());
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void fetchQualInfo(LicenseItem item) {
        String serviceKey = null;
        try {
            serviceKey = URLDecoder.decode(Constant.auth_key, "UTF-8");
            ServerRepository.get().getApi().getLicenseQualInfo(serviceKey, item.jmcd).enqueue(new Callback<LicenseQualInfo>() {
                @Override
                public void onResponse(Call<LicenseQualInfo> call, Response<LicenseQualInfo> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null && response.body().header != null && response.body().body != null) {
                            LicenseQualInfoBody body = response.body().body;
                            if (body.items != null && body.items.item != null) {
                                Logger.e("[INFO] item size ==> " + body.items.item.get(0).contents);
                                licenseQualInfoItem.set(body.items.item.get(0));
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
                public void onFailure(Call<LicenseQualInfo> call, Throwable t) {
                    Logger.e("[ERROR] " + t.getMessage());
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
