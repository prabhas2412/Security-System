package com.example.prabhas.loginregister;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by PRABHAS on 1/17/2017.
 */

public class Register2 extends Activity {

    EditText ET_USER_NAME, ET_USER_PASS, ET_SYSTEM_PASS;
    String user_name, user_pass, system_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        ET_USER_NAME = (EditText) findViewById(R.id.new_user_name);
        ET_USER_PASS = (EditText) findViewById(R.id.new_user_pass);
        ET_SYSTEM_PASS = (EditText) findViewById(R.id.system_pass);

    }

    public void userReg2(View view)
    {

        user_name = ET_USER_NAME.getText().toString();
        user_pass = ET_USER_PASS.getText().toString();
        system_pass = ET_SYSTEM_PASS.getText().toString();
        String method = "register2";
        if (user_name.isEmpty() && user_pass.isEmpty() && system_pass.isEmpty())
        {
            displayToast("user name / password or system password field empty");
        }
        else {
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute(method, user_name, user_pass, system_pass);
            finish();
        }


    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }

}
