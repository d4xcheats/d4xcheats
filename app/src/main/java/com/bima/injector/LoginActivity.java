package com.bima.injector;

import android.annotation.SuppressLint;
import android.app.*;
import android.content.Intent;
import android.graphics.*;
import android.net.Uri;
import android.os.*;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

public class LoginActivity extends Activity {

    static {
        System.loadLibrary("native-lib");
    }

    private native String getkey();
	public native String MainAct();
    public native String Logintitle();
    private final String USER = "USER";
    private final String PASS = "PASS";
    private Prefs prefs;

    private void setLightStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.getWindow().setStatusBarColor(Color.parseColor("#FF121212"));
            activity.getWindow().setNavigationBarColor(Color.parseColor("#FF121212"));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setLightStatusBar(this);
        setContentView(R.layout.activity_login);
        if (!SplashActivity.splashloaded) {
            finish();
        }
        prefs = Prefs.with(this);

        TextView textUsername = findViewById(R.id.textUsername);
        TextView textPassword = findViewById(R.id.textPassword);
        textUsername.setText(prefs.read(USER, ""));
        textPassword.setText(prefs.read(PASS, ""));



		
        CardView btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(v -> {

            @SuppressLint("CutPasteId") TextView textUsername1 = findViewById(R.id.textUsername);
            @SuppressLint("CutPasteId") TextView textPassword1 = findViewById(R.id.textPassword);

            if (!textUsername1.getText().toString().isEmpty() && !textPassword1.getText().toString().isEmpty()) {
                prefs.write(USER, textUsername1.getText().toString());
                prefs.write(PASS, textPassword1.getText().toString());
                new Auth(LoginActivity.this).execute(textUsername1.getText().toString(), textPassword1.getText().toString());
            }
            if (textUsername1.getText().toString().isEmpty() && textPassword1.getText().toString().isEmpty()) {
                textUsername1.setError("Please enter username");
                textPassword1.setError("Please enter password");
            }
            if (textUsername1.getText().toString().isEmpty()) {
                textUsername1.setError("Please enter username");
            }
            if (textPassword1.getText().toString().isEmpty()) {
                textPassword1.setError("Please enter password");
            }
        });
        if (!textUsername.getText().toString().isEmpty() && !textPassword.getText().toString().isEmpty())
        {
            btnSignIn.performClick();
        }
        TextView getKey = findViewById(R.id.getKey);
        getKey.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(getkey()));
            startActivity(intent);
        });

    }


}

