package com.bellacorp.licenseapplication.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.bellacorp.licenseapplication.Constant;
import com.bellacorp.licenseapplication.R;
import com.bellacorp.licenseapplication.databinding.ActivityMainBinding;
import com.bellacorp.licenseapplication.detail.LicenseDetailActivity;
import com.bellacorp.licenseapplication.main.model.ExamSchedule;
import com.bellacorp.licenseapplication.main.model.ExamScheduleItem;
import com.bellacorp.licenseapplication.main.model.LicenseItem;
import com.bellacorp.licenseapplication.util.Logger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;
    private ActivityMainBinding mBinding;

    public LicenseAdapter.LicenseClickListener licenseClickListener = new LicenseAdapter.LicenseClickListener() {
        @Override
        public void onClick(int position, LicenseItem item) {
            Logger.e("[INFO] click item ==> " + item.jmfldnm + " , " + position);
            goDetail(item);
        }
    };

//    public SearchView.OnQueryTextListener searchQuery = new SearchView.OnQueryTextListener() {
//        @Override
//        public boolean onQueryTextSubmit(String query) {
//            Logger.e("[INFO] search text ===> " + query);
//            mViewModel.searchText.set(query);
//            return true;
//        }
//
//        @Override
//        public boolean onQueryTextChange(String newText) {
//            if (mBinding.svSearch.getQuery().length() == 0) {
//                mViewModel.searchText.set(null);
//                mViewModel.fetchLicenseList();
//            }
//            return false;
//        }
//    };
//
//    public SearchView.OnCloseListener closeListener = new SearchView.OnCloseListener() {
//        @Override
//        public boolean onClose() {
////            Logger.e("[INFO] search text ===> " + mBinding.svSearch.getQuery());
//            mViewModel.searchText.set(null);
//            mViewModel.fetchLicenseList();
//            return true;
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setView(this);
        mBinding.setVm(mViewModel);

        String job = getIntent().getStringExtra(Constant.EXTRA_KEY_JOB);

        mViewModel.fetchLicenseList(job);
        mViewModel.fetchExamScheduleCL();
        mViewModel.fetchExamScheduleMC();
        mViewModel.fetchExamSchedulePE();
        mViewModel.fetchExamScheduleEL();
    }

    private void goDetail(LicenseItem item) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        ExamScheduleItem scheduleItem = null;
        switch (item.seriescd) {
            case "01": scheduleItem = mViewModel.examScheduleItemPE.get(); break;
            case "02": scheduleItem = mViewModel.examScheduleItemMC.get(); break;
            case "03": scheduleItem = mViewModel.examScheduleItemEL.get(); break;
            case "04": scheduleItem = mViewModel.examScheduleItemCL.get(); break;
        }

        Intent intent = new Intent(this, LicenseDetailActivity.class);
        intent.putExtra(Constant.EXTRA_KEY_ITEM, gson.toJson(item));
        intent.putExtra(Constant.EXTRA_KEY_SCHEDULE, gson.toJson(scheduleItem));
        startActivity(intent);
    }
}