package com.bellacorp.licenseapplication.job;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bellacorp.licenseapplication.Constant;
import com.bellacorp.licenseapplication.R;
import com.bellacorp.licenseapplication.databinding.ActivityJobBinding;
import com.bellacorp.licenseapplication.job.model.JobItem;
import com.bellacorp.licenseapplication.main.LicenseAdapter;
import com.bellacorp.licenseapplication.main.MainActivity;
import com.bellacorp.licenseapplication.main.MainViewModel;
import com.bellacorp.licenseapplication.main.model.LicenseItem;
import com.bellacorp.licenseapplication.util.Logger;

public class JobActivity extends AppCompatActivity {

    private ActivityJobBinding mBinding;
    private JobViewModel mViewModel;

    public JobAdapter.JobClickListener jobClickListener = new JobAdapter.JobClickListener() {
        @Override
        public void onClick(int position, JobItem item) {
            goLicense(item);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(JobViewModel.class);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_job);
        mBinding.setView(this);
        mBinding.setVm(mViewModel);

        mViewModel.fetchJobLister();

        mBinding.rvJobs.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!recyclerView.canScrollVertically(1)) {
                    if (recyclerView.getAdapter() != null && mViewModel.totalElement > mViewModel.row * mViewModel.page) {
                        mViewModel.nextPage();
                    }
                }
            }
        });
    }

    private void goLicense(JobItem item) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Constant.EXTRA_KEY_JOB, item.udeptmdoblignm);
        startActivity(intent);
    }
}