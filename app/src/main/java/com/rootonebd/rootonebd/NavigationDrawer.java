package com.rootonebd.rootonebd;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NavigationDrawer extends Fragment {

    public static final String PREF_NAME ="ROOTONE_PREF";
    public static final String KEY_USER_LEARNER_DRAWER = "ROOTONE_DRAWER";

    private ActionBarDrawerToggle rootDrawerToggle;
    private DrawerLayout rootDrawerLayout;

    private boolean rootUserLearnedDrawer;
    private boolean rootFromSaveInstanceState;

    private View containerView;


    public NavigationDrawer() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);


    }

    public void setUp(int fragmentId, DrawerLayout layout, final Toolbar toolbar){
        containerView = getActivity().findViewById(fragmentId);

        rootDrawerLayout = layout;
        rootDrawerToggle = new ActionBarDrawerToggle(getActivity(),rootDrawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){
            public void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);
                //if user gonna not seen the drawer before thats mean the drawer is open for the first time
                if(!rootUserLearnedDrawer){
                    rootUserLearnedDrawer = true;
                    saveToPreferences(getActivity(),KEY_USER_LEARNER_DRAWER,rootUserLearnedDrawer+"");
                    getActivity().invalidateOptionsMenu();
                }
            }
            public void onDrawerClosed(View drawerView){
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }
            public void onDrawerSlider(View drawerView,float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }
        };

        rootDrawerLayout.addDrawerListener(rootDrawerToggle);
        rootDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                rootDrawerToggle.syncState();
            }
        });
    }

    public static void saveToPreferences(Context context, String key, String prefValue) {
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key,prefValue);
        editor.apply();
    }
    public static String readFromPreferences(Context context, String key, String defaultValue){
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return pref.getString(key,defaultValue);
    }
}
