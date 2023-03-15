package com.frontm.frontm;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.swmansion.gesturehandler.react.RNGestureHandlerEnabledRootView;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.os.UserHandle;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import androidx.core.app.NotificationCompat;
import org.devio.rn.splashscreen.SplashScreen;
import android.os.Bundle;
//import android.os.Build;
//import android.os.Bundle;
//
//import android.app.NotificationChannel;
//import android.app.NotificationManager;

public class MainActivity extends ReactActivity {

    public static final String INCOMING_CALL_INVITE          = "INCOMING_CALL_INVITE";
    public static final String INCOMING_CALL_NOTIFICATION_ID = "INCOMING_CALL_NOTIFICATION_ID";
    public static final String CANCELLED_CALL_SSID = "CANCELLED_CALL_SSID";
    public static final String CANCELLED_CALL_INVITE = "CANCELLED_CALL_INVITE";
    public static final String NOTIFICATION_TYPE             = "NOTIFICATION_TYPE";

    public static final String ACTION_INCOMING_CALL = "space.amal.frontm.INCOMING_CALL";
    public static final String ACTION_FCM_TOKEN     = "space.amal.frontm.ACTION_FCM_TOKEN";
    public static final String ACTION_MISSED_CALL   = "space.amal.frontm.MISSED_CALL";
    public static final String ACTION_CANCELLED_CALL   = "space.amal.frontm.CANCELLED_CALL";
    public static final String ACTION_ANSWER_CALL   = "space.amal.frontm.ANSWER_CALL";
    public static final String ACTION_REJECT_CALL   = "space.amal.frontm.REJECT_CALL";
    public static final String ACTION_HANGUP_CALL   = "space.amal.frontm.HANGUP_CALL";
    public static final String ACTION_CLEAR_MISSED_CALLS_COUNT = "space.amal.frontm.CLEAR_MISSED_CALLS_COUNT";
    private Bundle mSavedInstanceState = null;
    /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */

    public static String TAG = "IncomingCallScreenActivity";
  @Override
  protected String getMainComponentName() {
    return "frontm_mobile";
  }

    @Override
    protected ReactActivityDelegate createReactActivityDelegate() {
        return new ReactActivityDelegate(this, getMainComponentName()) {
            @Override
            protected ReactRootView createRootView() {
                ReactRootView reactRootView = new ReactRootView(getContext());
                // If you opted-in for the New Architecture, we enable the Fabric Renderer.
                reactRootView.setIsFabric(BuildConfig.IS_NEW_ARCHITECTURE_ENABLED);
                return reactRootView;
            }


        };
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MainApplication.getCallbackManager().onActivityResult(requestCode, resultCode, data);
    }

    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.show(this);
        mSavedInstanceState = savedInstanceState;
        super.onCreate(null);

        NotificationManager nm = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);


    }





}
