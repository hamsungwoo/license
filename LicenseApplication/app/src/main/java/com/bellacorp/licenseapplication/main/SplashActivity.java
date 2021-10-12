package com.bellacorp.licenseapplication.main;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import com.bellacorp.licenseapplication.job.JobActivity;

public class SplashActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        startActivity(new Intent(this, JobActivity.class));
        finish();
    }

}
