package com.bellacorp.licenseapplication.detail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;

import com.bellacorp.licenseapplication.Constant;
import com.bellacorp.licenseapplication.R;
import com.bellacorp.licenseapplication.databinding.ActivityLicenseDetailBinding;
import com.bellacorp.licenseapplication.main.model.ExamSchedule;
import com.bellacorp.licenseapplication.main.model.ExamScheduleItem;
import com.bellacorp.licenseapplication.main.model.LicenseItem;
import com.google.gson.Gson;

public class LicenseDetailActivity extends AppCompatActivity {

    private ActivityLicenseDetailBinding mBinding;
    private LicenseDetailViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LicenseDetailViewModel.class);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_license_detail);
        mBinding.setView(this);
        mBinding.setVm(mViewModel);

        String str = getIntent().getStringExtra(Constant.EXTRA_KEY_ITEM);
        String scheduleStr = getIntent().getStringExtra(Constant.EXTRA_KEY_SCHEDULE);
        if (str != null) {
            LicenseItem item = new Gson().fromJson(str, LicenseItem.class);
            mViewModel.currentItem.set(item);
            mViewModel.fetchExamFee(item);
            mViewModel.fetchLicenseDetail(item);
            mViewModel.fetchQualInfo(item);
        }

        if (scheduleStr != null) {
            ExamScheduleItem item = new Gson().fromJson(scheduleStr, ExamScheduleItem.class);
            mViewModel.examScheduleItem.set(item);
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(mViewModel.currentItem.get().jmfldnm);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}