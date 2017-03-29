package com.example.zhang.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by zhang on 2017/3/28.
 */

public class backActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("backActivity",this.toString());
        setContentView(R.layout.activity_back);
        Button btn_back=(Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("data_return","hello,I'm returning data!");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent();
        intent.putExtra("data_return","hello,I'm also returning data!");
        setResult(RESULT_OK,intent);
        finish();
    }
}
