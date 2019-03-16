package com.example.sharingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int PERMISSION_REQUEST_CODE = 1;
    Button btncall,btnsms,btnsahre,btnweb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncall=findViewById(R.id.call);
        btncall.setOnClickListener(this);
        findViewById(R.id.sms).setOnClickListener(this);
        findViewById(R.id.share).setOnClickListener(this);
        findViewById(R.id.webview).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.call:
                Intent callIntent=new Intent(this,CallActivity.class);
                startActivity(callIntent);
                break;
            case R.id.sms:
                Intent smsIntent=new Intent(this,SmsActivity.class);
                startActivity(smsIntent);
                break;
            case R.id.share:
                Intent shareIntent=new Intent(this,ShareActivity.class);
                startActivity(shareIntent);
                break;
            case R.id.webview:
                Intent webIntent=new Intent(this,WebActivity.class);
                startActivity(webIntent);
                break;
        }

    }


    }

