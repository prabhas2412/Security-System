package com.example.prabhas.loginregister;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.prabhas.loginregister.R.id.bRegister;
import static com.example.prabhas.loginregister.R.id.new_user_pass;
import static com.example.prabhas.loginregister.R.id.system_pass;

public class update extends Activity {

    EditText ET_USER_NAME, ET_USER_PASS, ET_SYSTEM_PASS, ET_NEW_USER_PASS;
    String user_name, user_pass, new_user_pass, system_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        ET_USER_NAME = (EditText) findViewById(R.id.user_name);
        ET_USER_PASS = (EditText) findViewById(R.id.user_pass);
        ET_SYSTEM_PASS = (EditText) findViewById(R.id.system_pass);
        ET_NEW_USER_PASS = (EditText) findViewById(R.id.new_user_pass);

    }

    public void Update(View view)
    {

        user_name = ET_USER_NAME.getText().toString();
        user_pass = ET_USER_PASS.getText().toString();
        system_pass = ET_SYSTEM_PASS.getText().toString();
        new_user_pass = ET_NEW_USER_PASS.getText().toString();
        String method = "update";
        if (user_name.isEmpty() && user_pass.isEmpty() && system_pass.isEmpty() && new_user_pass.isEmpty())
        {
            displayToast("please fill up all the fields");
        }
        else {
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute(method, user_name, user_pass, system_pass , new_user_pass);
            finish();
        }


    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }

}