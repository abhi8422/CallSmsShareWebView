package com.example.sharingapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URL;

public class WebActivity extends AppCompatActivity implements View.OnClickListener {
EditText edturl;
Button btnopen;
String Url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        edturl=findViewById(R.id.url);
        btnopen=findViewById(R.id.open);
        btnopen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Url=edturl.getText().toString().trim();
        ShowUrl(Url);
    }

    private void ShowUrl(String url) {
        Intent webintent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+url));
        startActivity(webintent);
    }

}
