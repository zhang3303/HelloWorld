package com.example.zhang.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.zhang.helloworld.R.string.send;

public class MainActivity extends BaseActivity  {
    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity",this.toString());
        Log.d("MainActivity","Task id is"+getTaskId());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Button button1=(Button)findViewById(R.id.btn_toast);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,R.string.text_click,Toast.LENGTH_LONG).show();
            }
        });
        Button button2=(Button)findViewById(R.id.intent_test);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.example.zhang.helloworld.ACTION_START");
                intent.addCategory("com.example.zhang.helloworld.MY_CATEGORY");
                startActivity(intent);
            }
        });
        Button button3=(Button)findViewById(R.id.baidu_test);
        button3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }

            /*跳转到打电话页面
             public void onClick(View v) {
             改成这个则转入打电话的页面，就拨打10086
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);

            }
             */
        });
        //这块是有问题的,http是不可取的
        Button button4=(Button)findViewById(R.id.http_test);
        button4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http"));
                startActivity(intent);
            }
        });
        Button button5=(Button)findViewById(R.id.intent_http);
        button5.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                editText=(EditText) findViewById(R.id.message_send);
                String message=editText.getText().toString();
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(message));
                startActivity(intent);
            }
        });
        Button btn_back=(Button)findViewById(R.id.back_intent);
        btn_back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,backActivity.class);
                startActivityForResult(intent,1);
            }
        });
        Button btn_mode=(Button)findViewById(R.id.btn_mode);
        btn_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void sendMessage(View view){
        Intent intent=new Intent(this,showMessage.class);
        editText=(EditText) findViewById(R.id.message_send);
        String message=editText.getText().toString();
        intent.putExtra("Message_send",message);
        startActivity(intent);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.item_add:
                Toast.makeText(this,R.string.text_click_add,Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_remove:
                Toast.makeText(this,R.string.text_click_remove,Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returnedData=data.getStringExtra("data_return");
                    Toast.makeText(this,returnedData,Toast.LENGTH_SHORT).show();
                    Log.d("MainActivity",returnedData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MqinActivity","onRestart");
    }
}
