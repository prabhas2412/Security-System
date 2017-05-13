package com.example.prabhas.loginregister;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import static com.example.prabhas.loginregister.R.id.system_pass;
import static com.example.prabhas.loginregister.R.id.user_name;
import static com.example.prabhas.loginregister.R.id.user_pass;

/**
 * Created by PRABHAS on 12/1/2016.
 */

public class BackgroundTask extends AsyncTask<String,Void,String> {

    AlertDialog alertDialog;
    Context ctx;

    BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information....");
    }


    @Override
    protected String doInBackground(String... params) {

        String reg_url1 = "http://192.168.43.68/webapp/register1.php";
        String reg_url2 = "http://192.168.43.68/webapp/register2.php";
        String login_url = "http://192.168.43.68/webapp/login.php";
        String upd_url = "http://192.168.43.68/webapp/update.php";
       // String sys_url = "http://192.168.43.68/webapp/system.php";


        String method = params[0];
        if (method.equals("register1")) {
            String user_name = params[1];
            String user_pass = params[2];
            String system_pass = params[3];
            try {
                URL url = new URL(reg_url1);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));

                String data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&" +
                        URLEncoder.encode("user_pass", "UTF-8") + "=" + URLEncoder.encode(user_pass, "UTF-8") + "&" +
                        URLEncoder.encode("system_pass", "UTF-8") + "=" + URLEncoder.encode(system_pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registration Success....";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (method.equals("register2")) {
            String user_name = params[1];
            String user_pass = params[2];
            String system_pass = params[3];
            try {
                URL url = new URL(reg_url2);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));

                String data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&" +
                        URLEncoder.encode("user_pass", "UTF-8") + "=" + URLEncoder.encode(user_pass, "UTF-8") + "&" +
                        URLEncoder.encode("system_pass", "UTF-8") + "=" + URLEncoder.encode(system_pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registration Success....";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (method.equals("login")) {
            String login_name = params[1];
            String login_pass = params[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("login_name", "UTF-8") + "=" + URLEncoder.encode(login_name, "UTF-8") + "&" +
                        URLEncoder.encode("login_pass", "UTF-8") + "=" + URLEncoder.encode(login_pass, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {

                    response += line;

                    if (login_name.equals(user_name) && login_pass.equals(user_pass) ){
                        return "Login Success...";


                    }

                }




                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

         if (method.equals("update")) {
            String user_name = params[1];
             String user_pass = params[2];
            String system_pass = params[3];
            String new_user_pass = params[4];

            String pass = "coda_lab@124";


            try {
                URL url = new URL(upd_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&" +
                        URLEncoder.encode("user_pass", "UTF-8") + "=" + URLEncoder.encode(user_pass, "UTF-8") + "&" +
                        URLEncoder.encode("system_pass", "UTF-8") + "=" + URLEncoder.encode(system_pass, "UTF-8") + "&" +
                        URLEncoder.encode("new_user_pass", "UTF-8") + "=" + URLEncoder.encode(new_user_pass, "UTF-8") ;

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {

                    response += line;

                    if (user_name.equals(user_name) && user_pass.equals(user_pass) && system_pass.equals(pass))
                    {
                        return "Update Success...";


                    }
                    else
                    {
                        Intent y = new Intent(ctx, update.class);
                        ctx.startActivity(y);

                    }

                }


                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


      /*  if (method.equals("system")) {
            String key_word = params[1];
            String system_pass = params[2];
            String new_system_pass = params[3];
            String keyword = "prabhas@190006";


            try {
                URL url = new URL(sys_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("key_word", "UTF-8") + "=" + URLEncoder.encode(key_word, "UTF-8") + "&" +
                        URLEncoder.encode("system_pass", "UTF-8") + "=" + URLEncoder.encode(system_pass, "UTF-8") + "&" +
                        URLEncoder.encode("new_system_pass", "UTF-8") + "=" + URLEncoder.encode(new_system_pass, "UTF-8") ;

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {

                    response += line;

                    if (key_word.equals(keyword) && system_pass.equals(system_pass))
                    {
                        return "System Password Update Success...";


                    }
                    else
                    {
                        Intent y = new Intent(ctx, systempass.class);
                        ctx.startActivity(y);

                    }

                }


                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }*/



        return null;
    }



    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if (result.equals("Registration Success....")) {
            //  Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        } else {
            alertDialog.setMessage(result);
            alertDialog.show();

        }
        if (result.equals("Login Success...")) {
            Intent i = new Intent(ctx, inside.class);
            ctx.startActivity(i);
        }
        if (result.equals("Update Success...")) {
            Intent y = new Intent(ctx, MainActivity.class);
            ctx.startActivity(y);

        }
       /* if (result.equals("System Password Update Success...")) {
            Intent z = new Intent(ctx, inside.class);
            ctx.startActivity(z);

        }*/

    }
}
