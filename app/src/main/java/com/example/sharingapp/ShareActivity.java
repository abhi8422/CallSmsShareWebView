package com.example.sharingapp;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity implements View.OnClickListener {
EditText msgText;
Button sharebtn;
String meassage;
LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        msgText=findViewById(R.id.msg);
        sharebtn=findViewById(R.id.share);
        sharebtn.setOnClickListener(this);
        layout=findViewById(R.id.linearlayout);
    }

    @Override
    public void onClick(View v) {
        meassage=msgText.getText().toString().trim();
        //it shows the application which accepts the intent type which we defind intetn.setType();
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        //intetn pass this data to particular application as text to be send(EXTRA_TEXT) & (EXTRA_SUBJECT)as subject text.
        intent.putExtra(Intent.EXTRA_TEXT,meassage);
        //intent.putExtra(Intent.EXTRA_SUBJECT,meassage);
        //code opeing chooser window in your app.
        startActivity(Intent.createChooser(intent,"Share Using"));
    }
}
