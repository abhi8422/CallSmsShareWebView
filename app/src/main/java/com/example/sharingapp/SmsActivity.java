package com.example.sharingapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtnumber, edtmsg;
    Button btnsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        edtnumber = findViewById(R.id.number);
        edtmsg = findViewById(R.id.message);
        btnsend = findViewById(R.id.send);
        btnsend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        sendSms();
    }

    private void sendSms() {
        String sms = edtmsg.getText().toString();
        String phoneNum = edtmsg.getText().toString();
        if (!TextUtils.isEmpty(sms) && !TextUtils.isEmpty(phoneNum)) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
                }else{
                SmsManager smsManager = SmsManager.getDefault();
                //Send the SMS//
                smsManager.sendTextMessage(phoneNum, null, sms, null, null);
                }
            }
            else {
            Toast.makeText(SmsActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();
        }
        }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==1){
            if (grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                sendSms();
            }
            else {
                Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
    }
}


