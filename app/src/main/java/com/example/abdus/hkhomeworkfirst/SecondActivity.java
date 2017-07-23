package com.example.abdus.hkhomeworkfirst;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {
    final String TAG = "Second";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d(TAG, "SecondActivity onCreate");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "SecondActivity становится видимым");

    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "SecondActivity получает фокус (состояние Resumed)");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "SecondActivity приостановлено (состояние Paused)");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "SecondActivity остановлено (состояние Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "SecondActivity уничтожено");
    }
}
