package com.rootonebd.rootonebd.Utilities;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by IMATPC-12 on 19-Jan-18.
 */

public class RootOneAppPref {
    private static final String PREF_NAME = "ROOTONE_PREF";
    private static final String LOGIN = "LOGIN";
    private Context context;
    private SharedPreferences sharedPref;

    public RootOneAppPref(Context context) {
        this.context = context;
        sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE); //Not Understant this line
    }

    public boolean isLogIn(){
        return sharedPref.getBoolean(LOGIN,false);
    }

    public void setLogIn(boolean value){
        sharedPref.edit().putBoolean(LOGIN,value).apply();
    }

}
