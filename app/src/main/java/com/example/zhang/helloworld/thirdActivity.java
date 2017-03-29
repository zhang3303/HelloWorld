package com.example.zhang.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;


/**
 * Created by zhang on 2017/3/24.
 */
public class thirdActivity extends BaseActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("thirdActivity","Task id is"+getTaskId());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_third);
    }
}