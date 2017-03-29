package com.example.zhang.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Created by zhang on 2017/3/23.
 */

public class showMessage extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_show);
        Intent intent=getIntent();
        String message=intent.getStringExtra("Message_send");
        TextView textView=(TextView)findViewById(R.id.message_show);
        textView.setText(message);
    }
}
