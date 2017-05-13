package com.example.prabhas.loginregister;

/**
 * Created by PRABHAS on 1/18/2017.
 */
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class gmail extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sendEmail();}
       //setContentView(R.layout.activity_gmail);

       // Button startBtn = (Button) findViewById(R.id.sendEmail);
       // startBtn.setOnClickListener(new View.OnClickListener() {


    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {"prabhassingh2412@gmail.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(gmail.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
