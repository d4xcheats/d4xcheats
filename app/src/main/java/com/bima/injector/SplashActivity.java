package com.bima.injector;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;


public class SplashActivity extends Activity {

    static {
        System.loadLibrary("native-lib");
    }

    private native String versionCheckURL();

    private static long back_pressed;
    static boolean splashloaded=false;

    private void setLightStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.getWindow().setStatusBarColor(Color.parseColor("#FF182838"));
            activity.getWindow().setNavigationBarColor(Color.parseColor("#FF182838"));
        }
    }

    @SuppressLint("SetTextI18n")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        setLightStatusBar(this);
        new Thread() {
            final ProgressBar progressva = findViewById(R.id.progressBar);
            public void run() {
                try {
                    progressva.setProgress(1);
                    sleep(255);
                    progressva.setProgress(5);
                    sleep(225);
                    progressva.setProgress(10);
                    sleep(225);
                    progressva.setProgress(15);
                    sleep(225);
                    progressva.setProgress(20);
                    sleep(225);
                    progressva.setProgress(25);
                    sleep(225);
                    progressva.setProgress(30);
                    sleep(225);
                    progressva.setProgress(35);
                    sleep(225);
                    progressva.setProgress(40);
                    sleep(225);
                    progressva.setProgress(55);
                    sleep(25);
                    progressva.setProgress(60);
                    sleep(25);
                    progressva.setProgress(65);
                    sleep(25);
                    progressva.setProgress(70);
                    sleep(25);
                    progressva.setProgress(75);
                    sleep(25);
                    progressva.setProgress(80);
                    sleep(25);
                    progressva.setProgress(85);
                    sleep(25);
                    progressva.setProgress(90);
                    sleep(25);
                    progressva.setProgress(95);
                    sleep(25);
                    progressva.setProgress(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new CheckVersionApp(this).execute(versionCheckURL());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            finishAffinity();
            super.onBackPressed();
        } else {
            Toast.makeText(getBaseContext(), "Press once again to exit", Toast.LENGTH_SHORT).show();
            back_pressed = System.currentTimeMillis();
        }
    }

    class CheckVersionApp extends AsyncTask <String, String, String> {

        private Context context;
        public CheckVersionApp(Context ctx) {
            this.context = ctx;
        }

        @Override
        protected String doInBackground(String... string) {
            BufferedReader buffR = null;
            try {
                String url_address = string[0];
                URL url = new URL(url_address);
                URLConnection urlConnection = url.openConnection();
                buffR = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuffer strBuffer = new StringBuffer();
                String line;
                while ((line = buffR.readLine()) != null) {
                    strBuffer.append(line);
                }
                return strBuffer.toString();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (buffR != null) {
                    try {
                        buffR.close();

                    } catch (IOException e) {}

                }
            }

            return null;
        }


        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
                try {
                    JSONObject object = new JSONObject(result);
                    int versionFromJson = object.getInt("appVersion");
                    String releaseNote = object.get("releaseNote").toString();
                    final String downloadUpdate = object.get("downloadUpdate").toString();
                    try {
                        PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                        int version = pInfo.versionCode;
                        if  (version < versionFromJson) {
                            new AlertDialog.Builder(context)
                                    .setTitle(releaseNote)
                                    .setPositiveButton("UPDATE", new DialogInterface.OnClickListener(){
                                        @Override
                                        public void onClick(DialogInterface p1, int p2) {
                                            Intent intent = new Intent(Intent.ACTION_VIEW);
                                            intent.setData(Uri.parse(downloadUpdate));
                                            startActivity(intent);
                                            finish();
                                        }
                                    })
                                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener(){
                                        @Override
                                        public void onClick(DialogInterface p1, int p2) {
                                            finish();
                                        }
                                    })
                                    .setCancelable(false)
                                    .show();
                        } else {
                            new Thread() {
                                final ProgressBar progressva = findViewById(R.id.progressBar);
                                public void run() {
                                    try {
                                        sleep(600);
                                        splashloaded = true;
                                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                                        finish();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }.start();
                        }
                    } catch (PackageManager.NameNotFoundException ignored) {}

                } catch (final JSONException e) {
                    e.printStackTrace();

                }
            } else {
                new Thread() {
                    final ProgressBar progressva = findViewById(R.id.progressBar);
                    public void run() {
                        try {
                            sleep(2520);
                            finish();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        }




    }

}
