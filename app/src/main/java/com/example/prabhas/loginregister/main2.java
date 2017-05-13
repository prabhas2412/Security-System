package com.example.prabhas.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.prabhas.loginregister.R.id.user_name;

/**
 * Created by PRABHAS on 1/17/2017.
 */

public class main2 extends Activity {


    EditText ET_NAME, ET_PASS;
    String login_name, login_pass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ET_NAME = (EditText) findViewById(user_name);
        ET_PASS = (EditText) findViewById(R.id.user_pass);


    }
    public void userReg2(View view) {

        startActivity(new Intent(this, Register2.class));

    }


    public void userLogin2(View view) {
        login_name = ET_NAME.getText().toString();
        login_pass = ET_PASS.getText().toString();
        String method = "login";

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, login_name, login_pass);

        // if ( backgroundTask.equals("Login Success...")) {
        //  startActivity(new Intent(this, inside.class));
        //  finish();
        // }


        // else {
        //    Toast.makeText(getApplicationContext(),"wrong user name or password",Toast.LENGTH_SHORT).show();
    }
}

