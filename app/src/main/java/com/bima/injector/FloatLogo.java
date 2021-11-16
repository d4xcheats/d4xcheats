package com.bima.injector;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import static java.lang.System.exit;
import android.widget.Switch;

public class FloatLogo extends Service {

    private static FloatLogo Instance;
    private PowerManager.WakeLock mWakeLock;
    public static final String LOG_TAG = "";
    private View mainView;
    private WindowManager windowManagerMainView;
    private WindowManager.LayoutParams paramsMainView;
    private LinearLayout layoutView;
    private LinearLayout btnView;

    static boolean floatAimbot=false;

    @Override
    public IBinder onBind(Intent p1) {
        return null;
    }

    @SuppressLint({"InvalidWakeLockTag", "WakelockTimeout"})
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (mWakeLock == null) {
            PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
            mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
        }
        return START_NOT_STICKY;
    }


    private void ShowMainView() {
        mainView = LayoutInflater.from(this).inflate(R.layout.float_logo, null);
        paramsMainView = getParams();
        windowManagerMainView = (WindowManager) getSystemService(WINDOW_SERVICE);
        windowManagerMainView.addView(mainView, paramsMainView);
        InitShowMainView();
    }

    private void InitShowMainView() {
        btnView = mainView.findViewById(R.id.btnView);
        layoutView = mainView.findViewById(R.id.layoutView);
        TextView btnLayoutMinimize = mainView.findViewById(R.id.btnLayoutMinimize);
        btnLayoutMinimize.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View p1) {
                layoutView.setVisibility(View.GONE);
                btnView.setVisibility(View.VISIBLE);
            }
        });

        Button btnEspView = mainView.findViewById(R.id.btnEspView);
        Button btnOtherView = mainView.findViewById(R.id.btnOtherView);
        Button btnWeaponView = mainView.findViewById(R.id.btnWeaponView);
        Button btnSettingView = mainView.findViewById(R.id.btnSettingView);
        Button btnSettingView2 = mainView.findViewById(R.id.btnSettingView2);

        btnEspView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View p1)
            {
                Button btnEspView = mainView.findViewById(R.id.btnEspView);
                Button btnOtherView = mainView.findViewById(R.id.btnOtherView);
                Button btnWeaponView = mainView.findViewById(R.id.btnWeaponView);
                Button btnSettingView = mainView.findViewById(R.id.btnSettingView);
                Button btnSettingView2 = mainView.findViewById(R.id.btnSettingView2);

                LinearLayout espView = mainView.findViewById(R.id.espView);
                LinearLayout otherView = mainView.findViewById(R.id.otherView);
                LinearLayout weaponView = mainView.findViewById(R.id.weaponView);
                LinearLayout settingView = mainView.findViewById(R.id.settingView);
                LinearLayout settingView2 = mainView.findViewById(R.id.settingView2);


                espView.setVisibility(View.VISIBLE);
                otherView.setVisibility(View.GONE);
                weaponView.setVisibility(View.GONE);
                settingView.setVisibility(View.GONE);
                settingView2.setVisibility(View.GONE);

            }
        });

        btnOtherView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View p1)
            {
                Button btnEspView = mainView.findViewById(R.id.btnEspView);
                Button btnOtherView = mainView.findViewById(R.id.btnOtherView);
                Button btnWeaponView = mainView.findViewById(R.id.btnWeaponView);
                Button btnSettingView = mainView.findViewById(R.id.btnSettingView);
                Button btnSettingView2 = mainView.findViewById(R.id.btnSettingView2);


                LinearLayout espView = mainView.findViewById(R.id.espView);
                LinearLayout otherView = mainView.findViewById(R.id.otherView);
                LinearLayout weaponView = mainView.findViewById(R.id.weaponView);
                LinearLayout settingView = mainView.findViewById(R.id.settingView);
                LinearLayout settingView2 = mainView.findViewById(R.id.settingView2);

                espView.setVisibility(View.GONE);
                weaponView.setVisibility(View.GONE);
                otherView.setVisibility(View.VISIBLE);
                settingView.setVisibility(View.GONE);
                settingView2.setVisibility(View.GONE);

            }
        });


        btnWeaponView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View p1)
            {

                Button btnEspView = mainView.findViewById(R.id.btnEspView);
                Button btnOtherView = mainView.findViewById(R.id.btnOtherView);
                Button btnWeaponView = mainView.findViewById(R.id.btnWeaponView);
                Button btnSettingView = mainView.findViewById(R.id.btnSettingView);
                Button btnSettingView2 = mainView.findViewById(R.id.btnSettingView2);

                LinearLayout espView = mainView.findViewById(R.id.espView);
                LinearLayout otherView = mainView.findViewById(R.id.otherView);
                LinearLayout weaponView = mainView.findViewById(R.id.weaponView);
                LinearLayout settingView = mainView.findViewById(R.id.settingView);
                LinearLayout settingView2 = mainView.findViewById(R.id.settingView2);


                espView.setVisibility(View.GONE);
                otherView.setVisibility(View.GONE);
                settingView.setVisibility(View.GONE);
                weaponView.setVisibility(View.VISIBLE);
                settingView2.setVisibility(View.GONE);

            }
        });


        btnSettingView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View p1)
            {

                Button btnEspView = mainView.findViewById(R.id.btnEspView);
                Button btnOtherView = mainView.findViewById(R.id.btnOtherView);
                Button btnWeaponView = mainView.findViewById(R.id.btnWeaponView);
                Button btnSettingView = mainView.findViewById(R.id.btnSettingView);
                Button btnSettingView2 = mainView.findViewById(R.id.btnSettingView2);


                LinearLayout espView = mainView.findViewById(R.id.espView);
                LinearLayout otherView = mainView.findViewById(R.id.otherView);
                LinearLayout settingView = mainView.findViewById(R.id.settingView);
                LinearLayout weaponView = mainView.findViewById(R.id.weaponView);
                LinearLayout settingView2 = mainView.findViewById(R.id.settingView2);


                espView.setVisibility(View.GONE);
                otherView.setVisibility(View.GONE);
                weaponView.setVisibility(View.GONE);
                settingView.setVisibility(View.VISIBLE);
                settingView2.setVisibility(View.GONE);

            }
        });

        btnSettingView2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View p1)
            {

                Button btnEspView = mainView.findViewById(R.id.btnEspView);
                Button btnOtherView = mainView.findViewById(R.id.btnOtherView);
                Button btnWeaponView = mainView.findViewById(R.id.btnWeaponView);
                Button btnSettingView = mainView.findViewById(R.id.btnSettingView);
                Button btnSettingView2 = mainView.findViewById(R.id.btnSettingView2);


                LinearLayout espView = mainView.findViewById(R.id.espView);
                LinearLayout otherView = mainView.findViewById(R.id.otherView);
                LinearLayout settingView = mainView.findViewById(R.id.settingView);
                LinearLayout weaponView = mainView.findViewById(R.id.weaponView);
                LinearLayout settingView2 = mainView.findViewById(R.id.settingView2);


                espView.setVisibility(View.GONE);
                otherView.setVisibility(View.GONE);
                weaponView.setVisibility(View.GONE);
                settingView.setVisibility(View.GONE);
                settingView2.setVisibility(View.VISIBLE);
            }
        });

        LinearLayout viewScrolled = mainView.findViewById(R.id.btnView);
        viewScrolled.setOnTouchListener(onTouchListener());

        Instance=this;
        Init();
    }
    private View.OnTouchListener onTouchListener() {
        final GestureDetector gestureDetector = new GestureDetector(this, new SingleTapConfirm());
        return new View.OnTouchListener() {
            final View collapsedView = btnView;
            final View expandedView = layoutView;
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (gestureDetector.onTouchEvent(event)) {
                    collapsedView.setVisibility(View.GONE);
                    expandedView.setVisibility(View.VISIBLE);
                    return true;
                } else {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            initialX = paramsMainView.x;
                            initialY = paramsMainView.y;
                            initialTouchX = event.getRawX();
                            initialTouchY = event.getRawY();
                            return true;
                        case MotionEvent.ACTION_MOVE:
                            paramsMainView.x = initialX + (int) (event.getRawX() - initialTouchX);
                            paramsMainView.y = initialY + (int) (event.getRawY() - initialTouchY);
                            windowManagerMainView.updateViewLayout(mainView, paramsMainView);
                            return true;
                    }
                    return false;
                }
            }
        };
    }

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
        int LAYOUT_FLAG = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        return LAYOUT_FLAG;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ShowMainView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mWakeLock != null) {
            mWakeLock = null;
        }
        if (mainView != null) {
            windowManagerMainView.removeView(mainView);
        }
    }


    private String getType(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getString("type","1");
    }

    private void  setValue(String key,boolean b) {
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putBoolean(key,b);
        ed.apply();
    }

    boolean getConfig(String key){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return  sp.getBoolean(key,false);
        // return !key.equals("");
    }

    void setFps(int fps){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("fps",fps);
        ed.apply();
    }

    void setRange(int fps){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("range",fps);
        ed.apply();
    }




    int getFps(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("fps",100);
    }

    int getRange(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("range",400);
    }

    public static void HideFloat() {
        if (Instance != null)
        {
            Instance.Hide();
        }
    }
    public void Hide(){
        stopSelf();
        exit(-1);
    }

    void Init(){
        final CheckBox Buggy = mainView.findViewById(R.id.Buggy);
        Buggy.setChecked(getConfig((String) Buggy.getText()));
        Buggy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Buggy.getText()), Buggy.isChecked());
            }
        });
        final CheckBox UAZ = mainView.findViewById(R.id.UAZ);
        UAZ.setChecked(getConfig((String) UAZ.getText()));
        UAZ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(UAZ.getText()), UAZ.isChecked());
            }
        });
        final CheckBox Trike = mainView.findViewById(R.id.Trike);
        Trike.setChecked(getConfig((String) Trike.getText()));
        Trike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Trike.getText()), Trike.isChecked());
            }
        });
        final CheckBox Bike = mainView.findViewById(R.id.Bike);
        Bike.setChecked(getConfig((String) Bike.getText()));
        Bike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Bike.getText()), Bike.isChecked());
            }
        });
        final CheckBox Dacia = mainView.findViewById(R.id.Dacia);
        Dacia.setChecked(getConfig((String) Dacia.getText()));
        Dacia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Dacia.getText()), Dacia.isChecked());
            }
        });
        final CheckBox Jet = mainView.findViewById(R.id.Jet);
        Jet.setChecked(getConfig((String) Jet.getText()));
        Jet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Jet.getText()), Jet.isChecked());
            }
        });
        final CheckBox Boat = mainView.findViewById(R.id.Boat);
        Boat.setChecked(getConfig((String) Boat.getText()));
        Boat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Boat.getText()), Boat.isChecked());
            }
        });
        final CheckBox Scooter = mainView.findViewById(R.id.Scooter);
        Scooter.setChecked(getConfig((String) Scooter.getText()));
        Scooter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Scooter.getText()), Scooter.isChecked());
            }
        });
        final CheckBox Bus = mainView.findViewById(R.id.Bus);
        Bus.setChecked(getConfig((String) Bus.getText()));
        Bus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Bus.getText()), Bus.isChecked());
            }
        });
        final CheckBox Mirado = mainView.findViewById(R.id.Mirado);
        Mirado.setChecked(getConfig((String) Mirado.getText()));
        Mirado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Mirado.getText()), Mirado.isChecked());
            }
        });
        final CheckBox Rony = mainView.findViewById(R.id.Rony);
        Rony.setChecked(getConfig((String) Rony.getText()));
        Rony.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Rony.getText()), Rony.isChecked());
            }
        });
        final CheckBox Snowbike = mainView.findViewById(R.id.Snowbike);
        Snowbike.setChecked(getConfig((String) Snowbike.getText()));
        Snowbike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Snowbike.getText()), Snowbike.isChecked());
            }
        });
        final CheckBox Snowmobile = mainView.findViewById(R.id.Snowmobile);
        Snowmobile.setChecked(getConfig((String) Snowmobile.getText()));
        Snowmobile.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Snowmobile.getText()), Snowmobile.isChecked());
            }
        });
        final CheckBox Tempo = mainView.findViewById(R.id.Tempo);
        Tempo.setChecked(getConfig((String) Tempo.getText()));
        Tempo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Tempo.getText()), Tempo.isChecked());
            }
        });
        final CheckBox Truck = mainView.findViewById(R.id.Truck);
        Truck.setChecked(getConfig((String) Truck.getText()));
        Truck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Truck.getText()), Truck.isChecked());
            }
        });
        final CheckBox MonsterTruck = mainView.findViewById(R.id.MonsterTruck);
        MonsterTruck.setChecked(getConfig((String) MonsterTruck.getText()));
        MonsterTruck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(MonsterTruck.getText()), MonsterTruck.isChecked());
            }
        });
        final CheckBox BRDM = mainView.findViewById(R.id.BRDM);
        BRDM.setChecked(getConfig((String) BRDM.getText()));
        BRDM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(BRDM.getText()), BRDM.isChecked());
            }
        });
        final CheckBox LadaNiva = mainView.findViewById(R.id.LadaNiva);
        LadaNiva.setChecked(getConfig((String) LadaNiva.getText()));
        LadaNiva.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(LadaNiva.getText()), LadaNiva.isChecked());
            }
        });
        final CheckBox CheekPad = mainView.findViewById(R.id.CheekPad);
        CheekPad.setChecked(getConfig((String) CheekPad.getText()));
        CheekPad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(CheekPad.getText()), CheekPad.isChecked());
            }
        });
        final CheckBox AirDrop = mainView.findViewById(R.id.AirDrop);
        AirDrop.setChecked(getConfig((String) AirDrop.getText()));
        AirDrop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AirDrop.getText()), AirDrop.isChecked());
            }
        });
        final CheckBox Crate = mainView.findViewById(R.id.Crate);
        Crate.setChecked(getConfig((String) Crate.getText()));
        Crate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Crate.getText()), Crate.isChecked());
            }
        });
        final CheckBox DropPlane = mainView.findViewById(R.id.DropPlane);
        DropPlane.setChecked(getConfig((String) DropPlane.getText()));
        DropPlane.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(DropPlane.getText()), DropPlane.isChecked());
            }
        });
        final Switch isEnemyWeapon = mainView.findViewById(R.id.isEnemyWeapon);
        isEnemyWeapon.setChecked(getConfig((String) isEnemyWeapon.getText()));
        SettingValue(10,getConfig((String) isEnemyWeapon.getText()));
        isEnemyWeapon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isEnemyWeapon.getText()), isEnemyWeapon.isChecked());
                SettingValue(10,isEnemyWeapon.isChecked());
            }
        });
        final Switch isGrenadeWarning = mainView.findViewById(R.id.isGrenadeWarning);
        isGrenadeWarning.setChecked(getConfig((String) isGrenadeWarning.getText()));
        SettingValue(9,getConfig((String) isGrenadeWarning.getText()));
        isGrenadeWarning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isGrenadeWarning.getText()), isGrenadeWarning.isChecked());
                SettingValue(9,isGrenadeWarning.isChecked());
            }
        });
        final CheckBox isSkelton = mainView.findViewById(R.id.isSkelton);
        isSkelton.setChecked(getConfig((String) isSkelton.getText()));
        SettingValue(8,getConfig((String) isSkelton.getText()));
        isSkelton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isSkelton.getText()), isSkelton.isChecked());
                SettingValue(8,isSkelton.isChecked());
            }
        });
        final Switch isHead = mainView.findViewById(R.id.isHead);
        isHead.setChecked(getConfig((String) isHead.getText()));
        SettingValue(6,getConfig((String) isHead.getText()));
        isHead.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isHead.getText()), isHead.isChecked());
                SettingValue(6,isHead.isChecked());
            }
        });
        final RadioButton isBox = mainView.findViewById(R.id.isBox);
        isBox.setChecked(getConfig((String) isBox.getText()));
        SettingValue(1,getConfig((String) isBox.getText()));
        isBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isBox.getText()), isBox.isChecked());
                SettingValue(1,isBox.isChecked());
            }
        });
       /* final RadioButton isBoxFill = mainView.findViewById(R.id.isBoxFill);
        isBoxFill.setChecked(getConfig((String) isBoxFill.getText()));
        SettingValue(14,getConfig((String) isBoxFill.getText()));
        isBoxFill.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isBoxFill.getText()), isBoxFill.isChecked());
                SettingValue(14,isBoxFill.isChecked());
            }
        });*/
        final RadioButton isLineTop = mainView.findViewById(R.id.isLineTop);
        isLineTop.setChecked(getConfig((String) isLineTop.getText()));
        SettingValue(2,getConfig((String) isLineTop.getText()));
        isLineTop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isLineTop.getText()), isLineTop.isChecked());
                SettingValue(2,isLineTop.isChecked());
            }
        });
        final RadioButton isLineMiddle = mainView.findViewById(R.id.isLineMiddle);
        isLineMiddle.setChecked(getConfig((String) isLineMiddle.getText()));
        SettingValue(15,getConfig((String) isLineMiddle.getText()));
        isLineMiddle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isLineMiddle.getText()), isLineMiddle.isChecked());
                SettingValue(15,isLineMiddle.isChecked());
            }
        });
        final RadioButton isLineBottom = mainView.findViewById(R.id.isLineBottom);
        isLineBottom.setChecked(getConfig((String) isLineBottom.getText()));
        SettingValue(16,getConfig((String) isLineBottom.getText()));
        isLineBottom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isLineBottom.getText()), isLineBottom.isChecked());
                SettingValue(16,isLineBottom.isChecked());
            }
        });
        final CheckBox isBack = mainView.findViewById(R.id.isBack);
        isBack.setChecked(getConfig((String) isBack.getText()));
        SettingValue(7,getConfig((String) isBack.getText()));
        isBack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isBack.getText()), isBack.isChecked());
                SettingValue(7,isBack.isChecked());
            }
        });
        final CheckBox isHealth = mainView.findViewById(R.id.isHealth);
        isHealth.setChecked(getConfig((String) isHealth.getText()));
        SettingValue(4,getConfig((String) isHealth.getText()));
        isHealth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isHealth.getText()), isHealth.isChecked());
                SettingValue(4,isHealth.isChecked());
            }
        });
        final CheckBox isName = mainView.findViewById(R.id.isName);
        isName.setChecked(getConfig((String) isName.getText()));
        SettingValue(5,getConfig((String) isName.getText()));
        isName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isName.getText()), isName.isChecked());
                SettingValue(5,isName.isChecked());
            }
        });
        final CheckBox isDist = mainView.findViewById(R.id.isDist);
        isDist.setChecked(getConfig((String) isDist.getText()));
        SettingValue(3,getConfig((String) isDist.getText()));
        isDist.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isDist.getText()), isDist.isChecked());
                SettingValue(3,isDist.isChecked());
            }
        });


        final CheckBox canted = mainView.findViewById(R.id.canted);
        canted.setChecked(getConfig((String) canted.getText()));
        canted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(canted.getText()),canted.isChecked());
            }
        });

        final CheckBox reddot = mainView.findViewById(R.id.reddot);
        reddot.setChecked(getConfig((String) reddot.getText()));
        reddot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(reddot.getText()),reddot.isChecked());
            }
        });

        final CheckBox hollow = mainView.findViewById(R.id.hollow);
        hollow.setChecked(getConfig((String) hollow.getText()));
        hollow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(hollow.getText()),hollow.isChecked());
            }
        });

        final CheckBox twox = mainView.findViewById(R.id.twox);
        twox.setChecked(getConfig((String) twox.getText()));
        twox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(twox.getText()),twox.isChecked());
            }
        });

        final CheckBox threex = mainView.findViewById(R.id.threex);
        threex.setChecked(getConfig((String) threex.getText()));
        threex.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(threex.getText()),threex.isChecked());
            }
        });

        final CheckBox fourx = mainView.findViewById(R.id.fourx);
        fourx.setChecked(getConfig((String) fourx.getText()));
        fourx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(fourx.getText()),fourx.isChecked());
            }
        });

        final CheckBox sixx = mainView.findViewById(R.id.sixx);
        sixx.setChecked(getConfig((String) sixx.getText()));
        sixx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(sixx.getText()),sixx.isChecked());
            }
        });

        final CheckBox eightx = mainView.findViewById(R.id.eightx);
        eightx.setChecked(getConfig((String) eightx.getText()));
        eightx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(eightx.getText()),eightx.isChecked());
            }
        });

        final CheckBox AWM = mainView.findViewById(R.id.AWM);
        AWM.setChecked(getConfig((String) AWM.getText()));
        AWM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AWM.getText()),AWM.isChecked());
            }
        });

        final CheckBox QBU = mainView.findViewById(R.id.QBU);
        QBU.setChecked(getConfig((String) QBU.getText()));
        QBU.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QBU.getText()),QBU.isChecked());
            }
        });

        final CheckBox SLR = mainView.findViewById(R.id.SLR);
        SLR.setChecked(getConfig((String) SLR.getText()));
        SLR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SLR.getText()),SLR.isChecked());
            }
        });

        final CheckBox SKS = mainView.findViewById(R.id.SKS);
        SKS.setChecked(getConfig((String) SKS.getText()));
        SKS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SKS.getText()),SKS.isChecked());
            }
        });

        final CheckBox Mini14 = mainView.findViewById(R.id.Mini14);
        Mini14.setChecked(getConfig((String) Mini14.getText()));
        Mini14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Mini14.getText()),Mini14.isChecked());
            }
        });

        final CheckBox M24 = mainView.findViewById(R.id.M24);
        M24.setChecked(getConfig((String) M24.getText()));
        M24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M24.getText()),M24.isChecked());
            }
        });

        final CheckBox Kar98k = mainView.findViewById(R.id.Kar98k);
        Kar98k.setChecked(getConfig((String) Kar98k.getText()));
        Kar98k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Kar98k.getText()),Kar98k.isChecked());
            }
        });

        final CheckBox VSS = mainView.findViewById(R.id.VSS);
        VSS.setChecked(getConfig((String) VSS.getText()));
        VSS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(VSS.getText()),VSS.isChecked());
            }
        });

        final CheckBox Win94 = mainView.findViewById(R.id.Win94);
        Win94.setChecked(getConfig((String) Win94.getText()));
        Win94.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Win94.getText()),Win94.isChecked());
            }
        });

        final CheckBox AUG = mainView.findViewById(R.id.AUG);
        AUG.setChecked(getConfig((String) AUG.getText()));
        AUG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AUG.getText()),AUG.isChecked());
            }
        });

        final CheckBox M762 = mainView.findViewById(R.id.M762);
        M762.setChecked(getConfig((String) M762.getText()));
        M762.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M762.getText()),M762.isChecked());
            }
        });

        final CheckBox SCARL = mainView.findViewById(R.id.SCARL);
        SCARL.setChecked(getConfig((String) SCARL.getText()));
        SCARL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SCARL.getText()),SCARL.isChecked());
            }
        });

        final CheckBox M416 = mainView.findViewById(R.id.M416);
        M416.setChecked(getConfig((String) M416.getText()));
        M416.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M416.getText()),M416.isChecked());
            }
        });

        final CheckBox M16A4 = mainView.findViewById(R.id.M16A4);
        M16A4.setChecked(getConfig((String) M16A4.getText()));
        M16A4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M16A4.getText()),M16A4.isChecked());
            }
        });

        final CheckBox Mk47Mutant = mainView.findViewById(R.id.Mk47Mutant);
        Mk47Mutant.setChecked(getConfig((String) Mk47Mutant.getText()));
        Mk47Mutant.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Mk47Mutant.getText()),Mk47Mutant.isChecked());
            }
        });

        final CheckBox G36C = mainView.findViewById(R.id.G36C);
        G36C.setChecked(getConfig((String) G36C.getText()));
        G36C.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(G36C.getText()),G36C.isChecked());
            }
        });

        final CheckBox QBZ = mainView.findViewById(R.id.QBZ);
        QBZ.setChecked(getConfig((String) QBZ.getText()));
        QBZ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QBZ.getText()),QBZ.isChecked());
            }
        });

        final CheckBox AKM = mainView.findViewById(R.id.AKM);
        AKM.setChecked(getConfig((String) AKM.getText()));
        AKM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AKM.getText()),AKM.isChecked());
            }
        });

        final CheckBox Groza = mainView.findViewById(R.id.Groza);
        Groza.setChecked(getConfig((String) Groza.getText()));
        Groza.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Groza.getText()),Groza.isChecked());
            }
        });

        final CheckBox S12K = mainView.findViewById(R.id.S12K);
        S12K.setChecked(getConfig((String) S12K.getText()));
        S12K.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(S12K.getText()),S12K.isChecked());
            }
        });

        final CheckBox DBS = mainView.findViewById(R.id.DBS);
        DBS.setChecked(getConfig((String) DBS.getText()));
        DBS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(DBS.getText()),DBS.isChecked());
            }
        });

        final CheckBox S686 = mainView.findViewById(R.id.S686);
        S686.setChecked(getConfig((String) S686.getText()));
        S686.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(S686.getText()),S686.isChecked());
            }
        });

        final CheckBox S1897 = mainView.findViewById(R.id.S1897);
        S1897.setChecked(getConfig((String) S1897.getText()));
        S1897.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(S1897.getText()),S1897.isChecked());
            }
        });

        final CheckBox SawedOff = mainView.findViewById(R.id.SawedOff);
        SawedOff.setChecked(getConfig((String) SawedOff.getText()));
        SawedOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SawedOff.getText()),SawedOff.isChecked());
            }
        });

        final CheckBox TommyGun = mainView.findViewById(R.id.TommyGun);
        TommyGun.setChecked(getConfig((String) TommyGun.getText()));
        TommyGun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(TommyGun.getText()),TommyGun.isChecked());
            }
        });

        final CheckBox MP5K = mainView.findViewById(R.id.MP5K);
        MP5K.setChecked(getConfig((String) MP5K.getText()));
        MP5K.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(MP5K.getText()),MP5K.isChecked());
            }
        });

        final CheckBox Vector = mainView.findViewById(R.id.Vector);
        Vector.setChecked(getConfig((String) Vector.getText()));
        Vector.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Vector.getText()),Vector.isChecked());
            }
        });

        final CheckBox Uzi = mainView.findViewById(R.id.Uzi);
        Uzi.setChecked(getConfig((String) Uzi.getText()));
        Uzi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Uzi.getText()),Uzi.isChecked());
            }
        });

        final CheckBox R1895 = mainView.findViewById(R.id.R1895);
        R1895.setChecked(getConfig((String) R1895.getText()));
        R1895.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(R1895.getText()),R1895.isChecked());
            }
        });

        final CheckBox Vz61 = mainView.findViewById(R.id.Vz61);
        Vz61.setChecked(getConfig((String) Vz61.getText()));
        Vz61.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Vz61.getText()),Vz61.isChecked());
            }
        });

        final CheckBox P92 = mainView.findViewById(R.id.P92);
        P92.setChecked(getConfig((String) P92.getText()));
        P92.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(P92.getText()),P92.isChecked());
            }
        });

        final CheckBox P18C = mainView.findViewById(R.id.P18C);
        P18C.setChecked(getConfig((String) P18C.getText()));
        P18C.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(P18C.getText()),P18C.isChecked());
            }
        });

        final CheckBox R45 = mainView.findViewById(R.id.R45);
        R45.setChecked(getConfig((String) R45.getText()));
        R45.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(R45.getText()),R45.isChecked());
            }
        });

        final CheckBox P1911 = mainView.findViewById(R.id.P1911);
        P1911.setChecked(getConfig((String) P1911.getText()));
        P1911.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(P1911.getText()),P1911.isChecked());
            }
        });

        final CheckBox DesertEagle = mainView.findViewById(R.id.DesertEagle);
        DesertEagle.setChecked(getConfig((String) DesertEagle.getText()));
        DesertEagle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(DesertEagle.getText()),DesertEagle.isChecked());
            }
        });

        final CheckBox Sickle = mainView.findViewById(R.id.Sickle);
        Sickle.setChecked(getConfig((String) Sickle.getText()));
        Sickle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Sickle.getText()),Sickle.isChecked());
            }
        });

        final CheckBox Machete = mainView.findViewById(R.id.Machete);
        Machete.setChecked(getConfig((String) Machete.getText()));
        Machete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Machete.getText()),Machete.isChecked());
            }
        });

        final CheckBox Pan = mainView.findViewById(R.id.Pan);
        Pan.setChecked(getConfig((String) Pan.getText()));
        Pan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Pan.getText()),Pan.isChecked());
            }
        });

        final CheckBox Mk14 = mainView.findViewById(R.id.Mk14);
        Mk14.setChecked(getConfig((String) Mk14.getText()));
        Mk14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Mk14.getText()),Mk14.isChecked());
            }
        });

        final CheckBox sst = mainView.findViewById(R.id.sst);
        sst.setChecked(getConfig((String) sst.getText()));
        sst.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(sst.getText()),sst.isChecked());
            }
        });

        final CheckBox ffACP = mainView.findViewById(R.id.ffACP);
        ffACP.setChecked(getConfig((String) ffACP.getText()));
        ffACP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ffACP.getText()),ffACP.isChecked());
            }
        });

        final CheckBox ffs = mainView.findViewById(R.id.ffs);
        ffs.setChecked(getConfig((String) ffs.getText()));
        ffs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ffs.getText()),ffs.isChecked());
            }
        });

        final CheckBox nmm = mainView.findViewById(R.id.nmm);
        nmm.setChecked(getConfig((String) nmm.getText()));
        nmm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(nmm.getText()),nmm.isChecked());
            }
        });

        final CheckBox tzzMagnum = mainView.findViewById(R.id.tzzMagnum);
        tzzMagnum.setChecked(getConfig((String) tzzMagnum.getText()));
        tzzMagnum.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(tzzMagnum.getText()),tzzMagnum.isChecked());
            }
        });

        final CheckBox otGuage = mainView.findViewById(R.id.otGuage);
        otGuage.setChecked(getConfig((String) otGuage.getText()));
        otGuage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(otGuage.getText()),otGuage.isChecked());
            }
        });

        final CheckBox Choke = mainView.findViewById(R.id.Choke);
        Choke.setChecked(getConfig((String) Choke.getText()));
        Choke.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Choke.getText()),Choke.isChecked());
            }
        });

        final CheckBox SniperCompensator = mainView.findViewById(R.id.SniperCompensator);
        SniperCompensator.setChecked(getConfig((String) SniperCompensator.getText()));
        SniperCompensator.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SniperCompensator.getText()),SniperCompensator.isChecked());
            }
        });

        final CheckBox DP28 = mainView.findViewById(R.id.DP28);
        DP28.setChecked(getConfig((String) DP28.getText()));
        DP28.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(DP28.getText()),DP28.isChecked());
            }
        });

        final CheckBox M249 = mainView.findViewById(R.id.M249);
        M249.setChecked(getConfig((String) M249.getText()));
        M249.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M249.getText()),M249.isChecked());
            }
        });

        final CheckBox Grenade = mainView.findViewById(R.id.Grenade);
        Grenade.setChecked(getConfig((String) Grenade.getText()));
        Grenade.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Grenade.getText()),Grenade.isChecked());
            }
        });

        final CheckBox Smoke = mainView.findViewById(R.id.Smoke);
        Smoke.setChecked(getConfig((String) Smoke.getText()));
        Smoke.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Smoke.getText()),Smoke.isChecked());
            }
        });

        final CheckBox Molotov = mainView.findViewById(R.id.Molotov);
        Molotov.setChecked(getConfig((String) Molotov.getText()));
        Molotov.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Molotov.getText()),Molotov.isChecked());
            }
        });

        final CheckBox Painkiller = mainView.findViewById(R.id.Painkiller);
        Painkiller.setChecked(getConfig((String) Painkiller.getText()));
        Painkiller.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Painkiller.getText()),Painkiller.isChecked());
            }
        });

        final CheckBox Adrenaline = mainView.findViewById(R.id.Adrenaline);
        Adrenaline.setChecked(getConfig((String) Adrenaline.getText()));
        Adrenaline.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Adrenaline.getText()),Adrenaline.isChecked());
            }
        });

        final CheckBox EnergyDrink = mainView.findViewById(R.id.EnergyDrink);
        EnergyDrink.setChecked(getConfig((String) EnergyDrink.getText()));
        EnergyDrink.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(EnergyDrink.getText()),EnergyDrink.isChecked());
            }
        });

        final CheckBox FirstAidKit = mainView.findViewById(R.id.FirstAidKit);
        FirstAidKit.setChecked(getConfig((String) FirstAidKit.getText()));
        FirstAidKit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FirstAidKit.getText()),FirstAidKit.isChecked());
            }
        });

        final CheckBox Bandage = mainView.findViewById(R.id.Bandage);
        Bandage.setChecked(getConfig((String) Bandage.getText()));
        Bandage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Bandage.getText()),Bandage.isChecked());
            }
        });

        final CheckBox Medkit = mainView.findViewById(R.id.Medkit);
        Medkit.setChecked(getConfig((String) Medkit.getText()));
        Medkit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Medkit.getText()),Medkit.isChecked());
            }
        });

        final CheckBox FlareGun = mainView.findViewById(R.id.FlareGun);
        FlareGun.setChecked(getConfig((String) FlareGun.getText()));
        FlareGun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FlareGun.getText()),FlareGun.isChecked());
            }
        });

        final CheckBox GullieSuit = mainView.findViewById(R.id.GullieSuit);
        GullieSuit.setChecked(getConfig((String) GullieSuit.getText()));
        GullieSuit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(GullieSuit.getText()),GullieSuit.isChecked());
            }
        });

        final CheckBox UMP = mainView.findViewById(R.id.UMP);
        UMP.setChecked(getConfig((String) UMP.getText()));
        UMP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(UMP.getText()),UMP.isChecked());
            }
        });

        final CheckBox Bizon = mainView.findViewById(R.id.Bizon);
        Bizon.setChecked(getConfig((String) Bizon.getText()));
        Bizon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Bizon.getText()),Bizon.isChecked());
            }
        });

        final CheckBox CompensatorSMG = mainView.findViewById(R.id.CompensatorSMG);
        CompensatorSMG.setChecked(getConfig((String) CompensatorSMG.getText()));
        CompensatorSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(CompensatorSMG.getText()),CompensatorSMG.isChecked());
            }
        });

        final CheckBox FlashHiderSMG = mainView.findViewById(R.id.FlashHiderSMG);
        FlashHiderSMG.setChecked(getConfig((String) FlashHiderSMG.getText()));
        FlashHiderSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FlashHiderSMG.getText()),FlashHiderSMG.isChecked());
            }
        });

        final CheckBox FlashHiderAr = mainView.findViewById(R.id.FlashHiderAr);
        FlashHiderAr.setChecked(getConfig((String) FlashHiderAr.getText()));
        FlashHiderAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FlashHiderAr.getText()),FlashHiderAr.isChecked());
            }
        });

        final CheckBox ArCompensator = mainView.findViewById(R.id.ArCompensator);
        ArCompensator.setChecked(getConfig((String) ArCompensator.getText()));
        ArCompensator.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ArCompensator.getText()),ArCompensator.isChecked());
            }
        });

        final CheckBox TacticalStock = mainView.findViewById(R.id.TacticalStock);
        TacticalStock.setChecked(getConfig((String) TacticalStock.getText()));
        TacticalStock.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(TacticalStock.getText()),TacticalStock.isChecked());
            }
        });

        final CheckBox Duckbill = mainView.findViewById(R.id.Duckbill);
        Duckbill.setChecked(getConfig((String) Duckbill.getText()));
        Duckbill.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Duckbill.getText()),Duckbill.isChecked());
            }
        });

        final CheckBox FlashHiderSniper = mainView.findViewById(R.id.FlashHiderSniper);
        FlashHiderSniper.setChecked(getConfig((String) FlashHiderSniper.getText()));
        FlashHiderSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FlashHiderSniper.getText()),FlashHiderSniper.isChecked());
            }
        });

        final CheckBox SuppressorSMG = mainView.findViewById(R.id.SuppressorSMG);
        SuppressorSMG.setChecked(getConfig((String) SuppressorSMG.getText()));
        SuppressorSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SuppressorSMG.getText()),SuppressorSMG.isChecked());
            }
        });

        final CheckBox HalfGrip = mainView.findViewById(R.id.HalfGrip);
        HalfGrip.setChecked(getConfig((String) HalfGrip.getText()));
        HalfGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(HalfGrip.getText()),HalfGrip.isChecked());
            }
        });

        final CheckBox StockMicroUZI = mainView.findViewById(R.id.StockMicroUZI);
        StockMicroUZI.setChecked(getConfig((String) StockMicroUZI.getText()));
        StockMicroUZI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(StockMicroUZI.getText()),StockMicroUZI.isChecked());
            }
        });

        final CheckBox SuppressorSniper = mainView.findViewById(R.id.SuppressorSniper);
        SuppressorSniper.setChecked(getConfig((String) SuppressorSniper.getText()));
        SuppressorSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SuppressorSniper.getText()),SuppressorSniper.isChecked());
            }
        });

        final CheckBox SuppressorAr = mainView.findViewById(R.id.SuppressorAr);
        SuppressorAr.setChecked(getConfig((String) SuppressorAr.getText()));
        SuppressorAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SuppressorAr.getText()),SuppressorAr.isChecked());
            }
        });

        final CheckBox ExQdSniper = mainView.findViewById(R.id.ExQdSniper);
        ExQdSniper.setChecked(getConfig((String) ExQdSniper.getText()));
        ExQdSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExQdSniper.getText()),ExQdSniper.isChecked());
            }
        });

        final CheckBox QdSMG = mainView.findViewById(R.id.QdSMG);
        QdSMG.setChecked(getConfig((String) QdSMG.getText()));
        QdSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QdSMG.getText()),QdSMG.isChecked());
            }
        });

        final CheckBox ExSMG = mainView.findViewById(R.id.ExSMG);
        ExSMG.setChecked(getConfig((String) ExSMG.getText()));
        ExSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExSMG.getText()),ExSMG.isChecked());
            }
        });

        final CheckBox QdSniper = mainView.findViewById(R.id.QdSniper);
        QdSniper.setChecked(getConfig((String) QdSniper.getText()));
        QdSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QdSniper.getText()),QdSniper.isChecked());
            }
        });

        final CheckBox ExSniper = mainView.findViewById(R.id.ExSniper);
        ExSniper.setChecked(getConfig((String) ExSniper.getText()));
        ExSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExSniper.getText()),ExSniper.isChecked());
            }
        });

        final CheckBox ExAr = mainView.findViewById(R.id.ExAr);
        ExAr.setChecked(getConfig((String) ExAr.getText()));
        ExAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExAr.getText()),ExAr.isChecked());
            }
        });

        final CheckBox ExQdAr = mainView.findViewById(R.id.ExQdAr);
        ExQdAr.setChecked(getConfig((String) ExQdAr.getText()));
        ExQdAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExQdAr.getText()),ExQdAr.isChecked());
            }
        });

        final CheckBox QdAr = mainView.findViewById(R.id.QdAr);
        QdAr.setChecked(getConfig((String) QdAr.getText()));
        QdAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QdAr.getText()),QdAr.isChecked());
            }
        });

        final CheckBox ExQdSMG = mainView.findViewById(R.id.ExQdSMG);
        ExQdSMG.setChecked(getConfig((String) ExQdSMG.getText()));
        ExQdSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExQdSMG.getText()),ExQdSMG.isChecked());
            }
        });

        final CheckBox QuiverCrossBow = mainView.findViewById(R.id.QuiverCrossBow);
        QuiverCrossBow.setChecked(getConfig((String) QuiverCrossBow.getText()));
        QuiverCrossBow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QuiverCrossBow.getText()),QuiverCrossBow.isChecked());
            }
        });

        final CheckBox BulletLoop = mainView.findViewById(R.id.BulletLoop);
        BulletLoop.setChecked(getConfig((String) BulletLoop.getText()));
        BulletLoop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(BulletLoop.getText()),BulletLoop.isChecked());
            }
        });

        final CheckBox ThumbGrip = mainView.findViewById(R.id.ThumbGrip);
        ThumbGrip.setChecked(getConfig((String) ThumbGrip.getText()));
        ThumbGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ThumbGrip.getText()),ThumbGrip.isChecked());
            }
        });

        final CheckBox LaserSight = mainView.findViewById(R.id.LaserSight);
        LaserSight.setChecked(getConfig((String) LaserSight.getText()));
        LaserSight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(LaserSight.getText()),LaserSight.isChecked());
            }
        });

        final CheckBox AngledGrip = mainView.findViewById(R.id.AngledGrip);
        AngledGrip.setChecked(getConfig((String) AngledGrip.getText()));
        AngledGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AngledGrip.getText()),AngledGrip.isChecked());
            }
        });

        final CheckBox LightGrip = mainView.findViewById(R.id.LightGrip);
        LightGrip.setChecked(getConfig((String) LightGrip.getText()));
        LightGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(LightGrip.getText()),LightGrip.isChecked());
            }
        });

        final CheckBox VerticalGrip = mainView.findViewById(R.id.VerticalGrip);
        VerticalGrip.setChecked(getConfig((String) VerticalGrip.getText()));
        VerticalGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(VerticalGrip.getText()),VerticalGrip.isChecked());
            }
        });

        final CheckBox GasCan = mainView.findViewById(R.id.GasCan);
        GasCan.setChecked(getConfig((String) GasCan.getText()));
        GasCan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(GasCan.getText()),GasCan.isChecked());
            }
        });

        final CheckBox Arrow = mainView.findViewById(R.id.Arrow);
        Arrow.setChecked(getConfig((String) Arrow.getText()));
        Arrow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Arrow.getText()),Arrow.isChecked());
            }
        });

        final CheckBox CrossBow = mainView.findViewById(R.id.CrossBow);
        CrossBow.setChecked(getConfig((String) CrossBow.getText()));
        CrossBow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(CrossBow.getText()),CrossBow.isChecked());
            }
        });

        final CheckBox Baglvl1 = mainView.findViewById(R.id.Baglvl1);
        Baglvl1.setChecked(getConfig((String) Baglvl1.getText()));
        Baglvl1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Baglvl1.getText()),Baglvl1.isChecked());
            }
        });

        final CheckBox Baglvl2 = mainView.findViewById(R.id.Baglvl2);
        Baglvl2.setChecked(getConfig((String) Baglvl2.getText()));
        Baglvl2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Baglvl2.getText()),Baglvl2.isChecked());
            }
        });

        final CheckBox Baglvl3 = mainView.findViewById(R.id.Baglvl3);
        Baglvl3.setChecked(getConfig((String) Baglvl3.getText()));
        Baglvl3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Baglvl3.getText()),Baglvl3.isChecked());
            }
        });

        final CheckBox Helmetlvl1 = mainView.findViewById(R.id.Helmetlvl1);
        Helmetlvl1.setChecked(getConfig((String) Helmetlvl1.getText()));
        Helmetlvl1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Helmetlvl1.getText()),Helmetlvl1.isChecked());
            }
        });

        final CheckBox Helmetlvl2 = mainView.findViewById(R.id.Helmetlvl2);
        Helmetlvl2.setChecked(getConfig((String) Helmetlvl2.getText()));
        Helmetlvl2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Helmetlvl2.getText()),Helmetlvl2.isChecked());
            }
        });

        final CheckBox Helmetlvl3 = mainView.findViewById(R.id.Helmetlvl3);
        Helmetlvl3.setChecked(getConfig((String) Helmetlvl3.getText()));
        Helmetlvl3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Helmetlvl3.getText()),Helmetlvl3.isChecked());
            }
        });

        final CheckBox Vestlvl1 = mainView.findViewById(R.id.Vestlvl1);
        Vestlvl1.setChecked(getConfig((String) Vestlvl1.getText()));
        Vestlvl1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Vestlvl1.getText()),Vestlvl1.isChecked());
            }
        });

        final CheckBox Vestlvl2 = mainView.findViewById(R.id.Vestlvl2);
        Vestlvl2.setChecked(getConfig((String) Vestlvl2.getText()));
        Vestlvl2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Vestlvl2.getText()),Vestlvl2.isChecked());
            }
        });

        final CheckBox Vestlvl3 = mainView.findViewById(R.id.Vestlvl3);
        Vestlvl3.setChecked(getConfig((String) Vestlvl3.getText()));
        Vestlvl3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Vestlvl3.getText()),Vestlvl3.isChecked());
            }
        });

        final CheckBox Stung = mainView.findViewById(R.id.Stung);
        Stung.setChecked(getConfig((String) Stung.getText()));
        Stung.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Stung.getText()),Stung.isChecked());
            }
        });

        final CheckBox Crowbar = mainView.findViewById(R.id.Crowbar);
        Crowbar.setChecked(getConfig((String) Crowbar.getText()));
        Crowbar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Crowbar.getText()),Crowbar.isChecked());
            }
        });

        final SeekBar fps = mainView.findViewById(R.id.fps);
        fps.setProgress(getFps());
        ESPView.ChangeFps(getFps());
        fps.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int fpsms=fps.getProgress();
                setFps(fpsms);
                ESPView.ChangeFps(fpsms);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        final RadioButton fpssatu = mainView.findViewById(R.id.fpssatu);
        final RadioButton fpsdua = mainView.findViewById(R.id.fpsdua);

        fpssatu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    fpsdua.setChecked(false);
                }
            }
        });

        fpsdua.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    fpssatu.setChecked(false);
                }
            }
        });
        final RadioButton Icon = mainView.findViewById(R.id.meterial);
        final RadioButton IconDistance = mainView.findViewById(R.id.meterialdistance);

        Icon.setChecked(getConfig((String) Icon.getText()));
        Icon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Icon.getText()), Icon.isChecked());

                if (isChecked) {
                    IconDistance.setChecked(false);
                }
            }
        });

        IconDistance.setChecked(getConfig((String) IconDistance.getText()));
        IconDistance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                setValue(String.valueOf(IconDistance.getText()), IconDistance.isChecked());

                if (isChecked) {

                    Icon.setChecked(false);
                }
            }
        });

        LinearLayout test = mainView.findViewById(R.id.test);
        RadioGroup testhide = mainView.findViewById(R.id.testhide);
        RadioButton hideoff = mainView.findViewById(R.id.hideoff);
        hideoff.setChecked(true);
        testhide.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.hideoff:
                        test.setVisibility(View.GONE);
                        break;
                    case R.id.hideon:
                        test.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        LinearLayout hidespeed = mainView.findViewById(R.id.hidespeed);
        RadioGroup testspeed = mainView.findViewById(R.id.testspeed);
        RadioButton speedoff = mainView.findViewById(R.id.speedoff);
        speedoff.setChecked(true);
        testspeed.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.speedoff:
                        hidespeed.setVisibility(View.GONE);
                        break;
                    case R.id.speedon:
                        hidespeed.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        LinearLayout hideothers = mainView.findViewById(R.id.hideothers);
        RadioGroup testothers = mainView.findViewById(R.id.testothers);
        RadioButton othersoff = mainView.findViewById(R.id.othersoff);
        othersoff.setChecked(true);
        testothers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.othersoff:
                        hideothers.setVisibility(View.GONE);
                        break;
                    case R.id.otherson:
                        hideothers.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        final SeekBar range = mainView.findViewById(R.id.range);
        range.setProgress(getRange());
        Range(getRange());
        range.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Range(range.getProgress());
                setRange(range.getProgress());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        final RadioGroup aimby=mainView.findViewById(R.id.aimby);
        aimby.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int chkdId=aimby.getCheckedRadioButtonId();
                RadioButton btn=mainView.findViewById(chkdId);
                AimBy(Integer.parseInt(btn.getTag().toString()));
            }
        });
        final RadioGroup aimwhen=mainView.findViewById(R.id.aimwhen);
        aimwhen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int chkdId=aimwhen.getCheckedRadioButtonId();
                RadioButton btn=mainView.findViewById(chkdId);
                AimWhen(Integer.parseInt(btn.getTag().toString()));
            }
        });
        final RadioGroup aimbotmode=mainView.findViewById(R.id.aimbotmode);
        aimbotmode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int chkdId=aimbotmode.getCheckedRadioButtonId();
                RadioButton btn=mainView.findViewById(chkdId);
                Target(Integer.parseInt(btn.getTag().toString()));
            }
        });
        final CheckBox aimbot = mainView.findViewById(R.id.aimbot);
        aimbot.setChecked(getConfig((String) aimbot.getText()));
        aimbot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setValue(String.valueOf(aimbot.getText()), aimbot.isChecked());
                    floatAimbot=true;
                    startFloatAimbot();
                } else {
                    setValue(String.valueOf(aimbot.getText()), aimbot.isChecked());
                    SettingValue(11,false);
                    floatAimbot=false;
                    stopFloatAimbot();
                }
            }
        });
        final Switch aimknocked = mainView.findViewById(R.id.aimknocked);
        aimknocked.setChecked(getConfig((String) aimknocked.getText()));
        SettingValue(13,getConfig((String) aimknocked.getText()));
        aimknocked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(aimknocked.getText()), aimknocked.isChecked());
                SettingValue(13,aimknocked.isChecked());
            }
        });

        Switch X10 = mainView.findViewById(R.id.X10); //Speed v1
        X10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 44");
                } else {
                    RunCPP("/temp 45");
                }
            }
        });


        Switch X11 = mainView.findViewById(R.id.X11); //Speed v2
        X11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 46");
                } else {
                    RunCPP("/temp 47");
                }
            }
        });

        Switch X12 = mainView.findViewById(R.id.X12); //Speed v3
        X12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 48");
                } else {
                    RunCPP("/temp 49");
                }
            }
        });


        Switch X13 = mainView.findViewById(R.id.X13); //Speed v4
        X13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 50");
                } else {
                    RunCPP("/temp 51");
                }
            }
        });

        Switch X14 = mainView.findViewById(R.id.X14); //Speed v5
        X14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 52");
                } else {
                    RunCPP("/temp 53");
                }
            }
        });


        CheckBox X34 = mainView.findViewById(R.id.X34); //fix stuck
        X34.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 8448");
                } else {
                    RunCPP("/temp 8449");
                }
            }
        });

        SeekBar spedplus = mainView.findViewById(R.id.spedplus); //Speed+
        spedplus.incrementProgressBy(10);
        spedplus.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar p1, int progress, boolean p3)
            {
                progress = progress / 1;
                progress = progress * 1;

            }
            @Override
            public void onStartTrackingTouch(SeekBar p1)
            {
            }
            @Override
            public void onStopTrackingTouch(SeekBar p1)
            {
                int progress = p1.getProgress();
                progress = progress / 1;
                progress = progress * 1;
                if (progress == 0)
                {
                    RunCPP("/temp 500");
                }
                else if (progress == 1)
                {
                    RunCPP("/temp 501");
                }
                else if (progress == 2)
                {
                    RunCPP("/temp 502");
                }
                else if (progress == 3)
                {
                    RunCPP("/temp 503");
                }
                else if (progress == 4)
                {
                    RunCPP("/temp 504");
                }
                else if (progress == 5)
                {
                    RunCPP("/temp 505");
                }
                else if (progress == 6)
                {
                    RunCPP("/temp 506");
                }
                else if (progress == 7)
                {
                    RunCPP("/temp 507");
                }
                else if (progress == 8)
                {
                    RunCPP("/temp 508");
                }
                else if (progress == 9)
                {
                    RunCPP("/temp 509");
                }
                else if (progress == 10)
                {
                    RunCPP("/temp 510");
                }
            }
        });
        spedplus.setProgress(0);


        RadioGroup firemode = mainView.findViewById(R.id.firemode);
        RadioButton fireoff = mainView.findViewById(R.id.fireoff);
        fireoff.setChecked(true);
        firemode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.fireoff:
                        break;
                    case R.id.X15:
                        RunCPP("/temp 100"); //fire v1
                        break;
                    case R.id.X16:
                        RunCPP("/temp 101"); //fire v2
                        break;
                }
            }
        });

        Switch X33 = mainView.findViewById(R.id.X33); //fast paracute
        X33.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 54");
                } else {
                    RunCPP("/temp 55");
                }
            }
        });

        Switch X17 = mainView.findViewById(R.id.X17); //prone+knock
        X17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 89");
                } else {
                    RunCPP("/temp 90");
                }
            }
        });

        Switch X18 = mainView.findViewById(R.id.X18); //speed cars
        X18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 56");
                } else {
                    RunCPP("/temp 57");
                }
            }
        });
        SeekBar ipadview = mainView.findViewById(R.id.ipadview); //IpadView
        ipadview.incrementProgressBy(10);
        ipadview.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar p1, int progress, boolean p3)
            {
                progress = progress / 1;
                progress = progress * 1;

            }
            @Override
            public void onStartTrackingTouch(SeekBar p1)
            {
            }
            @Override
            public void onStopTrackingTouch(SeekBar p1)
            {
                int progress = p1.getProgress();
                progress = progress / 1;
                progress = progress * 1;
                if (progress == 0)
                {
                    RunCPP("/temp 20");
                }
                else if (progress == 1)
                {
                    RunCPP("/temp 21");
                }
                else if (progress == 2)
                {
                    RunCPP("/temp 22");
                }
                else if (progress == 3)
                {
                    RunCPP("/temp 23");
                }
                else if (progress == 4)
                {
                    RunCPP("/temp 24");
                }
                else if (progress == 5)
                {
                    RunCPP("/temp 25");
                }
            }
        });
        ipadview.setProgress(0);

        SeekBar wideview = mainView.findViewById(R.id.wideview); //WideView
        wideview.incrementProgressBy(10);
        wideview.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar p1, int progress, boolean p3)
            {
                progress = progress / 1;
                progress = progress * 1;

            }
            @Override
            public void onStartTrackingTouch(SeekBar p1)
            {
            }
            @Override
            public void onStopTrackingTouch(SeekBar p1)
            {
                int progress = p1.getProgress();
                progress = progress / 1;
                progress = progress * 1;
                if (progress == 0)
                {
                    RunCPP("/temp 83");
                }
                else if (progress == 1)
                {
                    RunCPP("/temp 84");
                }
                else if (progress == 2)
                {
                    RunCPP("/temp 85");
                }
                else if (progress == 3)
                {
                    RunCPP("/temp 86");
                }
                else if (progress == 4)
                {
                    RunCPP("/temp 87");
                }
                else if (progress == 5)
                {
                    RunCPP("/temp 88");
                }
            }
        });
        wideview.setProgress(0);


        CheckBox X2 = mainView.findViewById(R.id.X2); //Less recoil
        X2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 61");
                } else {
                    RunCPP("/temp 62");
                }
            }
        });

        CheckBox X3 = mainView.findViewById(R.id.X3); //No recoil
        X3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 63");
                } else {
                    RunCPP("/temp 64");
                }
            }
        });

        CheckBox X4 = mainView.findViewById(R.id.X4); //Small croshair
        X4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 65");
                } else {
                    RunCPP("/temp 66");
                }
            }
        });

        CheckBox X5 = mainView.findViewById(R.id.X5); //Hit-efex
        X5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 28");
                } else {
                    RunCPP("/temp 29");
                }
            }
        });


        Switch X29 = mainView.findViewById(R.id.X29); //Jump players
        X29.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 40");
                } else {
                    RunCPP("/temp 41");
                }
            }
        });

        Switch X30 = mainView.findViewById(R.id.X30); //Jump all cars
        X30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 42");
                } else {
                    RunCPP("/temp 43");
                }
            }
        });

        Switch X6 = mainView.findViewById(R.id.X6); //Fast scope
        X6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 30");
                } else {
                    RunCPP("/temp 31");
                }
            }
        });

        Switch X7 = mainView.findViewById(R.id.X7); //Sit scope
        X7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 34");
                } else {
                    RunCPP("/temp 35");
                }
            }
        });

        Switch X8 = mainView.findViewById(R.id.X8); //Stand scope
        X8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 36");
                } else {
                    RunCPP("/temp 37");
                }
            }
        });

        Switch X9 = mainView.findViewById(R.id.X9); //Prone scope
        X9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 38");
                } else {
                    RunCPP("/temp 39");
                }
            }
        });


        Switch X19 = mainView.findViewById(R.id.X19); //Instant hit
        X19.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 69");
                } else {
                    RunCPP("/temp 70");
                }
            }
        });


        CheckBox X20 = mainView.findViewById(R.id.X20); //Headshoot
        X20.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 26");
                } else {
                    RunCPP("/temp 27");
                }
            }
        });
        CheckBox X31 = mainView.findViewById(R.id.X31); //HeadShoots v2
        X31.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 600");
                } else {
                    RunCPP("/temp 601");
                }
            }
        });
        CheckBox X21 = mainView.findViewById(R.id.X21); //MagicBullet
        X21.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 67");
                } else {
                    RunCPP("/temp 68");
                }
            }
        });


        RadioGroup customfog = mainView.findViewById(R.id.customfog);
        RadioButton X22 = mainView.findViewById(R.id.X22);
        X22.setChecked(true);
        customfog.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.X22:
                        RunCPP("/temp 79"); //off all fog
                        break;
                    case R.id.X23:
                        RunCPP("/temp 80"); //no fog
                        break;
                    case R.id.X24:
                        RunCPP("/temp 82");//purple fog
                        break;
                    case R.id.X25:
                        RunCPP("/temp 81");//green fog
                        break;
                }
            }
        });


        Switch X26 = mainView.findViewById(R.id.X26); //Tree and grass
        X26.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 32");
                } else {
                    RunCPP("/temp 33");
                }
            }
        });


        Switch X27 = mainView.findViewById(R.id.X27); //Night mode
        X27.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 77");
                } else {
                    RunCPP("/temp 78");
                }
            }
        });

        Switch X28 = mainView.findViewById(R.id.X28); //Black body
        X28.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    RunCPP("/temp 75");
                } else {
                    RunCPP("/temp 76");
                }
            }
        });

    }

    public void RunCPP(String path)
    {
        try
        {
            ExecuteElf("chmod 777 " + getFilesDir() + path);
            ExecuteElf(getFilesDir() + path);
            ExecuteElf("su -c chmod 777 " + getFilesDir() + path);
            ExecuteElf("su -c " + getFilesDir() + path);
        }
        catch (Exception e)
        {
        }
    }

    private void ExecuteElf(String shell)
    {
        String s=shell;
        try
        {
            Runtime.getRuntime().exec(s, null, null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void startFloatAimbot(){
        startService(new Intent(this, FloatAimbot.class));
    }

    private void stopFloatAimbot(){
        stopService(new Intent(this, FloatAimbot.class));
    }

    public native void SettingValue(int setting_code,boolean value);
    public native void Range(int range);
    public native void Target(int target);
    public native void AimBy(int aimby);
    public native void AimWhen(int aimwhen);
}

class SingleTapConfirm extends GestureDetector.SimpleOnGestureListener {

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        return true;
    }
}

