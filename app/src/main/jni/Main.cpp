#include <jni.h>
#include <string>
#include "ESP.h"
#include "Hacks.h"
#include "Includes/obfuscate.h"
#include "Includes/Logger.h"

ESP espOverlay;
int type=1,utype=2;
bool logged=false;
extern "C" JNIEXPORT void JNICALL
Java_com_d4x_cheats_Overlay_DrawOn(JNIEnv *env, jclass , jobject espView, jobject canvas) {
    espOverlay = ESP(env, espView, canvas);
    if (espOverlay.isValid()){
        DrawESP(espOverlay, espOverlay.getWidth(), espOverlay.getHeight());
    }
}
extern "C" JNIEXPORT void JNICALL
Java_com_d4x_cheats_Overlay_Close(JNIEnv *,  jobject ) {
    Close();
}
extern "C" JNIEXPORT jstring JNICALL
Java_com_d4x_cheats_SplashActivity_versionCheckURL(JNIEnv *env, jobject thiz ) {
    return env->NewStringUTF(OBFUSCATE_KEY("https://ric2210/app_version.php", '~'));
}
extern "C" JNIEXPORT jstring JNICALL
Java_com_d4x_cheats_SplashActivity_downLoad(JNIEnv *env, jobject thiz ) {
    return env->NewStringUTF(OBFUSCATE_KEY("https://d4hack.my.id/D4XCheats/App/d4xcheats.zip", '~'));
}
extern "C" JNIEXPORT jstring JNICALL
Java_com_d4x_cheats_Auth_URLSERVER(JNIEnv *env, jobject thiz ) {
    return env->NewStringUTF(OBFUSCATE_KEY("https://d4hack.my.id/D4XCheats/login.php", '~'));
}
extern "C" JNIEXPORT jstring JNICALL
Java_com_d4x_cheats_LoginActivity_MainAct(JNIEnv *env, jobject thiz ) {
    return env->NewStringUTF(OBFUSCATE_KEY("com.d4x.cheats.LoaderActivity", '~'));
}
extern "C" JNIEXPORT jstring JNICALL
Java_com_d4x_cheats_LoginActivity_Logintitle(JNIEnv *env, jobject thiz ) {
    return env->NewStringUTF(OBFUSCATE_KEY("Login!",'~'));
}
extern "C" JNIEXPORT jstring JNICALL
Java_com_d4x_cheats_LoaderActivity_title(JNIEnv *env, jobject thiz ) {
    return env->NewStringUTF(OBFUSCATE_KEY("BimaInjector",'~'));
}



extern "C" JNIEXPORT jstring JNICALL
Java_com_d4x_cheats_LoginActivity_getkey(JNIEnv *env, jobject thiz ) {
    return env->NewStringUTF(OBFUSCATE_KEY("https://t.me/bimainjector",'~'));
}
extern "C" JNIEXPORT void JNICALL
Java_com_d4x_cheats_FloatLogo_SettingValue(JNIEnv *,  jobject ,jint code,jboolean jboolean1) {
    switch((int)code){
        case 1:
            isPlayerBox = jboolean1;   break;
        case 2:
            isPlayerLineTop = jboolean1;  break;
        case 3:
            isPlayerDist = jboolean1;  break;
        case 4:
            isPlayerHealth = jboolean1;  break;
        case 5:
            isPlayerName = jboolean1;  break;
        case 6:
            isPlayerHead = jboolean1;  break;
        case 7:
            isr360Alert = jboolean1;  break;
        case 8:
            isSkelton = jboolean1;  break;
        case 9:
            isGrenadeWarning = jboolean1;  break;
        case 10:
            isEnemyWeapon=jboolean1;  break;
        case 11:
            if(jboolean1 != 0)
                options.openState=0;
            else
                options.openState=-1;
            break;
        case 12:
            options.tracingStatus=jboolean1;
            break;
        case 13:
            options.pour=jboolean1;
            break;
        case 14:
            isPlayerBoxFill = jboolean1;   break;
        case 15:
            isPlayerLineMiddle = jboolean1;   break;
        case 16:
            isPlayerLineBottom = jboolean1;   break;
    }
}

extern "C" JNIEXPORT void JNICALL
Java_com_d4x_cheats_FloatAimbot_AimbotPOV(JNIEnv *,  jobject ,jint code,jboolean jboolean1) {
    switch((int)code){
        case 11:
            if(jboolean1 != 0)
                options.openState=0;
            else
                options.openState=-1;
            break;
    }
}

extern "C" JNIEXPORT void JNICALL
Java_com_d4x_cheats_FloatLogo_Range(JNIEnv *,  jobject ,jint range) {
    options.aimingRange=1+range;
}
extern "C" JNIEXPORT void JNICALL
Java_com_d4x_cheats_FloatLogo_Target(JNIEnv *,  jobject ,jint target) {
    options.aimbotmode=target;
}
extern "C" JNIEXPORT void JNICALL
Java_com_d4x_cheats_FloatLogo_AimWhen(JNIEnv *,  jobject ,jint state) {
    options.aimingState=state;
}
extern "C" JNIEXPORT void JNICALL
Java_com_d4x_cheats_FloatLogo_AimBy(JNIEnv *,  jobject ,jint aimby) {
    options.priority=aimby;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_com_d4x_cheats_Auth_ALREADYLOGIN(JNIEnv *env, jobject thiz ) {
    logged=true;
    return true;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_com_d4x_cheats_LoaderActivity_ALREADYLOGIN(JNIEnv *env, jobject thiz ) {
    if (logged){
        return true;
    }else{
        return false;
    }
}

extern "C" JNIEXPORT jboolean JNICALL
Java_com_d4x_cheats_MainActivity_ALREADYLOGIN(JNIEnv *env, jobject thiz ) {
    if (logged){
        return true;
    }else{
        return false;
    }
}
extern "C" JNIEXPORT jboolean JNICALL
Java_com_d4x_cheats_Overlay_getReady(JNIEnv *, jclass ,int typeofgame) {
    int sockCheck=1;
    if (!Create()) {
        perror("Creation failed");
        return false;
    }
    setsockopt(sock,SOL_SOCKET,SO_REUSEADDR,&sockCheck, sizeof(int));
    if (!Bind()) {
        perror("Bind failed");
        return false;
    }

    if (!Listen()) {
        perror("Listen failed");
        return false;
    }
    if (Accept()) {
        SetValue sv{};
        sv.mode=typeofgame;
        sv.type=utype;
        send((void*)&sv,sizeof(sv));

        return true;
    }
}