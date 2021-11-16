package com.bima.injector;

import android.annotation.SuppressLint;
import android.app.Service;
import android.os.IBinder;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.View;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.os.Build;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.widget.ImageView;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class FloatAimbot extends Service {

    static {
        System.loadLibrary("native-lib");
    }

    private View mainView;
    private WindowManager windowManager;
    private WindowManager.LayoutParams paramsView;

    @Override
    public IBinder onBind(Intent p1) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ShowMainView();
    }

    @SuppressLint("InflateParams")
    private void ShowMainView() {
        mainView = LayoutInflater.from(this).inflate(R.layout.float_aimbot, null);
        paramsView = getParams();
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        windowManager.addView(mainView, paramsView);
        InitShowMainView();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void InitShowMainView() {
        RelativeLayout layoutView = mainView.findViewById(R.id.layoutControlView);
        layoutView.setOnTouchListener(onTouchListener());
    }

    private View.OnTouchListener onTouchListener() {
        final GestureDetector gestureDetector = new GestureDetector(this, new SingleTapConfirm());
        return new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;

            public boolean flashnyala=false;

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (gestureDetector.onTouchEvent(event)) {
                    ImageView myImageView = mainView.findViewById(R.id.imageview_control);
                    if (!flashnyala) { //Jump Login Protection
                        myImageView.setImageResource(R.drawable.aim_on);
                        AimbotPOV(11, true);
                        flashnyala = true;
                    } else {
                        myImageView.setImageResource(R.drawable.aim_off);
                        AimbotPOV(11, false);
                        flashnyala = false;
                    }
                    return true;
                } else {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            initialX = paramsView.x;
                            initialY = paramsView.y;
                            initialTouchX = event.getRawX();
                            initialTouchY = event.getRawY();
                            return true;
                        case MotionEvent.ACTION_MOVE:
                            paramsView.x = initialX + (int) (event.getRawX() - initialTouchX);
                            paramsView.y = initialY + (int) (event.getRawY() - initialTouchY);
                            windowManager.updateViewLayout(mainView, paramsView);
                            return true;
                    }

                    return false;
                }
            }
        };
    }

    @SuppressLint("RtlHardcoded")
    private WindowManager.LayoutParams getParams() {
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                getLayoutType(),
                getFlagsType(),
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.x = 0;
        params.y = 0;
        return params;
    }

    private static int getLayoutType() {
        int LAYOUT_FLAG;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_PHONE;
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_TOAST;
        } else {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        }
        return LAYOUT_FLAG;
    }

    private int getFlagsType() {
        return WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
    }

    public native void AimbotPOV(int setting_code,boolean value);

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mainView != null) {
            windowManager.removeView(mainView);
        }
    }
}