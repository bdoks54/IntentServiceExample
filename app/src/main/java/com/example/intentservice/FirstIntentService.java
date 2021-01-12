package com.example.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class FirstIntentService extends IntentService {
    private int sum;
    public static final String NUMBER = "NUMBER";

    public FirstIntentService(){
        super("FirstIntentService");
        sum=0;
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        int number = intent.getIntExtra(NUMBER,0);
        synchronized (this) {
            try {
                wait(1000);
            } catch (InterruptedException ignored) {
            }
        }
        sum += number;
        Log.d("IntentService", "Sum: " + sum);
    }
}
