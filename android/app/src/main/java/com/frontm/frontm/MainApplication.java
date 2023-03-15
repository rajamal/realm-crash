package com.frontm.frontm;

import android.app.Application;
import android.content.Context;

import com.brentvatne.react.ReactVideoPackage;
import com.cmcewen.blurview.BlurViewPackage;
import com.facebook.CallbackManager;
import com.facebook.react.PackageList;
import com.bugsnag.android.Bugsnag;
import com.facebook.react.ReactApplication;
import com.swmansion.reanimated.ReanimatedPackage;
import com.swmansion.reanimated.ReanimatedPackage;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.soloader.SoLoader;
import com.facebook.react.config.ReactFeatureFlags;
import com.frontm.frontm.newarchitecture.MainApplicationReactNativeHost;


import org.pgsqlite.SQLitePluginPackage;
import android.database.CursorWindow;
import java.lang.reflect.Field;
import java.util.List;
import androidx.annotation.Nullable;

public class MainApplication extends Application implements ReactApplication {

    private static CallbackManager mCallbackManager = CallbackManager.Factory.create();

    protected static CallbackManager getCallbackManager() {
        return mCallbackManager;
    }


    private final ReactNativeHost mReactNativeHost =
            new ReactNativeHost(this) {
                @Override
                public boolean getUseDeveloperSupport() {
                    return BuildConfig.DEBUG;
                }

                @Override
                protected List<ReactPackage> getPackages() {
                    List<ReactPackage> packages = new PackageList(this).getPackages();
                    packages.add(new BlurViewPackage());
                    packages.add(new ReactVideoPackage());
                    packages.add(new SQLitePluginPackage());
                    //packages.add(new RNNotificationsPackage(MainApplication.this));
                    return packages;

                }

                @Override
                protected String getJSMainModuleName() {
                    return "index";
                }

                @Override
                protected @Nullable String getBundleAssetName() {
                    return "frontm.bundle";
                }
            };

    private final ReactNativeHost mNewArchitectureNativeHost =
      new MainApplicationReactNativeHost(this);

    @Override
    public ReactNativeHost getReactNativeHost() {
        if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
            return mNewArchitectureNativeHost;
        } else {
            return mReactNativeHost;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // If you opted-in for the New Architecture, we enable the TurboModule system
        ReactFeatureFlags.useTurboModules = BuildConfig.IS_NEW_ARCHITECTURE_ENABLED;
        Bugsnag.start(this);
        SoLoader.init(this, /* native exopackage */ false);
//        initializeFlipper(this, getReactNativeHost().getReactInstanceManager());


        try {
            Field field = CursorWindow.class.getDeclaredField("sCursorWindowSize");
            field.setAccessible(true);
            field.set(null, 20 * 1024 * 1024); //the 100MB is the new size
        } catch (Exception e) {

                e.printStackTrace();

        }

        // TODO(sourav) : Have to check if Facebook works ?
        // FacebookSdk.sdkInitialize(getApplicationContext());
//        BackgroundTaskPackage.useContext(this);
    }

    /**
     * Loads Flipper in React Native templates. Call this in the onCreate method with something like
     * initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
     *
     * @param context
     * @param reactInstanceManager
     */
//    private static void initializeFlipper(
//            Context context, ReactInstanceManager reactInstanceManager) {
//        if (BuildConfig.DEBUG) {
//            try {
//        /*
//         We use reflection here to pick up the class that initializes Flipper,
//        since Flipper library is not available in release mode
//        */
//                Class<?> aClass = Class.forName("com.rndiffapp.ReactNativeFlipper");
//                aClass
//                        .getMethod("initializeFlipper", Context.class, ReactInstanceManager.class)
//                        .invoke(null, context, reactInstanceManager);
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
