package com.example.prabhas.loginregister;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import static android.R.attr.button;
import static android.R.attr.onClick;
import static com.example.prabhas.loginregister.R.id.user_name;
import static com.example.prabhas.loginregister.R.id.user_pass;

public class MainActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void main1(View view) {

        startActivity(new Intent(this, main1.class));

    }
    public void main2(View v) {

        startActivity(new Intent(this, main2.class));

    }
    public void Gmail(View v) {

        startActivity(new Intent(this, gmail.class));

    }
}