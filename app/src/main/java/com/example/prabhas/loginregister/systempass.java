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

public class systempass extends Activity {

    EditText ET_KEY_WORD, ET_SYSTEM_PASS, ET_NEW_PASS;
    String key_word, system_pass, new_system_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_systempass);

        ET_KEY_WORD = (EditText) findViewById(R.id.key_word);
        ET_SYSTEM_PASS = (EditText) findViewById(R.id.system_pass);
        ET_NEW_PASS = (EditText) findViewById(R.id.new_system_pass);

    }

    public void Updsys(View view)
    {

        key_word = ET_KEY_WORD.getText().toString();
        system_pass = ET_SYSTEM_PASS.getText().toString();
        new_system_pass = ET_NEW_PASS.getText().toString();
        String method = "system";
        if (key_word.isEmpty() && system_pass.isEmpty() && new_system_pass.isEmpty())
        {
            displayToast("keyword / system password or new system password field empty");
        }
        else {
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute(method, key_word, system_pass, new_system_pass);
            finish();
        }


    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }
}