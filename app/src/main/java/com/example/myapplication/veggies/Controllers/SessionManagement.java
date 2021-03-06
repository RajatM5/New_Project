package com.example.myapplication.veggies.Controllers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;


import com.example.myapplication.veggies.Activity.Dashboard_activity;
import com.example.myapplication.veggies.Activity.Splash_mainactivity;


import java.util.HashMap;

public class SessionManagement {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "axpertz";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_USERID = "userid";
    // Email address (make variable public to access from outside)
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_MOBILE = "mobile";
    public static final String KEY_DOB = "bob";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_WALLET = "wallet";
    public static final String KEY_TYPE = "type";
    public static final String KEY_Status= "status";



  //  public static final String KEY_TYPE = "type";

    // Constructor
    public SessionManagement(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     * */
    public void createLoginSession(String userId, String userName, String emailId, String mobile, String status){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_USERID, userId);
        editor.putString(KEY_NAME, userName);
        editor.putString(KEY_EMAIL, emailId);
        editor.putString(KEY_MOBILE, mobile);
        editor.putString(KEY_Status, status);
        //     editor.putString(KEY_ADDRESS, address);

        editor.commit();
    }
//    public void createEmpLoginSession(String userId, String userName, String emailId, String mobile, String address, String login_type){
//        // Storing login value as TRUE
//        editor.putBoolean(IS_LOGIN, true);
//        editor.putString(KEY_USERID, userId);
//        editor.putString(KEY_NAME, userName);
//        editor.putString(KEY_EMAIL, emailId);
//        editor.putString(KEY_MOBILE, mobile);
//        editor.putString(KEY_ADDRESS, address);
//        editor.putString(KEY_TYPE, login_type);
//
//
//        editor.commit();
//    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, Dashboard_activity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }

    }



    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_USERID, pref.getString(KEY_USERID, ""));
        user.put(KEY_NAME, pref.getString(KEY_NAME, ""));
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        user.put(KEY_MOBILE, pref.getString(KEY_MOBILE, null));
        user.put(KEY_ADDRESS, pref.getString(KEY_ADDRESS, null));
        user.put(KEY_Status, pref.getString(KEY_Status, null));



        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, Splash_mainactivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

//    public String pincode(){
//        return pref.getString(KEY_Pincode, "");
//    }
}
