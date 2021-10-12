package com.bellacorp.licenseapplication.network;

import com.bellacorp.licenseapplication.detail.model.ExamFee;
import com.bellacorp.licenseapplication.job.model.JobModel;
import com.bellacorp.licenseapplication.main.model.ExamSchedule;
import com.bellacorp.licenseapplication.detail.model.LicenseDetail;
import com.bellacorp.licenseapplication.detail.model.LicenseQualInfo;
import com.bellacorp.licenseapplication.main.model.LicenseListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServerApi {
    @GET("/api/service/rest/InquiryListNationalQualifcationSVC/getList")
    Call<LicenseListResponse> getLicenseList(@Query(value = "serviceKey", encoded = true) String publicKey);

    @GET("/api/service/rest/InquiryTestInformationNTQSVC/getPEList")
    Call<ExamSchedule> getExamSchedulePE(@Query(value = "serviceKey", encoded = true) String publicKey);

    @GET("/api/service/rest/InquiryTestInformationNTQSVC/getMCList")
    Call<ExamSchedule> getExamScheduleMC(@Query(value = "serviceKey", encoded = true) String publicKey);

    @GET("/api/service/rest/InquiryTestInformationNTQSVC/getEList")
    Call<ExamSchedule> getExamScheduleEL(@Query(value = "serviceKey", encoded = true) String publicKey);

    @GET("/api/service/rest/InquiryTestInformationNTQSVC/getCList")
    Call<ExamSchedule> getExamScheduleCL(@Query(value = "serviceKey", encoded = true) String publicKey);

    @GET("/api/service/rest/InquiryTestInformationNTQSVC/getFeeList")
    Call<ExamFee> getExamFee(@Query(value = "serviceKey", encoded = true) String publicKey, @Query("jmcd") String jmcd);

    @GET("/api/service/rest/InquiryQualInfo/getList")
    Call<LicenseDetail> getLicenseDetail(@Query(value = "serviceKey", encoded = true) String publicKey, @Query("seriesCd") String seriesCd);

    @GET("/api/service/rest/InquiryInformationTradeNTQSVC/getList")
    Call<LicenseQualInfo> getLicenseQualInfo(@Query(value = "serviceKey", encoded = true) String publicKey, @Query("jmcd") String jmcd);

    @GET("/api/service/rest/InquiryUdeptObligSVC/getList")
    Call<JobModel> getJobList(@Query(value = "serviceKey", encoded = true) String publicKey, @Query("pageNo") int page, @Query("numOfRows") int rows);
}
