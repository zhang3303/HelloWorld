package com.example.zhang.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by zhang on 2017/3/24.
 */

public class secondActivity extends BaseActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("secondActivity",this.toString());
        Log.d("secondActivity","Task id is"+getTaskId());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_second);
        Button btn_mode=(Button)findViewById(R.id.btn_mode);
        btn_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(secondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Button btn_mode4=(Button)findViewById(R.id.btn_mode4);
        btn_mode4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(secondActivity.this,thirdActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("secondActivity","onDestroy");
    }
}
