package com.example.abdus.hkhomeworkfirst;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    final String TAG = "Activity";

    Button transformBtn;
    Button transformBtn2;
    Button openURL;
    Button shareBtn;
    Button call;
    Button openContactApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        transformBtn = (Button) findViewById(R.id.transformBtn);
        transformBtn2 = (Button) findViewById(R.id.transformBtn2);
        openURL = (Button) findViewById(R.id.openURL);
        shareBtn = (Button) findViewById(R.id.share);
        call = (Button) findViewById(R.id.call);
        openContactApp = (Button) findViewById(R.id.openContactApp);

        openContactApp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setComponent(new ComponentName("com.android.contacts", "com.android.contacts.DialtactsContactsEntryActivity"));
                i.setAction("android.intent.action.MAIN");
                i.addCategory("android.intent.category.LAUNCHER");
                i.addCategory("android.intent.category.DEFAULT");
                startActivity(i);
            }
        });

        call.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialContactPhone("+79894428691");
            }
        });

        shareBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(); intent2.setAction(Intent.ACTION_SEND);
                intent2.setType("text/plain");
                intent2.putExtra(Intent.EXTRA_TEXT, "Курсы Андроид занятие первое" );
                startActivity(Intent.createChooser(intent2, "Share via"));
            }
        });

        openURL.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = "http://www.google.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        transformBtn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        Log.d(TAG, "Activity onCreate");
    }

    private void dialContactPhone(final String phoneNumber) {
        Log.e(TAG, "phone numbr = " + phoneNumber);
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

     @Override
    protected void onStart(){
         super.onStart();
         Log.d(TAG, "Activity становится видимым");

     }

     @Override
    protected void onResume(){
         super.onResume();
         Log.d(TAG, "Activity получает фокус (состояние Resumed)");
     }

     @Override
    protected void onPause(){
         super.onPause();
         Log.d(TAG, "Activity приостановлено (состояние Paused)");
     }

     @Override
    protected void onStop(){
         super.onStop();
         Log.d(TAG, "Activity остановлено (состояние Stopped");
     }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Activity уничтожено");
    }
}
