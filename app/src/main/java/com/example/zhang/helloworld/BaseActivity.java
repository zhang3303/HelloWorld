package com.example.zhang.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by zhang on 2017/3/28.
 */

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity",getClass().getSimpleName());
    }
}
