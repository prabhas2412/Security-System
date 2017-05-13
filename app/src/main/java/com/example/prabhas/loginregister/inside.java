package com.example.prabhas.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


/**
 * Created by PRABHAS on 12/7/2016.
 */

public class inside extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside);
    }

    public void blue(View view) {

        startActivity(new Intent(this, blue1.class));

    }
    public void sensor(View v) {

        startActivity(new Intent(this, dcmotor.class));

    }

    public void update(View ve) {

        startActivity(new Intent(this, update.class));

    }


}
