package com.example.myapplication.veggies.Controllers;

import android.app.ActivityManager;
import android.app.Application;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


//import net.one97.paytm.nativesdk.PaytmSDK;

public class AppControllers extends Application {

    RequestQueue mRequestQueue;
    public static int tabCurrentItem=0;
    public static com.example.myapplication.veggies.Controllers.AppControllers AppControllers;
    //    public static String userid;
    public static String hname;
    public static String player_id="";
    Boolean isInForeground,isVisiBle;
    @Override
    public void onCreate() {
        super.onCreate();
        //PaytmSDK.init(this);
        AppControllers = this;
//        userid = new String();
        hname = new String();
//
//        OneSignal.startInit(this)
//                .setNotificationReceivedHandler(new MyNotificationReceivedHandler())
//                .setNotificationOpenedHandler(new MyNotificationOpenedHandler())
////                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
//                .unsubscribeWhenNotificationsAreDisabled(true)
//                .init();
//
//
//        OneSignal.idsAvailable(new OneSignal.IdsAvailableHandler() {
//            @Override
//            public void idsAvailable(String userId, String registrationId) {
//                player_id = userId;
//                Log.w("SHANTAG", "login player_id " + player_id);
//                Log.w("SHANTAG", "login player_id " + registrationId);
//            }
//        });

        ActivityManager.RunningAppProcessInfo myProcess = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(myProcess);
//                Boolean isInBackground = myProcess.importance != ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND;
        isInForeground = myProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND;
        isVisiBle = myProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_VISIBLE;
        Log.w("SHANTAG","App is in background==>"+isVisiBle);
    }

    public static synchronized com.example.myapplication.veggies.Controllers.AppControllers getInstance() {

        return AppControllers;
    }

    public RequestQueue getmRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addRequestInQueue(Request<T> request)    {
        getmRequestQueue().add(request);
    }
//    public class MyNotificationReceivedHandler  implements OneSignal.NotificationReceivedHandler {
//
//
//        @Override
//        public void notificationReceived(OSNotification notification) {
//            Log.w("NTAG","Noti result====>"+notification.payload.additionalData);
//
//
//        }
//    }
//
//    public class MyNotificationOpenedHandler implements OneSignal.NotificationOpenedHandler {
//        // This fires when a notification is opened by tapping on it.
//        @Override
//        public void notificationOpened(OSNotificationOpenResult result) {
//            Log.w("NTAG","Noti result 108====>"+result.notification.payload.additionalData);
//            JSONObject jsonObject = result.notification.payload.additionalData;
//
//            String notibody = result.notification.payload.body;
//            String notititle = result.notification.payload.title;
//
//            if(!(isInForeground)) {
//
//
//                Intent launchIntent = new Intent(com.tbd.gtechitworld.controllers.AppControllers.this, ActivityNotification.class);
////                    launchIntent.putExtra("room_id", jsonObject.getString("appointment_room_id"));
////                    launchIntent.putExtra("app_id", jsonObject.getString("appointment_id"));
//                launchIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(launchIntent);
//                //                launchIntent.putExtra("messageNoti", notibody);
//
//            }else{
//
//                Intent launchIntent = new Intent(com.tbd.gtechitworld.controllers.AppControllers.this, ActivityNotification.class);
////                    launchIntent.putExtra("room_id", jsonObject.getString("appointment_room_id"));
////                    launchIntent.putExtra("app_id", jsonObject.getString("appointment_id"));
//                launchIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(launchIntent);
//            }
//        }
//    }

}